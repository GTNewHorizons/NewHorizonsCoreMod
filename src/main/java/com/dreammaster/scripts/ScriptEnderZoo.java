package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.EnderZoo;
import static gregtech.api.enums.Mods.Minecraft;
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
        return Collections.singletonList(EnderZoo.ID);
    }

    @Override
    public void loadRecipes() {
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(Minecraft.ID, "tnt", 1),
                        getModItem(EnderZoo.ID, "confusingDust", 4) },
                GT_Values.NF,
                getModItem(EnderZoo.ID, "blockConfusingCharge", 1),
                400,
                16);

        boolean b = GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(Minecraft.ID, "tnt", 1),
                        getModItem(EnderZoo.ID, "enderFragment", 4) },
                GT_Values.NF,
                getModItem(EnderZoo.ID, "blockEnderCharge", 1),
                400,
                16);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(EnderZoo.ID, "blockConfusingCharge", 1),
                        getModItem(EnderZoo.ID, "blockEnderCharge", 1) },
                GT_Values.NF,
                getModItem(EnderZoo.ID, "blockConcussionCharge", 2),
                400,
                30);
    }
}
