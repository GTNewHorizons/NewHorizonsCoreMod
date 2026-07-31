package com.dreammaster.bartworksHandler;

import static bartworks.API.BioObjectAdder.regenerateBioFluids;
import static bartworks.API.recipe.BartWorksRecipeMaps.bacterialVatRecipes;
import static bartworks.API.recipe.BartWorksRecipeMaps.bioLabRecipes;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.Genetics;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.recipe.RecipeMaps.BEAMCRAFTER_METADATA;
import static gregtech.api.recipe.RecipeMaps.autoclaveRecipes;
import static gregtech.api.recipe.RecipeMaps.beamcrafterRecipes;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.recipe.RecipeMaps.crackingRecipes;
import static gregtech.api.recipe.RecipeMaps.distillationTowerRecipes;
import static gregtech.api.recipe.RecipeMaps.fusionRecipes;
import static gregtech.api.recipe.RecipeMaps.multiblockChemicalReactorRecipes;
import static gregtech.api.recipe.RecipeMaps.pyrolyseRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeConstants.FUSION_THRESHOLD;
import static gregtech.api.util.GTRecipeConstants.GLASS;
import static gregtech.api.util.GTRecipeConstants.SIEVERT;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.cokeOvenRecipes;
import static gtnhlanth.common.beamline.Particle.TAU;
import static gtnhlanth.common.beamline.Particle.TAUNEUTRINO;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import bartworks.API.enums.BioCultureEnum;
import bartworks.util.BWUtil;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.material.MU;
import gregtech.api.objects.OreDictItemStack;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.recipe.Sievert;
import gregtech.loaders.postload.recipes.beamcrafter.BeamCrafterMetadata;

public class BacteriaRegistry {

    public void runAllPostinit() {
        regenerateBioFluids(); // this will generate bacteria fluids. needs to be called AFTER ALL breedable bacterias
        // have been registered.
        runBWRecipes();
        runGTRecipes();
        new BW_Recipe_Loader().run();
    }

    private void runAdditionalFuelRecipes() {
        // XenoxRecycleRecipe
        GTValues.RA.stdBuilder()
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Ash, Materials2Shapes.dust, (int) (1)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.DilutedXenoxene,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1000)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Xenoxene,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (250)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.LightRadox,
                                Materials2FluidShapes.fluidGas,
                                (int) (300)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_UV).addTo(distillationTowerRecipes);

        // LightRadox + Nq -> Enriched Naquadah condensation
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Naquadah, Materials2Shapes.dust, (int) (1)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.NaquadahEnriched, Materials2Shapes.dust, (int) (3)))
                .outputChances(10000)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.LightRadox,
                                Materials2FluidShapes.fluidGas,
                                (int) (2000)))
                .requiresLowGravity().duration(17 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_IV).addTo(autoclaveRecipes);

        // super heavy -> heavy radox conversion
        GTValues.RA.stdBuilder().itemOutputs()
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperHeavyRadox,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1000)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.HeavyRadox,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (2000)))
                .duration(50 * MINUTES).eut(TierEU.RECIPE_UV).addTo(centrifugeRecipes);

        // heavy radox + Nq+ -> Nq*
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.NaquadahEnriched, Materials2Shapes.dust, (int) (1)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Naquadria, Materials2Shapes.dust, (int) (3)))
                .outputChances(10000)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.HeavyRadox,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (4000)))
                .requiresLowGravity().duration(17 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ZPM)
                .addTo(autoclaveRecipes);

    }

    private void runGTRecipes() {
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "barnardaClog", 64)).circuit(24)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Ash, Materials2Shapes.dust, (int) (8)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Xenoxene,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1000)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.RawRadox,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1000)))
                .duration(3 * MINUTES).eut(TierEU.RECIPE_UV).addTo(pyrolyseRecipes, cokeOvenRecipes);

        GTValues.RA.stdBuilder()
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Ash, Materials2Shapes.dust, (int) (5)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.RawRadox,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (5000)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.OilHeavy,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (600)),
                        MaterialLibAPI
                                .getFluidStack(Materials2Materials.Oil, Materials2FluidShapes.fluidLiquid, (int) (300)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Creosote,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1000)),
                        MU.materialOf(Materials2Materials.Water).getFluid(1400),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.FermentedBacterialSludge,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (50)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.FermentedBiomass,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (50)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperHeavyRadox,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (100)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.HeavyRadox,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (150)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.DilutedXenoxene,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (50)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.LightRadox,
                                Materials2FluidShapes.fluidGas,
                                (int) (300)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperLightRadox,
                                Materials2FluidShapes.fluidGas,
                                (int) (500)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(distillationTowerRecipes);

        GTValues.RA.stdBuilder().circuit(24).fluidInputs(
                MaterialLibAPI.getFluidStack(
                        Materials2Materials.SuperLightRadox,
                        Materials2FluidShapes.fluidGas,
                        (int) (100)),
                MaterialLibAPI.getFluidStack(Materials2Materials.Silver, Materials2FluidShapes.fluidPlasma, (int) (1)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.CrackedRadox,
                                Materials2FluidShapes.fluidGas,
                                (int) (100)))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_UV).addTo(crackingRecipes);

        GTValues.RA.stdBuilder()
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Ash, Materials2Shapes.dust, (int) (1)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.CrackedRadox,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.RadoxGas,
                                Materials2FluidShapes.fluidGas,
                                (int) (100)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.LightRadox,
                                Materials2FluidShapes.fluidGas,
                                (int) (200)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_UV).addTo(distillationTowerRecipes);

        // Ti & O Plasma Recipes
        GTValues.RA.stdBuilder().fluidInputs(
                MaterialLibAPI
                        .getFluidStack(Materials2Materials.Aluminium, Materials2FluidShapes.fluidMolten, (int) (144)),
                MaterialLibAPI.getFluidStack(Materials2Materials.Fluorine, Materials2FluidShapes.fluidGas, (int) (144)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Titanium,
                                Materials2FluidShapes.fluidPlasma,
                                (int) (144)))
                .duration(8 * SECONDS).eut(49_152).metadata(FUSION_THRESHOLD, 180_000_000L).addTo(fusionRecipes);

        GTValues.RA.stdBuilder().fluidInputs(
                MaterialLibAPI
                        .getFluidStack(Materials2Materials.Helium, Materials2FluidShapes.fluidPlasma, (int) (144)),
                MaterialLibAPI
                        .getFluidStack(Materials2Materials.Lithium, Materials2FluidShapes.fluidMolten, (int) (144)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Boron,
                                Materials2FluidShapes.fluidPlasma,
                                (int) (144)))
                .duration(12 * SECONDS).eut(10_240).metadata(FUSION_THRESHOLD, 50_000_000L).addTo(fusionRecipes);

        GTValues.RA.stdBuilder().fluidInputs(
                MaterialLibAPI.getFluidStack(Materials2Materials.Boron, Materials2FluidShapes.fluidPlasma, (int) (144)),
                MaterialLibAPI
                        .getFluidStack(Materials2Materials.Lithium, Materials2FluidShapes.fluidMolten, (int) (144)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidPlasma,
                                (int) (144)))
                .duration(12 * SECONDS).eut(49_152).metadata(FUSION_THRESHOLD, 180_000_000L).addTo(fusionRecipes);

        GTValues.RA.stdBuilder().circuit(2).fluidInputs(
                MaterialLibAPI
                        .getFluidStack(Materials2Materials.RadoxGas, Materials2FluidShapes.fluidGas, (int) (2160)),
                MaterialLibAPI
                        .getFluidStack(Materials2Materials.Oxygen, Materials2FluidShapes.fluidPlasma, (int) (7500L)),
                MaterialLibAPI
                        .getFluidStack(Materials2Materials.Titanium, Materials2FluidShapes.fluidPlasma, (int) (100L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.RadoxPoly,
                                Materials2FluidShapes.fluidMolten,
                                (int) (720L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_UV).addTo(multiblockChemicalReactorRecipes);

        runAdditionalFuelRecipes();
    }

    private void bacterialVatRecipes() {
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.AntimonyTrioxide, Materials2Shapes.dust, (int) (16)),
                        MaterialLibAPI.getStack(Materials2Materials.Osmium, Materials2Shapes.dust, (int) (16)))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.XenoxeneXenoxsis.bioCulture))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials2Materials.Oil, Materials2FluidShapes.fluidLiquid, (int) (20)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Xenoxene,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (20)))
                .duration(3 * MINUTES).eut(TierEU.RECIPE_UEV).metadata(GLASS, 8)
                .metadata(
                        SIEVERT,
                        new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.NaquadahEnriched)), false))
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Chip_Stemcell.get(64L),
                        getModItem(GalaxySpace.ID, "item.UnknowCrystal", 16),
                        NHItemList.TCetiESeaweedExtract.get(4),
                        MaterialLibAPI.getStack(Materials2Materials.Tritanium, Materials2Shapes.dust, (int) (4)))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.DerivanturCellulaEvolutionis.bioCulture))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.GrowthMediumRaw,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (8)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.BioMediumRaw,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (2)))
                .duration(3 * MINUTES).eut(TierEU.RECIPE_LuV).metadata(GLASS, 6)
                .metadata(SIEVERT, new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.Plutonium)), true))
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Chip_Stemcell.get(16L),
                        getModItem(GalaxySpace.ID, "item.UnknowCrystal", 16),
                        NHItemList.TCetiESeaweedExtract.get(8),
                        MaterialLibAPI
                                .getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dustTiny, (int) (4)))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.CellulaBiologicumEvolutione.bioCulture))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.GrowthMediumRaw,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (5)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.BioMediumRaw,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (5)))
                .duration(3 * MINUTES).eut(TierEU.RECIPE_ZPM).metadata(GLASS, 7)
                .metadata(
                        SIEVERT,
                        new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.NaquadahEnriched)), true))
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Chip_Biocell.get(8L),
                        NHItemList.TCetiESeaweedExtract.get(16),
                        MaterialLibAPI.getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dust, (int) (4)))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.CellulaBiologicumEvolutione.bioCulture))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.GrowthMediumRaw,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (5)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.BioMediumRaw,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (10)))
                .duration(3 * MINUTES).eut(TierEU.RECIPE_UV).metadata(GLASS, 8)
                .metadata(SIEVERT, new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.Naquadria)), true))
                .requiresCleanRoom().addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(Genetics.ID, "misc", 2, 4))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.BinniGrowthMedium.bioCulture))
                .fluidInputs(GTModHandler.getDistilledWater(4L))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.growthmedium", 2)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).metadata(GLASS, 4).addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.MysteriousCrystal, Materials2Shapes.dust, (int) (1)))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.BinniGrowthMedium.bioCulture))
                .fluidInputs(GTModHandler.getDistilledWater(8L))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.growthmedium", 4)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_EV).metadata(GLASS, 5)
                .metadata(SIEVERT, new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.Bismuth)), false))
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dustTiny, (int) (1)))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.BinniGrowthMedium.bioCulture))
                .fluidInputs(GTModHandler.getDistilledWater(16L))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.growthmedium", 8)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_IV).metadata(GLASS, 5)
                .metadata(SIEVERT, new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.Uranium)), false))
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dust, (int) (1)))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.BinniGrowthMedium.bioCulture))
                .fluidInputs(GTModHandler.getDistilledWater(16L * 9L))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.growthmedium", 8 * 9))
                .duration(9 * (7 * SECONDS + 10 * TICKS)).eut(TierEU.RECIPE_IV).metadata(GLASS, 5)
                .metadata(SIEVERT, new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.Uranium)), false))
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemBiochaff", 4, 0))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.BinniBacteria.bioCulture))
                .fluidInputs(GTModHandler.getDistilledWater(4L))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.bacteria", 2)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(GLASS, 4)
                .metadata(SIEVERT, new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.Bismuth)), false))
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.MysteriousCrystal, Materials2Shapes.dust, (int) (1)))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.BinniBacteria.bioCulture))
                .fluidInputs(GTModHandler.getDistilledWater(8L))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.bacteria", 4)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(GLASS, 5)
                .metadata(SIEVERT, new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.Uranium)), false))
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dustTiny, (int) (1)))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.BinniBacteria.bioCulture))
                .fluidInputs(GTModHandler.getDistilledWater(16L))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.bacteria", 8)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(GLASS, 6)
                .metadata(SIEVERT, new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.Plutonium)), false))
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dust, (int) (1)))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.BinniBacteria.bioCulture))
                .fluidInputs(GTModHandler.getDistilledWater(16L * 9L))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.bacteria", 8 * 9)).duration(9 * 15 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(GLASS, 6)
                .metadata(SIEVERT, new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.Plutonium)), false))
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MarsStoneDust.get(16))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.CorynebacteriumSludgeMarsensis.bioCulture))
                .fluidInputs(GTModHandler.getDistilledWater(4L))
                .fluidOutputs(FluidRegistry.getFluidStack("bacterialsludge", 1)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(GLASS, 5)
                .metadata(SIEVERT, new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.Bismuth)), false))
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.MysteriousCrystal, Materials2Shapes.dust, (int) (1)))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.CorynebacteriumSludgeMarsensis.bioCulture))
                .fluidInputs(GTModHandler.getDistilledWater(8L))
                .fluidOutputs(FluidRegistry.getFluidStack("bacterialsludge", 2)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(GLASS, 6)
                .metadata(SIEVERT, new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.Uranium)), false))
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dustTiny, (int) (1)))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.CorynebacteriumSludgeMarsensis.bioCulture))
                .fluidInputs(GTModHandler.getDistilledWater(16L))
                .fluidOutputs(FluidRegistry.getFluidStack("bacterialsludge", 4)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LuV).metadata(GLASS, 7)
                .metadata(SIEVERT, new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.Plutonium)), true))
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dust, (int) (1)))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.CorynebacteriumSludgeMarsensis.bioCulture))
                .fluidInputs(GTModHandler.getDistilledWater(16L * 9L))
                .fluidOutputs(FluidRegistry.getFluidStack("bacterialsludge", 4 * 9)).duration(9 * 30 * SECONDS)
                .eut(TierEU.RECIPE_LuV).metadata(GLASS, 7)
                .metadata(SIEVERT, new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.Plutonium)), true))
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.MysteriousCrystal, Materials2Shapes.dust, (int) (4)))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.MutagenBacteriaASpatio.bioCulture))
                .fluidInputs(GTModHandler.getDistilledWater(4L)).fluidOutputs(FluidRegistry.getFluidStack("mutagen", 1))
                .duration(1 * MINUTES).eut(TierEU.RECIPE_IV).metadata(GLASS, 6)
                .metadata(SIEVERT, new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.Uranium)), false))
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dustTiny, (int) (1)))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.MutagenBacteriaASpatio.bioCulture))
                .fluidInputs(GTModHandler.getDistilledWater(8L)).fluidOutputs(FluidRegistry.getFluidStack("mutagen", 2))
                .duration(1 * MINUTES).eut(TierEU.RECIPE_LuV).metadata(GLASS, 7)
                .metadata(SIEVERT, new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.Plutonium)), true))
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dust, (int) (1)))
                .special(BioCultureEnum.getPetriDish(BioCultureEnum.MutagenBacteriaASpatio.bioCulture))
                .fluidInputs(GTModHandler.getDistilledWater(8L * 9L))
                .fluidOutputs(FluidRegistry.getFluidStack("mutagen", 2 * 9)).duration(9 * MINUTES)
                .eut(TierEU.RECIPE_LuV).metadata(GLASS, 7)
                .metadata(SIEVERT, new Sievert(BWUtil.calculateSv(MU.materialOf(Materials2Materials.Plutonium)), true))
                .addTo(bacterialVatRecipes);

        // TheVat - BacVat

        if (EnderIO.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Thaumcraft.ID, "ItemZombieBrain", 4, 0),
                            new ItemStack(Items.fermented_spider_eye, 4))
                    .special(BioCultureEnum.getPetriDish(BioCultureEnum.BinniBacteria.bioCulture))
                    .fluidInputs(FluidRegistry.getFluidStack("potion.mineralwater", 40))
                    .fluidOutputs(FluidRegistry.getFluidStack("nutrient_distillation", 10)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_EV).metadata(GLASS, 2).addTo(bacterialVatRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.poisonous_potato, 4), new ItemStack(Items.sugar, 4))
                    .special(BioCultureEnum.getPetriDish(BioCultureEnum.BinniBacteria.bioCulture))
                    .fluidInputs(FluidRegistry.getFluidStack("potion.mineralwater", 80))
                    .fluidOutputs(FluidRegistry.getFluidStack("hootch", 20)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_EV).metadata(GLASS, 2).addTo(bacterialVatRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Items.blaze_powder, 4),
                            MaterialLibAPI.getStack(Materials2Materials.Redstone, Materials2Shapes.dust, (int) (4)))
                    .special(BioCultureEnum.getPetriDish(BioCultureEnum.BinniBacteria.bioCulture))
                    .fluidInputs(FluidRegistry.getFluidStack("hootch", 10))
                    .fluidOutputs(FluidRegistry.getFluidStack("fire_water", 10)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_EV).metadata(GLASS, 2).addTo(bacterialVatRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(new ItemStack(Blocks.glowstone, 4), getModItem(Botania.ID, "quartz", 4, 6))
                    .special(BioCultureEnum.getPetriDish(BioCultureEnum.BinniBacteria.bioCulture))
                    .fluidInputs(FluidRegistry.getFluidStack("fire_water", 10))
                    .fluidOutputs(FluidRegistry.getFluidStack("liquid_sunshine", 10)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_EV).metadata(GLASS, 2).addTo(bacterialVatRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.clay, 4), new ItemStack(Blocks.packed_ice, 4))
                    .special(BioCultureEnum.getPetriDish(BioCultureEnum.BinniBacteria.bioCulture))
                    .fluidInputs(FluidRegistry.getFluidStack("potion.mineralwater", 20))
                    .fluidOutputs(FluidRegistry.getFluidStack("cloud_seed", 20)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_EV).metadata(GLASS, 2).addTo(bacterialVatRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.clay, 4),
                            MaterialLibAPI.getStack(Materials2Materials.Saltpeter, Materials2Shapes.dust, (int) (4)))
                    .special(BioCultureEnum.getPetriDish(BioCultureEnum.BinniBacteria.bioCulture))
                    .fluidInputs(FluidRegistry.getFluidStack("cloud_seed", 20))
                    .fluidOutputs(FluidRegistry.getFluidStack("cloud_seed_concentrated", 20)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_EV).metadata(GLASS, 2).addTo(bacterialVatRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(EnderIO.ID, "itemMaterial", 4, 14),
                            getModItem(EnderIO.ID, "itemMaterial", 4, 16))
                    .special(BioCultureEnum.getPetriDish(BioCultureEnum.BinniBacteria.bioCulture))
                    .fluidInputs(FluidRegistry.getFluidStack("nutrient_distillation", 40))
                    .fluidOutputs(FluidRegistry.getFluidStack("ender_distillation", 40)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_EV).metadata(GLASS, 2).addTo(bacterialVatRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(EnderIO.ID, "itemMaterial", 4, 15),
                            getModItem(EnderIO.ID, "itemMaterial", 4, 17))
                    .special(BioCultureEnum.getPetriDish(BioCultureEnum.BinniBacteria.bioCulture))
                    .fluidInputs(FluidRegistry.getFluidStack("ender_distillation", 10))
                    .fluidOutputs(FluidRegistry.getFluidStack("vapor_of_levity", 10)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_EV).metadata(GLASS, 2).addTo(bacterialVatRecipes);

        }
    }

    private void bioLabRecipes() {
        GTValues.RA.stdBuilder()
                .itemInputs(BioCultureEnum.getPetriDish(null), getModItem(GalaxySpace.ID, "barnardaClog", 1))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.BarnadafisArboriatoris.bioCulture))
                .outputChances(2_50).fluidInputs(FluidRegistry.getFluidStack("unknowwater", 8000))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_UV).addTo(bioLabRecipes);

        if (!OreDictionary.getOres("cropTcetiESeaweed").isEmpty()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(BioCultureEnum.getPetriDish(null), new OreDictItemStack("cropTcetiESeaweed", 1))
                    .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.TcetieisFucusSerratus.bioCulture))
                    .outputChances(2_50).fluidInputs(FluidRegistry.getFluidStack("unknowwater", 8000))
                    .duration(25 * SECONDS).eut(TierEU.RECIPE_UV).addTo(bioLabRecipes);
        }

        GTValues.RA.stdBuilder().itemInputs(BioCultureEnum.getPetriDish(null), new ItemStack(Items.egg, 1, 0))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.OvaEvolutionis.bioCulture)).outputChances(15_00)
                .fluidInputs(FluidRegistry.getFluidStack("binnie.bacteria", 1000)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_IV).requiresCleanRoom().addTo(bioLabRecipes);

        GTValues.RA.stdBuilder().itemInputs(BioCultureEnum.getPetriDish(null), ItemList.Circuit_Chip_Stemcell.get(1L))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.DerivanturCellulaEvolutionis.bioCulture))
                .outputChances(7_50)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.GrowthMediumRaw,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1000)))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_ZPM).requiresCleanRoom().addTo(bioLabRecipes);

        GTValues.RA.stdBuilder().itemInputs(BioCultureEnum.getPetriDish(null), ItemList.Circuit_Chip_Biocell.get(1L))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.CellulaBiologicumEvolutione.bioCulture))
                .outputChances(7_50)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.BioMediumRaw,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1000)))
                .duration(3 * MINUTES).eut(TierEU.RECIPE_UV).requiresCleanRoom().addTo(bioLabRecipes);

        GTValues.RA.stdBuilder().itemInputs(BioCultureEnum.getPetriDish(null), getModItem(Genetics.ID, "misc", 1, 4))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.BinniGrowthMedium.bioCulture))
                .outputChances(50_00).fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(4000))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(bioLabRecipes);

        GTValues.RA.stdBuilder().itemInputs(BioCultureEnum.getPetriDish(null), getModItem(Genetics.ID, "misc", 1, 4))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.BinniGrowthMedium.bioCulture))
                .outputChances(75_00).fluidInputs(GTModHandler.getDistilledWater(2000L))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(bioLabRecipes);

        GTValues.RA.stdBuilder().itemInputs(BioCultureEnum.getPetriDish(null), getModItem(Genetics.ID, "misc", 1, 4))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.BinniGrowthMedium.bioCulture))
                .outputChances(90_00).fluidInputs(FluidRegistry.getFluidStack("binnie.growthmedium", 1000))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(bioLabRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        BioCultureEnum.getPetriDish(null),
                        MaterialLibAPI
                                .getStack(Materials2Materials.MysteriousCrystal, Materials2Shapes.dust, (int) (4)))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.BinniGrowthMedium.bioCulture))
                .fluidInputs(FluidRegistry.getFluidStack("binnie.growthmedium", 500)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_EV).addTo(bioLabRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(BioCultureEnum.getPetriDish(null), getModItem(IndustrialCraft2.ID, "itemBiochaff", 16, 0))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.BinniBacteria.bioCulture)).outputChances(60_00)
                .fluidInputs(FluidRegistry.getFluidStack("binnie.bacteria", 1000)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(bioLabRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        BioCultureEnum.getPetriDish(null),
                        MaterialLibAPI
                                .getStack(Materials2Materials.MysteriousCrystal, Materials2Shapes.dust, (int) (4)))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.BinniBacteria.bioCulture)).outputChances(80_00)
                .fluidInputs(FluidRegistry.getFluidStack("binnie.bacteria", 500)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_IV).requiresCleanRoom().addTo(bioLabRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        BioCultureEnum.getPetriDish(null),
                        MaterialLibAPI
                                .getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dustTiny, (int) (1)))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.BinniBacteria.bioCulture))
                .fluidInputs(FluidRegistry.getFluidStack("binnie.bacteria", 250)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LuV).requiresCleanRoom().addTo(bioLabRecipes);

        GTValues.RA.stdBuilder().itemInputs(BioCultureEnum.getPetriDish(null), NHItemList.MarsStoneDust.get(64))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.CorynebacteriumSludgeMarsensis.bioCulture))
                .outputChances(30_00).fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 1000))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(bioLabRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        BioCultureEnum.getPetriDish(null),
                        MaterialLibAPI
                                .getStack(Materials2Materials.MysteriousCrystal, Materials2Shapes.dust, (int) (16)))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.CorynebacteriumSludgeMarsensis.bioCulture))
                .outputChances(50_00).fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 500))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_IV).requiresCleanRoom().addTo(bioLabRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        BioCultureEnum.getPetriDish(null),
                        MaterialLibAPI
                                .getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dustTiny, (int) (4)))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.CorynebacteriumSludgeMarsensis.bioCulture))
                .outputChances(75_00).fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 250))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LuV).requiresCleanRoom().addTo(bioLabRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        BioCultureEnum.getPetriDish(null),
                        MaterialLibAPI
                                .getStack(Materials2Materials.MysteriousCrystal, Materials2Shapes.dust, (int) (16)))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.MutagenBacteriaASpatio.bioCulture))
                .outputChances(15_00).fluidInputs(FluidRegistry.getFluidStack("mutagen", 1000)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_LuV).requiresCleanRoom().addTo(bioLabRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        BioCultureEnum.getPetriDish(null),
                        MaterialLibAPI
                                .getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dustTiny, (int) (4)))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.MutagenBacteriaASpatio.bioCulture))
                .outputChances(30_00).fluidInputs(FluidRegistry.getFluidStack("mutagen", 500)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_ZPM).requiresCleanRoom().addTo(bioLabRecipes);
    }

    private void beamCrafterRecipes() {
        GTValues.RA.stdBuilder()
                .itemInputs(BioCultureEnum.getPetriDish(BioCultureEnum.BarnadafisArboriatoris.bioCulture))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Xenoxene,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (250L)))
                .itemOutputs(BioCultureEnum.getPetriDish(BioCultureEnum.XenoxeneXenoxsis.bioCulture))
                .metadata(
                        BEAMCRAFTER_METADATA,
                        BeamCrafterMetadata.builder().particleID_A(TAU.getId()).particleID_B(TAUNEUTRINO.getId())
                                .amount_A(300).amount_B(200).build())
                .outputChances(5000).eut(TierEU.RECIPE_UHV).duration(2 * SECONDS).addTo(beamcrafterRecipes);
    }

    private void runBWRecipes() {
        bioLabRecipes();
        bacterialVatRecipes();
        beamCrafterRecipes();

        BioItemLoader.registerRecipes();
    }
}
