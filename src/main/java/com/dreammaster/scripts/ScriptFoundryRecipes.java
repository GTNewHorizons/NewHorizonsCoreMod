package com.dreammaster.scripts;

import static bartworks.common.loaders.ItemRegistry.bw_realglas;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static goodgenerator.api.recipe.GoodGeneratorRecipeMaps.preciseAssemblerRecipes;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.UniversalSingularities;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.util.GTRecipeBuilder.INGOTS;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.AssemblyLine;
import static gregtech.api.util.GTRecipeConstants.PRECISE_ASSEMBLER_CASING_TIER;
import static gregtech.api.util.GTRecipeConstants.RESEARCH_ITEM;
import static gregtech.api.util.GTRecipeConstants.SCANNING;
import static gtPlusPlus.core.material.MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN;
import static gtPlusPlus.core.material.MaterialsElements.STANDALONE.RHUGNOR;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import goodgenerator.items.GGMaterial;
import goodgenerator.util.ItemRefer;
import gregtech.api.enums.Circuits;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.Superconductors;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.material.MU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.recipe.Scanning;
import gtPlusPlus.core.material.MaterialMisc;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import tectech.recipe.TTRecipeAdder;
import tectech.thing.block.BlockGodforgeGlass;

/**
 * Items used in these recipes are generated in post init, so Foundry Recipes need a late loading script To avoid
 * polluting the other files and making these recipes 'harder' to find, they are in one file.
 */
public class ScriptFoundryRecipes implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Exo-Foundry Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(UniversalSingularities.ID, EternalSingularity.ID, DraconicEvolution.ID);
    }

    @Override
    public void loadRecipes() {
        loadCasingRecipes();
    }

    public void loadCasingRecipes() {

        // Exo Foundry Glass
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(bw_realglas, 8, 6),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(4),
                        getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 13))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (64000)))
                .itemOutputs(ItemList.Glass_ExoFoundry.get(8)).duration(20 * SECONDS).eut(TierEU.RECIPE_UHV)
                .addTo(formingPressRecipes);

        // Central Exo Foundry Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Radiator_Fluid_Solidifier.get(4),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(8),
                        ItemList.FluidRegulator_UHV.get(4),
                        ItemList.Field_Generator_UV.get(1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Longasssuperconductornameforuvwire,
                                Materials2FluidShapes.fluidMolten,
                                (int) (INGOTS * 40)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.TungstenCarbide,
                                Materials2FluidShapes.fluidMolten,
                                (int) (INGOTS * 40)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.NaquadahEnriched,
                                Materials2FluidShapes.fluidMolten,
                                (int) (INGOTS * 40)))
                .itemOutputs(ItemList.Central_Casing_ExoFoundry.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_UHV)
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, 3).addTo(preciseAssemblerRecipes);

        // Exo-Foundry Inner Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(
                                OrePrefixes.frameGt,
                                MU.materialOf(Materials2Materials.Longasssuperconductornameforuvwire),
                                1),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(2),
                        ItemList.Electric_Pump_UV.get(4),
                        new Object[] { Circuits.UV.getIngredient(), 4 },
                        ItemList.Reactor_Coolant_Sp_6.get(1),
                        ItemList.Emitter_UV.get(1))
                .itemOutputs(ItemList.Secondary_Casing_ExoFoundry.get(1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.CosmicNeutronium,
                                Materials2FluidShapes.fluidMolten,
                                (int) (INGOTS * 16)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);

        // Extra Casting Basins
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Central_Casing_ExoFoundry.get(1),
                1_000_000,
                2_048,
                (int) TierEU.RECIPE_UEV,
                64,
                new Object[] { ItemList.Magnetic_Chassis_T1_ExoFoundry.get(1), ItemList.UHTResistantMesh.get(16),
                        new Object[] { Circuits.UEV.getIngredient(), 1 },
                        MaterialLibAPI.getStack(
                                Materials2Materials.SuperconductorUEVBase,
                                Materials2Shapes.stickLong,
                                (int) (4)),
                        MaterialLibAPI.getStack(
                                Materials2Materials.InfinityCatalyst,
                                Materials2Shapes.plateSuperdense,
                                (int) (2)),
                        MaterialLibAPI.getStack(
                                Materials2Materials.TengamAttuned,
                                Materials2Shapes.plateSuperdense,
                                (int) (2)),
                        MaterialLibAPI.getStack(
                                Materials2Materials.CosmicNeutronium,
                                Materials2Shapes.plateSuperdense,
                                (int) (2)),
                        MaterialLibAPI.getStack(
                                Materials2Materials.Neutronium,
                                Materials2Shapes.plateSuperdense,
                                (int) (2)), },
                new FluidStack[] { MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(INGOTS * 20),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Naquadria,
                                Materials2FluidShapes.fluidMolten,
                                (int) (INGOTS * 400)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Manyullyn,
                                Materials2FluidShapes.fluidMolten,
                                (int) (INGOTS * 100)),
                        GGMaterial.preciousMetalAlloy.getMolten(INGOTS * 20) },
                ItemList.Extra_Casting_Basins_ExoFoundry.get(1),
                30 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Streamlined Casters
        TTRecipeAdder
                .addResearchableAssemblylineRecipe(
                        ItemList.Secondary_Casing_ExoFoundry.get(1),
                        1_000_000,
                        2_048,
                        (int) TierEU.RECIPE_UEV,
                        64,
                        new Object[] { ItemList.Magnetic_Chassis_T1_ExoFoundry.get(1), MaterialLibAPI
                                .getStack(Materials2Materials.Tritanium, Materials2Shapes.plateSuperdense, (int) (16)),
                                ItemList.AcceleratorUV.get(8), CELESTIAL_TUNGSTEN.getRotor(4),
                                new Object[] { Circuits.UEV.getIngredient(), 2 }, ItemList.Electric_Pump_UHV.get(1) },
                        new FluidStack[] { MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(INGOTS * 20),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Holmium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (INGOTS * 40)),
                                GGMaterial.enrichedNaquadahAlloy.getMolten(INGOTS * 10) },
                        ItemList.Streamlined_Casters_ExoFoundry.get(1),
                        30 * SECONDS,
                        (int) TierEU.RECIPE_UEV);

        // Power Efficient Subsystems
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Glass_ExoFoundry.get(1),
                1_000_000,
                2_048,
                (int) TierEU.RECIPE_UEV,
                64,
                new Object[] { ItemList.Magnetic_Chassis_T1_ExoFoundry.get(1),
                        MaterialLibAPI.getStack(Materials2Materials.TengamAttuned, Materials2Shapes.plate, (int) (6)),
                        ItemList.Electromagnet_Samarium.get(1), ItemList.Cover_SolarPanel_UV.get(1),
                        Superconductors.UEV.getWireGt01(2), ItemList.Energy_Cluster.get(1), },
                // 4 : 2 : 1 magnet ratio
                new FluidStack[] { MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(INGOTS * 20),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Neodymium,
                                Materials2FluidShapes.fluidMolten,
                                (int) (INGOTS * 256)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Samarium,
                                Materials2FluidShapes.fluidMolten,
                                (int) (INGOTS * 128)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.TengamPurified,
                                Materials2FluidShapes.fluidMolten,
                                (int) (INGOTS * 64)) },
                ItemList.Power_Efficient_Subsystems_ExoFoundry.get(1),
                30 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Hypercooler
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.InfinityCooledCasing.get(1),
                2_000_000,
                2_048,
                (int) TierEU.RECIPE_UIV,
                64,
                new Object[] { ItemList.Magnetic_Chassis_T2_ExoFoundry.get(1), MaterialLibAPI
                        .getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.plateSuperdense, (int) (64)),
                        MaterialLibAPI.getStack(
                                Materials2Materials.CallistoIce,
                                Materials2Shapes.plateSuperdense,
                                (int) (32)),
                        MaterialLibAPI.getStack(
                                Materials2Materials.SixPhasedCopper,
                                Materials2Shapes.plateSuperdense,
                                (int) (16)),
                        ItemList.AcceleratorUV.get(8), ItemList.Electric_Pump_UIV.get(4),
                        ItemList.FluidRegulator_UIV.get(4), new Object[] { Circuits.UIV.getIngredient(), 2L }, },
                new FluidStack[] { MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(INGOTS * 1024),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.dimensionallyshiftedsuperfluid,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (90000)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.protohalkonitebase,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (INGOTS * 8)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SpaceTime,
                                Materials2FluidShapes.fluidMolten,
                                (int) (36)) },
                ItemList.Hypercooler_ExoFoundry.get(1),
                45 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Efficient Overclocker (Scanner)
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemRefer.AntimatterContainmentCasing.get(1))
                .metadata(SCANNING, new Scanning(2 * MINUTES, TierEU.RECIPE_UIV))
                .itemInputs(
                        ItemList.Magnetic_Chassis_T2_ExoFoundry.get(1),
                        ItemRefer.GravityStabilizationCasing.get(1),
                        ItemRefer.MagneticFluxCasing.get(1),
                        MaterialLibAPI.getStack(
                                Materials2Materials.SuperconductorUIVBase,
                                Materials2Shapes.plateSuperdense,
                                (int) (16)),
                        MaterialLibAPI.getStack(Materials2Materials.protohalkonite, Materials2Shapes.stick, (int) (8)),

                        new Object[] { Circuits.UXV.getIngredient(), 2 },
                        ItemList.Electric_Pump_UMV.get(4),
                        ItemList.Field_Generator_UMV.get(1))
                .fluidInputs(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(INGOTS * 1024),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.dimensionallyshiftedsuperfluid,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (300000)),
                        GGMaterial.shirabon.getMolten(INGOTS * 40))
                .itemOutputs(ItemList.Efficient_Overclocking_ExoFoundry.get(1)).duration(45 * SECONDS)
                .eut(TierEU.RECIPE_UMV).addTo(AssemblyLine);

        // Heliocast Reinforcement
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                new ItemStack(BlockGodforgeGlass.INSTANCE, 1),
                2_000_000,
                2_048,
                (int) TierEU.RECIPE_UIV,
                64,
                new Object[] { ItemList.Magnetic_Chassis_T2_ExoFoundry.get(1),
                        tectech.thing.CustomItemList.Godforge_StellarEnergySiphonCasing.get(1),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SixPhasedCopper, Materials2Shapes.stickLong, (int) (6)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.TranscendentMetal, Materials2Shapes.stickLong, (int) (6)),
                        new Object[] { Circuits.UIV.getIngredient(), 8 }, ItemList.Sensor_UIV.get(4),
                        ItemList.Emitter_UIV.get(4), RHUGNOR.getGear(4) },
                new FluidStack[] { GGMaterial.metastableOganesson.getMolten(INGOTS * 40),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Mellion,
                                Materials2FluidShapes.fluidMolten,
                                (int) (INGOTS * 20)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Creon,
                                Materials2FluidShapes.fluidMolten,
                                (int) (INGOTS * 20)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SpaceTime,
                                Materials2FluidShapes.fluidMolten,
                                (int) (INGOTS * 4)) },
                ItemList.Heliocast_Reinforcement_ExoFoundry.get(1),
                45 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Universal Collapser
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Magnetic_Chassis_T3_ExoFoundry.get(1),
                128_000_000,
                16_000,
                (int) TierEU.RECIPE_MAX,
                256,
                new Object[] { ItemList.Magnetic_Chassis_T3_ExoFoundry.get(4),
                        tectech.thing.CustomItemList.Machine_Multi_EyeOfHarmony.get(1),
                        tectech.thing.CustomItemList.StabilisationFieldGeneratorTier8.get(32),
                        tectech.thing.CustomItemList.eM_dynamoTunnel7_UXV.get(1), ItemList.Black_Hole_Opener.get(64),
                        ItemList.Timepiece.get(64),
                        MaterialLibAPI
                                .getStack(Materials2Materials.Eternity, Materials2Shapes.plateSuperdense, (int) (64)),
                        ItemList.Black_Hole_Closer.get(64), ItemList.Field_Generator_UXV.get(16),
                        GTOreDictUnificator.get(OrePrefixes.nanite, MU.materialOf(Materials2Materials.Magmatter), 4),
                        ItemList.ZPM6.get(1),
                        MaterialLibAPI.getStack(Materials2Materials.GravitonShard, Materials2Shapes.gem, (int) (1)) },
                new FluidStack[] {
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.RawStarMatter,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (4_000_000)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.temporalFluid,
                                Materials2FluidShapes.fluidMolten,
                                (int) (4_000_000)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.spatialFluid,
                                Materials2FluidShapes.fluidMolten,
                                (int) (4_000_000)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.PhononMedium,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1_000_000)) },
                ItemList.Universal_Collapser_ExoFoundry.get(1),
                60 * SECONDS,
                (int) TierEU.RECIPE_UXV);

        // Exo-Foundry Controller
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Machine_Mass_Solidifier.get(1),
                4_000_000,
                2_048,
                (int) TierEU.RECIPE_UEV,
                64,
                new Object[] { ItemList.Machine_Mass_Solidifier.get(64), ItemList.Primary_Casing_ExoFoundry.get(16),
                        GTOreDictUnificator.get(OrePrefixes.pipeLarge, MU.materialOf(Materials2Materials.Infinity), 8),
                        Superconductors.UEV.getWireGt16(8), ItemList.Field_Generator_UEV.get(4),
                        ItemList.Electric_Pump_UEV.get(8), ItemList.FluidRegulator_UEV.get(8),
                        new Object[] { Circuits.UIV.getIngredient(), 2 },
                        MaterialLibAPI
                                .getStack(Materials2Materials.Netherite, Materials2Shapes.plateSuperdense, (int) (4)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.rotor, (int) (8)),
                        getModItem(EternalSingularity.ID, "eternal_singularity", 1),
                        GregtechItemList.Laser_Lens_Special.get(1) },
                new FluidStack[] { MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(INGOTS * 64),
                        GGMaterial.preciousMetalAlloy.getMolten(INGOTS * 32),
                        GGMaterial.metastableOganesson.getMolten(INGOTS * 20),
                        MaterialsElements.STANDALONE.DRAGON_METAL.getFluidStack(INGOTS * 10) },
                ItemList.Machine_Multi_ExoFoundry.get(1),
                120 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Exo-Foundry Base Casing
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Casing_Fluid_Solidifier.get(1),
                500_000,
                2_048,
                (int) TierEU.RECIPE_UEV,
                8,
                new Object[] {
                        GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Netherite), 1),
                        ItemList.Optically_Perfected_CPU.get(6), ItemRefer.Advanced_Radiation_Protection_Plate.get(8),
                        MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.screw, (int) (4)),
                        Superconductors.UEV.getWireGt01(2) },
                new FluidStack[] { MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(INGOTS * 4),
                        new FluidStack(FluidRegistry.getFluid("oganesson"), 500),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.CosmicNeutronium,
                                Materials2FluidShapes.fluidMolten,
                                (int) (INGOTS * 2)) },
                ItemList.Primary_Casing_ExoFoundry.get(1),
                15 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Exo-Foundry Chassis Tier 1
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Primary_Casing_ExoFoundry.get(1),
                1_000_000,
                2_048,
                (int) TierEU.RECIPE_UEV,
                16,
                new Object[] {
                        GTOreDictUnificator
                                .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.CosmicNeutronium), 1),
                        MaterialLibAPI.getStack(
                                Materials2Materials.HighDurabilityCompoundSteel,
                                Materials2Shapes.plate,
                                (int) (32)),
                        ItemList.Optically_Compatible_Memory.get(6), ItemRefer.HiC_T4.get(4),
                        new Object[] { Circuits.UEV.getIngredient(), 1 }, ItemList.Emitter_UHV.get(1),
                        MaterialLibAPI.getStack(Materials2Materials.TengamAttuned, Materials2Shapes.screw, (int) (6)),
                        ItemList.NuclearStar.get(1) },
                new FluidStack[] { MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(INGOTS * 4),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperconductorUEVBase,
                                Materials2FluidShapes.fluidMolten,
                                (int) (INGOTS * 2)),
                        MaterialsElements.STANDALONE.RHUGNOR.getFluidStack(INGOTS) },
                ItemList.Magnetic_Chassis_T1_ExoFoundry.get(1),
                30 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Exo-Foundry Chassis Tier 2
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Magnetic_Chassis_T1_ExoFoundry.get(1),
                2_000_000,
                4_096,
                (int) TierEU.RECIPE_UIV,
                64,
                new Object[] { ItemRefer.Compact_Fusion_Coil_T4.get(1),
                        MaterialLibAPI.getStack(Materials2Materials.Ichorium, Materials2Shapes.screw, (int) (64)),
                        getModItem(EternalSingularity.ID, "combined_singularity", 1, 2),
                        getModItem(EternalSingularity.ID, "combined_singularity", 1, 4),
                        new Object[] { Circuits.UIV.getIngredient(), 4L },
                        GTOreDictUnificator
                                .get(OrePrefixes.nanite, MU.materialOf(Materials2Materials.TranscendentMetal), 2),
                        MaterialLibAPI.getStack(
                                Materials2Materials.SixPhasedCopper,
                                Materials2Shapes.plateSuperdense,
                                (int) (1)),
                        ItemList.Emitter_UIV.get(1) },
                new FluidStack[] {
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.protohalkonitebase,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (INGOTS * 20)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Mellion,
                                Materials2FluidShapes.fluidMolten,
                                (int) (INGOTS * 4)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Creon,
                                Materials2FluidShapes.fluidMolten,
                                (int) (INGOTS * 4)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.dimensionallyshiftedsuperfluid,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (20000)) },
                ItemList.Magnetic_Chassis_T2_ExoFoundry.get(1),
                45 * SECONDS,
                (int) TierEU.RECIPE_UIV);
    }
}
