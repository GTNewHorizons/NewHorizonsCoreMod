package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.UniversalSingularities;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.INGOTS;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.NANITE_TIERS;
import static gtPlusPlus.core.material.MaterialsElements.STANDALONE.HYPOGEN;
import static kekztech.common.Blocks.lscLapotronicEnergyUnit;
import static tectech.thing.CustomItemList.Godforge_SingularityShieldingCasing;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.item.NHItemList;
import com.dreammaster.scripts.IngredientFactory;

import bartworks.common.loaders.ItemRegistry;
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
import gregtech.api.util.GTUtility;
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
        addCircuitArrayRecipes();
        if (UniversalSingularities.isModLoaded()) addComputationSingularityRecipes();
    }

    public void runLate() {
        if (EternalSingularity.isModLoaded()) {
            addSGRecipes();

            // Exo-Foundry Chassis Tier 3
            addBec(
                    ItemList.Magnetic_Chassis_T3_ExoFoundry.get(1),
                    new ItemStack[] { ItemRefer.Field_Restriction_Coil_T4.get(1),
                            Godforge_SingularityShieldingCasing.get(4), new ItemStack(lscLapotronicEnergyUnit, 1, 5),
                            ItemList.SpaceElevatorMotorT5.get(2),
                            IngredientFactory.getModItem(DraconicEvolution.ID, "chaoticCore", 2),
                            IngredientFactory.getModItem(EternalSingularity.ID, "combined_singularity", 64, 15),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UXV, 16),
                            ItemList.Field_Generator_UMV.get(8),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.SpaceTime, 64),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.SuperconductorUMVBase, 64),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Eternity, 64),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.MagMatter, 64),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.SpaceTime, 16),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.SuperconductorUMVBase, 16),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Eternity, 16),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.MagMatter, 16) },
                    nanites(4, 2, 3, 5, 9, 8, 10, 6, 2, 2, 3, 3, 4, 4, 5, 5),
                    new FluidStack[] { CondensateType.QuarkGluonPlasma.getEntangled(1_024_000),
                            CondensateType.PhononMedium.getEntangled(256_000),
                            CondensateType.MagMatter.getEntangled(4_096 * INGOTS),
                            CondensateType.MHDCSM.getEntangled(1_024 * INGOTS) },
                    600 * SECONDS,
                    TierEU.RECIPE_UXV);
        }
    }

    private void addComputationSingularityRecipes() {
        final int duration = 32_000_000 * SECONDS;

        final ItemStack[] hulls = new ItemStack[15];
        final ItemStack[] energyHatches = new ItemStack[15];
        for (int i = 0; i < 14; ++i) {
            hulls[i] = ItemList.MACHINE_HULLS[i].get(64);
            energyHatches[i] = ItemList.WIRELESS_ENERGY_HATCHES[i].get(64);
        }
        hulls[14] = CustomItemList.TimeAccelerationFieldGeneratorTier8.get(64);
        energyHatches[14] = CustomItemList.StabilisationFieldGeneratorTier8.get(64);

        final ItemStack[] circuitSingularities = new ItemStack[] {
                GTModHandler.getModItem(UniversalSingularities.ID, "universal.circuit.singularity", 1, 0),
                GTModHandler.getModItem(UniversalSingularities.ID, "universal.circuit.singularity", 1, 1),
                GTModHandler.getModItem(UniversalSingularities.ID, "universal.circuit.singularity", 1, 2),
                GTModHandler.getModItem(UniversalSingularities.ID, "universal.circuit.singularity", 1, 3),
                GTModHandler.getModItem(UniversalSingularities.ID, "universal.circuit.singularity", 1, 4),
                GTModHandler.getModItem(UniversalSingularities.ID, "universal.circuit.singularity", 1, 5),
                GTModHandler.getModItem(UniversalSingularities.ID, "universal.circuit.singularity", 1, 6),
                GTModHandler.getModItem(UniversalSingularities.ID, "universal.circuit.singularity", 1, 7),
                GTModHandler.getModItem(UniversalSingularities.ID, "universal.circuit.singularity", 1, 8),
                GTModHandler.getModItem(UniversalSingularities.ID, "universal.circuit.singularity", 1, 9),
                GTModHandler.getModItem(UniversalSingularities.ID, "universal.circuit2.singularity", 1, 0),
                GTModHandler.getModItem(UniversalSingularities.ID, "universal.circuit2.singularity", 1, 1),
                GTModHandler.getModItem(UniversalSingularities.ID, "universal.circuit2.singularity", 1, 2),
                GTModHandler.getModItem(UniversalSingularities.ID, "universal.circuit2.singularity", 1, 3),
                GTModHandler.getModItem(UniversalSingularities.ID, "universal.circuit2.singularity", 1, 4) };

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

        final ItemStack[] compCircuits = new ItemStack[] { NHItemList.Compressed_Circuit_Array_ULV.get(16),
                NHItemList.Compressed_Circuit_Array_LV.get(16), NHItemList.Compressed_Circuit_Array_MV.get(16),
                NHItemList.Compressed_Circuit_Array_HV.get(16), NHItemList.Compressed_Circuit_Array_EV.get(16),
                NHItemList.Compressed_Circuit_Array_IV.get(16), NHItemList.Compressed_Circuit_Array_LuV.get(16),
                NHItemList.Compressed_Circuit_Array_ZPM.get(16), NHItemList.Compressed_Circuit_Array_UV.get(16),
                NHItemList.Compressed_Circuit_Array_UHV.get(16), NHItemList.Compressed_Circuit_Array_UEV.get(16),
                NHItemList.Compressed_Circuit_Array_UIV.get(16), NHItemList.Compressed_Circuit_Array_UMV.get(16),
                NHItemList.Compressed_Circuit_Array_UXV.get(16), NHItemList.Compressed_Circuit_Array_MAX.get(16), };

        final ItemStack[] energyConduits = new ItemStack[] { ItemList.MetaMaterial_EnergyConduit1.get(64),
                ItemList.MetaMaterial_EnergyConduit2.get(64), ItemList.MetaMaterial_EnergyConduit3.get(64) };

        final FluidStack[] condensates = new FluidStack[] {
                CondensateType.ChromaticGlass.getEntangled(1_024_000 * INGOTS),
                CondensateType.Neutronium.getEntangled(1_024_000 * INGOTS),
                CondensateType.CosmicNeutronium.getEntangled(1_024_000 * INGOTS),
                CondensateType.Bedrockium.getEntangled(1_024_000 * INGOTS) };

        for (int t = 0; t < 15; ++t) {
            addBec(
                    circuitSingularities[t],
                    new ItemStack[] {
                            GTModHandler.getModItem(UniversalSingularities.ID, "universal.circuit2.singularity", 1, 6),
                            hulls[t], coalCasings[t], material1[t], energyConduits[t / 5], compCircuits[t],
                            compCircuits[t], energyConduits[t / 5], energyConduits[t / 5], compCircuits[t],
                            compCircuits[t], energyConduits[t / 5], material2[t], energyHatches[t], batteries[t],
                            material3[t] },
                    nanites(10, 5, 9, 1, 4, 8, 8, 4, 4, 8, 8, 4, 2, 6, 7, 3),
                    condensates,
                    duration,
                    TierEU.RECIPE_UXV);
        }
    }

    private void addSGRecipes() {

        final int baseStargateTime = 8_000_000 * SECONDS;;

        // Stargate-Radiation-Containment-Plate
        addBec(
                NHItemList.StargateShieldingFoil.get(),
                new ItemStack[] { CustomItemList.StabilisationFieldGeneratorTier8.get(64),
                        CustomItemList.Godforge_HarmonicPhononTransmissionConduit.get(32),
                        ItemList.SuperconductivePlasmaEnergyConduit.get(64),
                        ItemList.FineStructureConstantManipulator.get(64),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.MagMatter, 32L),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Universium, 16L),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Eternity, 16L),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.SpaceTime, 32L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MAX, 16), ItemList.Sensor_UXV.get(32L),
                        ItemList.Emitter_UXV.get(32L),
                        getModItem(EternalSingularity.ID, "combined_singularity", 64, 15),
                        Materials.WhiteDwarfMatter.getNanite(16), Materials.BlackDwarfMatter.getNanite(16),
                        Materials.Universium.getNanite(16), Materials.MagMatter.getNanite(16) },
                nanites(7, 6, 5, 5, 3, 3, 2, 2, 9, 4, 4, 1, 6, 7, 8, 10),
                new FluidStack[] { CondensateType.QuarkGluonPlasma.getEntangled(1_024_000),
                        CondensateType.PhononMedium.getEntangled(256_000),
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
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.MagMatter, 32L),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.MagMatter, 16L),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.MHDCSM, 16L),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.MHDCSM, 32L),
                        ItemList.MetaMaterial_Shielding3.get(64), ItemList.MetaMaterial_Waveguide3.get(64),
                        ItemList.MetaMaterial_EnergyConduit3.get(64),
                        ItemList.MetaMaterial_ElectrograviticValve3.get(64), ItemList.Electric_Piston_UXV.get(64L),
                        ItemList.Robot_Arm_UXV.get(64L), ItemList.Field_Generator_UXV.get(32),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MAX, 32), },
                nanites(2, 2, 4, 10, 1, 3, 4, 3, 6, 6, 7, 7, 5, 5, 8, 9),
                new FluidStack[] { CondensateType.QuarkGluonPlasma.getEntangled(1_024_000),
                        CondensateType.PhononMedium.getEntangled(256_000),
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
                new FluidStack[] { CondensateType.QuarkGluonPlasma.getEntangled(128_000),
                        CondensateType.PhononMedium.getEntangled(32_00),
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
                new FluidStack[] { CondensateType.QuarkGluonPlasma.getEntangled(512_000),
                        CondensateType.PhononMedium.getEntangled(128_000),
                        CondensateType.MagMatter.getEntangled(2_048 * INGOTS),
                        CondensateType.Eternity.getEntangled(1_024 * INGOTS) },
                baseStargateTime / 2,
                TierEU.RECIPE_UXV);
    }

    private void addCircuitArrayRecipes() {

        final int duration = 50_000 * SECONDS;

        final ItemStack[] dynamoHatch = new ItemStack[15];
        final ItemStack[] energyHatch = new ItemStack[15];
        final ItemStack[] wetTransformer = new ItemStack[15];
        for (int i = 0; i < 14; ++i) {
            dynamoHatch[i] = ItemList.HATCHES_DYNAMO[i].get(64);
            energyHatch[i] = ItemList.HATCHES_ENERGY[i].get(64);
            wetTransformer[i] = ItemList.POWER_TRANSFORMERS[i].get(64);
        }
        dynamoHatch[14] = CustomItemList.TimeAccelerationFieldGeneratorTier8.get(64);
        energyHatch[14] = CustomItemList.SpacetimeCompressionFieldGeneratorTier8.get(64);
        wetTransformer[14] = CustomItemList.StabilisationFieldGeneratorTier8.get(64);

        final ItemStack[] circuits = new ItemStack[] { GTUtility.copyAmountUnsafe(8_388_608, ItemList.NandChip.get(1)),
                GTUtility.copyAmountUnsafe(8_388_608 / 2, ItemList.Circuit_Microprocessor.get(1)),
                GTUtility.copyAmountUnsafe(8_388_608 / 4, ItemList.Circuit_Processor.get(1)),
                GTUtility.copyAmountUnsafe(8_388_608 / 8, ItemList.Circuit_Nanoprocessor.get(1)),
                GTUtility.copyAmountUnsafe(8_388_608 / 16, ItemList.Circuit_Quantumprocessor.get(1)),
                GTUtility.copyAmountUnsafe(8_388_608 / 32, ItemList.Circuit_Crystalprocessor.get(1)),
                GTUtility.copyAmountUnsafe(8_388_608 / 64, ItemList.Circuit_Neuroprocessor.get(1)),
                GTUtility.copyAmountUnsafe(8_388_608 / 128, ItemList.Circuit_Bioprocessor.get(1)),
                GTUtility.copyAmountUnsafe(8_388_608 / 256, ItemList.Circuit_Crystalmainframe.get(1)),
                GTUtility.copyAmountUnsafe(8_388_608 / 512, ItemList.Circuit_Wetwaremainframe.get(1)),
                GTUtility.copyAmountUnsafe(8_388_608 / 1024, ItemList.Circuit_Biomainframe.get(1)),
                GTUtility.copyAmountUnsafe(8_388_608 / 2048, ItemList.Circuit_OpticalMainframe.get(1)),
                GTUtility.copyAmountUnsafe(8_388_608 / 4096, NHItemList.PikoCircuit.get(1)),
                GTUtility.copyAmountUnsafe(8_388_608 / 8192, NHItemList.QuantumCircuit.get(1)),
                GTUtility.copyAmountUnsafe(8_388_608 / 16384, NHItemList.PlanckCircuit.get(1)), };

        final ItemStack[] circuitArrays = new ItemStack[] { NHItemList.Compressed_Circuit_Array_ULV.get(1),
                NHItemList.Compressed_Circuit_Array_LV.get(1), NHItemList.Compressed_Circuit_Array_MV.get(1),
                NHItemList.Compressed_Circuit_Array_HV.get(1), NHItemList.Compressed_Circuit_Array_EV.get(1),
                NHItemList.Compressed_Circuit_Array_IV.get(1), NHItemList.Compressed_Circuit_Array_LuV.get(1),
                NHItemList.Compressed_Circuit_Array_ZPM.get(1), NHItemList.Compressed_Circuit_Array_UV.get(1),
                NHItemList.Compressed_Circuit_Array_UHV.get(1), NHItemList.Compressed_Circuit_Array_UEV.get(1),
                NHItemList.Compressed_Circuit_Array_UIV.get(1), NHItemList.Compressed_Circuit_Array_UMV.get(1),
                NHItemList.Compressed_Circuit_Array_UXV.get(1), NHItemList.Compressed_Circuit_Array_MAX.get(1), };

        final ItemStack[] longRod = new ItemStack[] {
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.CastIron, 64),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 64),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Aluminium, 64),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.StainlessSteel, 64),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Titanium, 64),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.TungstenSteel, 64),
                WerkstoffLoader.RhodiumPlatedPalladium.get(OrePrefixes.stickLong, 64),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Iridium, 64),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmium, 64),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Neutronium, 64),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Bedrockium, 64),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.BlackPlutonium, 64),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.SpaceTime, 64),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.MHDCSM, 64),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.MagMatter, 64), };

        final ItemStack[] boltSD = new ItemStack[] {
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.RedAlloy, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Copper, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.RedAlloy, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Platinum, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.NiobiumTitanium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.YttriumBariumCuprate, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.CosmicNeutronium, 64),
                MaterialsElements.STANDALONE.CHRONOMATIC_GLASS.getPlateSuperdense(64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.SuperconductorLuVBase, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.SuperconductorZPMBase, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.SuperconductorUHVBase, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.SuperconductorUEVBase, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.TranscendentMetal, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.SuperconductorUMVBase, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.WhiteDwarfMatter, 64), };

        final ItemStack[] wireSD = new ItemStack[] {
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.AnnealedCopper, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Copper, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.AnnealedCopper, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Electrum, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Platinum, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.NiobiumTitanium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.YttriumBariumCuprate, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.NiobiumTitanium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Aluminium, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.NaquadahEnriched, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.ElectrumFlux, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Tritanium, 64),
                MaterialsElements.STANDALONE.RHUGNOR.getPlateSuperdense(64),
                GGMaterial.metastableOganesson.get(OrePrefixes.plateSuperdense, 64),
                GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Hexanite, 64), };

        final ItemStack[] superconductor = new ItemStack[] {
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.RedAlloy, 64),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.RedstoneAlloy, 64),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorMV, 64),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorHV, 64),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorEV, 64),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorIV, 64),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorLuV, 64),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorZPM, 64),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUV, 64),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUHV, 64),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUEV, 64),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUIV, 64),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUMV, 64),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.Infinity, 64),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SpaceTime, 64), };

        final ItemStack[] hugePipe = new ItemStack[] {
                GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Lead, 64),
                GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Steel, 64),
                GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.StainlessSteel, 64),
                GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Titanium, 64),
                GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.TungstenSteel, 64),
                GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.NiobiumTitanium, 64),
                GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Enderium, 64),
                GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Naquadah, 64),
                GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Neutronium, 64),
                GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Bedrockium, 64),
                GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Infinity, 64),
                GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.TranscendentMetal, 64),
                GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.SpaceTime, 64),
                CustomItemList.Godforge_HarmonicPhononTransmissionConduit.get(64),
                ItemList.SuperconductivePlasmaEnergyConduit.get(64), };

        final FluidStack[] condensates = new FluidStack[] { CondensateType.BoundlessCosmicSolder.getEntangled(10_000),
                CondensateType.Space.getEntangled(10_000), CondensateType.Time.getEntangled(10_000),
                CondensateType.SpaceTime.getEntangled(10_240 * INGOTS) };

        for (int t = 0; t < 15; ++t) {
            addBecUnsafe(
                    circuitArrays[t],
                    new ItemStack[] { NHItemList.Compressed_Circuit_Array_Empty.get(1), boltSD[t], wireSD[t],
                            dynamoHatch[t], longRod[t], circuits[t], circuits[t], longRod[t], longRod[t], circuits[t],
                            circuits[t], longRod[t], energyHatch[t], superconductor[t], hugePipe[t],
                            wetTransformer[t] },
                    nanites(10, 5, 9, 1, 4, 8, 8, 4, 4, 8, 8, 4, 2, 6, 7, 3),
                    condensates,
                    duration,
                    TierEU.RECIPE_UXV);
        }
        addBec(
                NHItemList.Compressed_Circuit_Array_Empty.get(),
                new ItemStack[] { ItemList.Circuit_Board_Optical.get(64),
                        ItemList.FirewallProjectionNanochipCasing.get(64),
                        ItemList.ComputationalMatrixNanochipCasing.get(64),
                        CustomItemList.SpacetimeCompressionFieldGeneratorTier8.get(8L),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.SpaceTime, 64),
                        NHItemList.Display.get(64), new ItemStack(ItemRegistry.bw_glasses[0], 8, 10),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.WhiteDwarfMatter, 64),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.BlackDwarfMatter, 64),
                        IngredientFactory.getModItem(OpenComputers.ID, "case3", 64, 0),
                        IngredientFactory.getModItem(OpenComputers.ID, "screen3", 64, 0),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Universium, 64),
                        CustomItemList.TimeAccelerationFieldGeneratorTier8.get(8L),
                        CustomItemList.dataOut_Wireless_Hatch.get(64L), CustomItemList.dataIn_Wireless_Hatch.get(64L),
                        ItemList.Machine_Multi_BlackHoleCompressor.get(64), },
                nanites(2, 2, 4, 10, 1, 3, 4, 3, 6, 6, 7, 7, 5, 5, 8, 9),
                new FluidStack[] { CondensateType.Hypogen.getEntangled(8_192 * INGOTS),
                        CondensateType.DimensionallyShiftedSuperfluid.getEntangled(2_048_000),
                        CondensateType.Universium.getEntangled(8 * INGOTS),
                        CondensateType.MHDCSM.getEntangled(8 * INGOTS) },
                10_000 * SECONDS,
                TierEU.RECIPE_UXV);
    }

    private void addBec(ItemStack output, ItemStack[] inputs, NaniteTier[] nanites, FluidStack[] condensates,
            int duration, long eut) {
        GTValues.RA.stdBuilder().itemInputs(inputs).fluidInputs(condensates).itemOutputs(output)
                .metadata(NANITE_TIERS, nanites).duration(duration).eut(eut)
                .addTo(TecTechRecipeMaps.condensateAssemblingRecipes);
    }

    private void addBecUnsafe(ItemStack output, ItemStack[] inputs, NaniteTier[] nanites, FluidStack[] condensates,
            int duration, long eut) {
        GTValues.RA.stdBuilder().itemInputsUnsafe(inputs).fluidInputs(condensates).itemOutputs(output)
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
