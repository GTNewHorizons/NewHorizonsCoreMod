package com.dreammaster.bartworksHandler;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import gregtech.loaders.oreprocessing.ProcessingLog;

/**
 * Helper class to create pyrolyse oven recipes for all woods.
 * <p>
 * This needs to be run post-GT initialization, so that all woods have had a chance to get registered in the ore
 * dictionary.
 *
 * @see <a href="https://github.com/GTNewHorizons/GT-New-Horizons-Modpack/issues/8047"> Discussion on GitHub</a>
 */
public class PyrolyseOvenLoader {

    private PyrolyseOvenLoader() {}

    public static void registerRecipes() {
        for (ItemStack log : OreDictionary.getOres("logWood")) {
            ProcessingLog.addPyrolyeOvenRecipes(log);
        }
    }
}
