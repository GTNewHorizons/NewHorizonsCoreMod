package com.dreammaster.bartworksHandler;

import static bartworks.API.recipe.BartWorksRecipeMaps.radioHatchFakeRecipes;
import static bartworks.common.loaders.RadioHatchMaterialLoader.radioHatchMaterialAdder;
import static gregtech.api.util.GTRecipeConstants.MASS;
import static gregtech.api.util.GTRecipeConstants.SIEVERT;

import gregtech.api.enums.GTValues;
import gregtech.api.util.recipe.Sievert;
import gtPlusPlus.core.material.Material;
import gtPlusPlus.core.material.MaterialsElements;

public class BW_RadHatchMaterial {

    public static void runRadHatchAdder() {

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
            if (material.getRod(1) != null) {
                radioHatchMaterialAdder(material.getRod(1), level, (byte) 1);
                GTValues.RA.stdBuilder().itemInputs(material.getRod(1)).duration(0).eut(0)
                        .metadata(SIEVERT, new Sievert(level)).metadata(MASS, 1).fake().addTo(radioHatchFakeRecipes);
            }
            if (material.getLongRod(1) != null) {
                radioHatchMaterialAdder(material.getLongRod(1), level, (byte) 2);
                GTValues.RA.stdBuilder().itemInputs(material.getLongRod(1)).duration(0).eut(0)
                        .metadata(SIEVERT, new Sievert(level)).metadata(MASS, 2).fake().addTo(radioHatchFakeRecipes);
            }
        }
    }
}
