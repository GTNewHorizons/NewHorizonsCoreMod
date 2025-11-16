package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.VendingMachine;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.cubefury.vendingmachine.items.VMItems;

import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;

public class ScriptVendingMachine implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Vending Machine";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(AppliedEnergistics2.ID, VendingMachine.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                VMItems.vendingMachine,
                getModItem(Minecraft.ID, "stone_button", 1, 0),
                "craftingToolWrench",
                getModItem(Minecraft.ID, "stone_button", 1, 0),
                "plateIron",
                new ItemStack(GregTechAPI.sBlockCasings11, 1, 0),
                "plateIron",
                null,
                getModItem(Minecraft.ID, "hopper", 1),
                null);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1, 0, missing),
                        getModItem(Minecraft.ID, "dispenser", 1, 0))
                .duration(5 * SECONDS).itemOutputs(VMItems.uplinkHatch).eut(120).addTo(assemblerRecipes);
    }
}
