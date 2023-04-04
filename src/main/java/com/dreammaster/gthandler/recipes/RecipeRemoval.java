package com.dreammaster.gthandler.recipes;

import com.dreammaster.gthandler.CustomItemList;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.objects.GT_ItemStack;
import gregtech.api.util.GT_ModHandler;
import gregtech.common.tileentities.machines.basic.GT_MetaTileEntity_Disassembler;

import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.IndustrialCraft2;

public class RecipeRemoval implements Runnable {

    @Override
    public void run() {
        disassemblerBlacklist();

        if (IndustrialCraft2.isModLoaded()) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumHelmet", 1, GT_Values.W));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumBodyarmor", 1, GT_Values.W));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumLeggings", 1, GT_Values.W));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumBoots", 1, GT_Values.W));
        }
        if (GraviSuite.isModLoaded()) {
            GT_ModHandler
                    .removeRecipeByOutput(GT_ModHandler.getModItem(GraviSuite.ID, "graviChestPlate", 1, GT_Values.W));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(GraviSuite.ID, "relocator", 1, GT_Values.W));
        }
    }

    private void disassemblerBlacklist() {
        GT_MetaTileEntity_Disassembler.getBlackList()
                .add(new GT_ItemStack(CustomItemList.Automation_ChestBuffer_UEV.get(1L)));
        GT_MetaTileEntity_Disassembler.getBlackList()
                .add(new GT_ItemStack(CustomItemList.Automation_ChestBuffer_UIV.get(1L)));
        GT_MetaTileEntity_Disassembler.getBlackList()
                .add(new GT_ItemStack(CustomItemList.Automation_ChestBuffer_UMV.get(1L)));

        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.CircuitAssemblerMAX.get(1)));
        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.CircuitAssemblerUEV.get(1)));
        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.CircuitAssemblerUIV.get(1)));
        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.CircuitAssemblerUMV.get(1)));
        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.CircuitAssemblerUXV.get(1)));

        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.Hull_UEV.get(1)));
        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.Hull_UIV.get(1)));
        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.Hull_UMV.get(1)));
        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.Hull_UXV.get(1)));

        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.Hull_UEV.get(1)));
        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.Hull_UIV.get(1)));
        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.Hull_UMV.get(1)));
        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.Hull_UXV.get(1)));
        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.Hull_MAXV.get(1)));

        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.Casing_UEV.get(1)));
        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.Casing_UIV.get(1)));
        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.Casing_UMV.get(1)));
        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.Casing_UXV.get(1)));
        GT_MetaTileEntity_Disassembler.getBlackList().add(new GT_ItemStack(CustomItemList.Casing_MAXV.get(1)));
    }

}
