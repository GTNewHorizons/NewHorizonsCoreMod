package com.dreammaster.scripts;

import static gregtech.api.enums.ModIDs.IC2NuclearControl;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Collections;
import java.util.List;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;

public class ScriptNuclearControl implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "NuclearControl";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList(IC2NuclearControl.modID);
    }

    @Override
    public void loadRecipes() {
        final ItemStack NC2_REMOTE_SENSOR_KIT = getModItem(IC2NuclearControl.modID, "ItemRemoteSensorKit", 1, 0);
        final ItemStack NC2_PANEL_MEMORY_CARD = getModItem(IC2NuclearControl.modID, "ItemPanelMemoryCard", 1, 0);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { NC2_REMOTE_SENSOR_KIT,
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2) },
                GT_Values.NF,
                NC2_PANEL_MEMORY_CARD,
                200,
                16);
    }
}
