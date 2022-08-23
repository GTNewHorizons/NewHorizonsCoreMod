package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import gregtech.api.enums.GT_Values;
import java.util.Arrays;
import net.minecraft.item.ItemStack;

public class ScriptEnderZoo implements IScriptLoader {

    public ScriptEnderZoo() {}

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("EnderZoo");
        dependencies.clear();
        dependencies.addAll(Arrays.asList("EnderZoo"));
    }

    @Override
    public void loadRecipes() {
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {getModItem("minecraft", "tnt", 1), getModItem("EnderZoo", "confusingDust", 4)},
                GT_Values.NF,
                getModItem("EnderZoo", "blockConfusingCharge", 1),
                400,
                16);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {getModItem("minecraft", "tnt", 1), getModItem("EnderZoo", "enderFragment", 4)},
                GT_Values.NF,
                getModItem("EnderZoo", "blockEnderCharge", 1),
                400,
                16);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    getModItem("EnderZoo", "blockConfusingCharge", 1), getModItem("EnderZoo", "blockEnderCharge", 1)
                },
                GT_Values.NF,
                getModItem("EnderZoo", "blockConcussionCharge", 2),
                400,
                30);
    }
}
