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

import bartworks.system.material.WerkstoffLoader;
import goodgenerator.items.GGMaterial;
import goodgenerator.util.ItemRefer;
import gregtech.api.enums.CondensateType;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.NaniteTier;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import tectech.recipe.TecTechRecipeMaps;
import tectech.thing.CustomItemList;

public class BECRecipes implements Runnable {

    private static final NaniteTier[] TIER_TO_NANITE = { NaniteTier.Carbon, NaniteTier.Silver, NaniteTier.Gold,
            NaniteTier.Transcendent, NaniteTier.SixPhasedCopper, NaniteTier.WhiteDwarf, NaniteTier.BlackDwarf,
            NaniteTier.Universium, NaniteTier.Eternity, NaniteTier.MagMatter };

    @Override
    public void run() {
        addComputationCoreRecipes();
    }

    public void runLate() {
        if (EternalSingularity.isModLoaded()) addSGRecipes();
    }

    private void addComputationCoreRecipes() {
        final int duration = 64_000_000;

        final ItemStack[] hulls = new ItemStack[15];
        final ItemStack[] energyHatches = new ItemStack[15];
        for (int i = 0; i < ItemList.MACHINE_HULLS.length; ++i) {
            hulls[i] = ItemList.MACHINE_HULLS[i].get(64);
            energyHatches[i] = ItemList.WIRELESS_ENERGY_HATCHES[i].get(64);
        }
        hulls[14] = CustomItemList.TimeAccelerationFieldGeneratorTier8.get(64);
        energyHatches[14] = CustomItemList.StabilisationFieldGeneratorTier8.get(64);

        final ItemStack[] coalCasings = new ItemStack[] { GregtechItemList.GTPP_Casing_ULV.get(64),
                ItemRefer.Compassline_Casing_LV.get(64), ItemRefer.Compassline_Casing_MV.get(64),
                ItemRefer.Compassline_Casing_HV.get(64), ItemRefer.Compassline_Casing_EV.get(64),
                ItemRefer.Compassline_Casing_IV.get(64), ItemRefer.Compassline_Casing_LuV.get(64),
                ItemRefer.Compassline_Casing_ZPM.get(64), ItemRefer.Compassline_Casing_UV.get(64),
                ItemRefer.Compassline_Casing_UHV.get(64), ItemRefer.Compassline_Casing_UEV.get(64),
                ItemRefer.Compassline_Casing_UIV.get(64), ItemRefer.Compassline_Casing_UMV.get(64),
                ItemRefer.Compassline_Casing_UXV.get(64),
                CustomItemList.SpacetimeCompressionFieldGeneratorTier8.get(64) };

        final ItemStack[] batteries = new ItemStack[] { ItemList.Battery_RE_ULV_Tantalum.get(64),
                ItemList.Battery_RE_LV_Lithium.get(64), ItemList.Battery_RE_MV_Lithium.get(64),
                ItemList.Battery_RE_HV_Lithium.get(64), GTModHandler.getIC2Item("lapotronCrystal", 64L, 26),
                ItemList.Energy_LapotronicOrb.get(64), ItemList.Energy_LapotronicOrb2.get(64),
                ItemList.Energy_Module.get(64), ItemList.Energy_Cluster.get(64), ItemList.BatteryHull_UHV_Full.get(64),
                ItemList.BatteryHull_UEV_Full.get(64), ItemList.BatteryHull_UIV_Full.get(64), ItemList.ZPM3.get(64),
                ItemList.ZPM4.get(64), ItemList.ZPM5.get(64) };

        final ItemStack[] material1 = new ItemStack[] {
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Lead, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Tin, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Copper, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Gold, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Aluminium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Tungsten, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.VanadiumGallium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Naquadah, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.NaquadahAlloy, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Samarium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.TengamPurified, 64),
                MaterialsElements.STANDALONE.HYPOGEN.getPlateSuperdense(64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Quantium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.MagMatter, 64),
                MaterialsElements.STANDALONE.CHRONOMATIC_GLASS.getPlateSuperdense(64), };

        final ItemStack[] material2 = new ItemStack[] {
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.CastIron, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Steel, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Aluminium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.StainlessSteel, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Titanium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.TungstenSteel, 64),
                WerkstoffLoader.RhodiumPlatedPalladium.get(OrePrefixes.plateSuperdense, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Iridium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Osmium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Neutronium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Bedrockium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.TranscendentMetal, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.SpaceTime, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.MHDCSM, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Eternity, 64), };

        final ItemStack[] material3 = new ItemStack[] {
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.RedAlloy, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.RedstoneAlloy, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.AnnealedCopper, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.EnergeticAlloy, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.TungstenSteel, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Iridium, 64),
                WerkstoffLoader.Ruridit.get(OrePrefixes.plateSuperdense, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Europium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.ElectrumFlux, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Tritanium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Draconium, 64),
                MaterialsElements.STANDALONE.RHUGNOR.getPlateSuperdense(64),
                MaterialsElements.STANDALONE.DRAGON_METAL.getPlateSuperdense(64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Universium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Infinity, 64), };

        final ItemStack[] compCircuits = new ItemStack[] { NHItemList.Compressed_Circuit_Array_ULV.get(1),
                NHItemList.Compressed_Circuit_Array_LV.get(1), NHItemList.Compressed_Circuit_Array_MV.get(1),
                NHItemList.Compressed_Circuit_Array_HV.get(1), NHItemList.Compressed_Circuit_Array_EV.get(1),
                NHItemList.Compressed_Circuit_Array_IV.get(1), NHItemList.Compressed_Circuit_Array_LuV.get(1),
                NHItemList.Compressed_Circuit_Array_ZPM.get(1), NHItemList.Compressed_Circuit_Array_UV.get(1),
                NHItemList.Compressed_Circuit_Array_UHV.get(1), NHItemList.Compressed_Circuit_Array_UEV.get(1),
                NHItemList.Compressed_Circuit_Array_UIV.get(1), NHItemList.Compressed_Circuit_Array_UMV.get(1),
                NHItemList.Compressed_Circuit_Array_UXV.get(1), NHItemList.Compressed_Circuit_Array_MAX.get(1), };

        final ItemStack[] energyConduits = new ItemStack[] { ItemList.MetaMaterial_EnergyConduit1.get(64),
                ItemList.MetaMaterial_EnergyConduit2.get(64), ItemList.MetaMaterial_EnergyConduit3.get(64) };

        final FluidStack[] condensates = new FluidStack[] {
                CondensateType.ChromaticGlass.getEntangled(1_024_000 * INGOTS),
                CondensateType.Neutronium.getEntangled(1_024_000 * INGOTS),
                CondensateType.CosmicNeutronium.getEntangled(1_024_000 * INGOTS),
                CondensateType.Bedrockium.getEntangled(1_024_000 * INGOTS) };


    }

    private void addSGRecipes() {

        final int baseStargateTime = 16_000_000 * SECONDS;

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
