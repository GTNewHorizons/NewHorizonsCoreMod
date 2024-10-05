package com.dreammaster.bartworksHandler;

import static bartworks.API.recipe.BartWorksRecipeMaps.radioHatchRecipes;
import static bartworks.util.BWRecipes.calcDecayTicks;
import static gregtech.api.util.GTRecipeConstants.DECAY_TICKS;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.GTValues;
import gtPlusPlus.core.material.Material;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.core.util.minecraft.ItemUtils;

public class BW_RadHatchMaterial {

    public static void runRadHatchAdder() {
        ItemStack err = ItemUtils.getErrorStack(1);

        for (Material material : Material.mMaterialMap) {
            if (material == null || material.vRadiationLevel <= 0) {
                continue;
            }

            // already generated in BW
            if (material == MaterialsElements.getInstance().THORIUM
                    || material == MaterialsElements.getInstance().THORIUM232
                    || material == MaterialsElements.getInstance().CALIFORNIUM) {
                continue;
            }

            int level = (int) material.getProtons();
            if (material.getRod(1) != null && !material.getRod(1).isItemEqual(err)) {
                GTValues.RA.stdBuilder().itemInputs(material.getRod(1)).duration(1).eut(level)
                        .metadata(DECAY_TICKS, (int) calcDecayTicks(level)).noOptimize().addTo(radioHatchRecipes);
            }
            if (material.getLongRod(1) != null && !material.getLongRod(1).isItemEqual(err)) {
                GTValues.RA.stdBuilder().itemInputs(material.getLongRod(1)).duration(2).eut(level)
                        .metadata(DECAY_TICKS, (int) calcDecayTicks(level)).noOptimize().addTo(radioHatchRecipes);
            }

        }

    }
}
