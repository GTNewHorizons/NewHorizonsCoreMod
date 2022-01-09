package com.dreammaster.scripts;

import gregtech.api.enums.GT_Values;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.List;

import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptEnderZoo implements IScriptLoader{
    private long startTime;
    private long endTime;
    private static final String scriptName = "EnderZoo";
    private static final List<String> dependencies = Arrays.asList("EnderZoo");

    public ScriptEnderZoo() {

    }
    @Override
    public void loadRecipes() {
        startTime = System.currentTimeMillis();
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{
                        getModItem("minecraft", "tnt", 1),
                        getModItem("EnderZoo", "confusingDust", 4)},
                GT_Values.NF,
                getModItem("EnderZoo", "blockConfusingCharge", 1),
                400, 16);

        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{
                        getModItem("minecraft", "tnt", 1),
                        getModItem("EnderZoo", "enderFragment", 4)},
                GT_Values.NF,
                getModItem("EnderZoo", "blockEnderCharge", 1),
                400, 16);

        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{
                        getModItem("EnderZoo", "blockConfusingCharge", 1),
                        getModItem("EnderZoo", "blockEnderCharge", 1)},
                GT_Values.NF,
                getModItem("EnderZoo", "blockConcussionCharge", 2),
                400, 30);
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
