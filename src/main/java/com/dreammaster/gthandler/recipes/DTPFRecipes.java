package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.*;
import static gregtech.api.recipe.RecipeMaps.plasmaForgeRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.COIL_HEAT;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.block.BlockList;
import com.dreammaster.gthandler.DTPFCalculator;
import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import goodgenerator.items.GGMaterial;
import goodgenerator.util.ItemRefer;
import gregtech.api.enums.Circuits;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gregtech.common.items.CombType;
import gregtech.loaders.misc.GTBees;
import gtPlusPlus.core.material.MaterialsAlloy;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.core.material.Particle;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;

public class DTPFRecipes implements Runnable {

    @Override
    public void run() {
        // Dimensionally transcendent plasma forge recipes.
        // Ordered so that recipes using higher tier catalysts are prioritized.

        {
            // Coils
            int awakened_heat = 10800;
            int infinity_heat = awakened_heat + 900;
            int hypogen_heat = infinity_heat + 900;
            int eternal_heat = hypogen_heat + 900;

            // ------------------------------------------------------------------------------------------
            // ------------------------------------- Plasma Forge ---------------------------------------
            // ------------------------------------------------------------------------------------------

            {
                // Neutronium

                long base_quantity = 512L;
                long tier_up_multiplier = 2L;

                long tier_1_quantity = 144L * base_quantity;
                long tier_2_quantity = tier_1_quantity * tier_up_multiplier;
                long tier_3_quantity = tier_2_quantity * tier_up_multiplier;
                long tier_4_quantity = tier_3_quantity * tier_up_multiplier;

                DTPFCalculator neutronium = new DTPFCalculator().setBaseParallel(base_quantity)
                        .setCustomEBFinputItem(NHItemList.RawNeutronium.get())
                        .calculateGenericEBFBasedRecipe(Materials.Neutronium);

                // Tier 4
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTEC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (neutronium.getCatalystAmount(3))),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Iron,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_4_quantity)))
                        .fluidOutputs(
                                Materials.DTR.getFluid(neutronium.getResidueAmount(3)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Neutronium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_4_quantity)))
                        .duration(neutronium.getDuration(3)).eut(neutronium.getEUt(3)).metadata(COIL_HEAT, eternal_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 3
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTRC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (neutronium.getCatalystAmount(2))),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Iron,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_3_quantity)))
                        .fluidOutputs(
                                Materials.DTR.getFluid(neutronium.getResidueAmount(2)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Neutronium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_3_quantity)))
                        .duration(neutronium.getDuration(2)).eut(neutronium.getEUt(2)).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 2
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTPC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (neutronium.getCatalystAmount(1))),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Iron,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_2_quantity)))
                        .fluidOutputs(
                                Materials.DTR.getFluid(neutronium.getResidueAmount(1)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Neutronium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_2_quantity)))
                        .duration(neutronium.getDuration(1)).eut(neutronium.getEUt(1))
                        .metadata(COIL_HEAT, infinity_heat).addTo(plasmaForgeRecipes);

                // Tier 1
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTCC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (neutronium.getCatalystAmount(0))),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Iron,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_1_quantity)))
                        .fluidOutputs(
                                Materials.DTR.getFluid(neutronium.getResidueAmount(0)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Neutronium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_1_quantity)))
                        .duration(neutronium.getDuration(0)).eut(neutronium.getEUt(0))
                        .metadata(COIL_HEAT, awakened_heat).addTo(plasmaForgeRecipes);
            }

            {
                // Cosmic Neutronium

                long base_quantity = 512L;
                long tier_up_multiplier = 2L;

                long tier_1_quantity = 144L * base_quantity;
                long tier_2_quantity = tier_1_quantity * tier_up_multiplier;
                long tier_3_quantity = tier_2_quantity * tier_up_multiplier;
                long tier_4_quantity = tier_3_quantity * tier_up_multiplier;

                DTPFCalculator cosmic_neutronium = new DTPFCalculator().setBaseParallel(base_quantity)
                        .calculateGenericEBFBasedRecipe(Materials.CosmicNeutronium);

                // Tier 4 - Normal
                GTValues.RA.stdBuilder().circuit(4)
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTEC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (cosmic_neutronium.getCatalystAmount(3))),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Copper,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_4_quantity)))
                        .fluidOutputs(
                                Materials.DTR.getFluid(cosmic_neutronium.getResidueAmount(3)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.CosmicNeutronium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_4_quantity)))
                        .duration(cosmic_neutronium.getDuration(3)).eut(cosmic_neutronium.getEUt(3))
                        .metadata(COIL_HEAT, eternal_heat).addTo(plasmaForgeRecipes);

                // Tier 3 - Normal
                GTValues.RA.stdBuilder().circuit(4)
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTRC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (cosmic_neutronium.getCatalystAmount(2))),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Copper,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_3_quantity)))
                        .fluidOutputs(
                                Materials.DTR.getFluid(cosmic_neutronium.getResidueAmount(2)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.CosmicNeutronium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_3_quantity)))
                        .duration(cosmic_neutronium.getDuration(2)).eut(cosmic_neutronium.getEUt(2))
                        .metadata(COIL_HEAT, hypogen_heat).addTo(plasmaForgeRecipes);

                // Tier 2 - Normal
                GTValues.RA.stdBuilder().circuit(4)
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTPC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (cosmic_neutronium.getCatalystAmount(1))),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Copper,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_2_quantity)))
                        .fluidOutputs(
                                Materials.DTR.getFluid(cosmic_neutronium.getResidueAmount(1)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.CosmicNeutronium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_2_quantity)))
                        .duration(cosmic_neutronium.getDuration(1)).eut(cosmic_neutronium.getEUt(1))
                        .metadata(COIL_HEAT, infinity_heat).addTo(plasmaForgeRecipes);

                // Tier 1 - Normal
                GTValues.RA.stdBuilder().circuit(4)
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTCC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (cosmic_neutronium.getCatalystAmount(0))),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Copper,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_1_quantity)))
                        .fluidOutputs(
                                Materials.DTR.getFluid(cosmic_neutronium.getResidueAmount(0)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.CosmicNeutronium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_1_quantity)))
                        .duration(cosmic_neutronium.getDuration(0)).eut(cosmic_neutronium.getEUt(0))
                        .metadata(COIL_HEAT, awakened_heat).addTo(plasmaForgeRecipes);

                if (Forestry.isModLoaded()) {
                    long tier_1_bee_quantity = 144L * base_quantity;
                    long tier_2_bee_quantity = tier_1_bee_quantity * tier_up_multiplier;
                    long tier_3_bee_quantity = tier_2_bee_quantity * tier_up_multiplier;
                    long tier_4_bee_quantity = tier_3_bee_quantity * tier_up_multiplier;

                    DTPFCalculator cosmic_neutronium_bee = new DTPFCalculator().setBaseParallel(base_quantity)
                            .setCatalystDiscount(15).setProcessingTimeDiscount(50)
                            .calculateGenericEBFBasedRecipe(Materials.CosmicNeutronium);

                    // Tier 4 - Combs
                    GTValues.RA.stdBuilder().itemInputs(GTBees.combs.getStackForType(CombType.COSMICNEUTRONIUM))
                            .circuit(1)
                            .fluidInputs(
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.ExcitedDTEC,
                                            Materials2FluidShapes.fluidLiquid,
                                            (int) (cosmic_neutronium_bee.getCatalystAmount(3))),
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.Copper,
                                            Materials2FluidShapes.fluidMolten,
                                            (int) (tier_4_bee_quantity)))
                            .fluidOutputs(
                                    Materials.DTR.getFluid(cosmic_neutronium_bee.getResidueAmount(3)),
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.CosmicNeutronium,
                                            Materials2FluidShapes.fluidMolten,
                                            (int) (tier_4_bee_quantity)))
                            .duration(cosmic_neutronium_bee.getDuration(3)).eut(cosmic_neutronium_bee.getEUt(3))
                            .metadata(COIL_HEAT, eternal_heat).addTo(plasmaForgeRecipes);

                    // Tier 3 - Combs
                    GTValues.RA.stdBuilder().itemInputs(GTBees.combs.getStackForType(CombType.COSMICNEUTRONIUM))
                            .circuit(1)
                            .fluidInputs(
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.ExcitedDTRC,
                                            Materials2FluidShapes.fluidLiquid,
                                            (int) (cosmic_neutronium_bee.getCatalystAmount(2))),
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.Copper,
                                            Materials2FluidShapes.fluidMolten,
                                            (int) (tier_3_bee_quantity)))
                            .fluidOutputs(
                                    Materials.DTR.getFluid(cosmic_neutronium_bee.getResidueAmount(2)),
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.CosmicNeutronium,
                                            Materials2FluidShapes.fluidMolten,
                                            (int) (tier_3_bee_quantity)))
                            .duration(cosmic_neutronium_bee.getDuration(2)).eut(cosmic_neutronium_bee.getEUt(2))
                            .metadata(COIL_HEAT, hypogen_heat).addTo(plasmaForgeRecipes);

                    // Tier 2 - Combs
                    GTValues.RA.stdBuilder().itemInputs(GTBees.combs.getStackForType(CombType.COSMICNEUTRONIUM))
                            .circuit(1)
                            .fluidInputs(
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.ExcitedDTPC,
                                            Materials2FluidShapes.fluidLiquid,
                                            (int) (cosmic_neutronium_bee.getCatalystAmount(1))),
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.Copper,
                                            Materials2FluidShapes.fluidMolten,
                                            (int) (tier_2_bee_quantity)))
                            .fluidOutputs(
                                    Materials.DTR.getFluid(cosmic_neutronium_bee.getResidueAmount(1)),
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.CosmicNeutronium,
                                            Materials2FluidShapes.fluidMolten,
                                            (int) (tier_2_bee_quantity)))
                            .duration(cosmic_neutronium_bee.getDuration(1)).eut(cosmic_neutronium_bee.getEUt(1))
                            .metadata(COIL_HEAT, infinity_heat).addTo(plasmaForgeRecipes);

                    // Tier 1 - Combs
                    GTValues.RA.stdBuilder().itemInputs(GTBees.combs.getStackForType(CombType.COSMICNEUTRONIUM))
                            .circuit(1)
                            .fluidInputs(
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.ExcitedDTCC,
                                            Materials2FluidShapes.fluidLiquid,
                                            (int) (cosmic_neutronium_bee.getCatalystAmount(0))),
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.Copper,
                                            Materials2FluidShapes.fluidMolten,
                                            (int) (tier_1_quantity)))
                            .fluidOutputs(
                                    Materials.DTR.getFluid(cosmic_neutronium_bee.getResidueAmount(0)),
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.CosmicNeutronium,
                                            Materials2FluidShapes.fluidMolten,
                                            (int) (tier_1_quantity)))
                            .duration(cosmic_neutronium_bee.getDuration(0)).eut(cosmic_neutronium_bee.getEUt(0))
                            .metadata(COIL_HEAT, awakened_heat).addTo(plasmaForgeRecipes);
                }

            }

            {
                // Bedrockium

                long base_quantity = 2048L;
                long tier_up_multiplier = 2L;

                long tier_1_quantity = 144L * base_quantity;
                long tier_2_quantity = tier_1_quantity * tier_up_multiplier;
                long tier_3_quantity = tier_2_quantity * tier_up_multiplier;
                long tier_4_quantity = tier_3_quantity * tier_up_multiplier;

                DTPFCalculator bedrockium = new DTPFCalculator().setBaseParallel(base_quantity)
                        .calculateGenericEBFBasedRecipe(Materials.Bedrockium);

                // Tier 4
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTEC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (bedrockium.getCatalystAmount(3))),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Steel,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_4_quantity)))
                        .fluidOutputs(
                                Materials.DTR.getFluid(bedrockium.getResidueAmount(3)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Bedrockium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_4_quantity)))
                        .duration(bedrockium.getDuration(3)).eut(bedrockium.getEUt(3)).metadata(COIL_HEAT, eternal_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 3
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTRC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (bedrockium.getCatalystAmount(2))),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Steel,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_3_quantity)))
                        .fluidOutputs(
                                Materials.DTR.getFluid(bedrockium.getResidueAmount(2)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Bedrockium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_3_quantity)))
                        .duration(bedrockium.getDuration(2)).eut(bedrockium.getEUt(2)).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 2
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTPC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (bedrockium.getCatalystAmount(1))),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Steel,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_2_quantity)))
                        .fluidOutputs(
                                Materials.DTR.getFluid(bedrockium.getResidueAmount(1)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Bedrockium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_2_quantity)))
                        .duration(bedrockium.getDuration(1)).eut(bedrockium.getEUt(1))
                        .metadata(COIL_HEAT, infinity_heat).addTo(plasmaForgeRecipes);

                // Tier 1
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTCC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (bedrockium.getCatalystAmount(0))),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Steel,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_1_quantity)))
                        .fluidOutputs(
                                Materials.DTR.getFluid(bedrockium.getResidueAmount(0)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Bedrockium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_1_quantity)))
                        .duration(bedrockium.getDuration(0)).eut(bedrockium.getEUt(0))
                        .metadata(COIL_HEAT, awakened_heat).addTo(plasmaForgeRecipes);
            }

            {
                // Hypogen

                // V4
                GTValues.RA.stdBuilder().itemInputs(GregtechItemList.Compressed_Fusion_Reactor.get(0))
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Neutronium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (5760L * 2)),
                                new FluidStack(MaterialsAlloy.QUANTUM.getFluid(), 5760),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Infinity,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (1440L)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTSC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (1000)))
                        .fluidOutputs(
                                new FluidStack(MaterialsElements.STANDALONE.HYPOGEN.getFluid(), 5760 * 2),
                                Materials.DTR.getFluid(2000L))
                        .duration(1 * MINUTES + 15 * SECONDS).eut(2_000_000_000).metadata(COIL_HEAT, eternal_heat)
                        .addTo(plasmaForgeRecipes);

                // V3
                GTValues.RA.stdBuilder().itemInputs(GregtechItemList.Compressed_Fusion_Reactor.get(0))
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Neutronium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (5760L)),
                                new FluidStack(MaterialsAlloy.QUANTUM.getFluid(), 5760),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Infinity,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (1440L)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTEC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (1000)))
                        .fluidOutputs(
                                new FluidStack(MaterialsElements.STANDALONE.HYPOGEN.getFluid(), 5760),
                                Materials.DTR.getFluid(1000L))
                        .duration(1 * MINUTES + 15 * SECONDS).eut(1_600_000_000).metadata(COIL_HEAT, eternal_heat)
                        .addTo(plasmaForgeRecipes);

                // V2
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Neutronium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (5760L)),
                                new FluidStack(MaterialsAlloy.QUANTUM.getFluid(), 5760),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Infinity,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (1440L)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTRC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (1000)))
                        .fluidOutputs(
                                new FluidStack(MaterialsElements.STANDALONE.HYPOGEN.getFluid(), 2880),
                                Materials.DTR.getFluid(1000L / 2))
                        .duration(1 * MINUTES + 15 * SECONDS).eut(1_200_000_000).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(plasmaForgeRecipes);

                // V1
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                new FluidStack(MaterialsElements.STANDALONE.HYPOGEN.getFluid(), 144),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Neutronium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (5760L)),
                                new FluidStack(MaterialsAlloy.QUANTUM.getFluid(), 5760),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Infinity,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (1440L)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTPC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (1000)))
                        .fluidOutputs(
                                new FluidStack(MaterialsElements.STANDALONE.HYPOGEN.getFluid(), 1584),
                                Materials.DTR.getFluid(1000L / 4))
                        .duration(1 * MINUTES + 15 * SECONDS).eut(800_000_000).metadata(COIL_HEAT, infinity_heat)
                        .addTo(plasmaForgeRecipes);
            }

            {
                // Chromatic Glass

                long base_quantity = 256L;
                long tier_up_multiplier = 2L;

                long tier_1_quantity = 144L * base_quantity;
                long tier_2_quantity = tier_1_quantity * tier_up_multiplier;
                long tier_3_quantity = tier_2_quantity * tier_up_multiplier;
                long tier_4_quantity = tier_3_quantity * tier_up_multiplier;

                DTPFCalculator chromatic_glass = new DTPFCalculator().setBaseParallel(base_quantity)
                        .calculateNonEBFRecipe(1_966_080, 6_000);

                // Tier 4
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTEC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (chromatic_glass.getCatalystAmount(3))),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Glass,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_4_quantity)))
                        .fluidOutputs(
                                Materials.DTR.getFluid(chromatic_glass.getResidueAmount(3)),
                                new FluidStack(FluidRegistry.getFluid("molten.chromaticglass"), (int) tier_4_quantity))
                        .duration(chromatic_glass.getDuration(3)).eut(chromatic_glass.getEUt(3))
                        .metadata(COIL_HEAT, eternal_heat).addTo(plasmaForgeRecipes);

                // Tier 3
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTRC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (chromatic_glass.getCatalystAmount(2))),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Glass,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_3_quantity)))
                        .fluidOutputs(
                                Materials.DTR.getFluid(chromatic_glass.getResidueAmount(2)),
                                new FluidStack(FluidRegistry.getFluid("molten.chromaticglass"), (int) tier_3_quantity))
                        .duration(chromatic_glass.getDuration(2)).eut(chromatic_glass.getEUt(2))
                        .metadata(COIL_HEAT, hypogen_heat).addTo(plasmaForgeRecipes);

                // Tier 2
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTPC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (chromatic_glass.getCatalystAmount(1))),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Glass,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_2_quantity)))
                        .fluidOutputs(
                                Materials.DTR.getFluid(chromatic_glass.getResidueAmount(1)),
                                new FluidStack(FluidRegistry.getFluid("molten.chromaticglass"), (int) tier_2_quantity))
                        .duration(chromatic_glass.getDuration(1)).eut(chromatic_glass.getEUt(1))
                        .metadata(COIL_HEAT, infinity_heat).addTo(plasmaForgeRecipes);

                // Tier 1
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTCC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (chromatic_glass.getCatalystAmount(0))),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Glass,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_1_quantity)))
                        .fluidOutputs(
                                Materials.DTR.getFluid(chromatic_glass.getResidueAmount(0)),
                                new FluidStack(FluidRegistry.getFluid("molten.chromaticglass"), (int) tier_1_quantity))
                        .duration(chromatic_glass.getDuration(0)).eut(chromatic_glass.getEUt(0))
                        .metadata(COIL_HEAT, awakened_heat).addTo(plasmaForgeRecipes);
            }

            {
                // Spacetime

                // V2
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.EnergisedTesseract.get(1),
                                GregtechItemList.Compressed_Fusion_Reactor.get(0))
                        .fluidInputs(
                                Materials.DTR.getFluid(5000L),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Infinity,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (1152L)))
                        .fluidOutputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.SpaceTime,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (576L)))
                        .duration(20 * SECONDS).eut(2_000_000_000).metadata(COIL_HEAT, eternal_heat)
                        .addTo(plasmaForgeRecipes);

                // V1
                GTValues.RA.stdBuilder().itemInputs(ItemList.EnergisedTesseract.get(1))
                        .fluidInputs(
                                Materials.DTR.getFluid(10000L),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Infinity,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (2304L)),
                                new FluidStack(MaterialsElements.STANDALONE.HYPOGEN.getFluid(), 1152))
                        .fluidOutputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.SpaceTime,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (144L)))
                        .duration(40 * SECONDS).eut(1_000_000_000).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(plasmaForgeRecipes);
            }

            {
                // Raw Tesseract
                // 16 Vertices, 24 faces and 32 edges.

                // V3
                GTValues.RA.stdBuilder().itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.TranscendentMetal, Materials2Shapes.stick, (int) (32L)),
                        MaterialsAlloy.BLACK_TITANIUM.getPlate(24),
                        MaterialsAlloy.ZERON_100.getScrew(16),
                        GregtechItemList.Laser_Lens_Special.get(1)).itemOutputs(ItemList.Tesseract.get(16))
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTSC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (1000)))
                        .fluidOutputs(Materials.DTR.getFluid(2000)).duration(40 * SECONDS).eut(512_000_000)
                        .metadata(COIL_HEAT, eternal_heat).addTo(plasmaForgeRecipes);

                // V2
                GTValues.RA.stdBuilder().itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.stick, (int) (12L)),
                        GGMaterial.tairitsu.get(OrePrefixes.stick, 12),
                        MaterialLibAPI
                                .getStack(Materials2Materials.TranscendentMetal, Materials2Shapes.stick, (int) (8L)),
                        MaterialsAlloy.BOTMIUM.getPlate(24),
                        MaterialsAlloy.ARCANITE.getScrew(16),
                        getModItem(SuperSolarPanels.ID, "enderquantumcomponent", 1))
                        .itemOutputs(ItemList.Tesseract.get(8))
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTEC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (1000)))
                        .fluidOutputs(Materials.DTR.getFluid(1000)).duration(40 * SECONDS).eut(128_000_000)
                        .metadata(COIL_HEAT, eternal_heat).addTo(plasmaForgeRecipes);

                // V1
                GTValues.RA.stdBuilder().itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.stick, (int) (8L)),
                        MaterialsAlloy.OCTIRON.getRod(8),
                        GGMaterial.tairitsu.get(OrePrefixes.stick, 8),
                        MaterialLibAPI.getStack(Materials2Materials.Sunnarium, Materials2Shapes.stick, (int) (8L)),
                        MaterialsAlloy.ABYSSAL.getPlate(24),
                        MaterialsAlloy.BOTMIUM.getScrew(16),
                        Circuits.ZPM.get(1)).itemOutputs(ItemList.Tesseract.get(4))
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTRC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (1000)))
                        .fluidOutputs(Materials.DTR.getFluid(1000 / 2)).duration(40 * SECONDS).eut(32_000_000)
                        .metadata(COIL_HEAT, infinity_heat).addTo(plasmaForgeRecipes);
            }

            if (Avaritia.isModLoaded()) {
                if (GalacticraftAmunRa.isModLoaded()) {
                    // TODO: remove for 2.10
                    GTValues.RA.stdBuilder()
                            .itemInputs(
                                    GTOreDictUnificator.get(OrePrefixes.block, Materials.TranscendentMetal, 16),
                                    getModItem(Avaritia.ID, "Resource", 16, 8),
                                    GTUtility.copyAmount(0, Particle.getBaseParticle(Particle.HIGGS_BOSON)))
                            .fluidInputs(
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.ExcitedDTEC,
                                            Materials2FluidShapes.fluidLiquid,
                                            (int) (1797693L)),
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.CosmicNeutronium,
                                            Materials2FluidShapes.fluidMolten,
                                            (int) (16384 * 144)),
                                    GGMaterial.tairitsu.getMolten(16384 * 144),
                                    MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getFluidStack(4096 * 144))
                            .itemOutputs(getModItem(GalacticraftAmunRa.ID, "tile.baseBlockRock", 1, 14))
                            .duration(80 * SECONDS).fluidOutputs(Materials.DTR.getFluid(1797693L))
                            .eut(TierEU.RECIPE_UMV).metadata(COIL_HEAT, hypogen_heat).addTo(plasmaForgeRecipes);
                    // Dark Matter
                    GTValues.RA.stdBuilder()
                            .itemInputs(
                                    GTOreDictUnificator.get(OrePrefixes.block, Materials.TranscendentMetal, 16),
                                    getModItem(Avaritia.ID, "Resource", 16, 8),
                                    ItemList.StableBosonContainmentUnit.get(0))
                            .fluidInputs(
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.ExcitedDTEC,
                                            Materials2FluidShapes.fluidLiquid,
                                            (int) (1797693L)),
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.CosmicNeutronium,
                                            Materials2FluidShapes.fluidMolten,
                                            (int) (16384 * 144)),
                                    GGMaterial.tairitsu.getMolten(16384 * 144),
                                    MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getFluidStack(4096 * 144))
                            .itemOutputs(getModItem(GalacticraftAmunRa.ID, "tile.baseBlockRock", 1, 14))
                            .duration(80 * SECONDS).fluidOutputs(Materials.DTR.getFluid(1797693L))
                            .eut(TierEU.RECIPE_UMV).metadata(COIL_HEAT, hypogen_heat).addTo(plasmaForgeRecipes);
                }

                {
                    // Infinity

                    long base_time = 10_000;
                    long base_quantity = 64L;

                    DTPFCalculator infinity = new DTPFCalculator().setBaseParallel(base_quantity)
                            .setLowestCatalystTier(2).setHighestCatalystTier(4).setEUtDivisor(2)
                            .calculateNonEBFRecipe(32_000_000, base_time);

                    // Tier 5
                    GTValues.RA.stdBuilder().itemInputs(getModItem(Avaritia.ID, "Resource", 4, 5)).circuit(4)
                            .fluidInputs(
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.ExcitedDTSC,
                                            Materials2FluidShapes.fluidLiquid,
                                            (int) (infinity.getCatalystAmount(4))))
                            .fluidOutputs(
                                    Materials.DTR.getFluid(infinity.getResidueAmount(4)),
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.Infinity,
                                            Materials2FluidShapes.fluidMolten,
                                            (int) (256L * 144L)))
                            .duration(infinity.getDuration(4)).eut(infinity.getEUt(4)).metadata(COIL_HEAT, eternal_heat)
                            .addTo(plasmaForgeRecipes);

                    // Tier 4
                    GTValues.RA.stdBuilder().itemInputs(getModItem(Avaritia.ID, "Resource", 2, 5)).circuit(4)
                            .fluidInputs(
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.ExcitedDTEC,
                                            Materials2FluidShapes.fluidLiquid,
                                            (int) (infinity.getCatalystAmount(3))))
                            .fluidOutputs(
                                    Materials.DTR.getFluid(infinity.getResidueAmount(3)),
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.Infinity,
                                            Materials2FluidShapes.fluidMolten,
                                            (int) (128L * 144L)))
                            .duration(infinity.getDuration(3)).eut(infinity.getEUt(3)).metadata(COIL_HEAT, eternal_heat)
                            .addTo(plasmaForgeRecipes);

                    // Tier 3
                    GTValues.RA.stdBuilder().itemInputs(getModItem(Avaritia.ID, "Resource", 1, 5)).circuit(4)
                            .fluidInputs(
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.ExcitedDTRC,
                                            Materials2FluidShapes.fluidLiquid,
                                            (int) (infinity.getCatalystAmount(2) / 64)))
                            .fluidOutputs(
                                    Materials.DTR.getFluid(infinity.getResidueAmount(2) / 64),
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.Infinity,
                                            Materials2FluidShapes.fluidMolten,
                                            (int) (144L)))
                            .duration(infinity.getDuration(2) / 128).eut(infinity.getEUt(2) / 64)
                            .metadata(COIL_HEAT, awakened_heat).addTo(plasmaForgeRecipes);

                    // Tier 3.5
                    GTValues.RA.stdBuilder().itemInputs(getModItem(Avaritia.ID, "Resource", 1, 5)).circuit(5)
                            .fluidInputs(
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.ExcitedDTRC,
                                            Materials2FluidShapes.fluidLiquid,
                                            (int) (infinity.getCatalystAmount(2))))
                            .fluidOutputs(
                                    Materials.DTR.getFluid(infinity.getResidueAmount(2)),
                                    MaterialLibAPI.getFluidStack(
                                            Materials2Materials.Infinity,
                                            Materials2FluidShapes.fluidMolten,
                                            (int) (64L * 144L)))
                            .duration(infinity.getDuration(2)).eut(infinity.getEUt(2)).metadata(COIL_HEAT, hypogen_heat)
                            .addTo(plasmaForgeRecipes);

                    if (Forestry.isModLoaded()) {
                        DTPFCalculator infinity_bee = new DTPFCalculator().setBaseParallel(base_quantity)
                                .setLowestCatalystTier(2).setHighestCatalystTier(4).setCatalystDiscount(15)
                                .setProcessingTimeDiscount(50).setEUtDivisor(2)
                                .calculateNonEBFRecipe(32_000_000, base_time);

                        // Tier 5 - Combs
                        GTValues.RA.stdBuilder()
                                .itemInputs(
                                        getModItem(Avaritia.ID, "Resource", 4, 5),
                                        GTBees.combs.getStackForType(CombType.INFINITY))
                                .circuit(3)
                                .fluidInputs(
                                        MaterialLibAPI.getFluidStack(
                                                Materials2Materials.ExcitedDTSC,
                                                Materials2FluidShapes.fluidLiquid,
                                                (int) (infinity_bee.getCatalystAmount(4))))
                                .fluidOutputs(
                                        Materials.DTR.getFluid(infinity_bee.getResidueAmount(4)),
                                        MaterialLibAPI.getFluidStack(
                                                Materials2Materials.Infinity,
                                                Materials2FluidShapes.fluidMolten,
                                                (int) (256L * 144L)))
                                .duration(infinity_bee.getDuration(4)).eut(infinity_bee.getEUt(4))
                                .metadata(COIL_HEAT, eternal_heat).addTo(plasmaForgeRecipes);

                        // Tier 4 - Combs
                        GTValues.RA.stdBuilder()
                                .itemInputs(
                                        getModItem(Avaritia.ID, "Resource", 2, 5),
                                        GTBees.combs.getStackForType(CombType.INFINITY))
                                .circuit(3)
                                .fluidInputs(
                                        MaterialLibAPI.getFluidStack(
                                                Materials2Materials.ExcitedDTEC,
                                                Materials2FluidShapes.fluidLiquid,
                                                (int) (infinity_bee.getCatalystAmount(3))))
                                .fluidOutputs(
                                        Materials.DTR.getFluid(infinity_bee.getResidueAmount(3)),
                                        MaterialLibAPI.getFluidStack(
                                                Materials2Materials.Infinity,
                                                Materials2FluidShapes.fluidMolten,
                                                (int) (128L * 144L)))
                                .duration(infinity_bee.getDuration(3)).eut(infinity_bee.getEUt(3))
                                .metadata(COIL_HEAT, eternal_heat).addTo(plasmaForgeRecipes);

                        // Tier 3.5 - Combs
                        GTValues.RA.stdBuilder()
                                .itemInputs(
                                        getModItem(Avaritia.ID, "Resource", 1, 5),
                                        GTBees.combs.getStackForType(CombType.INFINITY))
                                .circuit(2)
                                .fluidInputs(
                                        MaterialLibAPI.getFluidStack(
                                                Materials2Materials.ExcitedDTRC,
                                                Materials2FluidShapes.fluidLiquid,
                                                (int) (infinity_bee.getCatalystAmount(2))))
                                .fluidOutputs(
                                        Materials.DTR.getFluid(infinity_bee.getResidueAmount(2)),
                                        MaterialLibAPI.getFluidStack(
                                                Materials2Materials.Infinity,
                                                Materials2FluidShapes.fluidMolten,
                                                (int) (64L * 144L)))
                                .duration(infinity_bee.getDuration(2)).eut(infinity_bee.getEUt(2))
                                .metadata(COIL_HEAT, hypogen_heat).addTo(plasmaForgeRecipes);

                        // Tier 3 - Combs
                        GTValues.RA.stdBuilder()
                                .itemInputs(
                                        getModItem(Avaritia.ID, "Resource", 1, 5),
                                        GTBees.combs.getStackForType(CombType.INFINITY))
                                .circuit(3)
                                .fluidInputs(
                                        MaterialLibAPI.getFluidStack(
                                                Materials2Materials.ExcitedDTRC,
                                                Materials2FluidShapes.fluidLiquid,
                                                (int) (infinity_bee.getCatalystAmount(2) / 64)))
                                .fluidOutputs(
                                        Materials.DTR.getFluid(infinity_bee.getResidueAmount(2) / 64),
                                        MaterialLibAPI.getFluidStack(
                                                Materials2Materials.Infinity,
                                                Materials2FluidShapes.fluidMolten,
                                                (int) (144L)))
                                .duration(infinity_bee.getDuration(2) / 128).eut(infinity_bee.getEUt(2) / 64)
                                .metadata(COIL_HEAT, awakened_heat).addTo(plasmaForgeRecipes);
                    }

                }

            }

            {
                // LuV Superconductor

                long base_quantity = 8190L;
                long tier_up_multiplier = 2L;

                long tier_1_quantity = 144L * base_quantity;
                long tier_2_quantity = tier_1_quantity * tier_up_multiplier;
                long tier_3_quantity = tier_2_quantity * tier_up_multiplier;
                long tier_4_quantity = tier_3_quantity * tier_up_multiplier;

                DTPFCalculator baseLuV = new DTPFCalculator().setBaseParallel(base_quantity)
                        .calculateGenericEBFBasedRecipe(Materials.SuperconductorLuVBase);

                // Tier 4
                GTValues.RA.stdBuilder().circuit(6)
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Indium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (4L * tier_4_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Tin,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (2L * tier_4_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Barium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (2L * tier_4_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Titanium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_4_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Copper,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (7L * tier_4_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Oxygen,
                                        Materials2FluidShapes.fluidPlasma,
                                        (int) (14_000L / 32 * tier_4_quantity / 30 / 144)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTEC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (baseLuV.getCatalystAmount(3))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseLuV.getResidueAmount(3)),
                                Materials.SuperconductorLuVBase.getMolten(tier_4_quantity))
                        .duration(baseLuV.getDuration(3)).eut(baseLuV.getEUt(3)).metadata(COIL_HEAT, eternal_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 3
                GTValues.RA.stdBuilder().circuit(6)
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Indium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (4L * tier_3_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Tin,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (2L * tier_3_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Barium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (2L * tier_3_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Titanium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_3_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Copper,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (7L * tier_3_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Oxygen,
                                        Materials2FluidShapes.fluidPlasma,
                                        (int) (14_000L / 32 * tier_3_quantity / 30 / 144)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTRC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (baseLuV.getCatalystAmount(2))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseLuV.getResidueAmount(2)),
                                Materials.SuperconductorLuVBase.getMolten(tier_3_quantity))
                        .duration(baseLuV.getDuration(2)).eut(baseLuV.getEUt(2)).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 2
                GTValues.RA.stdBuilder().circuit(6)
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Indium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (4L * tier_2_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Tin,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (2L * tier_2_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Barium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (2L * tier_2_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Titanium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_2_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Copper,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (7L * tier_2_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Oxygen,
                                        Materials2FluidShapes.fluidPlasma,
                                        (int) (14_000L / 32 * tier_2_quantity / 30 / 144)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTPC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (baseLuV.getCatalystAmount(1))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseLuV.getResidueAmount(1)),
                                Materials.SuperconductorLuVBase.getMolten(tier_2_quantity))
                        .duration(baseLuV.getDuration(1)).eut(baseLuV.getEUt(1)).metadata(COIL_HEAT, infinity_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 1
                GTValues.RA.stdBuilder().circuit(6)
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Indium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (4L * tier_1_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Tin,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (2L * tier_1_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Barium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (2L * tier_1_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Titanium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_1_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Copper,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (7L * tier_1_quantity / 30)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Oxygen,
                                        Materials2FluidShapes.fluidPlasma,
                                        (int) (14_000L / 32 * tier_1_quantity / 30 / 144)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTCC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (baseLuV.getCatalystAmount(0))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseLuV.getResidueAmount(0)),
                                Materials.SuperconductorLuVBase.getMolten(tier_1_quantity))
                        .duration(baseLuV.getDuration(0)).eut(baseLuV.getEUt(0)).metadata(COIL_HEAT, awakened_heat)
                        .addTo(plasmaForgeRecipes);
            }

            {
                // ZPM Superconductor

                long base_quantity = 4095L;
                long tier_up_multiplier = 2L;

                long tier_1_quantity = 144L * base_quantity;
                long tier_2_quantity = tier_1_quantity * tier_up_multiplier;
                long tier_3_quantity = tier_2_quantity * tier_up_multiplier;
                long tier_4_quantity = tier_3_quantity * tier_up_multiplier;

                DTPFCalculator baseZPM = new DTPFCalculator().setBaseParallel(base_quantity)
                        .calculateGenericEBFBasedRecipe(Materials.SuperconductorZPMBase);

                // Tier 4
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Palladium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (6L * tier_4_quantity / 13)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Indium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (2L * tier_4_quantity / 13)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Osmium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_4_quantity / 13)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Naquadah,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (4L * tier_4_quantity / 13)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTEC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (baseZPM.getCatalystAmount(3))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseZPM.getResidueAmount(3)),
                                Materials.SuperconductorZPMBase.getMolten(tier_4_quantity))
                        .duration(baseZPM.getDuration(3)).eut(baseZPM.getEUt(3)).metadata(COIL_HEAT, eternal_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 3
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Palladium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (6L * tier_3_quantity / 13)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Indium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (2L * tier_3_quantity / 13)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Osmium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_3_quantity / 13)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Naquadah,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (4L * tier_3_quantity / 13)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTRC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (baseZPM.getCatalystAmount(2))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseZPM.getResidueAmount(2)),
                                Materials.SuperconductorZPMBase.getMolten(tier_3_quantity))
                        .duration(baseZPM.getDuration(2)).eut(baseZPM.getEUt(2)).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 2
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Palladium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (6L * tier_2_quantity / 13)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Indium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (2L * tier_2_quantity / 13)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Osmium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_2_quantity / 13)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Naquadah,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (4L * tier_2_quantity / 13)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTPC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (baseZPM.getCatalystAmount(1))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseZPM.getResidueAmount(1)),
                                Materials.SuperconductorZPMBase.getMolten(tier_2_quantity))
                        .duration(baseZPM.getDuration(1)).eut(baseZPM.getEUt(1)).metadata(COIL_HEAT, infinity_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 1
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Palladium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (6L * tier_1_quantity / 13)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Indium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (2L * tier_1_quantity / 13)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Osmium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_1_quantity / 13)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Naquadah,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (4L * tier_1_quantity / 13)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTCC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (baseZPM.getCatalystAmount(0))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseZPM.getResidueAmount(0)),
                                Materials.SuperconductorZPMBase.getMolten(tier_1_quantity))
                        .duration(baseZPM.getDuration(0)).eut(baseZPM.getEUt(0)).metadata(COIL_HEAT, awakened_heat)
                        .addTo(plasmaForgeRecipes);
            }

            {
                // UV Superconductor

                long base_quantity = 2043L;
                long tier_up_multiplier = 2L;

                long tier_1_quantity = 144L * base_quantity;
                long tier_2_quantity = tier_1_quantity * tier_up_multiplier;
                long tier_3_quantity = tier_2_quantity * tier_up_multiplier;
                long tier_4_quantity = tier_3_quantity * tier_up_multiplier;

                DTPFCalculator baseUV = new DTPFCalculator().setBaseParallel(base_quantity)
                        .calculateGenericEBFBasedRecipe(Materials.SuperconductorUVBase);

                // Tier 4
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Samarium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_4_quantity / 9)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Europium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_4_quantity / 9)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Osmiridium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (3L * tier_4_quantity / 9)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Naquadria,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (4L * tier_4_quantity / 9)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTEC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (baseUV.getCatalystAmount(3))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseUV.getResidueAmount(3)),
                                Materials.SuperconductorUVBase.getMolten(tier_4_quantity))
                        .duration(baseUV.getDuration(3)).eut(baseUV.getEUt(3)).metadata(COIL_HEAT, eternal_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 3
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Samarium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_3_quantity / 9)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Europium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_3_quantity / 9)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Osmiridium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (3L * tier_3_quantity / 9)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Naquadria,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (4L * tier_3_quantity / 9)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTRC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (baseUV.getCatalystAmount(2))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseUV.getResidueAmount(2)),
                                Materials.SuperconductorUVBase.getMolten(tier_3_quantity))
                        .duration(baseUV.getDuration(2)).eut(baseUV.getEUt(2)).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 2
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Samarium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_2_quantity / 9)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Europium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_2_quantity / 9)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Osmiridium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (3L * tier_2_quantity / 9)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Naquadria,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (4L * tier_2_quantity / 9)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTPC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (baseUV.getCatalystAmount(1))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseUV.getResidueAmount(1)),
                                Materials.SuperconductorUVBase.getMolten(tier_2_quantity))
                        .duration(baseUV.getDuration(1)).eut(baseUV.getEUt(1)).metadata(COIL_HEAT, infinity_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 1
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Samarium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_1_quantity / 9)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Europium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_1_quantity / 9)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Osmiridium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (3L * tier_1_quantity / 9)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Naquadria,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (4L * tier_1_quantity / 9)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTCC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (baseUV.getCatalystAmount(0))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseUV.getResidueAmount(0)),
                                Materials.SuperconductorUVBase.getMolten(tier_1_quantity))
                        .duration(baseUV.getDuration(0)).eut(baseUV.getEUt(0)).metadata(COIL_HEAT, awakened_heat)
                        .addTo(plasmaForgeRecipes);
            }

            {
                // UHV Superconductor

                long base_quantity = 1008L;
                long tier_up_multiplier = 2L;

                long tier_2_quantity = 144L * base_quantity;
                long tier_3_quantity = tier_2_quantity * tier_up_multiplier;
                long tier_4_quantity = tier_3_quantity * tier_up_multiplier;
                long tier_5_quantity = tier_4_quantity * tier_up_multiplier;

                DTPFCalculator baseUHV = new DTPFCalculator().setBaseParallel(base_quantity).setLowestCatalystTier(1)
                        .setHighestCatalystTier(4).calculateGenericEBFBasedRecipe(Materials.SuperconductorUHVBase);

                // Tier 5
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Draconium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (6L * tier_5_quantity / 24)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Americium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (6L * tier_5_quantity / 24)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.CosmicNeutronium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (7L * tier_5_quantity / 24)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Tritanium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (5L * tier_5_quantity / 24)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTSC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (baseUHV.getCatalystAmount(4))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseUHV.getResidueAmount(4)),
                                Materials.SuperconductorUHVBase.getMolten(tier_5_quantity))
                        .duration(baseUHV.getDuration(4)).eut(baseUHV.getEUt(4)).metadata(COIL_HEAT, eternal_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 4
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Draconium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (6L * tier_4_quantity / 24)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Americium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (6L * tier_4_quantity / 24)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.CosmicNeutronium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (7L * tier_4_quantity / 24)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Tritanium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (5L * tier_4_quantity / 24)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTEC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (baseUHV.getCatalystAmount(3))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseUHV.getResidueAmount(3)),
                                Materials.SuperconductorUHVBase.getMolten(tier_4_quantity))
                        .duration(baseUHV.getDuration(3)).eut(baseUHV.getEUt(3)).metadata(COIL_HEAT, eternal_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 3
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Draconium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (6L * tier_3_quantity / 24)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Americium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (6L * tier_3_quantity / 24)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.CosmicNeutronium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (7L * tier_3_quantity / 24)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Tritanium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (5L * tier_3_quantity / 24)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTRC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (baseUHV.getCatalystAmount(2))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseUHV.getResidueAmount(2)),
                                Materials.SuperconductorUHVBase.getMolten(tier_3_quantity))
                        .duration(baseUHV.getDuration(2)).eut(baseUHV.getEUt(2)).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 2
                GTValues.RA.stdBuilder()
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Draconium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (6L * tier_2_quantity / 24)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Americium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (6L * tier_2_quantity / 24)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.CosmicNeutronium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (7L * tier_2_quantity / 24)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Tritanium,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (5L * tier_2_quantity / 24)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.ExcitedDTPC,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (baseUHV.getCatalystAmount(1))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseUHV.getResidueAmount(1)),
                                Materials.SuperconductorUHVBase.getMolten(tier_2_quantity))
                        .duration(baseUHV.getDuration(1)).eut(baseUHV.getEUt(1)).metadata(COIL_HEAT, infinity_heat)
                        .addTo(plasmaForgeRecipes);
            }

            {
                // UEV Superconductor

                long base_quantity = 504L;
                long tier_up_multiplier = 2L;

                long tier_3_quantity = 144L * base_quantity;
                long tier_4_quantity = tier_3_quantity * tier_up_multiplier;
                long tier_5_quantity = tier_4_quantity * tier_up_multiplier;

                DTPFCalculator baseUEV = new DTPFCalculator().setBaseParallel(base_quantity).setLowestCatalystTier(2)
                        .setHighestCatalystTier(4).calculateGenericEBFBasedRecipe(Materials.SuperconductorUEVBase);

                // Tier 5
                GTValues.RA.stdBuilder().fluidInputs(
                        new FluidStack(FluidRegistry.getFluid("molten.advancednitinol"), (int) tier_5_quantity / 12),
                        new FluidStack(FluidRegistry.getFluid("molten.celestialtungsten"), (int) tier_5_quantity / 12),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.DraconiumAwakened,
                                Materials2FluidShapes.fluidMolten,
                                (int) (5L * tier_5_quantity / 12)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Infinity,
                                Materials2FluidShapes.fluidMolten,
                                (int) (5L * tier_5_quantity / 12)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Iron,
                                Materials2FluidShapes.fluidPlasma,
                                (int) (tier_5_quantity / 12)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.ExcitedDTSC,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (baseUEV.getCatalystAmount(4))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseUEV.getResidueAmount(4)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.SuperconductorUEVBase,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_5_quantity)))
                        .duration(baseUEV.getDuration(4)).eut(baseUEV.getEUt(4)).metadata(COIL_HEAT, eternal_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 4
                GTValues.RA.stdBuilder().fluidInputs(
                        new FluidStack(FluidRegistry.getFluid("molten.advancednitinol"), (int) tier_4_quantity / 12),
                        new FluidStack(FluidRegistry.getFluid("molten.celestialtungsten"), (int) tier_4_quantity / 12),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.DraconiumAwakened,
                                Materials2FluidShapes.fluidMolten,
                                (int) (5L * tier_4_quantity / 12)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Infinity,
                                Materials2FluidShapes.fluidMolten,
                                (int) (5L * tier_4_quantity / 12)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Iron,
                                Materials2FluidShapes.fluidPlasma,
                                (int) (tier_4_quantity / 12)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.ExcitedDTEC,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (baseUEV.getCatalystAmount(3))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseUEV.getResidueAmount(3)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.SuperconductorUEVBase,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_4_quantity)))
                        .duration(baseUEV.getDuration(3)).eut(baseUEV.getEUt(3)).metadata(COIL_HEAT, eternal_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 3
                GTValues.RA.stdBuilder().fluidInputs(
                        new FluidStack(FluidRegistry.getFluid("molten.advancednitinol"), (int) tier_3_quantity / 12),
                        new FluidStack(FluidRegistry.getFluid("molten.celestialtungsten"), (int) tier_3_quantity / 12),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.DraconiumAwakened,
                                Materials2FluidShapes.fluidMolten,
                                (int) (5L * tier_3_quantity / 12)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Infinity,
                                Materials2FluidShapes.fluidMolten,
                                (int) (5L * tier_3_quantity / 12)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Iron,
                                Materials2FluidShapes.fluidPlasma,
                                (int) (tier_3_quantity / 12)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.ExcitedDTRC,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (baseUEV.getCatalystAmount(2))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseUEV.getResidueAmount(2)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.SuperconductorUEVBase,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_3_quantity)))
                        .duration(baseUEV.getDuration(2)).eut(baseUEV.getEUt(2)).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(plasmaForgeRecipes);
            }

            {
                // UIV Superconductor

                long base_quantity = 250L;
                long tier_up_multiplier = 2L;

                long tier_3_quantity = 144L * base_quantity;
                long tier_4_quantity = tier_3_quantity * tier_up_multiplier;
                long tier_5_quantity = tier_4_quantity * tier_up_multiplier;

                DTPFCalculator baseUIV = new DTPFCalculator().setBaseParallel(base_quantity).setLowestCatalystTier(2)
                        .setHighestCatalystTier(4).calculateGenericEBFBasedRecipe(Materials.SuperconductorUIVBase);

                // Tier 5
                GTValues.RA.stdBuilder().fluidInputs(
                        Materials.RadoxPolymer.getMolten(4L * tier_5_quantity / 25),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.TranscendentMetal,
                                Materials2FluidShapes.fluidMolten,
                                (int) (10L * tier_5_quantity / 25)),
                        new FluidStack(FluidRegistry.getFluid("molten.rhugnor"), (int) tier_5_quantity * 6 / 25),
                        new FluidStack(FluidRegistry.getFluid("molten.chromaticglass"), (int) tier_5_quantity * 5 / 25),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Bismuth,
                                Materials2FluidShapes.fluidPlasma,
                                (int) (tier_5_quantity / 25)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.ExcitedDTSC,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (baseUIV.getCatalystAmount(4))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseUIV.getResidueAmount(4)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.SuperconductorUIVBase,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_5_quantity)))
                        .duration(baseUIV.getDuration(4)).eut(baseUIV.getEUt(4)).metadata(COIL_HEAT, eternal_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 4
                GTValues.RA.stdBuilder().fluidInputs(
                        Materials.RadoxPolymer.getMolten(4L * tier_4_quantity / 25),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.TranscendentMetal,
                                Materials2FluidShapes.fluidMolten,
                                (int) (10L * tier_4_quantity / 25)),
                        new FluidStack(FluidRegistry.getFluid("molten.rhugnor"), (int) tier_4_quantity * 6 / 25),
                        new FluidStack(FluidRegistry.getFluid("molten.chromaticglass"), (int) tier_4_quantity * 5 / 25),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Bismuth,
                                Materials2FluidShapes.fluidPlasma,
                                (int) (tier_4_quantity / 25)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.ExcitedDTEC,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (baseUIV.getCatalystAmount(3))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseUIV.getResidueAmount(3)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.SuperconductorUIVBase,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_4_quantity)))
                        .duration(baseUIV.getDuration(3)).eut(baseUIV.getEUt(3)).metadata(COIL_HEAT, eternal_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 3
                GTValues.RA.stdBuilder().fluidInputs(
                        Materials.RadoxPolymer.getMolten(4L * tier_3_quantity / 25),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.TranscendentMetal,
                                Materials2FluidShapes.fluidMolten,
                                (int) (10L * tier_3_quantity / 25)),
                        new FluidStack(FluidRegistry.getFluid("molten.rhugnor"), (int) tier_3_quantity * 6 / 25),
                        new FluidStack(FluidRegistry.getFluid("molten.chromaticglass"), (int) tier_3_quantity * 5 / 25),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Bismuth,
                                Materials2FluidShapes.fluidPlasma,
                                (int) (tier_3_quantity / 25)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.ExcitedDTRC,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (baseUIV.getCatalystAmount(2))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseUIV.getResidueAmount(2)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.SuperconductorUIVBase,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_3_quantity)))
                        .duration(baseUIV.getDuration(2)).eut(baseUIV.getEUt(2)).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(plasmaForgeRecipes);
            }

            {
                // UMV Superconductor

                long base_quantity = 243L;
                long tier_up_multiplier = 2L;

                long tier_4_quantity = 144L * base_quantity;
                long tier_5_quantity = tier_4_quantity * tier_up_multiplier;

                DTPFCalculator baseUMV = new DTPFCalculator().setBaseParallel(base_quantity).setLowestCatalystTier(3)
                        .setHighestCatalystTier(4).calculateGenericEBFBasedRecipe(Materials.SuperconductorUMVBase);

                // Tier 5
                GTValues.RA.stdBuilder().fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SpaceTime,
                                Materials2FluidShapes.fluidMolten,
                                (int) (6L * tier_5_quantity / 27)),
                        new FluidStack(FluidRegistry.getFluid("molten.orundum"), (int) tier_5_quantity * 3 / 27),
                        new FluidStack(FluidRegistry.getFluid("molten.hypogen"), (int) tier_5_quantity * 11 / 27),
                        new FluidStack(FluidRegistry.getFluid("molten.titansteel"), (int) tier_5_quantity * 5 / 27),
                        new FluidStack(FluidRegistry.getFluid("molten.dragonblood"), (int) tier_5_quantity * 2 / 27),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidPlasma,
                                (int) (tier_5_quantity / 27)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.ExcitedDTSC,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (baseUMV.getCatalystAmount(4))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseUMV.getResidueAmount(4)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.SuperconductorUMVBase,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_5_quantity)))
                        .duration(baseUMV.getDuration(4)).eut(baseUMV.getEUt(4)).metadata(COIL_HEAT, eternal_heat)
                        .addTo(plasmaForgeRecipes);

                // Tier 4
                GTValues.RA.stdBuilder().fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SpaceTime,
                                Materials2FluidShapes.fluidMolten,
                                (int) (6L * tier_4_quantity / 27)),
                        new FluidStack(FluidRegistry.getFluid("molten.orundum"), (int) tier_4_quantity * 3 / 27),
                        new FluidStack(FluidRegistry.getFluid("molten.hypogen"), (int) tier_4_quantity * 11 / 27),
                        new FluidStack(FluidRegistry.getFluid("molten.titansteel"), (int) tier_4_quantity * 5 / 27),
                        new FluidStack(FluidRegistry.getFluid("molten.dragonblood"), (int) tier_4_quantity * 2 / 27),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidPlasma,
                                (int) (tier_4_quantity / 27)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.ExcitedDTEC,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (baseUMV.getCatalystAmount(3))))
                        .fluidOutputs(
                                Materials.DTR.getFluid(baseUMV.getResidueAmount(3)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.SuperconductorUMVBase,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (tier_4_quantity)))
                        .duration(baseUMV.getDuration(3)).eut(baseUMV.getEUt(3)).metadata(COIL_HEAT, eternal_heat)
                        .addTo(plasmaForgeRecipes);
            }

            // Transcendent metal
            long total_EU_per_ingot = 113_246_208_000L + 629_145_600L;
            long recipe_time = 180 * 20;

            DTPFCalculator transcendent_metal = new DTPFCalculator().setBaseParallel(360).setLowestCatalystTier(4)
                    .setScalingFactor(8).setHighestCatalystTier(4)
                    .calculateNonEBFRecipe(total_EU_per_ingot / recipe_time, recipe_time);

            GTValues.RA.stdBuilder()
                    .itemInputs(ItemList.Tesseract.get(32), GTOreDictUnificator.get("blockCosmicNeutronium", 40))
                    .itemOutputs(
                            Materials.TranscendentMetal.getBlocks(40),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.TranscendentMetal, Materials2Shapes.dust, (int) (24)))
                    .fluidInputs(
                            MaterialsAlloy.TITANSTEEL.getFluidStack(144 * 40 * 9),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.CallistoIce,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (144 * 20 * 9)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Ledox,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (144 * 20 * 9)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Tungsten,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (144 * 40 * 9)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTSC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (transcendent_metal.getCatalystAmount(4))))
                    .fluidOutputs(
                            Materials.DTR.getFluid(transcendent_metal.getResidueAmount(4)),
                            MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getFluidStack(144 * 20 * 9))
                    .duration(transcendent_metal.getDuration(4)).eut(transcendent_metal.getEUt(4))
                    .metadata(COIL_HEAT, eternal_heat).addTo(plasmaForgeRecipes);

            // Quantum + Astral Titanium

            // Based on quantum abs recipe
            long total_EU_per_quantum_ingot = (long) (9_437_184_000L * 0.9);
            // Laser engraver recipe
            long total_EU_per_astral_dust = 4_718_592_000L;
            // Astral titanium ebf
            long total_EU_per_astral_ingot_ebf = 22_118_400_000L;
            // Astral titanium freezer
            long total_EU_per_astral_ingot_freezer = 1_639_710_720L;
            // 2 astral titanium blocks per 320 quantum ingots
            float astral_ingots_per_quantum_ingot = 18 / 320f;
            // Based on quantum abs including coil discount
            long recipe_time_per_quantum_ingot = (long) (600 * 20 / 10 * 0.9);
            long total_EUt = (long) (total_EU_per_quantum_ingot + astral_ingots_per_quantum_ingot
                    * (total_EU_per_astral_dust + total_EU_per_astral_ingot_ebf + total_EU_per_astral_ingot_freezer))
                    / recipe_time_per_quantum_ingot;
            DTPFCalculator quantum = new DTPFCalculator().setBaseParallel(320).setLowestCatalystTier(3)
                    .setHighestCatalystTier(4).setEUtDivisor(1.12f)
                    .calculateNonEBFRecipe(total_EUt, recipe_time_per_quantum_ingot);
            GTValues.RA.stdBuilder().itemInputs(
                    GregtechItemList.Energy_Core_UHV.get(0),
                    BlockList.Quantinum.get(2),
                    // Quantum Anomaly
                    GregtechItemList.Laser_Lens_Special.get(2))
                    .itemOutputs(MaterialsElements.STANDALONE.ASTRAL_TITANIUM.getBlock(2))
                    .fluidInputs(
                            MaterialsAlloy.BLACK_TITANIUM.getFluidStack(144 * 320 * 7 / 10),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Americium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (144 * 320 / 10)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Bismuth,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (144 * 320 / 10)),
                            MaterialsElements.STANDALONE.HYPOGEN.getFluidStack(144 * 320 / 10),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Titanium,
                                    Materials2FluidShapes.fluidPlasma,
                                    (int) (144 * 9 * 2 * 2)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTEC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (quantum.getCatalystAmount(3))))
                    .fluidOutputs(
                            Materials.DTR.getFluid(quantum.getResidueAmount(3)),
                            MaterialsAlloy.QUANTUM.getFluidStack(144 * 320))
                    .duration(quantum.getDuration(3)).eut(quantum.getEUt(3)).metadata(COIL_HEAT, eternal_heat)
                    .addTo(plasmaForgeRecipes);

            // Quantum + Astral Titanium v2
            GTValues.RA.stdBuilder().itemInputs(
                    GregtechItemList.Energy_Core_UHV.get(0),
                    BlockList.Quantinum.get(4),
                    // Quantum Anomaly
                    GregtechItemList.Laser_Lens_Special.get(3))
                    .itemOutputs(MaterialsElements.STANDALONE.ASTRAL_TITANIUM.getBlock(4))
                    .fluidInputs(
                            MaterialsAlloy.BLACK_TITANIUM.getFluidStack(144 * 640 * 7 / 10),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Americium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (144 * 640 / 10)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Bismuth,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (144 * 640 / 10)),
                            MaterialsElements.STANDALONE.HYPOGEN.getFluidStack(144 * 640 / 10),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Titanium,
                                    Materials2FluidShapes.fluidPlasma,
                                    (int) (144 * 9 * 4 * 2)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTSC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (quantum.getCatalystAmount(4))))
                    .fluidOutputs(
                            Materials.DTR.getFluid(quantum.getResidueAmount(4)),
                            MaterialsAlloy.QUANTUM.getFluidStack(144 * 640))
                    .duration(quantum.getDuration(4)).eut(quantum.getEUt(4)).metadata(COIL_HEAT, eternal_heat)
                    .addTo(plasmaForgeRecipes);

            // Timepiece
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GregtechItemList.SpaceTimeBendingCore.get(0),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.DarkIron, Materials2Shapes.plateDense, (int) (1L)),
                            MaterialLibAPI.getStack(Materials2Materials.Dilithium, Materials2Shapes.gem, (int) (32)),
                            Materials.Universium.getNanite(1))
                    .itemOutputs(ItemList.Timepiece.get(3))
                    .fluidInputs(
                            Materials.Time.getMolten(18432L * 8),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTSC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (100000L)))
                    .fluidOutputs(Materials.DTR.getFluid(100000L * 2), Materials.Space.getMolten(18432L * 8))
                    .duration(80 * SECONDS).eut(TierEU.RECIPE_MAX).metadata(COIL_HEAT, 13500).addTo(plasmaForgeRecipes);

            // Time to Space
            GTValues.RA.stdBuilder().itemInputs(
                    // Spacetime Continuum Ripper
                    GregtechItemList.SpaceTimeContinuumRipper.get(0),
                    ItemList.EnergisedTesseract.get(2),
                    // Quantum Anomaly
                    GregtechItemList.Laser_Lens_Special.get(16)).itemOutputs(ItemList.Tesseract.get(1))
                    .fluidInputs(
                            Materials.Time.getMolten(9216L * 64),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SpaceTime,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (9216L * 16)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTSC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (1000L)))
                    .fluidOutputs(Materials.DTR.getFluid(1000L * 2), Materials.Space.getMolten(9216L * 64))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_MAX).metadata(COIL_HEAT, 13500).addTo(plasmaForgeRecipes);

            // Space to Time
            GTValues.RA.stdBuilder().itemInputs(
                    // Spacetime Continuum Ripper
                    GregtechItemList.SpaceTimeContinuumRipper.get(0),
                    ItemList.EnergisedTesseract.get(2),
                    ItemList.Timepiece.get(16)).itemOutputs(ItemList.Tesseract.get(1))
                    .fluidInputs(
                            Materials.Space.getMolten(9216L * 64),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SpaceTime,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (9216L * 16)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTSC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (1000L)))
                    .fluidOutputs(Materials.DTR.getFluid(1000L * 2), Materials.Time.getMolten(9216L * 64))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_MAX).metadata(COIL_HEAT, 13500).addTo(plasmaForgeRecipes);

            // Quantum anomaly
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GregtechItemList.Laser_Lens_Special.get(1),
                            ItemList.StableBosonContainmentUnit.get(4),
                            NHItemList.MysteriousCrystalLens.get(0),
                            ItemRefer.HiC_T5.get(0))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTEC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (92)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Tritanium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (144)))
                    .itemOutputs(GregtechItemList.Laser_Lens_Special.get(4)).duration(5 * SECONDS)
                    .fluidOutputs(Materials.DTR.getFluid(92)).eut((int) TierEU.RECIPE_UIV)
                    .metadata(COIL_HEAT, eternal_heat).addTo(plasmaForgeRecipes);

            // TODO: remove this old recipe Quantum anomaly
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GregtechItemList.Laser_Lens_Special.get(1),
                            new ItemStack(Particle.getBaseParticle(Particle.GRAVITON).getItem(), 4),
                            NHItemList.MysteriousCrystalLens.get(0),
                            ItemRefer.HiC_T5.get(0))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTEC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (92)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Tritanium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (144)))
                    .itemOutputs(GregtechItemList.Laser_Lens_Special.get(4)).duration(5 * SECONDS)
                    .fluidOutputs(Materials.DTR.getFluid(92)).eut((int) TierEU.RECIPE_UIV)
                    .metadata(COIL_HEAT, eternal_heat).addTo(plasmaForgeRecipes);

        }
    }
}
