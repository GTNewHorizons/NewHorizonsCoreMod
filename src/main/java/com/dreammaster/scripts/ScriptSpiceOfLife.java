package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.SpiceOfLife;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ScriptSpiceOfLife implements IScriptLoader {

    @Override
    public String getScriptName() {
        return SpiceOfLife.ID;
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(IndustrialCraft2.ID, SpiceOfLife.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(SpiceOfLife.ID, "lunchbag", 1),
                new Object[] { getModItem(Minecraft.ID, "paper", 1), null, getModItem(Minecraft.ID, "paper", 1),
                        getModItem(IndustrialCraft2.ID, "itemHarz", 1), getModItem(Minecraft.ID, "paper", 1),
                        getModItem(IndustrialCraft2.ID, "itemHarz", 1), null, null, null });

        addShapedRecipe(
                getModItem(SpiceOfLife.ID, "lunchbox", 1),
                new Object[] { "plateDoubleIron", "craftingToolScrewdriver", "plateDoubleIron", "screwAnyIron",
                        "plateDoubleIron", "screwAnyIron", null, null, null });

        addShapelessCraftingRecipe(
                getModItem(SpiceOfLife.ID, "bookfoodjournal", 1),
                new Object[] { new ItemStack(Items.wheat), new ItemStack(Items.paper) });
    }
}
