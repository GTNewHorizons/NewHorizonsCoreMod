package com.dreammaster.gthandler.recipes;

import static bartworks.API.recipe.BartWorksRecipeMaps.circuitAssemblyLineRecipes;
import static gregtech.api.enums.GTValues.RA;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.EIGHTH_INGOTS;
import static gregtech.api.util.GTRecipeBuilder.HALF_INGOTS;
import static gregtech.api.util.GTRecipeBuilder.INGOTS;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gtPlusPlus.core.material.MaterialMisc.MUTATED_LIVING_SOLDER;
import static gtPlusPlus.core.material.MaterialsAlloy.INDALLOY_140;
import static gtPlusPlus.core.material.MaterialsElements.STANDALONE.CHRONOMATIC_GLASS;

import com.dreammaster.gthandler.GT_Loader_Items;
import com.dreammaster.item.NHItemList;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

public class CircuitAssemblyLineRecipes implements Runnable {

    public void run() {
        // Integrated Logic Circuit
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_CircuitBoards.get(1),
                        ItemList.Wrap_IntegratedLogicCircuits.get(1),
                        ItemList.Wrap_SMDResistors.get(2),
                        ItemList.Wrap_SMDDiodes.get(2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Copper, 2),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 32))
                .itemOutputs(ItemList.Circuit_Basic.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_IntegratedLogicCircuit.get(0)).eut(16).duration(2 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Good Integrated Circuit
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_GoodCircuitBoards.get(1),
                        ItemList.Circuit_Basic.get(32),
                        ItemList.Wrap_AdvancedSMDResistors.get(1),
                        ItemList.Wrap_AdvancedSMDDiodes.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Gold, 4),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 64))
                .itemOutputs(ItemList.Circuit_Integrated_Good.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_GoodIntegratedCircuit.get(0)).eut(24).duration(2 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_GoodCircuitBoards.get(1),
                        ItemList.Circuit_Basic.get(32),
                        ItemList.Wrap_SMDResistors.get(4),
                        ItemList.Wrap_SMDDiodes.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Gold, 4),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 64))
                .itemOutputs(ItemList.Circuit_Integrated_Good.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_GoodIntegratedCircuit.get(0)).eut(24).duration(4 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // ModLoader check because the Imprint is not set if Forestry is not loaded, preventing map creation in dev env
        // without forestry
        if (Forestry.isModLoaded()) {
            // Basic Circuit Board
            RA.stdBuilder()
                    .itemInputs(
                            ItemList.Wrap_CircuitBoards.get(1),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 32),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.Iron, 32),
                            GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 64),
                            GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Iron, 1)
                    )
                    .itemOutputs(getModItem(Forestry.ID, "chipsets", 16, 0))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(4 * INGOTS))
                    .special(ItemList.CircuitImprint_BasicCircuitBoard.get(0)).eut(TierEU.RECIPE_LV).duration(2 * MINUTES)
                    .requireMods(Forestry).addTo(circuitAssemblyLineRecipes);

            // Enhanced Circuit Board
            RA.stdBuilder()
                    .itemInputs(
                            ItemList.Wrap_CircuitBoards.get(1),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 32),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.Bronze, 32),
                            GTOreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 64),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Bronze, 16)
                    )
                    .itemOutputs(getModItem(Forestry.ID, "chipsets", 16, 1))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(4 * INGOTS))
                    .special(ItemList.CircuitImprint_EnhancedCircuitBoard.get(0)).eut(TierEU.RECIPE_LV)
                    .duration(2 * MINUTES).requireMods(Forestry).addTo(circuitAssemblyLineRecipes);

            // Refined Circuit Board
            RA.stdBuilder()
                    .itemInputs(
                            ItemList.Wrap_GoodCircuitBoards.get(1),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 32),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.Steel, 32),
                            GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 64),
                            GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Steel, 1)
                    )
                    .itemOutputs(getModItem(Forestry.ID, "chipsets", 16, 2))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(4 * INGOTS))
                    .special(ItemList.CircuitImprint_RefinedCircuitBoard.get(0)).eut(TierEU.RECIPE_LV).duration(2 * MINUTES)
                    .requireMods(Forestry).addTo(circuitAssemblyLineRecipes);

            // Intricate Circuit Board
            RA.stdBuilder()
                    .itemInputs(
                            ItemList.Wrap_GoodCircuitBoards.get(1),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 32),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 32),
                            GTOreDictUnificator.get(OrePrefixes.screw, Materials.Electrum, 64),
                            GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 1)
                    )
                    .itemOutputs(getModItem(Forestry.ID, "chipsets", 16, 3))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(4 * INGOTS))
                    .special(ItemList.CircuitImprint_IntricateCircuitBoard.get(0)).eut(TierEU.RECIPE_LV)
                    .duration(2 * MINUTES).requireMods(Forestry).addTo(circuitAssemblyLineRecipes);
        }

        // ModLoader check because the Imprint is not set if Railcract is not loaded, preventing map creation in dev env
        // without Railcraft

        if (Railcraft.isModLoaded()) {
            // Controller Circuit
            RA.stdBuilder()
                    .itemInputs(
                            ItemList.Wrap_CircuitBoards.get(1),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 16),
                            ItemList.Cover_Controller.get(16)
                    ).itemOutputs(GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 0))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                    .special(ItemList.CircuitImprint_ControllerCircuit.get(0)).eut(TierEU.RECIPE_LV).duration(3 * MINUTES)
                    .requireMods(Railcraft).addTo(circuitAssemblyLineRecipes);

            // Receiver Circuit
            RA.stdBuilder()
                    .itemInputs(
                            ItemList.Wrap_CircuitBoards.get(1),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 16),
                            ItemList.Sensor_LV.get(16)
                    ).itemOutputs(GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 1))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                    .special(ItemList.CircuitImprint_ReceiverCircuit.get(0)).eut(TierEU.RECIPE_LV).duration(3 * MINUTES)
                    .requireMods(Railcraft).addTo(circuitAssemblyLineRecipes);

            // Signal Circuit
            RA.stdBuilder()
                    .itemInputs(
                            ItemList.Wrap_CircuitBoards.get(1),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 16),
                            GTModHandler.getModItem(Railcraft.ID, "part.signal.lamp", 16)
                    ).itemOutputs(GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 2))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                    .special(ItemList.CircuitImprint_SignalCircuit.get(0)).eut(TierEU.RECIPE_LV).duration(3 * MINUTES)
                    .requireMods(Railcraft).addTo(circuitAssemblyLineRecipes);

            // Controller Circuit
            RA.stdBuilder()
                    .itemInputs(
                            ItemList.Wrap_GoodCircuitBoards.get(1),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 16),
                            ItemList.Cover_Controller.get(16)
                    )
                    .itemOutputs(
                            GTUtility.copyAmountUnsafe(128, GTModHandler.getModItem(Railcraft.ID, "part.circuit", 1, 0)))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                    .special(ItemList.CircuitImprint_ControllerCircuit.get(0)).eut(TierEU.RECIPE_LV).duration(4 * MINUTES)
                    .requireMods(Railcraft).addTo(circuitAssemblyLineRecipes);

            // Receiver Circuit
            RA.stdBuilder()
                    .itemInputs(
                            ItemList.Wrap_GoodCircuitBoards.get(1),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 16),
                            ItemList.Sensor_LV.get(16)
                    )
                    .itemOutputs(
                            GTUtility.copyAmountUnsafe(128, GTModHandler.getModItem(Railcraft.ID, "part.circuit", 1, 1)))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                    .special(ItemList.CircuitImprint_ReceiverCircuit.get(0)).eut(TierEU.RECIPE_LV).duration(4 * MINUTES)
                    .requireMods(Railcraft).addTo(circuitAssemblyLineRecipes);

            // Signal Circuit
            RA.stdBuilder()
                    .itemInputs(
                            ItemList.Wrap_GoodCircuitBoards.get(1),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 16),
                            GTModHandler.getModItem(Railcraft.ID, "part.signal.lamp", 16))
                    .itemOutputs(
                            GTUtility.copyAmountUnsafe(128, GTModHandler.getModItem(Railcraft.ID, "part.circuit", 1, 2)))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                    .special(ItemList.CircuitImprint_SignalCircuit.get(0)).eut(TierEU.RECIPE_LV).duration(4 * MINUTES)
                    .requireMods(Railcraft).addTo(circuitAssemblyLineRecipes);

            // Controller Circuit
            RA.stdBuilder()
                    .itemInputs(
                            ItemList.Wrap_AdvancedCircuitBoards.get(1),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 16),
                            ItemList.Cover_Controller.get(16)
                    )
                    .itemOutputs(
                            GTUtility.copyAmountUnsafe(256, GTModHandler.getModItem(Railcraft.ID, "part.circuit", 1, 0)))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                    .special(ItemList.CircuitImprint_ControllerCircuit.get(0)).eut(TierEU.RECIPE_LV).duration(5 * MINUTES)
                    .requireMods(Railcraft).addTo(circuitAssemblyLineRecipes);

            // Receiver Circuit
            RA.stdBuilder()
                    .itemInputs(
                            ItemList.Wrap_AdvancedCircuitBoards.get(1),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 16),
                            ItemList.Sensor_LV.get(16)
                    )
                    .itemOutputs(
                            GTUtility.copyAmountUnsafe(256, GTModHandler.getModItem(Railcraft.ID, "part.circuit", 1, 1)))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                    .special(ItemList.CircuitImprint_ReceiverCircuit.get(0)).eut(TierEU.RECIPE_LV).duration(5 * MINUTES)
                    .requireMods(Railcraft).addTo(circuitAssemblyLineRecipes);

            // Signal Circuit
            RA.stdBuilder()
                    .itemInputs(
                            ItemList.Wrap_AdvancedCircuitBoards.get(1),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 16),
                            GTModHandler.getModItem(Railcraft.ID, "part.signal.lamp", 16))
                    .itemOutputs(
                            GTUtility.copyAmountUnsafe(256, GTModHandler.getModItem(Railcraft.ID, "part.circuit", 1, 2)))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                    .special(ItemList.CircuitImprint_SignalCircuit.get(0)).eut(TierEU.RECIPE_LV).duration(5 * MINUTES)
                    .requireMods(Railcraft).addTo(circuitAssemblyLineRecipes);
        }

        // Good Electronic Circuit
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_GoodCircuitBoards.get(1),
                        GTModHandler.getModItem(IndustrialCraft2.ID, "itemPartCircuit", 32, 0),
                        ItemList.Wrap_SMDDiodes.get(2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.Copper, 2))
                .itemOutputs(ItemList.Circuit_Good.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_GoodElectronicCircuit.get(0)).eut(TierEU.RECIPE_LV)
                .duration(3 * MINUTES).requireMods(IndustrialCraft2).addTo(circuitAssemblyLineRecipes);

        // Integrated Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_PlasticCircuitBoards2.get(1),
                        ItemList.Wrap_CentralProcessingUnits.get(1),
                        ItemList.Wrap_AdvancedSMDResistors.get(1),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(1),
                        ItemList.Wrap_AdvancedSMDTransistors.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.RedAlloy, 4))
                .itemOutputs(ItemList.Circuit_Processor.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_IntegratedProcessor.get(0)).eut(60).duration(1 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Microprocessor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_PlasticCircuitBoards2.get(1),
                        ItemList.Wrap_CentralProcessingUnits.get(1),
                        ItemList.Wrap_SMDResistors.get(2),
                        ItemList.Wrap_SMDCapacitors.get(2),
                        ItemList.Wrap_SMDTransistors.get(2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Copper, 2))
                .itemOutputs(ItemList.Circuit_Microprocessor.get(32))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_Microprocessor.get(0)).eut(60).duration(2 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Integrated Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_PlasticCircuitBoards2.get(1),
                        ItemList.Wrap_CentralProcessingUnits.get(1),
                        ItemList.Wrap_SMDResistors.get(4),
                        ItemList.Wrap_SMDCapacitors.get(4),
                        ItemList.Wrap_SMDTransistors.get(4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.RedAlloy, 4))
                .itemOutputs(ItemList.Circuit_Processor.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_IntegratedProcessor.get(0)).eut(60).duration(2 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Processor Assembly
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_PlasticCircuitBoards2.get(1),
                        ItemList.Circuit_Processor.get(32),
                        ItemList.Wrap_AdvancedSMDInductors.get(1),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(2),
                        ItemList.Wrap_RandomAccessMemoryChips.get(4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.RedAlloy, 8))
                .itemOutputs(ItemList.Circuit_Advanced.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * INGOTS))
                .special(ItemList.CircuitImprint_ProcessorAssembly.get(0)).eut(96).duration(2 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // NAND Chip Array
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_GoodCircuitBoards.get(1),
                        ItemList.Wrap_SimpleSOCs.get(1),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.AnnealedCopper, 1)
                ).itemOutputs(GTUtility.copyAmount(16, GT_Loader_Items.NandChipBoard))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * EIGHTH_INGOTS))
                .special(ItemList.CircuitImprint_NANDChipArray.get(0)).eut(TierEU.RECIPE_MV)
                .duration(1 * MINUTES + 30 * SECONDS).addTo(circuitAssemblyLineRecipes);

        // Workstation
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_PlasticCircuitBoards2.get(1),
                        ItemList.Circuit_Advanced.get(32),
                        ItemList.Wrap_AdvancedSMDDiodes.get(1),
                        ItemList.Wrap_RandomAccessMemoryChips.get(8),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 16),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.BlueAlloy, 64)
                ).itemOutputs(ItemList.Circuit_Data.get(16)).fluidInputs(Materials.SolderingAlloy.getMolten(1 * INGOTS))
                .special(ItemList.CircuitImprint_Workstation.get(0)).eut(TierEU.RECIPE_MV).duration(2 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // NAND Chip Array
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_GoodCircuitBoards.get(1),
                        ItemList.Wrap_SimpleSOCs.get(1),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Copper, 1)
                ).itemOutputs(GTUtility.copyAmount(16, GT_Loader_Items.NandChipBoard))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * EIGHTH_INGOTS))
                .special(ItemList.CircuitImprint_NANDChipArray.get(0)).eut(TierEU.RECIPE_MV).duration(3 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Processor Assembly
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_PlasticCircuitBoards2.get(1),
                        ItemList.Circuit_Processor.get(32),
                        ItemList.Wrap_SMDInductors.get(4),
                        ItemList.Wrap_SMDCapacitors.get(8),
                        ItemList.Wrap_RandomAccessMemoryChips.get(4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.RedAlloy, 8))
                .itemOutputs(ItemList.Circuit_Advanced.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * INGOTS))
                .special(ItemList.CircuitImprint_ProcessorAssembly.get(0)).eut(TierEU.RECIPE_MV).duration(4 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Workstation
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_PlasticCircuitBoards2.get(1),
                        ItemList.Circuit_Advanced.get(32),
                        ItemList.Wrap_SMDDiodes.get(4),
                        ItemList.Wrap_RandomAccessMemoryChips.get(8),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 16),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.BlueAlloy, 64)
                ).itemOutputs(ItemList.Circuit_Data.get(16)).fluidInputs(Materials.SolderingAlloy.getMolten(1 * INGOTS))
                .special(ItemList.CircuitImprint_Workstation.get(0)).eut(TierEU.RECIPE_MV).duration(4 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // NAND Chip Array
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_PlasticCircuitBoards2.get(1),
                        ItemList.Wrap_SimpleSOCs.get(2),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.AnnealedCopper, 4))
                .itemOutputs(ItemList.NandChip.get(32))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * EIGHTH_INGOTS))
                .special(ItemList.CircuitImprint_NANDChipArray.get(0)).eut(TierEU.RECIPE_HV)
                .duration(1 * MINUTES + 30 * SECONDS).addTo(circuitAssemblyLineRecipes);

        // NAND Chip Array
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_PlasticCircuitBoards2.get(1),
                        ItemList.Wrap_SimpleSOCs.get(2),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.AnnealedCopper, 4))
                .itemOutputs(ItemList.NandChip.get(32))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * EIGHTH_INGOTS))
                .special(ItemList.CircuitImprint_NANDChipArray.get(0)).eut(TierEU.RECIPE_HV).duration(3 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Mainframe
        RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 32),
                        ItemList.Circuit_Data.get(32),
                        ItemList.Wrap_AdvancedSMDInductors.get(3),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(4),
                        ItemList.Wrap_RandomAccessMemoryChips.get(16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.AnnealedCopper, 16))
                .itemOutputs(ItemList.Circuit_Elite.get(16)).fluidInputs(Materials.SolderingAlloy.getMolten(2 * INGOTS))
                .special(ItemList.CircuitImprint_Mainframe.get(0)).eut(TierEU.RECIPE_HV).duration(8 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Mainframe
        RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 32),
                        ItemList.Circuit_Data.get(32),
                        ItemList.Wrap_SMDInductors.get(12),
                        ItemList.Wrap_SMDCapacitors.get(24),
                        ItemList.Wrap_RandomAccessMemoryChips.get(16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.AnnealedCopper, 24))
                .itemOutputs(ItemList.Circuit_Elite.get(16)).fluidInputs(Materials.SolderingAlloy.getMolten(2 * INGOTS))
                .special(ItemList.CircuitImprint_Mainframe.get(0)).eut(TierEU.RECIPE_HV).duration(8 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Microprocessor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_PlasticCircuitBoards2.get(1),
                        ItemList.Wrap_SoCs.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Copper, 2),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Copper, 32))
                .itemOutputs(ItemList.Circuit_Microprocessor.get(32))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_Microprocessor.get(0)).eut(600).duration(30 * SECONDS)
                .addTo(circuitAssemblyLineRecipes);

        // Nano Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_AdvancedCircuitBoards.get(1),
                        ItemList.Wrap_NanocomponentCentralProcessingUnits.get(1),
                        ItemList.Wrap_AdvancedSMDResistors.get(2),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(2),
                        ItemList.Wrap_AdvancedSMDTransistors.get(2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 8))
                .itemOutputs(ItemList.Circuit_Nanoprocessor.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_NanoProcessor.get(0)).eut(600).duration(1 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Nano Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_AdvancedCircuitBoards.get(1),
                        ItemList.Wrap_NanocomponentCentralProcessingUnits.get(1),
                        ItemList.Wrap_SMDResistors.get(8),
                        ItemList.Wrap_SMDCapacitors.get(8),
                        ItemList.Wrap_SMDTransistors.get(8),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 8))
                .itemOutputs(ItemList.Circuit_Nanoprocessor.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_NanoProcessor.get(0)).eut(600).duration(2 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Nano Assembly
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_AdvancedCircuitBoards.get(1),
                        ItemList.Circuit_Nanoprocessor.get(32),
                        ItemList.Wrap_AdvancedSMDInductors.get(2),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(2),
                        ItemList.Wrap_RandomAccessMemoryChips.get(8),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 16))
                .itemOutputs(ItemList.Circuit_Nanocomputer.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * INGOTS))
                .special(ItemList.CircuitImprint_NanoAssembly.get(0)).eut(600).duration(2 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Nano Supercomputer
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_AdvancedCircuitBoards.get(1),
                        ItemList.Circuit_Nanocomputer.get(32),
                        ItemList.Wrap_AdvancedSMDDiodes.get(2),
                        ItemList.Wrap_NORMemoryChips.get(4),
                        ItemList.Wrap_RandomAccessMemoryChips.get(16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 16))
                .itemOutputs(ItemList.Circuit_Elitenanocomputer.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * INGOTS))
                .special(ItemList.CircuitImprint_NanoSupercomputer.get(0)).eut(600).duration(2 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Nano Assembly
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_AdvancedCircuitBoards.get(1),
                        ItemList.Circuit_Nanoprocessor.get(32),
                        ItemList.Wrap_SMDInductors.get(8),
                        ItemList.Wrap_SMDCapacitors.get(8),
                        ItemList.Wrap_RandomAccessMemoryChips.get(8),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 16))
                .itemOutputs(ItemList.Circuit_Nanocomputer.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * INGOTS))
                .special(ItemList.CircuitImprint_NanoAssembly.get(0)).eut(600).duration(4 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Nano Supercomputer
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_AdvancedCircuitBoards.get(1),
                        ItemList.Circuit_Nanocomputer.get(32),
                        ItemList.Wrap_SMDDiodes.get(8),
                        ItemList.Wrap_NORMemoryChips.get(4),
                        ItemList.Wrap_RandomAccessMemoryChips.get(16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 16))
                .itemOutputs(ItemList.Circuit_Elitenanocomputer.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * INGOTS))
                .special(ItemList.CircuitImprint_NanoSupercomputer.get(0)).eut(600).duration(4 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // NAND Chip Array
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_AdvancedCircuitBoards.get(1),
                        ItemList.Wrap_SimpleSOCs.get(4),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.AnnealedCopper, 4))
                .itemOutputs(GTUtility.copyAmount(64, GT_Loader_Items.NandChipBoard))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * EIGHTH_INGOTS))
                .special(ItemList.CircuitImprint_NANDChipArray.get(0)).eut(TierEU.RECIPE_EV)
                .duration(1 * MINUTES + 30 * SECONDS).addTo(circuitAssemblyLineRecipes);

        // NAND Chip Array
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_AdvancedCircuitBoards.get(1),
                        ItemList.Wrap_SimpleSOCs.get(4),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Copper, 4))
                .itemOutputs(GTUtility.copyAmount(64, GT_Loader_Items.NandChipBoard))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * EIGHTH_INGOTS))
                .special(ItemList.CircuitImprint_NANDChipArray.get(0)).eut(TierEU.RECIPE_EV).duration(3 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Nano Mainframe
        RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 32),
                        ItemList.Circuit_Elitenanocomputer.get(32),
                        ItemList.Wrap_AdvancedSMDInductors.get(4),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(8),
                        ItemList.Wrap_RandomAccessMemoryChips.get(16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.AnnealedCopper, 32))
                .itemOutputs(ItemList.Circuit_Master.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(2 * INGOTS))
                .special(ItemList.CircuitImprint_NanoMainframe.get(0)).eut(TierEU.RECIPE_EV).duration(8 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Nano Mainframe
        RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 32),
                        ItemList.Circuit_Elitenanocomputer.get(32),
                        ItemList.Wrap_SMDInductors.get(16),
                        ItemList.Wrap_SMDCapacitors.get(32),
                        ItemList.Wrap_RandomAccessMemoryChips.get(16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.AnnealedCopper, 32))
                .itemOutputs(ItemList.Circuit_Master.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(2 * INGOTS))
                .special(ItemList.CircuitImprint_NanoMainframe.get(0)).eut(TierEU.RECIPE_EV).duration(16 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Integrated Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_PlasticCircuitBoards2.get(1),
                        ItemList.Wrap_SoCs.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.RedAlloy, 4),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 64))
                .itemOutputs(ItemList.Circuit_Processor.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_IntegratedProcessor.get(0)).eut(2400).duration(30 * SECONDS)
                .addTo(circuitAssemblyLineRecipes);

        // Quantum Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_MoreAdvancedCircuitBoards.get(1),
                        ItemList.Wrap_QBitProcessingUnits.get(1),
                        ItemList.Wrap_NanocomponentCentralProcessingUnits.get(1),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(3),
                        ItemList.Wrap_AdvancedSMDTransistors.get(3),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Platinum, 16))
                .itemOutputs(ItemList.Circuit_Quantumprocessor.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_QuantumProcessor.get(0)).eut(2400).duration(1 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Quantum Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_MoreAdvancedCircuitBoards.get(1),
                        ItemList.Wrap_QBitProcessingUnits.get(1),
                        ItemList.Wrap_NanocomponentCentralProcessingUnits.get(1),
                        ItemList.Wrap_SMDCapacitors.get(12),
                        ItemList.Wrap_SMDTransistors.get(12),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Platinum, 16))
                .itemOutputs(ItemList.Circuit_Quantumprocessor.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_QuantumProcessor.get(0)).eut(2400).duration(2 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Quantum Assembly
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_MoreAdvancedCircuitBoards.get(1),
                        ItemList.Circuit_Quantumprocessor.get(32),
                        ItemList.Wrap_AdvancedSMDInductors.get(3),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(4),
                        ItemList.Wrap_RandomAccessMemoryChips.get(4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Platinum, 24))
                .itemOutputs(ItemList.Circuit_Quantumcomputer.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * INGOTS))
                .special(ItemList.CircuitImprint_QuantumAssembly.get(1)).eut(2400).duration(2 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Quantum Supercomputer
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_MoreAdvancedCircuitBoards.get(1),
                        ItemList.Circuit_Quantumcomputer.get(32),
                        ItemList.Wrap_AdvancedSMDDiodes.get(2),
                        ItemList.Wrap_NORMemoryChips.get(4),
                        ItemList.Wrap_RandomAccessMemoryChips.get(16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Platinum, 48))
                .itemOutputs(ItemList.Circuit_Masterquantumcomputer.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * INGOTS))
                .special(ItemList.CircuitImprint_QuantumSupercomputer.get(1)).eut(2400).duration(2 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Quantum Assembly
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_MoreAdvancedCircuitBoards.get(1),
                        ItemList.Circuit_Quantumprocessor.get(32),
                        ItemList.Wrap_SMDInductors.get(12),
                        ItemList.Wrap_SMDCapacitors.get(16),
                        ItemList.Wrap_RandomAccessMemoryChips.get(4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Platinum, 24))
                .itemOutputs(ItemList.Circuit_Quantumcomputer.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * INGOTS))
                .special(ItemList.CircuitImprint_QuantumAssembly.get(1)).eut(2400).duration(4 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Quantum Supercomputer
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_MoreAdvancedCircuitBoards.get(1),
                        ItemList.Circuit_Quantumcomputer.get(32),
                        ItemList.Wrap_SMDDiodes.get(8),
                        ItemList.Wrap_NORMemoryChips.get(4),
                        ItemList.Wrap_RandomAccessMemoryChips.get(16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Platinum, 48))
                .itemOutputs(ItemList.Circuit_Masterquantumcomputer.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1 * INGOTS))
                .special(ItemList.CircuitImprint_QuantumSupercomputer.get(1)).eut(2400).duration(4 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Quantum Mainframe
        RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 32),
                        ItemList.Circuit_Masterquantumcomputer.get(32),
                        ItemList.Wrap_AdvancedSMDInductors.get(6),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(12),
                        ItemList.Wrap_RandomAccessMemoryChips.get(24),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.AnnealedCopper, 48))
                .itemOutputs(ItemList.Circuit_Quantummainframe.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(2 * INGOTS))
                .special(ItemList.CircuitImprint_QuantumMainframe.get(0)).eut(TierEU.RECIPE_IV).duration(8 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Quantum Mainframe
        RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 32),
                        ItemList.Circuit_Masterquantumcomputer.get(32),
                        ItemList.Wrap_SMDInductors.get(24),
                        ItemList.Wrap_SMDCapacitors.get(48),
                        ItemList.Wrap_RandomAccessMemoryChips.get(24),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.AnnealedCopper, 48))
                .itemOutputs(ItemList.Circuit_Quantummainframe.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(2 * INGOTS))
                .special(ItemList.CircuitImprint_QuantumMainframe.get(0)).eut(TierEU.RECIPE_IV).duration(16 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // High Energy Flow Circuit
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_EliteCircuitBoards.get(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ZPM, 32),
                        ItemList.Wrap_UltraHighPowerICs.get(4),
                        ItemList.Wrap_QBitProcessingUnits.get(2),
                        ItemList.Wrap_NanocomponentCentralProcessingUnits.get(2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorZPM, 64))
                .itemOutputs(NHItemList.HighEnergyFlowCircuit.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(2 * INGOTS))
                .special(ItemList.CircuitImprint_HighEnergyFlowCircuit.get(0)).eut(TierEU.RECIPE_IV)
                .duration(24 * MINUTES).addTo(circuitAssemblyLineRecipes);

        // Nano Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_AdvancedCircuitBoards.get(1),
                        ItemList.Wrap_ASoCs.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 8),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 64))
                .itemOutputs(ItemList.Circuit_Nanoprocessor.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_NanoProcessor.get(0)).eut(9600).duration(30 * SECONDS)
                .addTo(circuitAssemblyLineRecipes);

        // Continuer a la page 27

        // Crystal Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_EliteCircuitBoards.get(1),
                        ItemList.Wrap_CrystalProcessingUnits.get(1),
                        ItemList.Wrap_NanocomponentCentralProcessingUnits.get(2),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(6),
                        ItemList.Wrap_AdvancedSMDTransistors.get(6),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.NiobiumTitanium, 8))
                .itemOutputs(ItemList.Circuit_Crystalprocessor.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_CrystalProcessor.get(0)).eut(9600).duration(1 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Crystal Assembly
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_EliteCircuitBoards.get(1),
                        ItemList.Circuit_Crystalprocessor.get(16),
                        ItemList.Wrap_AdvancedSMDInductors.get(6),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(8),
                        ItemList.Wrap_RandomAccessMemoryChips.get(24),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.NiobiumTitanium, 16))
                .itemOutputs(ItemList.Circuit_Crystalcomputer.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * INGOTS))
                .special(ItemList.CircuitImprint_CrystalAssembly.get(0)).eut(9600).duration(2 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Crystal Supercomputer
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_EliteCircuitBoards.get(1),
                        ItemList.Circuit_Crystalcomputer.get(32),
                        ItemList.Wrap_RandomAccessMemoryChips.get(4),
                        ItemList.Wrap_NORMemoryChips.get(32),
                        ItemList.Wrap_NANDMemoryChips.get(64),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.NiobiumTitanium, 32))
                .itemOutputs(ItemList.Circuit_Ultimatecrystalcomputer.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * INGOTS))
                .special(ItemList.CircuitImprint_CrystalSupercomputer.get(0)).eut(9_600).duration(4 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Crystal Mainframe
        RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 32),
                        ItemList.Circuit_Ultimatecrystalcomputer.get(32),
                        ItemList.Wrap_AdvancedSMDInductors.get(8),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(16),
                        ItemList.Wrap_RandomAccessMemoryChips.get(32),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorLuV, 16))
                .itemOutputs(ItemList.Circuit_Crystalmainframe.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(2 * INGOTS))
                .special(ItemList.CircuitImprint_CrystalMainframe.get(0)).eut(TierEU.RECIPE_LuV).duration(8 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Quantum Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_MoreAdvancedCircuitBoards.get(1),
                        ItemList.Wrap_ASoCs.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Platinum, 16),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.NiobiumTitanium, 64))
                .itemOutputs(ItemList.Circuit_Quantumprocessor.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_QuantumProcessor.get(0)).eut(38_400).duration(30 * SECONDS)
                .addTo(circuitAssemblyLineRecipes);

        // Wetware Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_NeuroProcessingUnits.get(1),
                        ItemList.Wrap_CrystalProcessingUnits.get(1),
                        ItemList.Wrap_NanocomponentCentralProcessingUnits.get(1),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(8),
                        ItemList.Wrap_AdvancedSMDTransistors.get(8),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.YttriumBariumCuprate, 8))
                .itemOutputs(ItemList.Circuit_Neuroprocessor.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_WetwareProcessor.get(0)).eut(38_400).duration(2 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Wetware Assembly
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_ExtremeWetwareLifesupportCircuitBoards.get(1),
                        ItemList.Circuit_Neuroprocessor.get(32),
                        ItemList.Wrap_AdvancedSMDInductors.get(8),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(12),
                        ItemList.Wrap_RandomAccessMemoryChips.get(24),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.YttriumBariumCuprate, 16))
                .itemOutputs(ItemList.Circuit_Wetwarecomputer.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * INGOTS))
                .special(ItemList.CircuitImprint_WetwareAssembly.get(0)).eut(38_400).duration(3 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Wetware Supercomputer
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_ExtremeWetwareLifesupportCircuitBoards.get(2),
                        ItemList.Circuit_Wetwarecomputer.get(32),
                        ItemList.Wrap_AdvancedSMDDiodes.get(8),
                        ItemList.Wrap_NORMemoryChips.get(16),
                        ItemList.Wrap_RandomAccessMemoryChips.get(64),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.YttriumBariumCuprate, 24))
                .itemOutputs(ItemList.Circuit_Wetwaresupercomputer.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * INGOTS))
                .special(ItemList.CircuitImprint_WetwareSupercomputer.get(0)).eut(38_400).duration(6 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Wetware Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_NeuroProcessingUnits.get(1),
                        ItemList.Wrap_CrystalProcessingUnits.get(1),
                        ItemList.Wrap_NanocomponentCentralProcessingUnits.get(1),
                        ItemList.Wrap_OpticalSMDCapacitors.get(2),
                        ItemList.Wrap_OpticalSMDTransistors.get(2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.YttriumBariumCuprate, 8))
                .itemOutputs(ItemList.Circuit_Neuroprocessor.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_WetwareProcessor.get(0)).eut(153_600).duration(15 * SECONDS)
                .addTo(circuitAssemblyLineRecipes);

        // Wetware Assembly
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_ExtremeWetwareLifesupportCircuitBoards.get(1),
                        ItemList.Circuit_Neuroprocessor.get(32),
                        ItemList.Wrap_OpticalSMDInductors.get(2),
                        ItemList.Wrap_OpticalSMDCapacitors.get(3),
                        ItemList.Wrap_RandomAccessMemoryChips.get(24),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.YttriumBariumCuprate, 16))
                .itemOutputs(ItemList.Circuit_Wetwarecomputer.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * INGOTS))
                .special(ItemList.CircuitImprint_WetwareAssembly.get(0)).eut(153_600).duration(22 * SECONDS + 4 * TICKS)
                .addTo(circuitAssemblyLineRecipes);

        // Crystal Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_EliteCircuitBoards.get(1),
                        ItemList.Wrap_CrystalSoCs.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.NiobiumTitanium, 8),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.YttriumBariumCuprate, 64))
                .itemOutputs(ItemList.Circuit_Crystalprocessor.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_CrystalProcessor.get(0)).eut(153_600).duration(30 * SECONDS)
                .addTo(circuitAssemblyLineRecipes);

        // Wetware Supercomputer
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_ExtremeWetwareLifesupportCircuitBoards.get(2),
                        ItemList.Circuit_Wetwarecomputer.get(32),
                        ItemList.Wrap_OpticalSMDDiodes.get(2),
                        ItemList.Wrap_NORMemoryChips.get(16),
                        ItemList.Wrap_RandomAccessMemoryChips.get(64),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.YttriumBariumCuprate, 24))
                .itemOutputs(ItemList.Circuit_Wetwaresupercomputer.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * INGOTS))
                .special(ItemList.CircuitImprint_WetwareSupercomputer.get(0)).eut(153_600).duration(45 * SECONDS)
                .addTo(circuitAssemblyLineRecipes);

        // Bioware Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_BioProcessingUnits.get(1),
                        ItemList.Wrap_RawAdvancedCrystalChips.get(1),
                        ItemList.Wrap_NanocomponentCentralProcessingUnits.get(2),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(12),
                        ItemList.Wrap_AdvancedSMDTransistors.get(12),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.NiobiumTitanium, 16))
                .itemOutputs(ItemList.Circuit_Bioprocessor.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_BiowareProcessor.get(0)).eut(153_600).duration(3 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Bioware Assembly
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_UltraBioMutatedCircuitBoards.get(1),
                        ItemList.Circuit_Bioprocessor.get(32),
                        ItemList.Wrap_AdvancedSMDInductors.get(12),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(16),
                        ItemList.Wrap_RandomAccessMemoryChips.get(32),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.NiobiumTitanium, 24))
                .itemOutputs(ItemList.Circuit_Biowarecomputer.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * INGOTS))
                .special(ItemList.CircuitImprint_BiowareAssembly.get(0)).eut(153_600).duration(4 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Bioware Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_BioProcessingUnits.get(1),
                        ItemList.Wrap_RawAdvancedCrystalChips.get(1),
                        ItemList.Wrap_NanocomponentCentralProcessingUnits.get(2),
                        ItemList.Wrap_OpticalSMDCapacitors.get(3),
                        ItemList.Wrap_OpticalSMDTransistors.get(3),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.NiobiumTitanium, 16))
                .itemOutputs(ItemList.Circuit_Bioprocessor.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * HALF_INGOTS))
                .special(ItemList.CircuitImprint_BiowareProcessor.get(0)).eut(614_400)
                .duration(22 * SECONDS + 4 * TICKS).addTo(circuitAssemblyLineRecipes);

        // Wetware Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_ExtremeWetwareLifesupportCircuitBoards.get(1),
                        ItemList.Wrap_LivingCrystalChips.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.YttriumBariumCuprate, 8),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.CosmicNeutronium, 64))
                .itemOutputs(ItemList.Circuit_Neuroprocessor.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * INGOTS))
                .special(ItemList.CircuitImprint_WetwareProcessor.get(0)).eut(614_400).duration(30 * SECONDS)
                .addTo(circuitAssemblyLineRecipes);

        // Bioware Assembly
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_UltraBioMutatedCircuitBoards.get(1),
                        ItemList.Circuit_Bioprocessor.get(32),
                        ItemList.Wrap_OpticalSMDInductors.get(3),
                        ItemList.Wrap_OpticalSMDCapacitors.get(4),
                        ItemList.Wrap_RandomAccessMemoryChips.get(32),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.NiobiumTitanium, 24))
                .itemOutputs(ItemList.Circuit_Biowarecomputer.get(16))
                .fluidInputs(INDALLOY_140.getFluidStack(1 * INGOTS))
                .special(ItemList.CircuitImprint_BiowareAssembly.get(0)).eut(614_400).duration(30 * SECONDS)
                .addTo(circuitAssemblyLineRecipes);

        // Optical Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_OpticallyPerfectedCPUs.get(1),
                        ItemList.Wrap_OpticallyCompatibleMemories.get(2),
                        ItemList.Wrap_OpticalSMDCapacitors.get(16),
                        ItemList.Wrap_OpticalSMDDiodes.get(16),
                        tectech.thing.CustomItemList.DATApipe.get(64),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.EnrichedHolmium, 64))
                .itemOutputs(ItemList.Circuit_OpticalProcessor.get(16))
                .fluidInputs(MUTATED_LIVING_SOLDER.getFluidStack(2 * INGOTS))
                .special(ItemList.CircuitImprint_OpticalProcessor.get(0)).eut(614_400).duration(4 * MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Bioware Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_UltraBioMutatedCircuitBoards.get(1),
                        ItemList.Wrap_LivingBioChips.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.NiobiumTitanium, 16),
                        CHRONOMATIC_GLASS.getBolt(64))
                .itemOutputs(ItemList.Circuit_Bioprocessor.get(16))
                .fluidInputs(MUTATED_LIVING_SOLDER.getFluidStack(1 * INGOTS))
                .special(ItemList.CircuitImprint_BiowareProcessor.get(0)).eut(2_457_600).duration(45 * SECONDS)
                .addTo(circuitAssemblyLineRecipes);
    }
}
