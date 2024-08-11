package com.dreammaster.bartworksHandler;

import static com.github.bartimaeusnek.bartworks.API.recipe.BartWorksRecipeMaps.radioHatchRecipes;
import static com.github.bartimaeusnek.bartworks.util.BWRecipes.calcDecayTicks;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.util.GT_RecipeConstants.DECAY_TICKS;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gtPlusPlus.core.material.Material;
import gtPlusPlus.core.util.minecraft.ItemUtils;

public class BW_RadHatchMaterial {

    public static void runRadHatchAdder() {
        if (!GTPlusPlus.isModLoaded()) {
            return;
        }

        ItemStack err = ItemUtils.getErrorStack(1);

        for (Material material : Material.mMaterialMap) {
            if (material == null || material.vRadiationLevel <= 0) {
                continue;
            }

            int level = (int) material.getProtons();
            if (material.getRod(1) != null && !material.getRod(1).isItemEqual(err)) {
                GT_Values.RA.stdBuilder().itemInputs(material.getRod(1)).duration(1).eut(level)
                        .metadata(DECAY_TICKS, (int) calcDecayTicks(level)).noOptimize().addTo(radioHatchRecipes);
            }
            if (material.getLongRod(1) != null && !material.getLongRod(1).isItemEqual(err)) {
                GT_Values.RA.stdBuilder().itemInputs(material.getLongRod(1)).duration(2).eut(level)
                        .metadata(DECAY_TICKS, (int) calcDecayTicks(level)).noOptimize().addTo(radioHatchRecipes);
            }

        }

    }
}
