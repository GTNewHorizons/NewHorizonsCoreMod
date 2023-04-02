package com.dreammaster.gthandler;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.metatileentity.implementations.GT_MetaPipeEntity_Fluid;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_OreDictUnificator;

public class GT_Loader_FluidPipes {

    public void run() {
        registerHighTierPipes();
    }

    private void registerHighTierPipes() {
        // 5110 - 5114 Copper
        // 5120 - 5124 Bronze
        // 5130 - 5134 Steel
        // 5140 - 5144 Stainless
        // 5150 - 5154 Titanium
        // 5160 - 5164 Tungstensteel
        // 5165 - 5167 High Pressure Pipe
        // 5168 - Plasma Pipe
        // 5170 - 5174 Plastic

        // 5180 - 5187 NiobiumTitanium

        generateFluidPipes(Materials.NiobiumTitanium, Materials.NiobiumTitanium.mName, 5180, 900, 2900, true);
        generateFluidMultiPipes(Materials.NiobiumTitanium, Materials.NiobiumTitanium.mName, 5185, 900, 2900, true);

        // 5190 - 5197 Enderium

        generateFluidPipes(Materials.Enderium, Materials.Enderium.mName, 5190, 1800, 15000, true);
        generateFluidMultiPipes(Materials.Enderium, Materials.Enderium.mName, 5195, 1800, 15000, true);

        // 5200 - 5207 Naquadah

        generateFluidPipes(Materials.Naquadah, Materials.Naquadah.mName, 5200, 9000, 19000, true);
        generateFluidMultiPipes(Materials.Naquadah, Materials.Naquadah.mName, 5205, 9000, 19000, true);

        // 5210 - 5217 Neutronium

        generateFluidPipes(Materials.Neutronium, Materials.Neutronium.mName, 5210, 16800, 1000000, true);
        generateFluidMultiPipes(Materials.Neutronium, Materials.Neutronium.mName, 5215, 16800, 1000000, true);

        // 5220 - 5227 Nether Star

        generateFluidPipes(Materials.NetherStar, Materials.NetherStar.mName, 5220, 19200, 1000000, true);
        generateFluidMultiPipes(Materials.NetherStar, Materials.NetherStar.mName, 5225, 19200, 1000000, true);

        // 5230 - 5237 Mysteroius Crystal

        generateFluidPipes(Materials.MysteriousCrystal, Materials.MysteriousCrystal.mName, 5230, 24000, 1000000, true);
        generateFluidMultiPipes(
                Materials.MysteriousCrystal,
                Materials.MysteriousCrystal.mName,
                5235,
                24000,
                1000000,
                true);

        // 5240 - 5247 Awakened Draconium

        generateFluidPipes(Materials.DraconiumAwakened, Materials.DraconiumAwakened.mName, 5240, 45000, 10000000, true);
        generateFluidMultiPipes(
                Materials.DraconiumAwakened,
                Materials.DraconiumAwakened.mName,
                5245,
                45000,
                10000000,
                true);

        // 5250 - 5257 Infinity

        generateFluidPipes(Materials.Infinity, Materials.Infinity.mName, 5250, 60000, 10000000, true);
        generateFluidMultiPipes(Materials.Infinity, Materials.Infinity.mName, 5255, 60000, 10000000, true);

        // 5260 - 5267 Wrough Iron

        generateFluidPipes(Materials.WroughtIron, Materials.WroughtIron.mName, 5260, 180, 2250, true);
        generateFluidMultiPipes(Materials.WroughtIron, Materials.WroughtIron.mName, 5265, 180, 2250, true);

        generateFluidPipes(
                GT_CoreModSupport.RadoxPolymer,
                GT_CoreModSupport.RadoxPolymer.mName,
                5760,
                5000,
                1500,
                true);
        // 5277 - 5588 Free, as of GT 5.09.32.xx
        // 5589+ Item Pipes Tin
    }

    private static void generateFluidPipes(Materials aMaterial, String name, int startID, int baseCapacity,
            int heatCapacity, boolean gasProof) {
        generateFluidPipes(
                aMaterial,
                name,
                GT_LanguageManager.i18nPlaceholder ? "%material" : aMaterial.mDefaultLocalName,
                startID,
                baseCapacity,
                heatCapacity,
                gasProof);
    }

    private static void generateFluidPipes(Materials aMaterial, String name, String displayName, int startID,
            int baseCapacity, int heatCapacity, boolean gasProof) {
        GT_OreDictUnificator.registerOre(
                OrePrefixes.pipeTiny.get(aMaterial),
                new GT_MetaPipeEntity_Fluid(
                        startID,
                        "GT_Pipe_" + name + "_Tiny",
                        "Tiny " + displayName + " Fluid Pipe",
                        0.25F,
                        aMaterial,
                        baseCapacity / 6,
                        heatCapacity,
                        gasProof).getStackForm(1L));
        GT_OreDictUnificator.registerOre(
                OrePrefixes.pipeSmall.get(aMaterial),
                new GT_MetaPipeEntity_Fluid(
                        startID + 1,
                        "GT_Pipe_" + name + "_Small",
                        "Small " + displayName + " Fluid Pipe",
                        0.375F,
                        aMaterial,
                        baseCapacity / 3,
                        heatCapacity,
                        gasProof).getStackForm(1L));
        GT_OreDictUnificator.registerOre(
                OrePrefixes.pipeMedium.get(aMaterial),
                new GT_MetaPipeEntity_Fluid(
                        startID + 2,
                        "GT_Pipe_" + name,
                        displayName + " Fluid Pipe",
                        0.5F,
                        aMaterial,
                        baseCapacity,
                        heatCapacity,
                        gasProof).getStackForm(1L));
        GT_OreDictUnificator.registerOre(
                OrePrefixes.pipeLarge.get(aMaterial),
                new GT_MetaPipeEntity_Fluid(
                        startID + 3,
                        "GT_Pipe_" + name + "_Large",
                        "Large " + displayName + " Fluid Pipe",
                        0.75F,
                        aMaterial,
                        baseCapacity * 2,
                        heatCapacity,
                        gasProof).getStackForm(1L));
        GT_OreDictUnificator.registerOre(
                OrePrefixes.pipeHuge.get(aMaterial),
                new GT_MetaPipeEntity_Fluid(
                        startID + 4,
                        "GT_Pipe_" + name + "_Huge",
                        "Huge " + displayName + " Fluid Pipe",
                        0.875F,
                        aMaterial,
                        baseCapacity * 4,
                        heatCapacity,
                        gasProof).getStackForm(1L));
    }

    private static void generateFluidMultiPipes(Materials aMaterial, String name, int startID, int baseCapacity,
            int heatCapacity, boolean gasProof) {
        generateFluidMultiPipes(
                aMaterial,
                name,
                GT_LanguageManager.i18nPlaceholder ? "%material" : aMaterial.mDefaultLocalName,
                startID,
                baseCapacity,
                heatCapacity,
                gasProof);
    }

    private static void generateFluidMultiPipes(Materials aMaterial, String name, String displayName, int startID,
            int baseCapacity, int heatCapacity, boolean gasProof) {
        GT_OreDictUnificator.registerOre(
                OrePrefixes.pipeQuadruple.get(aMaterial),
                new GT_MetaPipeEntity_Fluid(
                        startID,
                        "GT_Pipe_" + name + "_Quadruple",
                        "Quadruple " + displayName + " Fluid Pipe",
                        1.0F,
                        aMaterial,
                        baseCapacity,
                        heatCapacity,
                        gasProof,
                        4).getStackForm(1L));
        GT_OreDictUnificator.registerOre(
                OrePrefixes.pipeNonuple.get(aMaterial),
                new GT_MetaPipeEntity_Fluid(
                        startID + 1,
                        "GT_Pipe_" + name + "_Nonuple",
                        "Nonuple " + displayName + " Fluid Pipe",
                        1.0F,
                        aMaterial,
                        baseCapacity / 3,
                        heatCapacity,
                        gasProof,
                        9).getStackForm(1L));
    }
}
