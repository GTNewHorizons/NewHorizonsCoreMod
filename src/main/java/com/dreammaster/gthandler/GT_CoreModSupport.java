package com.dreammaster.gthandler;

import gregtech.api.enums.Materials;
import gregtech.api.interfaces.IMaterialHandler;

public class GT_CoreModSupport implements IMaterialHandler {

    public GT_CoreModSupport() {
        Materials.add(this);
    }

    @Override
    public void onMaterialsInit() {
        /** This is just left here as an example of how to add new materials. **/
        /*
         * int i = 0; for (int j = GregTechAPI.sMaterialProperties.get("general", "AmountOfCustomMaterialSlots", 16); i
         * < j; i++) { String aID = (i < 10 ? "0" : "") + i; new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 0, 0,
         * 255, 255, 255, 0, "CustomMat" + aID, "CustomMat" + aID, 0, 0, 0, 0, false, false, 1, 1, 1, Dyes._NULL,
         * "custom", true, aID); }
         */
    }
}
