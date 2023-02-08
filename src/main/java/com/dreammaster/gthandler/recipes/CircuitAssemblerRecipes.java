package com.dreammaster.gthandler.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class CircuitAssemblerRecipes implements Runnable {

    // put the soldering Materials in this array
    public final Materials[] solderingMaterials = new Materials[] { Materials.Lead, Materials.SolderingAlloy,
            Materials.Tin };

    public final ItemStack[] RocketMaterial = new ItemStack[] {
            GT_ModHandler.getModItem("GalacticraftCore", "item.heavyPlating", 1L),
            GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 3),
            GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L),
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

        // Crystal Circuits
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        ItemList.Circuit_Chip_CrystalCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(2L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(6), ItemList.Circuit_Parts_TransistorASMD.get(6),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8) },
                new FluidStack(solderIndalloy, 72),
                ItemList.Circuit_Crystalprocessor.get(1L),
                100,
                9600,
                true);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        ItemList.Circuit_Crystalprocessor.get(2L), ItemList.Circuit_Parts_InductorASMD.get(6L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(8L), ItemList.Circuit_Chip_Ram.get(24),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16) },
                new

                FluidStack(solderIndalloy, 144),
                ItemList.Circuit_Crystalcomputer.get(1L),
                200,
                9600,
                true);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        ItemList.Circuit_Crystalcomputer.get(2L), ItemList.Circuit_Chip_Ram.get(4L),
                        ItemList.Circuit_Chip_NOR.get(32L), ItemList.Circuit_Chip_NAND.get(64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 32) },
                new

                FluidStack(solderIndalloy, 144),
                ItemList.Circuit_Ultimatecrystalcomputer.get(1L),
                400,
                9600,
                true);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                        ItemList.Circuit_Ultimatecrystalcomputer.get(2L), ItemList.Circuit_Parts_InductorASMD.get(8L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(16L), ItemList.Circuit_Chip_Ram.get(32L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 16) },
                new

                FluidStack(solderIndalloy, 288),
                ItemList.Circuit_Crystalmainframe.get(1L),
                800,
                30720,
                true);

        // Wetware Circuits
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Chip_NeuroCPU.get(1L), ItemList.Circuit_Chip_CrystalCPU.get(1L),
                        ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                        ItemList.Circuit_Parts_TransistorASMD.get(8L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8) },
                new

                FluidStack(solderIndalloy, 72),
                ItemList.Circuit_Neuroprocessor.get(1L),
                200,
                38400,
                true);
        // Wetware SoC recipe
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Board_Wetware_Extreme.get(1),
                        Circuit_Parts_Crystal_Chip_Wetware.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CosmicNeutronium, 8) },
                new

                FluidStack(solderIndalloy, 144),
                ItemList.Circuit_Neuroprocessor.get(1L),
                3 * 20,
                614400,
                true);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Chip_NeuroCPU.get(1L), ItemList.Circuit_Chip_CrystalCPU.get(1L),
                        ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_CapacitorXSMD.get(2L),
                        ItemList.Circuit_Parts_TransistorXSMD.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8) },
                new

                FluidStack(solderIndalloy, 72),
                ItemList.Circuit_Neuroprocessor.get(1L),
                25,
                153600,
                true);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                        ItemList.Circuit_Neuroprocessor.get(2L), ItemList.Circuit_Parts_InductorASMD.get(8L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(12L), ItemList.Circuit_Chip_Ram.get(24L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 16) },
                new

                FluidStack(solderIndalloy, 144),
                ItemList.Circuit_Wetwarecomputer.get(1L),
                300,
                38400,
                true);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                        ItemList.Circuit_Neuroprocessor.get(2L), ItemList.Circuit_Parts_InductorXSMD.get(2L),
                        ItemList.Circuit_Parts_CapacitorXSMD.get(3L), ItemList.Circuit_Chip_Ram.get(24L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 16) },
                new

                FluidStack(solderIndalloy, 144),
                ItemList.Circuit_Wetwarecomputer.get(1L),
                37,
                153600,
                true);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Board_Wetware_Extreme.get(2L),
                        ItemList.Circuit_Wetwarecomputer.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(8L),
                        ItemList.Circuit_Chip_NOR.get(16L), ItemList.Circuit_Chip_Ram.get(64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 24) },
                new

                FluidStack(solderIndalloy, 144),
                ItemList.Circuit_Wetwaresupercomputer.get(1L),
                600,
                38400,
                true);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Board_Wetware_Extreme.get(2L),
                        ItemList.Circuit_Wetwarecomputer.get(2L), ItemList.Circuit_Parts_DiodeXSMD.get(2L),
                        ItemList.Circuit_Chip_NOR.get(16L), ItemList.Circuit_Chip_Ram.get(64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 24) },
                new

                FluidStack(solderIndalloy, 144),
                ItemList.Circuit_Wetwaresupercomputer.get(1L),
                75,
                153600,
                true);

        // Bio Circuits
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Chip_BioCPU.get(1L), ItemList.Circuit_Chip_CrystalSoC2.get(1L),
                        ItemList.Circuit_Chip_NanoCPU.get(2L), ItemList.Circuit_Parts_CapacitorASMD.get(12L),
                        ItemList.Circuit_Parts_TransistorASMD.get(12L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16) },
                new

                FluidStack(solderIndalloy, 72),
                ItemList.Circuit_Bioprocessor.get(1L),
                300,
                153600,
                true);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Chip_BioCPU.get(1L), ItemList.Circuit_Chip_CrystalSoC2.get(1L),
                        ItemList.Circuit_Chip_NanoCPU.get(2L), ItemList.Circuit_Parts_CapacitorXSMD.get(3L),
                        ItemList.Circuit_Parts_TransistorXSMD.get(3L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16) },
                new

                FluidStack(solderIndalloy, 72),
                ItemList.Circuit_Bioprocessor.get(1L),
                37,
                614400,
                true);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Board_Bio_Ultra.get(1L), ItemList.Circuit_Bioprocessor.get(2L),
                        ItemList.Circuit_Parts_InductorASMD.get(12L), ItemList.Circuit_Parts_CapacitorASMD.get(16L),
                        ItemList.Circuit_Chip_Ram.get(32L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 24) },
                new

                FluidStack(solderIndalloy, 144),
                ItemList.Circuit_Biowarecomputer.get(1L),
                400,
                153600,
                true);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Board_Bio_Ultra.get(1L), ItemList.Circuit_Bioprocessor.get(2L),
                        ItemList.Circuit_Parts_InductorXSMD.get(3L), ItemList.Circuit_Parts_CapacitorXSMD.get(4L),
                        ItemList.Circuit_Chip_Ram.get(32L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 24) },
                new

                FluidStack(solderIndalloy, 144),
                ItemList.Circuit_Biowarecomputer.get(1L),
                50,
                614400,
                true);

        // Energy Flow Circuit
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 2),
                        ItemList.Circuit_Chip_UHPIC.get(4L), ItemList.Circuit_Chip_QuantumCPU.get(2L),
                        ItemList.Circuit_Chip_NanoCPU.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 64) },
                new

                FluidStack(solderIndalloy, 288),
                CustomItemList.HighEnergyFlowCircuit.get(1L),
                2400,
                7680,
                true);

        // SoC for nano, quantum, crystal
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Chip_SoC2.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 8) },
                new

                FluidStack(solderIndalloy, 72),
                ItemList.Circuit_Nanoprocessor.get(1L),
                50,
                9600,
                true);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                        ItemList.Circuit_Chip_SoC2.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.NiobiumTitanium, 8) },
                new

                FluidStack(solderIndalloy, 72),
                ItemList.Circuit_Quantumprocessor.get(1L),
                50,
                38400,
                true);
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        ItemList.Circuit_Chip_CrystalSoC.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.YttriumBariumCuprate, 8) },
                new

                FluidStack(solderIndalloy, 72),
                ItemList.Circuit_Crystalprocessor.get(1L),
                50,
                153600,
                true);

        if (Loader.isModLoaded("bartworks")) {

            Fluid solderUEV = FluidRegistry.getFluid("molten.mutatedlivingsolder") != null
                    ? FluidRegistry.getFluid("molten.mutatedlivingsolder")
                    : FluidRegistry.getFluid("molten.solderingalloy");

            // Optically Perfected CPU
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Chip_Optical.get(1L),
                            ItemList.Optical_Cpu_Containment_Housing.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Infinity, 16L) },
                    new FluidStack(solderUEV, 288),
                    ItemList.Optically_Perfected_CPU.get(1L),
                    20 * 20,
                    1_966_080,
                    true);
        }

        if (Loader.isModLoaded("appliedenergistics2")) {
            // 1k ME Storage Component
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 2),
                            CustomItemList.ChargedCertusQuartzDust.get(2),
                            CustomItemList.LogicProcessorItemGoldCore.get(1), ItemList.Circuit_Board_Basic.get(1),
                            GT_Utility.getIntegratedCircuit(1) },
                    Materials.Lead.getMolten(288),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 35),
                    200,
                    30,
                    false);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 2),
                            CustomItemList.ChargedCertusQuartzDust.get(2),
                            CustomItemList.LogicProcessorItemGoldCore.get(1), ItemList.Circuit_Board_Basic.get(1),
                            GT_Utility.getIntegratedCircuit(1) },
                    Materials.Tin.getMolten(144),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 35),
                    200,
                    30,
                    false);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 2),
                            CustomItemList.ChargedCertusQuartzDust.get(2),
                            CustomItemList.LogicProcessorItemGoldCore.get(1), ItemList.Circuit_Board_Basic.get(1),
                            GT_Utility.getIntegratedCircuit(1) },
                    Materials.SolderingAlloy.getMolten(72),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 35),
                    200,
                    30,
                    false);

            // 4k ME Storage Component
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 16),
                            CustomItemList.LogicProcessorItemGoldCore.get(1),
                            ItemList.Circuit_Board_Coated_Basic.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.Lead.getMolten(288),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 36),
                    200,
                    30,
                    true);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 16),
                            CustomItemList.LogicProcessorItemGoldCore.get(1),
                            ItemList.Circuit_Board_Coated_Basic.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.Tin.getMolten(144),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 36),
                    200,
                    30,
                    true);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 16),
                            CustomItemList.LogicProcessorItemGoldCore.get(1),
                            ItemList.Circuit_Board_Coated_Basic.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.SolderingAlloy.getMolten(72),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 36),
                    200,
                    30,
                    true);

            // 16k ME Storage Component
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Phenolic_Good.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.Lead.getMolten(288),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 37),
                    200,
                    120,
                    true);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Phenolic_Good.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.Tin.getMolten(144),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 37),
                    200,
                    120,
                    true);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Phenolic_Good.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.SolderingAlloy.getMolten(72),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 37),
                    200,
                    120,
                    true);

            // 64k ME Storage Component
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.Lead.getMolten(288),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 38),
                    200,
                    480,
                    true);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.Tin.getMolten(144),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 38),
                    200,
                    480,
                    true);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.SolderingAlloy.getMolten(72),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 38),
                    200,
                    480,
                    true);
        }
    }

    public void solderingMaterials() {
        for (Materials tMat : solderingMaterials) {
            int tMultiplier = tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD) ? 1
                    : tMat.contains(SubTag.SOLDERING_MATERIAL_BAD) ? 4 : 2;

            // Rocket Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Quantumprocessor.get(1L), RocketMaterial[0],
                            GT_Utility.getIntegratedCircuit(1) },
                    tMat.getMolten(576L * tMultiplier / 2L),
                    RocketChip[0],
                    9000,
                    480,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Data.get(1L), RocketMaterial[0],
                            GT_Utility.getIntegratedCircuit(1) },
                    tMat.getMolten(576L * tMultiplier / 2L),
                    RocketChip[0],
                    9000,
                    480,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Nanocomputer.get(1L), RocketMaterial[0],
                            GT_Utility.getIntegratedCircuit(1) },
                    tMat.getMolten(576L * tMultiplier / 2L),
                    RocketChip[0],
                    9000,
                    480,
                    true);

            for (int i = 2; i < 9; ++i) {
                ItemStack DataStickWScheme = ItemList.Tool_DataStick.get(1L);
                DataStickWScheme.setTagCompound(
                        GT_Utility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", (short) i));
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { RocketMaterial[(i - 1)], ItemList.Circuit_Elite.get(1L),
                                DataStickWScheme.splitStack(0) },
                        tMat.getMolten(576L * tMultiplier / 2L),
                        RocketChip[(i - 1)],
                        9000,
                        EUperRecipe[(i - 2)],
                        true);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { RocketMaterial[(i - 1)], ItemList.Circuit_Elitenanocomputer.get(1L),
                                DataStickWScheme.splitStack(0) },
                        tMat.getMolten(576L * tMultiplier / 2L),
                        RocketChip[(i - 1)],
                        9000,
                        EUperRecipe[(i - 2)],
                        true);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { RocketMaterial[(i - 1)], ItemList.Circuit_Quantumcomputer.get(1L),
                                DataStickWScheme.splitStack(0) },
                        tMat.getMolten(576L * tMultiplier / 2L),
                        RocketChip[(i - 1)],
                        9000,
                        EUperRecipe[(i - 2)],
                        true);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { RocketMaterial[(i - 1)], ItemList.Circuit_Crystalprocessor.get(1L),
                                DataStickWScheme.splitStack(0) },
                        tMat.getMolten(576L * tMultiplier / 2L),
                        RocketChip[(i - 1)],
                        9000,
                        EUperRecipe[(i - 2)],
                        true);
            }

            for (byte i = 0; i < 3; ++i) {
                ItemStack DataStickWScheme = ItemList.Tool_DataStick.get(1L);
                DataStickWScheme.setTagCompound(
                        GT_Utility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", (short) (i + 100)));
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { RocketMaterial[i], ItemList.Circuit_Quantumprocessor.get(1L),
                                DataStickWScheme.splitStack(0) },
                        tMat.getMolten(576L * tMultiplier / 2L),
                        ExtraChips[i],
                        9000,
                        EUperRecipe[i],
                        true);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { RocketMaterial[i], ItemList.Circuit_Data.get(1L),
                                DataStickWScheme.splitStack(0) },
                        tMat.getMolten(576L * tMultiplier / 2L),
                        ExtraChips[i],
                        9000,
                        EUperRecipe[i],
                        true);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { RocketMaterial[i], ItemList.Circuit_Nanocomputer.get(1L),
                                DataStickWScheme.splitStack(0) },
                        tMat.getMolten(576L * tMultiplier / 2L),
                        ExtraChips[i],
                        9000,
                        EUperRecipe[i],
                        true);
            }
            // Primitive Circuit
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 1) },
                    tMat.getMolten(36L * tMultiplier / 2L),
                    CustomItemList.NandChipBoard.get(1),
                    300,
                    120);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 1) },
                    tMat.getMolten(36L * tMultiplier / 2L),
                    CustomItemList.NandChipBoard.get(1),
                    150,
                    120);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 1) },
                    tMat.getMolten(36L * tMultiplier / 2L),
                    CustomItemList.NandChipBoard.get(2),
                    300,
                    480);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 1) },
                    tMat.getMolten(36L * tMultiplier / 2L),
                    CustomItemList.NandChipBoard.get(2),
                    150,
                    480);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 1) },
                    tMat.getMolten(36L * tMultiplier / 2L),
                    CustomItemList.NandChipBoard.get(4),
                    300,
                    1920);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 1) },
                    tMat.getMolten(36L * tMultiplier / 2L),
                    CustomItemList.NandChipBoard.get(4),
                    150,
                    1920);

            // Basic Circuit
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2),
                            ItemList.Circuit_Parts_Vacuum_Tube.get(2L) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L, 0),
                    200,
                    16);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2),
                            ItemList.Circuit_Parts_Vacuum_Tube.get(2L) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L, 0),
                    200,
                    16);

            // Good Circuit
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0),
                            ItemList.Circuit_Parts_Diode.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Good.get(1L),
                    300,
                    30);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0),
                            ItemList.Circuit_Parts_DiodeSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Good.get(1L),
                    300,
                    30);

            // Integraded Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_Diode.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Basic.get(1L),
                    200,
                    16);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_Diode.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Basic.get(1L),
                    200,
                    16);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Basic.get(1L),
                    200,
                    16);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Basic.get(1L),
                    200,
                    16);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_Diode.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Integrated_Good.get(1L),
                    400,
                    24);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_Diode.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Integrated_Good.get(1L),
                    400,
                    24);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_DiodeSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Integrated_Good.get(1L),
                    400,
                    24);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_ResistorASMD.get(1L), ItemList.Circuit_Parts_DiodeASMD.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Integrated_Good.get(1L),
                    200,
                    24);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_DiodeSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Integrated_Good.get(1L),
                    400,
                    24);

            // Advanced circuit
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(2L),
                            ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_Transistor.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    GT_ModHandler.getIC2Item("advancedCircuit", 1L),
                    800,
                    30,
                    false);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(2L),
                            ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    GT_ModHandler.getIC2Item("advancedCircuit", 1L),
                    800,
                    30,
                    false);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(2L),
                            ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_TransistorASMD.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    GT_ModHandler.getIC2Item("advancedCircuit", 1L),
                    400,
                    30,
                    false);

            // Integrated Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L),
                            ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_Transistor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L),
                            ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_Transistor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_Transistor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L),
                            ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_Transistor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L),
                            ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    200,
                    60,
                    true);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_Transistor.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_Transistor.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(1L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(1L), ItemList.Circuit_Parts_TransistorASMD.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    100,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_Transistor.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_Transistor.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Processor.get(2L), ItemList.Circuit_Parts_Coil.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(8L), ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Computer.get(1L),
                    400,
                    120,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(2L), ItemList.Circuit_Chip_NAND.get(32L),
                            ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 16),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Tool_DataStick.get(1L),
                    400,
                    90,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Advanced.get(2L), ItemList.Circuit_Parts_Diode.get(4L),
                            ItemList.Circuit_Chip_Ram.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Data.get(1L),
                    400,
                    120,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                            ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_Capacitor.get(24),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 24) },
                    tMat.getMolten(144L * tMultiplier * 2),
                    ItemList.Circuit_Elite.get(1L),
                    1600,
                    480,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Processor.get(2L), ItemList.Circuit_Parts_Coil.get(4L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Computer.get(1L),
                    400,
                    96,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(4L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(1L), ItemList.Circuit_Parts_TransistorASMD.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    100,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Processor.get(2L), ItemList.Circuit_Parts_InductorASMD.get(1L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(2L), ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Computer.get(1L),
                    200,
                    96,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Advanced.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(4L),
                            ItemList.Circuit_Chip_Ram.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Data.get(1L),
                    400,
                    120,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Advanced.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(1L),
                            ItemList.Circuit_Chip_Ram.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Data.get(1L),
                    200,
                    120,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                            ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_CapacitorSMD.get(16L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16) },
                    tMat.getMolten(144L * tMultiplier * 2),
                    ItemList.Circuit_Elite.get(1L),
                    1600,
                    480,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                            ItemList.Circuit_Parts_InductorASMD.get(3L), ItemList.Circuit_Parts_CapacitorASMD.get(4L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16) },
                    tMat.getMolten(144L * tMultiplier * 2),
                    ItemList.Circuit_Elite.get(1L),
                    800,
                    480,
                    true);

            // Nanotech Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(8L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Parts_TransistorSMD.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Nanoprocessor.get(1L),
                    200,
                    600,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(2L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(2L), ItemList.Circuit_Parts_TransistorASMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Nanoprocessor.get(1L),
                    100,
                    600,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanoprocessor.get(2L), ItemList.Circuit_Parts_InductorSMD.get(8L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Chip_Ram.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Nanocomputer.get(1L),
                    400,
                    600,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanoprocessor.get(2L), ItemList.Circuit_Parts_InductorASMD.get(2L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(2L), ItemList.Circuit_Chip_Ram.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Nanocomputer.get(1L),
                    200,
                    600,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanoprocessor.get(2L), ItemList.Circuit_Chip_Ram.get(4L),
                            ItemList.Circuit_Chip_NOR.get(32L), ItemList.Circuit_Chip_NAND.get(64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 32) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Tool_DataOrb.get(1L),
                    400,
                    1200,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanocomputer.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(8L),
                            ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Elitenanocomputer.get(1L),
                    400,
                    600,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanocomputer.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(2L),
                            ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Elitenanocomputer.get(1L),
                    200,
                    600,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Elitenanocomputer.get(2L), ItemList.Circuit_Parts_InductorSMD.get(16L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(32L), ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32) },
                    tMat.getMolten(144L * tMultiplier * 2),
                    ItemList.Circuit_Master.get(1L),
                    1600,
                    1920,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Elitenanocomputer.get(2L), ItemList.Circuit_Parts_InductorASMD.get(4L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(8L), ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32) },
                    tMat.getMolten(144L * tMultiplier * 2),
                    ItemList.Circuit_Master.get(1L),
                    800,
                    1920,
                    true);

            // Quantum Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Chip_QuantumCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(12L), ItemList.Circuit_Parts_TransistorSMD.get(12L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Quantumprocessor.get(1L),
                    200,
                    2400,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Chip_QuantumCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(3L), ItemList.Circuit_Parts_TransistorASMD.get(3L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Quantumprocessor.get(1L),
                    100,
                    2400,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Quantumprocessor.get(2L), ItemList.Circuit_Parts_InductorSMD.get(12L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(16L), ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 24) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Quantumcomputer.get(1L),
                    400,
                    2400,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Quantumprocessor.get(2L), ItemList.Circuit_Parts_InductorASMD.get(3L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(4L), ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 24) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Quantumcomputer.get(1L),
                    200,
                    2400,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Quantumcomputer.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(8L),
                            ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 48) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Masterquantumcomputer.get(1L),
                    400,
                    2400,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Quantumcomputer.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(2L),
                            ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 48) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Masterquantumcomputer.get(1L),
                    200,
                    2400,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Masterquantumcomputer.get(2L), ItemList.Circuit_Parts_InductorSMD.get(24),
                            ItemList.Circuit_Parts_CapacitorSMD.get(48L), ItemList.Circuit_Chip_Ram.get(24),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48) },
                    tMat.getMolten(144L * tMultiplier * 2),
                    ItemList.Circuit_Quantummainframe.get(1L),
                    1600,
                    7680,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Masterquantumcomputer.get(2L), ItemList.Circuit_Parts_InductorASMD.get(6L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(12L), ItemList.Circuit_Chip_Ram.get(24),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48) },
                    tMat.getMolten(144L * tMultiplier * 2),
                    ItemList.Circuit_Quantummainframe.get(1L),
                    800,
                    7680,
                    true);

            // SoC
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_SoC.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    50,
                    600,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_SoC.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    50,
                    2400,
                    true);

            // Lapo orbs
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Chip_PIC.get(4L), ItemList.Circuit_Parts_Crystal_Chip_Master.get(24L),
                            ItemList.Circuit_Chip_NanoCPU.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Platinum, 8) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Energy_LapotronicOrb.get(1L),
                    512,
                    1024,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Chip_HPIC.get(4L), ItemList.Energy_LapotronicOrb.get(8L),
                            ItemList.Circuit_Chip_QuantumCPU.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 16) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Energy_LapotronicOrb2.get(1L),
                    1024,
                    4096,
                    true);

            // Wetware Board
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Multifiberglass.get(16L),
                            ItemList.Circuit_Parts_PetriDish.get(1L), ItemList.Electric_Pump_LuV.get(1L),
                            ItemList.Sensor_IV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 16L) },
                    Materials.GrowthMediumSterilized.getFluid(4000L),
                    ItemList.Circuit_Board_Wetware.get(16L),
                    1200,
                    30720,
                    true);

            // Bio Board
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Wetware.get(32L), ItemList.Circuit_Parts_PetriDish.get(8L),
                            ItemList.Electric_Pump_UV.get(1L), ItemList.Sensor_LuV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 32L) },
                    Materials.BioMediumSterilized.getFluid(16000L),
                    ItemList.Circuit_Board_Bio.get(32L),
                    1200,
                    500000,
                    true);

            // PCBs Steve Carts
            if (Loader.isModLoaded("StevesCarts")) {
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 8),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 9),
                        200,
                        30);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 2L, 9),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 16),
                        400,
                        30);
            }

            if (Loader.isModLoaded("OpenComputers")) {
                // ALU
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_ILC.get(16L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 2L, 27),
                        400,
                        64);
                // CU
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Parts_Transistor.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                        200,
                        30);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                        200,
                        30);
                // anylyser
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Tool_Scanner.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                ItemList.Circuit_Parts_Transistor.get(2L), ItemList.Sensor_HV.get(1L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0),
                        300,
                        120);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Tool_Scanner.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L), ItemList.Sensor_HV.get(1L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0),
                        300,
                        120);
                // CPU 1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 8L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 29),
                        200,
                        120);
                // CPU 2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 12L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 42),
                        200,
                        120);
                // CPU 3
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 16L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(3) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 43),
                        200,
                        120);
                // Graphics Card 1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 8L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 8),
                        400,
                        120);
                // Graphics Card 2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 16L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 9),
                        400,
                        256);
                // Graphics Card 3
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 32L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 26),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 10),
                        400,
                        480);
                // Internet Crad
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L),
                                GT_ModHandler.getModItem(
                                        "ProjRed|Illumination",
                                        "projectred.illumination.lightbutton",
                                        1L,
                                        14),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 44),
                        400,
                        480);
                // APU T1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 32L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 101),
                        200,
                        256);
                // APU T2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 64L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 8L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(3) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 102),
                        200,
                        480);
                // EEPROM
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                ItemList.Circuit_Parts_Transistor.get(6L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0),
                        200,
                        120);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                ItemList.Circuit_Parts_TransistorSMD.get(6L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0),
                        200,
                        120);

                // RAM 1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(16L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1),
                        250,
                        64);
                // RAM 1.5
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(32L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 50),
                        250,
                        120);
                // RAM 2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(64L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2),
                        250,
                        256);
                // RAM 2.5
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NAND.get(16L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 3),
                        250,
                        480);
                // RAM 3
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NAND.get(32L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38),
                        250,
                        1024);
                // RAM 3.5
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NAND.get(64L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 39),
                        250,
                        1920);
                // Circuit 1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                ItemList.Circuit_Parts_Transistor.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                        300,
                        120);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                ItemList.Circuit_Parts_TransistorSMD.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                        300,
                        120);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                        150,
                        120);
                // Circuit 2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                ItemList.Circuit_Parts_Transistor.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                        300,
                        256);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                ItemList.Circuit_Parts_TransistorSMD.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                        300,
                        256);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                ItemList.Circuit_Parts_TransistorASMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(3) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                        150,
                        256);
                // Circuit 3
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                ItemList.Circuit_Parts_Transistor.get(16L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                        300,
                        480);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                ItemList.Circuit_Parts_TransistorSMD.get(16L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                        300,
                        480);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                ItemList.Circuit_Parts_TransistorASMD.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                        150,
                        480);
                // network card
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11),
                        200,
                        120);

                // tps card
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { new ItemStack(Items.clock, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66), ItemList.Emitter_HV.get(1L),
                                ItemList.Sensor_HV.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 117),
                        200,
                        120);

                // wlan card1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), ItemList.Emitter_LV.get(1L),
                                ItemList.Sensor_LV.get(1L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 113),
                        200,
                        120);
                // wlan card2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11),
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), ItemList.Emitter_HV.get(1L),
                                ItemList.Sensor_HV.get(1L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13),
                        200,
                        256);
                // World sensor card
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("GalacticraftCore", "item.sensorLens", 2L, 0),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 89),
                        200,
                        120);
                // redstone card 1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0),
                                ItemList.Circuit_Chip_ILC.get(4L), new ItemStack(Blocks.redstone_torch, 2),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66),
                        200,
                        120);
                // redstone card 2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0),
                                ItemList.Circuit_Chip_ILC.get(16L), new ItemStack(Blocks.redstone_torch, 4),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 12),
                        200,
                        256);
                // data card 1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4, 27),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 104),
                        300,
                        120);
                // data card 2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1, 29),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 105),
                        300,
                        156);
                // data card 3
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1, 42),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 32L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 106),
                        300,
                        480);

                // component bus t1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 70),
                        250,
                        120);
                // component bus t2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 71),
                        250,
                        256);
                // component bus t3
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                GT_ModHandler.getModItem("OpenComputers", "item", 8L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Diamond, 16),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 72),
                        250,
                        480);
            }

        }

    }
}
