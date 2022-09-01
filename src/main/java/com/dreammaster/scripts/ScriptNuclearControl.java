package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.item.ItemStack;

public class ScriptNuclearControl implements IScriptLoader {

    public ScriptNuclearControl() {}

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("NuclearControl");
        dependencies.clear();
        dependencies.addAll(java.util.Arrays.asList("IC2NuclearControl"));
    }

    @Override
    public void loadRecipes() {
        final ItemStack NC2_RANGE_UPGRADE = getModItem("IC2NuclearControl", "ItemUpgrade", 1, 0);
        final ItemStack NC2_COLOR_UPGRADE = getModItem("IC2NuclearControl", "ItemUpgrade", 1, 1);
        final ItemStack NC2_REMOTE_SENSOR_KIT = getModItem("IC2NuclearControl", "ItemRemoteSensorKit", 1, 0);
        final ItemStack NC2_PANEL_MEMORY_CARD = getModItem("IC2NuclearControl", "ItemPanelMemoryCard", 1, 0);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    NC2_REMOTE_SENSOR_KIT,
                    GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2),
                    GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2)
                },
                GT_Values.NF,
                NC2_PANEL_MEMORY_CARD,
                200,
                16);
    }
}
