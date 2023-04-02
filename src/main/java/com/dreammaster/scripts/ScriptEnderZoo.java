package com.dreammaster.scripts;

import static com.dreammaster.MissingModIDs.EnderZoo;
import static gregtech.api.enums.ModIDs.Minecraft;
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
        return Collections.singletonList(EnderZoo.modID);
    }

    @Override
    public void loadRecipes() {
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(Minecraft.modID, "tnt", 1),
                        getModItem(EnderZoo.modID, "confusingDust", 4) },
                GT_Values.NF,
                getModItem(EnderZoo.modID, "blockConfusingCharge", 1),
                400,
                16);

        boolean b = GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(Minecraft.modID, "tnt", 1),
                        getModItem(EnderZoo.modID, "enderFragment", 4) },
                GT_Values.NF,
                getModItem(EnderZoo.modID, "blockEnderCharge", 1),
                400,
                16);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(EnderZoo.modID, "blockConfusingCharge", 1),
                        getModItem(EnderZoo.modID, "blockEnderCharge", 1) },
                GT_Values.NF,
                getModItem(EnderZoo.modID, "blockConcussionCharge", 2),
                400,
                30);
    }
}
