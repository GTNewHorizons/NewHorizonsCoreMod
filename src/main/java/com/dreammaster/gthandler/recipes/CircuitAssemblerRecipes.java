package com.dreammaster.gthandler.recipes;

import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.CustomItemList;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class CircuitAssemblerRecipes implements Runnable {

    @Override
    public void run() {

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
}
