package com.dreammaster.bartworksHandler;

import static bartworks.API.recipe.BartWorksRecipeMaps.radioHatchFakeRecipes;
import static bartworks.common.loaders.RadioHatchMaterialLoader.radioHatchMaterialAdder;
import static gregtech.api.util.GTRecipeConstants.MASS;
import static gregtech.api.util.GTRecipeConstants.SIEVERT;

import com.ruling_0.materiallib.api.Material;
import com.ruling_0.materiallib.api.MaterialLibAPI;
import com.ruling_0.materiallib.api.Shape;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.material.GTMaterialProperties;
import gregtech.api.material.MaterialAtomics;
import gregtech.api.util.recipe.Sievert;

/// Radiation hatch entries for the radioactive materials that originate in gtPlusPlus. BartWorks
/// registers the werkstoff-backed and GT-native ones itself, so Thorium, Thorium 232 and Californium
/// are skipped here to avoid a second entry.
public class BW_RadHatchMaterial {

    public static void runRadHatchAdder() {
        for (Material material : MaterialLibAPI.getMaterials()) {
            if (material.getProperty(GTMaterialProperties.GTPP_STATE) == null) continue;

            Integer radiation = material.getProperty(GTMaterialProperties.RADIATION_LEVEL);
            if (radiation == null || radiation <= 0) continue;

            if (material == Materials2Materials.Thorium || material == Materials2Materials.Thorium232
                    || material == Materials2Materials.Californium) {
                continue;
            }

            int level = (int) MaterialAtomics.protons(material);
            addRod(material, Materials2Shapes.stick, level, 1);
            addRod(material, Materials2Shapes.stickLong, level, 2);
        }
    }

    private static void addRod(Material material, Shape shape, int level, int mass) {
        if (!material.hasShape(shape)) return;

        radioHatchMaterialAdder(MaterialLibAPI.getStack(material, shape, 1), level, (byte) mass);
        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(material, shape, 1)).duration(0).eut(0)
                .metadata(SIEVERT, new Sievert(level)).metadata(MASS, mass).fake().addTo(radioHatchFakeRecipes);
    }
}
