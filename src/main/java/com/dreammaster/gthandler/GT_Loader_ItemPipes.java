package com.dreammaster.gthandler;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.metatileentity.implementations.MTEItem;
import gregtech.api.util.GTLanguageManager;
import gregtech.api.util.GTOreDictUnificator;

public final class GT_Loader_ItemPipes {

    private GT_Loader_ItemPipes() {}

    public static void registerPipes() {

        // These IDs are totally messed up. Watch out if you want to add or change something here!

        // Brass
        String displayName = GTLanguageManager.i18nPlaceholder ? "%material" : Materials.Brass.mDefaultLocalName;
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeTiny.get(Materials.Brass),
                new MTEItem(
                        5600,
                        "GT_Pipe_Brass_Tiny",
                        "Tiny " + displayName + " Item Pipe",
                        0.25F,
                        Materials.Brass,
                        1,
                        131072,
                        false,
                        80).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeSmall.get(Materials.Brass),
                new MTEItem(
                        5601,
                        "GT_Pipe_Brass_Small",
                        "Small " + displayName + " Item Pipe",
                        0.375F,
                        Materials.Brass,
                        1,
                        65536,
                        false,
                        40).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveTiny.get(Materials.Brass),
                new MTEItem(
                        5640,
                        "GT_Pipe_Restrictive_Brass_Tiny",
                        "Tiny Restrictive " + displayName + " Item Pipe",
                        0.25F,
                        Materials.Brass,
                        1,
                        13107200,
                        true,
                        80).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveSmall.get(Materials.Brass),
                new MTEItem(
                        5641,
                        "GT_Pipe_Restrictive_Brass_Small",
                        "Small Restrictive " + displayName + " Item Pipe",
                        0.375F,
                        Materials.Brass,
                        1,
                        6553600,
                        true,
                        40).getStackForm(1L));

        // Electrum
        displayName = GTLanguageManager.i18nPlaceholder ? "%material" : Materials.Electrum.mDefaultLocalName;
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeTiny.get(Materials.Electrum),
                new MTEItem(
                        5610,
                        "GT_Pipe_Electrum_Tiny",
                        "Tiny " + displayName + " Item Pipe",
                        0.25F,
                        Materials.Electrum,
                        1,
                        65536,
                        false,
                        40).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeSmall.get(Materials.Electrum),
                new MTEItem(
                        5611,
                        "GT_Pipe_Electrum_Small",
                        "Small " + displayName + " Item Pipe",
                        0.375F,
                        Materials.Electrum,
                        1,
                        32768,
                        false).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveTiny.get(Materials.Electrum),
                new MTEItem(
                        5642,
                        "GT_Pipe_Restrictive_Electrum_Tiny",
                        "Tiny Restrictive " + displayName + " Item Pipe",
                        0.25F,
                        Materials.Electrum,
                        1,
                        6553600,
                        true,
                        40).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveSmall.get(Materials.Electrum),
                new MTEItem(
                        5643,
                        "GT_Pipe_Restrictive_Electrum_Small",
                        "Small Restrictive " + displayName + " Item Pipe",
                        0.375F,
                        Materials.Electrum,
                        1,
                        3276800,
                        true).getStackForm(1L));

        // Platinum
        displayName = GTLanguageManager.i18nPlaceholder ? "%material" : Materials.Platinum.mDefaultLocalName;
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeTiny.get(Materials.Platinum),
                new MTEItem(
                        5620,
                        "GT_Pipe_Platinum_Tiny",
                        "Tiny " + displayName + " Item Pipe",
                        0.25F,
                        Materials.Platinum,
                        1,
                        32768,
                        false).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeSmall.get(Materials.Platinum),
                new MTEItem(
                        5621,
                        "GT_Pipe_Platinum_Small",
                        "Small " + displayName + " Item Pipe",
                        0.375F,
                        Materials.Platinum,
                        2,
                        16384,
                        false).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveTiny.get(Materials.Platinum),
                new MTEItem(
                        5644,
                        "GT_Pipe_Restrictive_Platinum_Tiny",
                        "Tiny Restrictive " + displayName + " Item Pipe",
                        0.25F,
                        Materials.Platinum,
                        1,
                        3276800,
                        true).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveSmall.get(Materials.Platinum),
                new MTEItem(
                        5645,
                        "GT_Pipe_Restrictive_Platinum_Small",
                        "Small Restrictive " + displayName + " Item Pipe",
                        0.375F,
                        Materials.Platinum,
                        2,
                        1638400,
                        true).getStackForm(1L));

        // Osmium
        displayName = GTLanguageManager.i18nPlaceholder ? "%material" : Materials.Osmium.mDefaultLocalName;
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeTiny.get(Materials.Osmium),
                new MTEItem(
                        5630,
                        "GT_Pipe_Osmium_Tiny",
                        "Tiny " + displayName + " Item Pipe",
                        0.25F,
                        Materials.Osmium,
                        2,
                        16384,
                        false).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeSmall.get(Materials.Osmium),
                new MTEItem(
                        5631,
                        "GT_Pipe_Osmium_Small",
                        "Small " + displayName + " Item Pipe",
                        0.375F,
                        Materials.Osmium,
                        4,
                        8192,
                        false).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveTiny.get(Materials.Osmium),
                new MTEItem(
                        5646,
                        "GT_Pipe_Restrictive_Osmium_Tiny",
                        "Tiny Restrictive " + displayName + " Item Pipe",
                        0.25F,
                        Materials.Osmium,
                        2,
                        1638400,
                        true).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveSmall.get(Materials.Osmium),
                new MTEItem(
                        5647,
                        "GT_Pipe_Restrictive_Osmium_Small",
                        "Small Restrictive " + displayName + " Item Pipe",
                        0.375F,
                        Materials.Osmium,
                        4,
                        819200,
                        true).getStackForm(1L));

        // Tin
        displayName = GTLanguageManager.i18nPlaceholder ? "%material" : Materials.Tin.mDefaultLocalName;
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeTiny.get(Materials.Tin),
                new MTEItem(
                        5589,
                        "GT_Pipe_Tin_Tiny",
                        "Tiny " + displayName + " Item Pipe",
                        0.25F,
                        Materials.Tin,
                        1,
                        262144,
                        false,
                        160).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeSmall.get(Materials.Tin),
                new MTEItem(
                        5590,
                        "GT_Pipe_Tin_Small",
                        "Small " + displayName + " Item Pipe",
                        0.375F,
                        Materials.Tin,
                        1,
                        131072,
                        false,
                        80).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeMedium.get(Materials.Tin),
                new MTEItem(5591, "GT_Pipe_Tin", displayName + " Item Pipe", 0.5F, Materials.Tin, 1, 65536, false, 40)
                        .getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeLarge.get(Materials.Tin),
                new MTEItem(
                        5592,
                        "GT_Pipe_Tin_Large",
                        "Large " + displayName + " Item Pipe",
                        0.75F,
                        Materials.Tin,
                        1,
                        32768,
                        false).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeHuge.get(Materials.Tin),
                new MTEItem(
                        5593,
                        "GT_Pipe_Tin_Huge",
                        "Huge " + displayName + " Item Pipe",
                        0.875F,
                        Materials.Tin,
                        2,
                        16384,
                        false).getStackForm(1L));

        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveTiny.get(Materials.Tin),
                new MTEItem(
                        5594,
                        "GT_Pipe_Restrictive_Tin_Tiny",
                        "Tiny Restrictive " + displayName + " Item Pipe",
                        0.25F,
                        Materials.Tin,
                        1,
                        26214400,
                        true,
                        160).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveSmall.get(Materials.Tin),
                new MTEItem(
                        5595,
                        "GT_Pipe_Restrictive_Tin_Small",
                        "Small Restrictive " + displayName + " Item Pipe",
                        0.375F,
                        Materials.Tin,
                        1,
                        13107200,
                        true,
                        80).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveMedium.get(Materials.Tin),
                new MTEItem(
                        5596,
                        "GT_Pipe_Restrictive_Tin",
                        "Restrictive " + displayName + " Pipe",
                        0.5F,
                        Materials.Tin,
                        1,
                        6553600,
                        true,
                        40).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveLarge.get(Materials.Tin),
                new MTEItem(
                        5597,
                        "GT_Pipe_Restrictive_Tin_Large",
                        "Large Restrictive " + displayName + " Item Pipe",
                        0.75F,
                        Materials.Tin,
                        1,
                        3276800,
                        true).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveHuge.get(Materials.Tin),
                new MTEItem(
                        5598,
                        "GT_Pipe_Restrictive_Tin_Huge",
                        "Huge Restrictive " + displayName + " Item Pipe",
                        0.875F,
                        Materials.Tin,
                        2,
                        1638400,
                        true).getStackForm(1L));

        generateItemPipes(Materials.ElectrumFlux, Materials.ElectrumFlux.mName, 5650, 16);
        generateItemPipes(Materials.BlackPlutonium, Materials.BlackPlutonium.mName, 5660, 32);
        generateItemPipes(Materials.Bedrockium, Materials.Bedrockium.mName, 5670, 64);
        generateItemPipes(Materials.Quantium, Materials.Quantium.mName, 5730, 128);
    }

    private static void generateItemPipes(Materials aMaterial, String name, int startID, int baseInvSlots) {
        generateItemPipes(
                aMaterial,
                name,
                GTLanguageManager.i18nPlaceholder ? "%material" : aMaterial.mDefaultLocalName,
                startID,
                baseInvSlots);
    }

    private static void generateItemPipes(Materials aMaterial, String name, String displayName, int startID,
            int baseInvSlots) {
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeTiny.get(aMaterial),
                new MTEItem(
                        startID,
                        "GT_Pipe_" + name + "_Tiny",
                        "Tiny " + displayName + " Item Pipe",
                        0.25F,
                        aMaterial,
                        baseInvSlots / 4,
                        131072 / baseInvSlots,
                        false).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeSmall.get(aMaterial),
                new MTEItem(
                        startID + 1,
                        "GT_Pipe_" + name + "_Small",
                        "Small " + displayName + " Item Pipe",
                        0.375F,
                        aMaterial,
                        baseInvSlots / 2,
                        65536 / baseInvSlots,
                        false).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeMedium.get(aMaterial),
                new MTEItem(
                        startID + 2,
                        "GT_Pipe_" + name,
                        displayName + " Item Pipe",
                        0.50F,
                        aMaterial,
                        baseInvSlots,
                        32768 / baseInvSlots,
                        false).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeLarge.get(aMaterial),
                new MTEItem(
                        startID + 3,
                        "GT_Pipe_" + name + "_Large",
                        "Large " + displayName + " Item Pipe",
                        0.75F,
                        aMaterial,
                        baseInvSlots * 2,
                        16384 / baseInvSlots,
                        false).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeHuge.get(aMaterial),
                new MTEItem(
                        startID + 4,
                        "GT_Pipe_" + name + "_Huge",
                        "Huge " + displayName + " Item Pipe",
                        0.875F,
                        aMaterial,
                        baseInvSlots * 4,
                        8192 / baseInvSlots,
                        false).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveTiny.get(aMaterial),
                new MTEItem(
                        startID + 5,
                        "GT_Pipe_Restrictive_" + name + "_Tiny",
                        "Tiny Restrictive " + displayName + " Item Pipe",
                        0.25F,
                        aMaterial,
                        baseInvSlots / 4,
                        13107200 / baseInvSlots,
                        true).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveSmall.get(aMaterial),
                new MTEItem(
                        startID + 6,
                        "GT_Pipe_Restrictive_" + name + "_Small",
                        "Small Restrictive " + displayName + " Item Pipe",
                        0.375F,
                        aMaterial,
                        baseInvSlots / 2,
                        6553600 / baseInvSlots,
                        true).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveMedium.get(aMaterial),
                new MTEItem(
                        startID + 7,
                        "GT_Pipe_Restrictive_" + name,
                        "Restrictive " + displayName + " Item Pipe",
                        0.50F,
                        aMaterial,
                        baseInvSlots,
                        3276800 / baseInvSlots,
                        true).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveLarge.get(aMaterial),
                new MTEItem(
                        startID + 8,
                        "GT_Pipe_Restrictive_" + name + "_Large",
                        "Large Restrictive " + displayName + " Item Pipe",
                        0.75F,
                        aMaterial,
                        baseInvSlots * 2,
                        1638400 / baseInvSlots,
                        true).getStackForm(1L));
        GTOreDictUnificator.registerOre(
                OrePrefixes.pipeRestrictiveHuge.get(aMaterial),
                new MTEItem(
                        startID + 9,
                        "GT_Pipe_Restrictive_" + name + "_Huge",
                        "Huge Restrictive " + displayName + " Item Pipe",
                        0.875F,
                        aMaterial,
                        baseInvSlots * 4,
                        819200 / baseInvSlots,
                        true).getStackForm(1L));
    }
}
// Last ID here: 5679
