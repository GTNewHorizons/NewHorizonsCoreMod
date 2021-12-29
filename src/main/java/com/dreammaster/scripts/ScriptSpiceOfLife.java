package com.dreammaster.scripts;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.List;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptSpiceOfLife implements IScriptLoader{
    private long startTime;
    private long endTime;
    private static final String scriptName = "SpiceOfLife";
    private static final List<String> dependencies = Arrays.asList("IC2", "SpiceOfLife");

    public ScriptSpiceOfLife() {

    }

    @Override
    public void loadRecipes() {
        startTime = System.currentTimeMillis();
        addShapedRecipe(getModItem("SpiceOfLife", "lunchbag", 1), new Object[]{
                getModItem("minecraft", "paper", 1), null, getModItem("minecraft", "paper", 1),
                getModItem("IC2", "itemHarz", 1), getModItem("minecraft", "paper", 1), getModItem("IC2", "itemHarz", 1),
                null, null, null});

        addShapedRecipe(getModItem("SpiceOfLife", "lunchbox", 1), new Object[]{
                "plateDoubleIron", "craftingToolScrewdriver", "plateDoubleIron",
                "screwAnyIron", "plateDoubleIron", "screwAnyIron",
                null, null, null});

        addShapelessCraftingRecipe(getModItem("SpiceOfLife", "bookfoodjournal", 1), new Object[]{
                new ItemStack(Items.wheat),
                new ItemStack(Items.paper)
        });

        endTime = System.currentTimeMillis();
    }

    @Override
    public long getExecutionTime(){
        return endTime-startTime;
    }

    @Override
    public List<String> getDependencies() {
        return dependencies;
    }

    @Override
    public String getScriptName() {
        return scriptName;
    }
}
