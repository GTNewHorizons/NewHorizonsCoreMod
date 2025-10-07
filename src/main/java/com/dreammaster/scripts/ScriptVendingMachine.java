package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.VendingMachine;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import gregtech.api.GregTechAPI;

@SuppressWarnings("deprecation")
public class ScriptVendingMachine implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Vending Machine";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(VendingMachine.ID, AppliedEnergistics2.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(VendingMachine.ID, "multimachine.vendingmachine", 1, 0, missing),
                getModItem(Minecraft.ID, "dispenser", 1, 0),
                "craftingToolWrench",
                getModItem(Minecraft.ID, "dispenser", 1, 0),
                getModItem(Minecraft.ID, "stone_button", 1, 0),
                new ItemStack(GregTechAPI.sBlockCasings11, 1, 0),
                getModItem(Minecraft.ID, "stone_button", 1, 0),
                "cableGt01Tin",
                getModItem(Minecraft.ID, "chest", 1),
                "cableGt01Tin");
        addShapelessRecipe(
                getModItem(VendingMachine.ID, "hatch.vendinguplink.me", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1, 0, missing),
                getModItem(Minecraft.ID, "dispenser", 1, 0));
    }
}
