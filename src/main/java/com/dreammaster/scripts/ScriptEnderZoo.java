package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Collections;
import java.util.List;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;

public class ScriptEnderZoo implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "EnderZoo";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList("EnderZoo");
    }

    @Override
    public void loadRecipes() {
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem("minecraft", "tnt", 1), getModItem("EnderZoo", "confusingDust", 4) },
                GT_Values.NF,
                getModItem("EnderZoo", "blockConfusingCharge", 1),
                400,
                16);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem("minecraft", "tnt", 1), getModItem("EnderZoo", "enderFragment", 4) },
                GT_Values.NF,
                getModItem("EnderZoo", "blockEnderCharge", 1),
                400,
                16);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem("EnderZoo", "blockConfusingCharge", 1),
                        getModItem("EnderZoo", "blockEnderCharge", 1) },
                GT_Values.NF,
                getModItem("EnderZoo", "blockConcussionCharge", 2),
                400,
                30);
    }
}
