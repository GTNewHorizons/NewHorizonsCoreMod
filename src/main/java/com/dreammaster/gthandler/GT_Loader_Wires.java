package com.dreammaster.gthandler;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.metatileentity.implementations.MTECable;
import gregtech.api.util.GTLanguageManager;
import gregtech.api.util.GTOreDictUnificator;

public class GT_Loader_Wires {

    public void run() {
        registerWires();
    }

    private void registerWires() {

        // Take a look in gt5u MetaTileEntityIDs for free spaces

        // ===================================================================================================
        // Make wires
        // ===================================================================================================

        // Takes 20!!! slots per wire
        makeWires(Materials.ElectricalSteel, 11490, 1L, 2L, 3L, GTValues.V[2], true, false);
        makeWires(Materials.EnergeticAlloy, 11510, 1L, 2L, 4L, gregtech.api.enums.GTValues.V[3], true, false);
        makeWires(Materials.VibrantAlloy, 11530, 3L, 6L, 6L, gregtech.api.enums.GTValues.V[4], true, false);
        makeWires(Materials.EndSteel, 1860, 3L, 6L, 6L, gregtech.api.enums.GTValues.V[5], true, false);
        makeWires(Materials.MelodicAlloy, 11550, 2L, 4L, 4L, gregtech.api.enums.GTValues.V[6], true, false);
        makeWires(Materials.StellarAlloy, 11570, 12L, 24L, 12L, gregtech.api.enums.GTValues.V[8], true, false);
        makeWires(Materials.Trinium, 11450, 3L, 6L, 6L, GTValues.V[7], true, false);
        makeWires(Materials.ElectrumFlux, 1900, 3L, 2L, 6L, GTValues.V[8], true, false);
        makeWires(Materials.Bedrockium, 11310, 6L, 48L, 3L, GTValues.V[9], true, false);
        makeWires(Materials.Osmiridium, 11610, 1L, 2L, 16L, GTValues.V[7], true, false);
        makeWires(Materials.HSSE, 11590, 4L, 8L, 6L, GTValues.V[6], true, false);
        makeWires(Materials.HSSS, 11470, 4L, 8L, 8L, GTValues.V[9], true, false);
        makeWires(Materials.Draconium, 11330, 32L, 64L, 8L, GTValues.V[10], true, false);
        makeWires(Materials.NetherStar, 11350, 16L, 32L, 4L, GTValues.V[11], true, false);
        makeWires(Materials.Quantium, 11370, 32L, 128L, 4L, GTValues.V[12], true, false);
        makeWires(Materials.BlackPlutonium, 11390, 8L, 8L, 8L, GTValues.V[13], false, false);
        makeWires(Materials.DraconiumAwakened, 11410, 64L, 64L, 8L, GTValues.V[14], false, false);
        makeWires(Materials.Infinity, 11430, 0L, 0L, 8192L, GTValues.V[14], false, true);

        /**
         * ID SPACE RESERVED: to 11800, FOR WIRES makeWires(Materials.???, 1920, 4L, 8L, 8L,
         * gregtech.api.enums.GTValues.V[8], true, false); 2000 and 2010 are used for RedAlloy and Super Conductor
         **/
    }

    private static void makeWires(Materials aMaterial, int aStartID, long aLossInsulated, long aLoss, long aAmperage,
            long aVoltage, boolean aInsulatable, boolean aAutoInsulated) {
        String displayName = GTLanguageManager.i18nPlaceholder ? "%material" : aMaterial.mDefaultLocalName;
        GTOreDictUnificator.registerOre(
                OrePrefixes.wireGt01,
                aMaterial,
                new MTECable(
                        aStartID + 0,
                        "wire." + aMaterial.mName.toLowerCase() + ".01",
                        "1x " + displayName + " Wire",
                        0.125F,
                        aMaterial,
                        aLoss,
                        1L * aAmperage,
                        aVoltage,
                        false,
                        !aAutoInsulated).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.wireGt02,
                aMaterial,
                new MTECable(
                        aStartID + 1,
                        "wire." + aMaterial.mName.toLowerCase() + ".02",
                        "2x " + displayName + " Wire",
                        0.25F,
                        aMaterial,
                        aLoss,
                        2L * aAmperage,
                        aVoltage,
                        false,
                        !aAutoInsulated).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.wireGt04,
                aMaterial,
                new MTECable(
                        aStartID + 2,
                        "wire." + aMaterial.mName.toLowerCase() + ".04",
                        "4x " + displayName + " Wire",
                        0.375F,
                        aMaterial,
                        aLoss,
                        4L * aAmperage,
                        aVoltage,
                        false,
                        !aAutoInsulated).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.wireGt08,
                aMaterial,
                new MTECable(
                        aStartID + 3,
                        "wire." + aMaterial.mName.toLowerCase() + ".08",
                        "8x " + displayName + " Wire",
                        0.5F,
                        aMaterial,
                        aLoss,
                        8L * aAmperage,
                        aVoltage,
                        false,
                        !aAutoInsulated).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.wireGt12,
                aMaterial,
                new MTECable(
                        aStartID + 4,
                        "wire." + aMaterial.mName.toLowerCase() + ".12",
                        "12x " + displayName + " Wire",
                        0.625F,
                        aMaterial,
                        aLoss,
                        12L * aAmperage,
                        aVoltage,
                        false,
                        !aAutoInsulated).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.wireGt16,
                aMaterial,
                new MTECable(
                        aStartID + 5,
                        "wire." + aMaterial.mName.toLowerCase() + ".16",
                        "16x " + displayName + " Wire",
                        0.75F,
                        aMaterial,
                        aLoss,
                        16L * aAmperage,
                        aVoltage,
                        false,
                        !aAutoInsulated).getStackForm(1L));
        if (aInsulatable) {
            GTOreDictUnificator.registerOre(
                    OrePrefixes.cableGt01,
                    aMaterial,
                    new MTECable(
                            aStartID + 6,
                            "cable." + aMaterial.mName.toLowerCase() + ".01",
                            "1x " + displayName + " Cable",
                            0.25F,
                            aMaterial,
                            aLossInsulated,
                            1L * aAmperage,
                            aVoltage,
                            true,
                            false).getStackForm(1L));
            GTOreDictUnificator.registerOre(
                    OrePrefixes.cableGt02,
                    aMaterial,
                    new MTECable(
                            aStartID + 7,
                            "cable." + aMaterial.mName.toLowerCase() + ".02",
                            "2x " + displayName + " Cable",
                            0.375F,
                            aMaterial,
                            aLossInsulated,
                            2L * aAmperage,
                            aVoltage,
                            true,
                            false).getStackForm(1L));
            GTOreDictUnificator.registerOre(
                    OrePrefixes.cableGt04,
                    aMaterial,
                    new MTECable(
                            aStartID + 8,
                            "cable." + aMaterial.mName.toLowerCase() + ".04",
                            "4x " + displayName + " Cable",
                            0.5F,
                            aMaterial,
                            aLossInsulated,
                            4L * aAmperage,
                            aVoltage,
                            true,
                            false).getStackForm(1L));
            GTOreDictUnificator.registerOre(
                    OrePrefixes.cableGt08,
                    aMaterial,
                    new MTECable(
                            aStartID + 9,
                            "cable." + aMaterial.mName.toLowerCase() + ".08",
                            "8x " + displayName + " Cable",
                            0.625F,
                            aMaterial,
                            aLossInsulated,
                            8L * aAmperage,
                            aVoltage,
                            true,
                            false).getStackForm(1L));
            GTOreDictUnificator.registerOre(
                    OrePrefixes.cableGt12,
                    aMaterial,
                    new MTECable(
                            aStartID + 10,
                            "cable." + aMaterial.mName.toLowerCase() + ".12",
                            "12x " + displayName + " Cable",
                            0.75F,
                            aMaterial,
                            aLossInsulated,
                            12L * aAmperage,
                            aVoltage,
                            true,
                            false).getStackForm(1L));
            GTOreDictUnificator.registerOre(
                    OrePrefixes.cableGt16,
                    aMaterial,
                    new MTECable(
                            aStartID + 11,
                            "cable." + aMaterial.mName.toLowerCase() + ".16",
                            "16x " + displayName + " Cable",
                            0.875F,
                            aMaterial,
                            aLossInsulated,
                            16L * aAmperage,
                            aVoltage,
                            true,
                            false).getStackForm(1L));
        }
    }
}
