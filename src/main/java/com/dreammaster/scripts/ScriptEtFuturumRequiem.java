package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.EtFuturumRequiem;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

public class ScriptEtFuturumRequiem implements IScriptLoader {
    @Override
    public String getScriptName() {
        return "Et Futurum Requiem";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
            EtFuturumRequiem.ID,
            GTPlusPlus.ID
        );
    }

    @Override
    public void loadRecipes() {
        final ItemStack CHERRY_LOG = getModItem(EtFuturumRequiem.ID, "cherry_log", 1, 0, missing);
        final ItemStack CHERRY_WOOD = getModItem(EtFuturumRequiem.ID, "cherry_log", 1, 1, missing);
        final ItemStack STRIPPED_CHERRY_LOG = getModItem(EtFuturumRequiem.ID, "cherry_log", 1, 2, missing);
        final ItemStack STRIPPED_CHERRY_WOOD = getModItem(EtFuturumRequiem.ID, "cherry_log", 1, 3, missing);

        addShapelessRecipe(getModItem(EtFuturumRequiem.ID, "wood_planks", 2, 3, missing), CHERRY_LOG);

        addShapelessRecipe(getModItem(EtFuturumRequiem.ID, "stone_slab", 2, missing), "craftingToolSaw", null, "stone", null);
    }
};