package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.INGOTS;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.NANITE_TIERS;
import static gtPlusPlus.core.material.MaterialsElements.STANDALONE.HYPOGEN;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.item.NHItemList;

import goodgenerator.items.GGMaterial;
import gregtech.api.enums.CondensateType;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.NaniteTier;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import tectech.recipe.TecTechRecipeMaps;
import tectech.thing.CustomItemList;

public class BECRecipes implements Runnable {

    private static final NaniteTier[] TIER_TO_NANITE = { NaniteTier.Carbon, NaniteTier.Silver, NaniteTier.Gold,
            NaniteTier.Transcendent, NaniteTier.SixPhasedCopper, NaniteTier.WhiteDwarf, NaniteTier.BlackDwarf,
            NaniteTier.Universium, NaniteTier.Eternity, NaniteTier.MagMatter };

    @Override
    public void run() {
        if (EternalSingularity.isModLoaded()) addSGRecipes();
    }

    private void addSGRecipes() {

        final int baseStargateTime = 8_000_000 * SECONDS;

        // Stargate-Radiation-Containment-Plate
        addBec(
                NHItemList.StargateShieldingFoil.get(),
                new ItemStack[] { CustomItemList.StabilisationFieldGeneratorTier8.get(64),
                        CustomItemList.Godforge_HarmonicPhononTransmissionConduit.get(32),
                        ItemList.SuperconductivePlasmaEnergyConduit.get(64),
                        ItemList.FineStructureConstantManipulator.get(64),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.MagMatter, 16L),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Universium, 8L),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Eternity, 8L),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.SpaceTime, 16L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MAX, 16), ItemList.Sensor_UXV.get(32L),
                        ItemList.Emitter_UXV.get(32L),
                        getModItem(EternalSingularity.ID, "combined_singularity", 64, 15),
                        Materials.WhiteDwarfMatter.getNanite(16), Materials.BlackDwarfMatter.getNanite(16),
                        Materials.Universium.getNanite(16), Materials.MagMatter.getNanite(16) },
                nanites(7, 6, 5, 5, 3, 3, 2, 2, 9, 4, 4, 1, 6, 7, 8, 10),
                new FluidStack[] { CondensateType.QuarkGluonPlasma.getEntangled(1_024_000 * INGOTS),
                        CondensateType.PhononMedium.getEntangled(256_000 * INGOTS),
                        CondensateType.MagMatter.getEntangled(4_096 * INGOTS),
                        CondensateType.MHDCSM.getEntangled(1_024 * INGOTS) },
                baseStargateTime,
                TierEU.RECIPE_UXV);

        // Stargate Chevron
        addBec(
                NHItemList.StargateChevron.get(),
                new ItemStack[] { CustomItemList.EOH_Reinforced_Spatial_Casing.get(64),
                        CustomItemList.EOH_Reinforced_Temporal_Casing.get(64), ItemList.MetaMaterial_WaveFocus4.get(64),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Amalgatite, 64),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.MagMatter, 16L),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.MagMatter, 8L),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.MHDCSM, 8L),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.MHDCSM, 16L),
                        ItemList.MetaMaterial_Shielding3.get(64), ItemList.MetaMaterial_Waveguide3.get(64),
                        ItemList.MetaMaterial_EnergyConduit3.get(64),
                        ItemList.MetaMaterial_ElectrograviticValve3.get(64), ItemList.Electric_Piston_UXV.get(64L),
                        ItemList.Robot_Arm_UXV.get(64L), ItemList.Field_Generator_UXV.get(32),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MAX, 32), },
                nanites(2, 2, 4, 10, 1, 3, 4, 3, 6, 6, 7, 7, 5, 5, 8, 9),
                new FluidStack[] { CondensateType.QuarkGluonPlasma.getEntangled(1_024_000 * INGOTS),
                        CondensateType.PhononMedium.getEntangled(256_000 * INGOTS),
                        CondensateType.MagMatter.getEntangled(4_096 * INGOTS),
                        CondensateType.Eternity.getEntangled(2_048 * INGOTS) },
                baseStargateTime,
                TierEU.RECIPE_UXV);

        // Multi-Material Mesh
        addBec(
                NHItemList.StargateMaterialMesh.get(),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Infinity, 64L),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.ProtoHalkonite, 64L),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.TranscendentMetal, 64L),
                        HYPOGEN.getLongRod(64),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.SuperconductorUMVBase, 64L),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Creon, 64L),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Mellion, 64L),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Hexanite, 64L),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.SpaceTime, 64L),
                        GGMaterial.shirabon.get(OrePrefixes.stickLong, 64),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.WhiteDwarfMatter, 64L),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.BlackDwarfMatter, 64L),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Universium, 64L),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.MHDCSM, 64L),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Eternity, 64L),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.MagMatter, 64L) },
                nanites(1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 9, 10),
                new FluidStack[] { CondensateType.QuarkGluonPlasma.getEntangled(128_000 * INGOTS),
                        CondensateType.PhononMedium.getEntangled(32_000 * INGOTS),
                        CondensateType.MagMatter.getEntangled(512 * INGOTS),
                        CondensateType.Universium.getEntangled(128 * INGOTS) },
                baseStargateTime / 8,
                TierEU.RECIPE_UXV);

        // Stargate Frame Part
        addBec(
                NHItemList.StargateFramePart.get(),
                new ItemStack[] { ItemList.MetaMaterial_Shielding3.get(64),
                        ItemList.MetaMaterial_ElectrograviticValve3.get(64),
                        ItemList.MetaMaterial_ElectrograviticValve3.get(64), ItemList.MetaMaterial_Shielding3.get(64),
                        ItemList.MetaMaterial_EnergyConduit3.get(64), NHItemList.StargateMaterialMesh.get(),
                        NHItemList.StargateMaterialMesh.get(), ItemList.MetaMaterial_EnergyConduit3.get(64),
                        ItemList.MetaMaterial_EnergyConduit3.get(64), NHItemList.StargateMaterialMesh.get(),
                        NHItemList.StargateMaterialMesh.get(), ItemList.MetaMaterial_EnergyConduit3.get(64),
                        ItemList.MetaMaterial_Shielding3.get(64), ItemList.MetaMaterial_ElectrograviticValve3.get(64),
                        ItemList.MetaMaterial_ElectrograviticValve3.get(64), ItemList.MetaMaterial_Shielding3.get(64) },
                nanites(3, 7, 7, 2, 5, 1, 8, 6, 5, 9, 10, 6, 2, 4, 4, 3),
                new FluidStack[] { CondensateType.QuarkGluonPlasma.getEntangled(512_000 * INGOTS),
                        CondensateType.PhononMedium.getEntangled(128_000 * INGOTS),
                        CondensateType.MagMatter.getEntangled(2_048 * INGOTS),
                        CondensateType.Eternity.getEntangled(1_024 * INGOTS) },
                baseStargateTime / 2,
                TierEU.RECIPE_UXV);
    }

    private void addBec(ItemStack output, ItemStack[] inputs, NaniteTier[] nanites, FluidStack[] condensates,
            int duration, long eut) {
        GTValues.RA.stdBuilder().itemInputs(inputs).fluidInputs(condensates).itemOutputs(output)
                .metadata(NANITE_TIERS, nanites).duration(duration).eut(eut)
                .addTo(TecTechRecipeMaps.condensateAssemblingRecipes);
    }

    private static NaniteTier[] nanites(int... tiers) {
        NaniteTier[] result = new NaniteTier[tiers.length];
        for (int i = 0; i < tiers.length; i++) {
            result[i] = TIER_TO_NANITE[tiers[i] - 1];
        }
        return result;
    }
}
