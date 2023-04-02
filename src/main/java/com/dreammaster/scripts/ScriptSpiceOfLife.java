package com.dreammaster.scripts;

import static com.dreammaster.MissingModIDs.SpiceOfLife;
import static gregtech.api.enums.ModIDs.IndustrialCraft2;
import static gregtech.api.enums.ModIDs.Minecraft;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ScriptSpiceOfLife implements IScriptLoader {

    @Override
    public String getScriptName() {
        return SpiceOfLife.modID;
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(IndustrialCraft2.modID, SpiceOfLife.modID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(SpiceOfLife.modID, "lunchbag", 1),
                new Object[] { getModItem(Minecraft.modID, "paper", 1), null, getModItem(Minecraft.modID, "paper", 1),
                        getModItem(IndustrialCraft2.modID, "itemHarz", 1), getModItem(Minecraft.modID, "paper", 1),
                        getModItem(IndustrialCraft2.modID, "itemHarz", 1), null, null, null });

        addShapedRecipe(
                getModItem(SpiceOfLife.modID, "lunchbox", 1),
                new Object[] { "plateDoubleIron", "craftingToolScrewdriver", "plateDoubleIron", "screwAnyIron",
                        "plateDoubleIron", "screwAnyIron", null, null, null });

        addShapelessCraftingRecipe(
                getModItem(SpiceOfLife.modID, "bookfoodjournal", 1),
                new Object[] { new ItemStack(Items.wheat), new ItemStack(Items.paper) });
    }
}
