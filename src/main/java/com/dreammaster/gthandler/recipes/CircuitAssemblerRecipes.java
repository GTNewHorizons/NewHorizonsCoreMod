package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.*;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCircuitAssemblerRecipes;
import static gregtech.api.util.GT_RecipeBuilder.*;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gtPlusPlus.core.material.ELEMENT;

public class CircuitAssemblerRecipes implements Runnable {

    // put the soldering Materials in this array
    public final Materials[] solderingMaterials = new Materials[] { Materials.Lead, Materials.SolderingAlloy,
            Materials.Tin };

    public final ItemStack[] RocketMaterial = new ItemStack[] {
            GT_ModHandler.getModItem(GalacticraftCore.ID, "item.heavyPlating", 1L),
            GT_ModHandler.getModItem(GalacticraftMars.ID, "item.null", 1L, 3),
            GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1L),
            CustomItemList.HeavyDutyPlateTier4.get(1L), CustomItemList.HeavyDutyPlateTier5.get(1L),
            CustomItemList.HeavyDutyPlateTier6.get(1L), CustomItemList.HeavyDutyPlateTier7.get(1L),
            CustomItemList.HeavyDutyPlateTier8.get(1L) };

    public final ItemStack[] RocketChip = new ItemStack[] { CustomItemList.SchematicsTier1.get(1L),
            CustomItemList.SchematicsTier2.get(1L), CustomItemList.SchematicsTier3.get(1L),
            CustomItemList.SchematicsTier4.get(1L), CustomItemList.SchematicsTier5.get(1L),
            CustomItemList.SchematicsTier6.get(1L), CustomItemList.SchematicsTier7.get(1L),
            CustomItemList.SchematicsTier8.get(1L), };

    // Rocket Circuits
    public final int[] EUperRecipe = new int[] { 480, // t2 = HV
            1920, // t3 = EV
            7680, // t4 = IV
            30720, // t5 = LuV (Gated behind Assline)
            30720, // t6 = LuV
            130870, // t7 = ZPM
            520400, // t8 = UV
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

        // Crystal Circuits

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        ItemList.Circuit_Chip_CrystalCPU.get(1L),
                        ItemList.Circuit_Chip_NanoCPU.get(2L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(6),
                        ItemList.Circuit_Parts_TransistorASMD.get(6),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8))
                .itemOutputs(ItemList.Circuit_Crystalprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 72))
                .noFluidOutputs().requiresCleanRoom().duration(5 * SECONDS).eut(9600).addTo(sCircuitAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        ItemList.Circuit_Crystalprocessor.get(2L),
                        ItemList.Circuit_Parts_InductorASMD.get(6L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                        ItemList.Circuit_Chip_Ram.get(24),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16))
                .itemOutputs(ItemList.Circuit_Crystalcomputer.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 144))
                .noFluidOutputs().requiresCleanRoom().duration(10 * SECONDS).eut(9600).addTo(sCircuitAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        ItemList.Circuit_Crystalcomputer.get(2L),
                        ItemList.Circuit_Chip_Ram.get(4L),
                        ItemList.Circuit_Chip_NOR.get(32L),
                        ItemList.Circuit_Chip_NAND.get(64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 32))
                .itemOutputs(ItemList.Circuit_Ultimatecrystalcomputer.get(1L))
                .fluidInputs(new FluidStack(solderIndalloy, 144)).noFluidOutputs().requiresCleanRoom()
                .duration(20 * SECONDS).eut(9600).addTo(sCircuitAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                        ItemList.Circuit_Ultimatecrystalcomputer.get(2L),
                        ItemList.Circuit_Parts_InductorASMD.get(8L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(16L),
                        ItemList.Circuit_Chip_Ram.get(32L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 16))
                .itemOutputs(ItemList.Circuit_Crystalmainframe.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 288))
                .noFluidOutputs().requiresCleanRoom().duration(40 * SECONDS).eut(TierEU.RECIPE_LuV)
                .addTo(sCircuitAssemblerRecipes);
        // Wetware Circuits

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Chip_NeuroCPU.get(1L),
                        ItemList.Circuit_Chip_CrystalCPU.get(1L),
                        ItemList.Circuit_Chip_NanoCPU.get(1L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                        ItemList.Circuit_Parts_TransistorASMD.get(8L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8))
                .itemOutputs(ItemList.Circuit_Neuroprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 72))
                .noFluidOutputs().requiresCleanRoom().duration(10 * SECONDS).eut(38400).addTo(sCircuitAssemblerRecipes);
        // Wetware SoC recipe

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware_Extreme.get(1),
                        ItemList.Circuit_Parts_Crystal_Chip_Wetware.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CosmicNeutronium, 8))
                .itemOutputs(ItemList.Circuit_Neuroprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 144))
                .noFluidOutputs().requiresCleanRoom().duration(2 * SECONDS + 10 * TICKS).eut(614400)
                .addTo(sCircuitAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Chip_NeuroCPU.get(1L),
                        ItemList.Circuit_Chip_CrystalCPU.get(1L),
                        ItemList.Circuit_Chip_NanoCPU.get(1L),
                        ItemList.Circuit_Parts_CapacitorXSMD.get(2L),
                        ItemList.Circuit_Parts_TransistorXSMD.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8))
                .itemOutputs(ItemList.Circuit_Neuroprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 72))
                .noFluidOutputs().requiresCleanRoom().duration(1 * SECONDS + 5 * TICKS).eut(153600)
                .addTo(sCircuitAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                        ItemList.Circuit_Neuroprocessor.get(2L),
                        ItemList.Circuit_Parts_InductorASMD.get(8L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(12L),
                        ItemList.Circuit_Chip_Ram.get(24L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 16))
                .itemOutputs(ItemList.Circuit_Wetwarecomputer.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 144))
                .noFluidOutputs().requiresCleanRoom().duration(15 * SECONDS).eut(38400).addTo(sCircuitAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                        ItemList.Circuit_Neuroprocessor.get(2L),
                        ItemList.Circuit_Parts_InductorXSMD.get(2L),
                        ItemList.Circuit_Parts_CapacitorXSMD.get(3L),
                        ItemList.Circuit_Chip_Ram.get(24L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 16))
                .itemOutputs(ItemList.Circuit_Wetwarecomputer.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 144))
                .noFluidOutputs().requiresCleanRoom().duration(1 * SECONDS + 17 * TICKS).eut(153600)
                .addTo(sCircuitAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware_Extreme.get(2L),
                        ItemList.Circuit_Wetwarecomputer.get(2L),
                        ItemList.Circuit_Parts_DiodeASMD.get(8L),
                        ItemList.Circuit_Chip_NOR.get(16L),
                        ItemList.Circuit_Chip_Ram.get(64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 24))
                .itemOutputs(ItemList.Circuit_Wetwaresupercomputer.get(1L))
                .fluidInputs(new FluidStack(solderIndalloy, 144)).noFluidOutputs().requiresCleanRoom()
                .duration(30 * SECONDS).eut(38400).addTo(sCircuitAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware_Extreme.get(2L),
                        ItemList.Circuit_Wetwarecomputer.get(2L),
                        ItemList.Circuit_Parts_DiodeXSMD.get(2L),
                        ItemList.Circuit_Chip_NOR.get(16L),
                        ItemList.Circuit_Chip_Ram.get(64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 24))
                .itemOutputs(ItemList.Circuit_Wetwaresupercomputer.get(1L))
                .fluidInputs(new FluidStack(solderIndalloy, 144)).noFluidOutputs().requiresCleanRoom()
                .duration(3 * SECONDS + 15 * TICKS).eut(153600).addTo(sCircuitAssemblerRecipes);
        // Bio Circuits

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Chip_BioCPU.get(1L),
                        ItemList.Circuit_Chip_CrystalSoC2.get(1L),
                        ItemList.Circuit_Chip_NanoCPU.get(2L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(12L),
                        ItemList.Circuit_Parts_TransistorASMD.get(12L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16))
                .itemOutputs(ItemList.Circuit_Bioprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 72))
                .noFluidOutputs().requiresCleanRoom().duration(15 * SECONDS).eut(153600)
                .addTo(sCircuitAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Chip_BioCPU.get(1L),
                        ItemList.Circuit_Chip_CrystalSoC2.get(1L),
                        ItemList.Circuit_Chip_NanoCPU.get(2L),
                        ItemList.Circuit_Parts_CapacitorXSMD.get(3L),
                        ItemList.Circuit_Parts_TransistorXSMD.get(3L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16))
                .itemOutputs(ItemList.Circuit_Bioprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 72))
                .noFluidOutputs().requiresCleanRoom().duration(1 * SECONDS + 17 * TICKS).eut(614400)
                .addTo(sCircuitAssemblerRecipes);

        if (GTPlusPlus.isModLoaded()) {
            // Bio SoC
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Bio_Ultra.get(1L),
                            ItemList.Circuit_Parts_Chip_Bioware.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16),
                            ELEMENT.STANDALONE.CHRONOMATIC_GLASS.getBolt(8))
                    .itemOutputs(ItemList.Circuit_Bioprocessor.get(1L)).fluidInputs(new FluidStack(solderUEV, 144))
                    .noFluidOutputs().requiresCleanRoom().duration(3 * SECONDS + 15 * TICKS)
                    .eut((int) TierEU.RECIPE_UEV).addTo(sCircuitAssemblerRecipes);
        }

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Bio_Ultra.get(1L),
                        ItemList.Circuit_Bioprocessor.get(2L),
                        ItemList.Circuit_Parts_InductorASMD.get(12L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(16L),
                        ItemList.Circuit_Chip_Ram.get(32L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 24))
                .itemOutputs(ItemList.Circuit_Biowarecomputer.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 144))
                .noFluidOutputs().requiresCleanRoom().duration(20 * SECONDS).eut(153600)
                .addTo(sCircuitAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Bio_Ultra.get(1L),
                        ItemList.Circuit_Bioprocessor.get(2L),
                        ItemList.Circuit_Parts_InductorXSMD.get(3L),
                        ItemList.Circuit_Parts_CapacitorXSMD.get(4L),
                        ItemList.Circuit_Chip_Ram.get(32L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 24))
                .itemOutputs(ItemList.Circuit_Biowarecomputer.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 144))
                .noFluidOutputs().requiresCleanRoom().duration(2 * SECONDS + 10 * TICKS).eut(614400)
                .addTo(sCircuitAssemblerRecipes);
        // Energy Flow Circuit

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 2),
                        ItemList.Circuit_Chip_UHPIC.get(4L),
                        ItemList.Circuit_Chip_QuantumCPU.get(2L),
                        ItemList.Circuit_Chip_NanoCPU.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 64))
                .itemOutputs(CustomItemList.HighEnergyFlowCircuit.get(1L))
                .fluidInputs(new FluidStack(solderIndalloy, 288)).noFluidOutputs().requiresCleanRoom()
                .duration(2 * MINUTES).eut(TierEU.RECIPE_IV).addTo(sCircuitAssemblerRecipes);
        // SoC for nano, quantum, crystal

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        ItemList.Circuit_Chip_SoC2.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 8))
                .itemOutputs(ItemList.Circuit_Nanoprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 72))
                .noFluidOutputs().requiresCleanRoom().duration(2 * SECONDS + 10 * TICKS).eut(9600)
                .addTo(sCircuitAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                        ItemList.Circuit_Chip_SoC2.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.NiobiumTitanium, 8))
                .itemOutputs(ItemList.Circuit_Quantumprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 72))
                .noFluidOutputs().requiresCleanRoom().duration(2 * SECONDS + 10 * TICKS).eut(38400)
                .addTo(sCircuitAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        ItemList.Circuit_Chip_CrystalSoC.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.YttriumBariumCuprate, 8))
                .itemOutputs(ItemList.Circuit_Crystalprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 72))
                .noFluidOutputs().requiresCleanRoom().duration(2 * SECONDS + 10 * TICKS).eut(153600)
                .addTo(sCircuitAssemblerRecipes);

        if (AppliedEnergistics2.isModLoaded()) {
            // 1k ME Storage Component

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 2),
                            CustomItemList.ChargedCertusQuartzDust.get(2),
                            CustomItemList.LogicProcessorItemGoldCore.get(1),
                            ItemList.Circuit_Board_Basic.get(1),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 35))
                    .fluidInputs(Materials.Lead.getMolten(288)).noFluidOutputs().duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 2),
                            CustomItemList.ChargedCertusQuartzDust.get(2),
                            CustomItemList.LogicProcessorItemGoldCore.get(1),
                            ItemList.Circuit_Board_Basic.get(1),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 35))
                    .fluidInputs(Materials.Tin.getMolten(144)).noFluidOutputs().duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 2),
                            CustomItemList.ChargedCertusQuartzDust.get(2),
                            CustomItemList.LogicProcessorItemGoldCore.get(1),
                            ItemList.Circuit_Board_Basic.get(1),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 35))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(72)).noFluidOutputs().duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(sCircuitAssemblerRecipes);
            // 4k ME Storage Component

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 16),
                            CustomItemList.LogicProcessorItemGoldCore.get(1),
                            ItemList.Circuit_Board_Coated_Basic.get(1),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 36))
                    .fluidInputs(Materials.Lead.getMolten(288)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 16),
                            CustomItemList.LogicProcessorItemGoldCore.get(1),
                            ItemList.Circuit_Board_Coated_Basic.get(1),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 36))
                    .fluidInputs(Materials.Tin.getMolten(144)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 16),
                            CustomItemList.LogicProcessorItemGoldCore.get(1),
                            ItemList.Circuit_Board_Coated_Basic.get(1),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 36))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(72)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sCircuitAssemblerRecipes);
            // 16k ME Storage Component

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Phenolic_Good.get(1),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 37))
                    .fluidInputs(Materials.Lead.getMolten(288)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Phenolic_Good.get(1),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 37))
                    .fluidInputs(Materials.Tin.getMolten(144)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Phenolic_Good.get(1),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 37))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(72)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);
            // 64k ME Storage Component

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 38))
                    .fluidInputs(Materials.Lead.getMolten(288)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 38))
                    .fluidInputs(Materials.Tin.getMolten(144)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 38))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(72)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sCircuitAssemblerRecipes);

        }
    }

    public void solderingMaterials() {
        for (Materials tMat : solderingMaterials) {
            int tMultiplier = tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD) ? 1
                    : tMat.contains(SubTag.SOLDERING_MATERIAL_BAD) ? 4 : 2;

            // Rocket Circuits

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Quantumprocessor.get(1L),
                            RocketMaterial[0],
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(RocketChip[0]).fluidInputs(tMat.getMolten(576L * tMultiplier / 2L)).noFluidOutputs()
                    .requiresCleanRoom().duration(7 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(ItemList.Circuit_Data.get(1L), RocketMaterial[0], GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(RocketChip[0]).fluidInputs(tMat.getMolten(576L * tMultiplier / 2L)).noFluidOutputs()
                    .requiresCleanRoom().duration(7 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Nanocomputer.get(1L),
                            RocketMaterial[0],
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(RocketChip[0]).fluidInputs(tMat.getMolten(576L * tMultiplier / 2L)).noFluidOutputs()
                    .requiresCleanRoom().duration(7 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(sCircuitAssemblerRecipes);

            for (int i = 2; i < 9; ++i) {
                ItemStack DataStickWScheme = ItemList.Tool_DataStick.get(1L);
                DataStickWScheme.setTagCompound(
                        GT_Utility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", (short) i));

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                RocketMaterial[(i - 1)],
                                ItemList.Circuit_Elite.get(1L),
                                DataStickWScheme.splitStack(0))
                        .itemOutputs(RocketChip[(i - 1)]).fluidInputs(tMat.getMolten(576L * tMultiplier / 2L))
                        .noFluidOutputs().requiresCleanRoom().duration(7 * MINUTES + 30 * SECONDS)
                        .eut(EUperRecipe[(i - 2)]).addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                RocketMaterial[(i - 1)],
                                ItemList.Circuit_Elitenanocomputer.get(1L),
                                DataStickWScheme.splitStack(0))
                        .itemOutputs(RocketChip[(i - 1)]).fluidInputs(tMat.getMolten(576L * tMultiplier / 2L))
                        .noFluidOutputs().requiresCleanRoom().duration(7 * MINUTES + 30 * SECONDS)
                        .eut(EUperRecipe[(i - 2)]).addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                RocketMaterial[(i - 1)],
                                ItemList.Circuit_Quantumcomputer.get(1L),
                                DataStickWScheme.splitStack(0))
                        .itemOutputs(RocketChip[(i - 1)]).fluidInputs(tMat.getMolten(576L * tMultiplier / 2L))
                        .noFluidOutputs().requiresCleanRoom().duration(7 * MINUTES + 30 * SECONDS)
                        .eut(EUperRecipe[(i - 2)]).addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                RocketMaterial[(i - 1)],
                                ItemList.Circuit_Crystalprocessor.get(1L),
                                DataStickWScheme.splitStack(0))
                        .itemOutputs(RocketChip[(i - 1)]).fluidInputs(tMat.getMolten(576L * tMultiplier / 2L))
                        .noFluidOutputs().requiresCleanRoom().duration(7 * MINUTES + 30 * SECONDS)
                        .eut(EUperRecipe[(i - 2)]).addTo(sCircuitAssemblerRecipes);

            }

            for (int i = 0; i < 3; ++i) {
                ItemStack DataStickWScheme = ItemList.Tool_DataStick.get(1L);
                DataStickWScheme.setTagCompound(
                        GT_Utility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", (short) (i + 100)));

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                RocketMaterial[i],
                                ItemList.Circuit_Quantumprocessor.get(1L),
                                DataStickWScheme.splitStack(0))
                        .itemOutputs(ExtraChips[i]).fluidInputs(tMat.getMolten(576L * tMultiplier / 2L))
                        .noFluidOutputs().requiresCleanRoom().duration(7 * MINUTES + 30 * SECONDS).eut(EUperRecipe[i])
                        .addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(RocketMaterial[i], ItemList.Circuit_Data.get(1L), DataStickWScheme.splitStack(0))
                        .itemOutputs(ExtraChips[i]).fluidInputs(tMat.getMolten(576L * tMultiplier / 2L))
                        .noFluidOutputs().requiresCleanRoom().duration(7 * MINUTES + 30 * SECONDS).eut(EUperRecipe[i])
                        .addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                RocketMaterial[i],
                                ItemList.Circuit_Nanocomputer.get(1L),
                                DataStickWScheme.splitStack(0))
                        .itemOutputs(ExtraChips[i]).fluidInputs(tMat.getMolten(576L * tMultiplier / 2L))
                        .noFluidOutputs().requiresCleanRoom().duration(7 * MINUTES + 30 * SECONDS).eut(EUperRecipe[i])
                        .addTo(sCircuitAssemblerRecipes);

            }
            // Primitive Circuit

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 1))
                    .itemOutputs(CustomItemList.NandChipBoard.get(1))
                    .fluidInputs(tMat.getMolten(36L * tMultiplier / 2L)).noFluidOutputs().duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 1))
                    .itemOutputs(CustomItemList.NandChipBoard.get(1))
                    .fluidInputs(tMat.getMolten(36L * tMultiplier / 2L)).noFluidOutputs()
                    .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 1))
                    .itemOutputs(CustomItemList.NandChipBoard.get(2))
                    .fluidInputs(tMat.getMolten(36L * tMultiplier / 2L)).noFluidOutputs().duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 1))
                    .itemOutputs(CustomItemList.NandChipBoard.get(2))
                    .fluidInputs(tMat.getMolten(36L * tMultiplier / 2L)).noFluidOutputs()
                    .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 1))
                    .itemOutputs(CustomItemList.NandChipBoard.get(4))
                    .fluidInputs(tMat.getMolten(36L * tMultiplier / 2L)).noFluidOutputs().duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 1))
                    .itemOutputs(CustomItemList.NandChipBoard.get(4))
                    .fluidInputs(tMat.getMolten(36L * tMultiplier / 2L)).noFluidOutputs()
                    .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV).addTo(sCircuitAssemblerRecipes);

            if (IndustrialCraft2.isModLoaded()) {
                // Basic Circuit

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Coated_Basic.get(1L),
                                ItemList.Circuit_Parts_Resistor.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2),
                                ItemList.Circuit_Parts_Vacuum_Tube.get(2L))
                        .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1L, 0))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(16).addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Coated_Basic.get(1L),
                                ItemList.Circuit_Parts_ResistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2),
                                ItemList.Circuit_Parts_Vacuum_Tube.get(2L))
                        .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1L, 0))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(16).addTo(sCircuitAssemblerRecipes);
                // Good Circuit

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2L, 0),
                                ItemList.Circuit_Parts_Diode.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2))
                        .itemOutputs(ItemList.Circuit_Good.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier / 2L))
                        .noFluidOutputs().duration(15 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2L, 0),
                                ItemList.Circuit_Parts_DiodeSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2))
                        .itemOutputs(ItemList.Circuit_Good.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier / 2L))
                        .noFluidOutputs().duration(15 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sCircuitAssemblerRecipes);

            }

            // Integraded Circuits

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Coated_Basic.get(1L),
                            ItemList.Circuit_Chip_ILC.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(2L),
                            ItemList.Circuit_Parts_Diode.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2))
                    .itemOutputs(ItemList.Circuit_Basic.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier / 2L))
                    .noFluidOutputs().duration(10 * SECONDS).eut(16).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Coated_Basic.get(1L),
                            ItemList.Circuit_Chip_ILC.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(2L),
                            ItemList.Circuit_Parts_Diode.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2))
                    .itemOutputs(ItemList.Circuit_Basic.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier / 2L))
                    .noFluidOutputs().duration(10 * SECONDS).eut(16).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Coated_Basic.get(1L),
                            ItemList.Circuit_Chip_ILC.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(2L),
                            ItemList.Circuit_Parts_DiodeSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2))
                    .itemOutputs(ItemList.Circuit_Basic.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier / 2L))
                    .noFluidOutputs().duration(10 * SECONDS).eut(16).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Coated_Basic.get(1L),
                            ItemList.Circuit_Chip_ILC.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(2L),
                            ItemList.Circuit_Parts_DiodeSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2))
                    .itemOutputs(ItemList.Circuit_Basic.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier / 2L))
                    .noFluidOutputs().duration(10 * SECONDS).eut(16).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_Resistor.get(4L),
                            ItemList.Circuit_Parts_Diode.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4))
                    .itemOutputs(ItemList.Circuit_Integrated_Good.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(20 * SECONDS)
                    .eut(24).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_ResistorSMD.get(4L),
                            ItemList.Circuit_Parts_Diode.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4))
                    .itemOutputs(ItemList.Circuit_Integrated_Good.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(20 * SECONDS)
                    .eut(24).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_ResistorSMD.get(4L),
                            ItemList.Circuit_Parts_DiodeSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4))
                    .itemOutputs(ItemList.Circuit_Integrated_Good.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(20 * SECONDS)
                    .eut(24).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_ResistorASMD.get(1L),
                            ItemList.Circuit_Parts_DiodeASMD.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4))
                    .itemOutputs(ItemList.Circuit_Integrated_Good.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                    .eut(24).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_Resistor.get(4L),
                            ItemList.Circuit_Parts_DiodeSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4))
                    .itemOutputs(ItemList.Circuit_Integrated_Good.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(20 * SECONDS)
                    .eut(24).addTo(sCircuitAssemblerRecipes);

            // Advanced circuit

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Integrated_Good.get(1L),
                            ItemList.Circuit_Chip_ILC.get(2L),
                            ItemList.Circuit_Chip_Ram.get(2L),
                            ItemList.Circuit_Parts_Transistor.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8))
                    .itemOutputs(GT_ModHandler.getIC2Item("advancedCircuit", 1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(40 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Integrated_Good.get(1L),
                            ItemList.Circuit_Chip_ILC.get(2L),
                            ItemList.Circuit_Chip_Ram.get(2L),
                            ItemList.Circuit_Parts_TransistorSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8))
                    .itemOutputs(GT_ModHandler.getIC2Item("advancedCircuit", 1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(40 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Integrated_Good.get(1L),
                            ItemList.Circuit_Chip_ILC.get(2L),
                            ItemList.Circuit_Chip_Ram.get(2L),
                            ItemList.Circuit_Parts_TransistorASMD.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8))
                    .itemOutputs(GT_ModHandler.getIC2Item("advancedCircuit", 1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(sCircuitAssemblerRecipes);
            // Integrated Circuits

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(2L),
                            ItemList.Circuit_Parts_Capacitor.get(2L),
                            ItemList.Circuit_Parts_Transistor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2))
                    .itemOutputs(ItemList.Circuit_Microprocessor.get(2L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(2L),
                            ItemList.Circuit_Parts_Capacitor.get(2L),
                            ItemList.Circuit_Parts_Transistor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2))
                    .itemOutputs(ItemList.Circuit_Microprocessor.get(2L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(2L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(2L),
                            ItemList.Circuit_Parts_Transistor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2))
                    .itemOutputs(ItemList.Circuit_Microprocessor.get(2L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(2L),
                            ItemList.Circuit_Parts_Capacitor.get(2L),
                            ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2))
                    .itemOutputs(ItemList.Circuit_Microprocessor.get(2L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(2L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(2L),
                            ItemList.Circuit_Parts_Transistor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2))
                    .itemOutputs(ItemList.Circuit_Microprocessor.get(2L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(2L),
                            ItemList.Circuit_Parts_Capacitor.get(2L),
                            ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2))
                    .itemOutputs(ItemList.Circuit_Microprocessor.get(2L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(2L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(2L),
                            ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2))
                    .itemOutputs(ItemList.Circuit_Microprocessor.get(2L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(4L),
                            ItemList.Circuit_Parts_Transistor.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4))
                    .itemOutputs(ItemList.Circuit_Processor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(4L),
                            ItemList.Circuit_Parts_Transistor.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4))
                    .itemOutputs(ItemList.Circuit_Processor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_ResistorASMD.get(1L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(1L),
                            ItemList.Circuit_Parts_TransistorASMD.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4))
                    .itemOutputs(ItemList.Circuit_Processor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(5 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(4L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(4L),
                            ItemList.Circuit_Parts_Transistor.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4))
                    .itemOutputs(ItemList.Circuit_Processor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(4L),
                            ItemList.Circuit_Parts_TransistorSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4))
                    .itemOutputs(ItemList.Circuit_Processor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(4L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(4L),
                            ItemList.Circuit_Parts_Transistor.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4))
                    .itemOutputs(ItemList.Circuit_Processor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(4L),
                            ItemList.Circuit_Parts_TransistorSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4))
                    .itemOutputs(ItemList.Circuit_Processor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(4L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(4L),
                            ItemList.Circuit_Parts_TransistorSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4))
                    .itemOutputs(ItemList.Circuit_Processor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Processor.get(2L),
                            ItemList.Circuit_Parts_Coil.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(8L),
                            ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8))
                    .itemOutputs(ItemList.Circuit_Computer.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .noFluidOutputs().requiresCleanRoom().duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(2L),
                            ItemList.Circuit_Chip_NAND.get(32L),
                            ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 16),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4))
                    .itemOutputs(ItemList.Tool_DataStick.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .noFluidOutputs().requiresCleanRoom().duration(20 * SECONDS).eut(90)
                    .addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Advanced.get(2L),
                            ItemList.Circuit_Parts_Diode.get(4L),
                            ItemList.Circuit_Chip_Ram.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16))
                    .itemOutputs(ItemList.Circuit_Data.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .noFluidOutputs().requiresCleanRoom().duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                            ItemList.Circuit_Parts_Coil.get(12L),
                            ItemList.Circuit_Parts_Capacitor.get(24),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 24))
                    .itemOutputs(ItemList.Circuit_Elite.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier * 2))
                    .noFluidOutputs().requiresCleanRoom().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(2L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(2L),
                            ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2))
                    .itemOutputs(ItemList.Circuit_Microprocessor.get(2L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(4L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(4L),
                            ItemList.Circuit_Parts_TransistorSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4))
                    .itemOutputs(ItemList.Circuit_Processor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Processor.get(2L),
                            ItemList.Circuit_Parts_Coil.get(4L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(8L),
                            ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8))
                    .itemOutputs(ItemList.Circuit_Computer.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .noFluidOutputs().requiresCleanRoom().duration(20 * SECONDS).eut(96)
                    .addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_ResistorASMD.get(4L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(1L),
                            ItemList.Circuit_Parts_TransistorASMD.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4))
                    .itemOutputs(ItemList.Circuit_Processor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(5 * SECONDS).eut(60).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Processor.get(2L),
                            ItemList.Circuit_Parts_InductorASMD.get(1L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(2L),
                            ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8))
                    .itemOutputs(ItemList.Circuit_Computer.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .noFluidOutputs().requiresCleanRoom().duration(10 * SECONDS).eut(96)
                    .addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Advanced.get(2L),
                            ItemList.Circuit_Parts_DiodeSMD.get(4L),
                            ItemList.Circuit_Chip_Ram.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16))
                    .itemOutputs(ItemList.Circuit_Data.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .noFluidOutputs().requiresCleanRoom().duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Advanced.get(2L),
                            ItemList.Circuit_Parts_DiodeASMD.get(1L),
                            ItemList.Circuit_Chip_Ram.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16))
                    .itemOutputs(ItemList.Circuit_Data.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .noFluidOutputs().requiresCleanRoom().duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                            ItemList.Circuit_Parts_Coil.get(12L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(16L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16))
                    .itemOutputs(ItemList.Circuit_Elite.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier * 2))
                    .noFluidOutputs().requiresCleanRoom().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                            ItemList.Circuit_Parts_InductorASMD.get(3L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(4L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16))
                    .itemOutputs(ItemList.Circuit_Elite.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier * 2))
                    .noFluidOutputs().requiresCleanRoom().duration(40 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(sCircuitAssemblerRecipes);
            // Nanotech Circuits

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Chip_NanoCPU.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(8L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(8L),
                            ItemList.Circuit_Parts_TransistorSMD.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8))
                    .itemOutputs(ItemList.Circuit_Nanoprocessor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(600).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Chip_NanoCPU.get(1L),
                            ItemList.Circuit_Parts_ResistorASMD.get(2L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(2L),
                            ItemList.Circuit_Parts_TransistorASMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8))
                    .itemOutputs(ItemList.Circuit_Nanoprocessor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(5 * SECONDS).eut(600).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanoprocessor.get(2L),
                            ItemList.Circuit_Parts_InductorSMD.get(8L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(8L),
                            ItemList.Circuit_Chip_Ram.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16))
                    .itemOutputs(ItemList.Circuit_Nanocomputer.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .noFluidOutputs().requiresCleanRoom().duration(20 * SECONDS).eut(600)
                    .addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanoprocessor.get(2L),
                            ItemList.Circuit_Parts_InductorASMD.get(2L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(2L),
                            ItemList.Circuit_Chip_Ram.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16))
                    .itemOutputs(ItemList.Circuit_Nanocomputer.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .noFluidOutputs().requiresCleanRoom().duration(10 * SECONDS).eut(600)
                    .addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanoprocessor.get(2L),
                            ItemList.Circuit_Chip_Ram.get(4L),
                            ItemList.Circuit_Chip_NOR.get(32L),
                            ItemList.Circuit_Chip_NAND.get(64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 32))
                    .itemOutputs(ItemList.Tool_DataOrb.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .noFluidOutputs().requiresCleanRoom().duration(20 * SECONDS).eut(1200)
                    .addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanocomputer.get(2L),
                            ItemList.Circuit_Parts_DiodeSMD.get(8L),
                            ItemList.Circuit_Chip_NOR.get(4L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16))
                    .itemOutputs(ItemList.Circuit_Elitenanocomputer.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier)).noFluidOutputs().requiresCleanRoom()
                    .duration(20 * SECONDS).eut(600).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanocomputer.get(2L),
                            ItemList.Circuit_Parts_DiodeASMD.get(2L),
                            ItemList.Circuit_Chip_NOR.get(4L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16))
                    .itemOutputs(ItemList.Circuit_Elitenanocomputer.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(600).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Elitenanocomputer.get(2L),
                            ItemList.Circuit_Parts_InductorSMD.get(16L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(32L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32))
                    .itemOutputs(ItemList.Circuit_Master.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier * 2))
                    .noFluidOutputs().requiresCleanRoom().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Elitenanocomputer.get(2L),
                            ItemList.Circuit_Parts_InductorASMD.get(4L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32))
                    .itemOutputs(ItemList.Circuit_Master.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier * 2))
                    .noFluidOutputs().requiresCleanRoom().duration(40 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(sCircuitAssemblerRecipes);
            // Quantum Circuits

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Chip_QuantumCPU.get(1L),
                            ItemList.Circuit_Chip_NanoCPU.get(1L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(12L),
                            ItemList.Circuit_Parts_TransistorSMD.get(12L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16))
                    .itemOutputs(ItemList.Circuit_Quantumprocessor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(2400).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Chip_QuantumCPU.get(1L),
                            ItemList.Circuit_Chip_NanoCPU.get(1L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(3L),
                            ItemList.Circuit_Parts_TransistorASMD.get(3L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16))
                    .itemOutputs(ItemList.Circuit_Quantumprocessor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(5 * SECONDS).eut(2400).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Quantumprocessor.get(2L),
                            ItemList.Circuit_Parts_InductorSMD.get(12L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(16L),
                            ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 24))
                    .itemOutputs(ItemList.Circuit_Quantumcomputer.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier)).noFluidOutputs().requiresCleanRoom()
                    .duration(20 * SECONDS).eut(2400).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Quantumprocessor.get(2L),
                            ItemList.Circuit_Parts_InductorASMD.get(3L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(4L),
                            ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 24))
                    .itemOutputs(ItemList.Circuit_Quantumcomputer.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(2400).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Quantumcomputer.get(2L),
                            ItemList.Circuit_Parts_DiodeSMD.get(8L),
                            ItemList.Circuit_Chip_NOR.get(4L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 48))
                    .itemOutputs(ItemList.Circuit_Masterquantumcomputer.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier)).noFluidOutputs().requiresCleanRoom()
                    .duration(20 * SECONDS).eut(2400).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Quantumcomputer.get(2L),
                            ItemList.Circuit_Parts_DiodeASMD.get(2L),
                            ItemList.Circuit_Chip_NOR.get(4L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 48))
                    .itemOutputs(ItemList.Circuit_Masterquantumcomputer.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier)).noFluidOutputs().requiresCleanRoom()
                    .duration(10 * SECONDS).eut(2400).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Masterquantumcomputer.get(2L),
                            ItemList.Circuit_Parts_InductorSMD.get(24),
                            ItemList.Circuit_Parts_CapacitorSMD.get(48L),
                            ItemList.Circuit_Chip_Ram.get(24),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48))
                    .itemOutputs(ItemList.Circuit_Quantummainframe.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier * 2)).noFluidOutputs().requiresCleanRoom()
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_IV).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Masterquantumcomputer.get(2L),
                            ItemList.Circuit_Parts_InductorASMD.get(6L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(12L),
                            ItemList.Circuit_Chip_Ram.get(24),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48))
                    .itemOutputs(ItemList.Circuit_Quantummainframe.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier * 2)).noFluidOutputs().requiresCleanRoom()
                    .duration(40 * SECONDS).eut(TierEU.RECIPE_IV).addTo(sCircuitAssemblerRecipes);
            // SoC

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_SoC.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Copper, 2))
                    .itemOutputs(ItemList.Circuit_Microprocessor.get(2L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(2 * SECONDS + 10 * TICKS).eut(600).addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_SoC.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 4))
                    .itemOutputs(ItemList.Circuit_Processor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().requiresCleanRoom()
                    .duration(2 * SECONDS + 10 * TICKS).eut(2400).addTo(sCircuitAssemblerRecipes);
            // Lapo orbs

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Chip_PIC.get(4L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(24L),
                            ItemList.Circuit_Chip_NanoCPU.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Platinum, 8))
                    .itemOutputs(ItemList.Energy_LapotronicOrb.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .noFluidOutputs().requiresCleanRoom().duration(25 * SECONDS + 12 * TICKS).eut(1024)
                    .addTo(sCircuitAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Chip_HPIC.get(4L),
                            ItemList.Energy_LapotronicOrb.get(8L),
                            ItemList.Circuit_Chip_QuantumCPU.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 16))
                    .itemOutputs(ItemList.Energy_LapotronicOrb2.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .noFluidOutputs().requiresCleanRoom().duration(51 * SECONDS + 4 * TICKS).eut(4096)
                    .addTo(sCircuitAssemblerRecipes);
            // Wetware Board

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Multifiberglass.get(16L),
                            ItemList.Circuit_Parts_PetriDish.get(1L),
                            ItemList.Electric_Pump_LuV.get(1L),
                            ItemList.Sensor_IV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 16L))
                    .itemOutputs(ItemList.Circuit_Board_Wetware.get(16L))
                    .fluidInputs(Materials.GrowthMediumSterilized.getFluid(4000L)).noFluidOutputs().requiresCleanRoom()
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(sCircuitAssemblerRecipes);
            // Bio Board

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Wetware.get(32L),
                            ItemList.Circuit_Parts_PetriDish.get(8L),
                            ItemList.Electric_Pump_UV.get(1L),
                            ItemList.Sensor_LuV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 32L))
                    .itemOutputs(ItemList.Circuit_Board_Bio.get(32L))
                    .fluidInputs(Materials.BioMediumSterilized.getFluid(16000L)).noFluidOutputs().requiresCleanRoom()
                    .duration(60 * SECONDS).eut(500000).addTo(sCircuitAssemblerRecipes);

            // PCBs Steve Carts
            if (StevesCarts2.isModLoaded()) {

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Coated_Basic.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 8),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 9))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_LV).addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                GT_ModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 2L, 9),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 16))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).noFluidOutputs().duration(20 * SECONDS)
                        .eut(TierEU.RECIPE_LV).addTo(sCircuitAssemblerRecipes);

            }

            if (OpenComputers.isModLoaded()) {
                // ALU

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_ILC.get(16L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 27))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(20 * SECONDS)
                        .eut(64).addTo(sCircuitAssemblerRecipes);
                // CU

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Parts_Transistor.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 28))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_LV).addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 28))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_LV).addTo(sCircuitAssemblerRecipes);
                // anylyser

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Tool_Scanner.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                ItemList.Circuit_Parts_Transistor.get(2L),
                                ItemList.Sensor_HV.get(1L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 0))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Tool_Scanner.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L),
                                ItemList.Sensor_HV.get(1L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 0))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);
                // CPU 1

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 8L, 27),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 29))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);
                // CPU 2

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 12L, 27),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 42))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);
                // CPU 3

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 16L, 27),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(3))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 43))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);
                // Graphics Card 1

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 8L, 27),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 28),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 1),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 8))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).noFluidOutputs().duration(20 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);
                // Graphics Card 2

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 16L, 27),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 28),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 2),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 9))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).noFluidOutputs().duration(20 * SECONDS)
                        .eut(256).addTo(sCircuitAssemblerRecipes);
                // Graphics Card 3

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 32L, 27),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 28),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 26),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 38),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 10))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).noFluidOutputs().duration(20 * SECONDS)
                        .eut(TierEU.RECIPE_HV).addTo(sCircuitAssemblerRecipes);
                // Internet Crad

                GT_Values.RA.stdBuilder().itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 13),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 48),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L),
                        GT_ModHandler
                                .getModItem(ProjectRedIllumination.ID, "projectred.illumination.lightbutton", 1L, 14),
                        GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 44))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).noFluidOutputs().duration(20 * SECONDS)
                        .eut(TierEU.RECIPE_HV).addTo(sCircuitAssemblerRecipes);
                // APU T1

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 32L, 27),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 101))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(256).addTo(sCircuitAssemblerRecipes);
                // APU T2

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 64L, 27),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 8L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(3))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 102))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_HV).addTo(sCircuitAssemblerRecipes);
                // EEPROM

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                                ItemList.Circuit_Parts_Transistor.get(6L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "eeprom", 1L, 0))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                                ItemList.Circuit_Parts_TransistorSMD.get(6L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "eeprom", 1L, 0))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);
                // RAM 1

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(16L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 1))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs()
                        .duration(12 * SECONDS + 10 * TICKS).eut(64).addTo(sCircuitAssemblerRecipes);
                // RAM 1.5

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(32L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 50))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs()
                        .duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);
                // RAM 2

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(64L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 2))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs()
                        .duration(12 * SECONDS + 10 * TICKS).eut(256).addTo(sCircuitAssemblerRecipes);
                // RAM 2.5

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(64L),
                                ItemList.Circuit_Chip_NAND.get(16L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 3))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs()
                        .duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(sCircuitAssemblerRecipes);
                // RAM 3

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(64L),
                                ItemList.Circuit_Chip_NAND.get(32L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 38))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs()
                        .duration(12 * SECONDS + 10 * TICKS).eut(1024).addTo(sCircuitAssemblerRecipes);
                // RAM 3.5

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(64L),
                                ItemList.Circuit_Chip_NAND.get(64L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 39))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs()
                        .duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV).addTo(sCircuitAssemblerRecipes);
                // Circuit 1

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                ItemList.Circuit_Parts_Transistor.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                ItemList.Circuit_Parts_TransistorSMD.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs()
                        .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);
                // Circuit 2

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                ItemList.Circuit_Parts_Transistor.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(15 * SECONDS)
                        .eut(256).addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                ItemList.Circuit_Parts_TransistorSMD.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(15 * SECONDS)
                        .eut(256).addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                ItemList.Circuit_Parts_TransistorASMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(3))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs()
                        .duration(7 * SECONDS + 10 * TICKS).eut(256).addTo(sCircuitAssemblerRecipes);
                // Circuit 3

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                ItemList.Circuit_Parts_Transistor.get(16L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_HV).addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                ItemList.Circuit_Parts_TransistorSMD.get(16L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_HV).addTo(sCircuitAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                ItemList.Circuit_Parts_TransistorASMD.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs()
                        .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(sCircuitAssemblerRecipes);
                // network card

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 11))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);
                // tps card

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Items.clock, 1),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 66),
                                ItemList.Emitter_HV.get(1L),
                                ItemList.Sensor_HV.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 117))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);
                // wlan card1

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 11),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                                ItemList.Emitter_LV.get(1L),
                                ItemList.Sensor_LV.get(1L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 113))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);
                // wlan card2

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 11),
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                                ItemList.Emitter_HV.get(1L),
                                ItemList.Sensor_HV.get(1L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 13))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(256).addTo(sCircuitAssemblerRecipes);
                // World sensor card

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.sensorLens", 2L, 0),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 89))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);
                // redstone card 1

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                                ItemList.Circuit_Chip_ILC.get(4L),
                                new ItemStack(Blocks.redstone_torch, 2),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 66))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);
                // redstone card 2

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                                ItemList.Circuit_Chip_ILC.get(16L),
                                new ItemStack(Blocks.redstone_torch, 4),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 12))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(10 * SECONDS)
                        .eut(256).addTo(sCircuitAssemblerRecipes);
                // data card 1

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 4, 27),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 104))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);
                // data card 2

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1, 29),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 105))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(15 * SECONDS)
                        .eut(156).addTo(sCircuitAssemblerRecipes);
                // data card 3

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1, 42),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 32L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 106))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs().duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_HV).addTo(sCircuitAssemblerRecipes);
                // component bus t1

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 70))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs()
                        .duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sCircuitAssemblerRecipes);
                // component bus t2

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 28),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 2),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 71))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs()
                        .duration(12 * SECONDS + 10 * TICKS).eut(256).addTo(sCircuitAssemblerRecipes);
                // component bus t3

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 8L, 28),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 38),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Diamond, 16),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 72))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).noFluidOutputs()
                        .duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(sCircuitAssemblerRecipes);

            }

        }

    }
}
