package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.Gendustry;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import bartworks.system.material.WerkstoffLoader;
import goodgenerator.items.GGMaterial;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2CellShapes;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.common.items.CombType;
import gregtech.loaders.misc.GTBees;

public class CentrifugeRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdsorptionFilterDirty.get()).circuit(1)
                .itemOutputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        MaterialLibAPI.getStack(Materials2Materials.Carbon, Materials2Shapes.dust, (int) (4L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.AshDark, 4L))
                .outputChances(8000, 10000, 10000)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Pollution,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (100)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdsorptionFilterDirty.get()).circuit(2)
                .itemOutputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        MaterialLibAPI.getStack(Materials2Materials.Carbon, Materials2Shapes.dust, (int) (8L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.AshDark, 8L))
                .outputChances(9000, 10000, 10000)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Pollution,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (250)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdsorptionFilterDirty.get()).circuit(3)
                .itemOutputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        MaterialLibAPI.getStack(Materials2Materials.Carbon, Materials2Shapes.dust, (int) (12L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.AshDark, 12L))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Pollution,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (500)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdsorptionFilterDirty.get()).circuit(4)
                .itemOutputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        MaterialLibAPI.getStack(Materials2Materials.Carbon, Materials2Shapes.dust, (int) (16L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.AshDark, 16L))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Pollution,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1000)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.BandedIron, Materials2Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.dust, (int) (3L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 2L),
                        MaterialLibAPI.getStack(Materials2Materials.Rutile, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Quicklime, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.SodiumOxide, Materials2Shapes.dust, (int) (1L)))
                .outputChances(10000, 10000, 9000, 7500, 5000, 2500)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.RedMud,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1000L)))
                .fluidOutputs(Materials.Water.getFluid(500L)).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.fire_charge, 1, 0))
                .itemOutputs(
                        new ItemStack(Items.blaze_powder, 1, 0),
                        new ItemStack(Items.gunpowder, 1, 0),
                        MaterialLibAPI.getStack(Materials2Materials.Coal, Materials2Shapes.dust, (int) (1L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoonStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Manganese, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Olivine, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.RareEarth, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Platinum, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Tungstate, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 2000, 1000, 750, 500, 250).duration(2 * MINUTES + 42 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MarsStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.BandedIron, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Magnesium, Materials2Shapes.dust, (int) (9L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 9L),
                        MaterialLibAPI.getStack(Materials2Materials.Ruby, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Diamond, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Iridium, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 500, 250).duration(2 * MINUTES + 1 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.PhobosStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.BandedIron, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Bauxite, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Molybdenite, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Desh, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Uranium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Plutonium, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 1000, 750, 500, 150).duration(2 * MINUTES + 1 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.DeimosStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Magnesite, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Lapis, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Pitchblende, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Cooperite, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Neodymium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Tungstate, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 650, 350)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SulfuricAcid,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1800L)))
                .duration(2 * MINUTES + 1 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AsteroidsStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Gold, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Lead, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Titanium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Ruby, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Chrome, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Osmium, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 500, 150).duration(5 * MINUTES + 24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CeresStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.MeteoricIron, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Beryllium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Platinum, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Titanium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Tungsten, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Naquadah, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 1000, 750, 500, 150).duration(5 * MINUTES + 24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EuropaIceDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ledox, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Lapis, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Lazurite, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Oriharukon, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Barium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Naquadah, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 1250, 750, 500, 150)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1800L)))
                .duration(5 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EuropaStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Ledox, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Sodalite, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Barium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Uranium, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 500, 300)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Nitrogen,
                                Materials2FluidShapes.fluidGas,
                                (int) (3600L)))
                .duration(5 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.GanymedeStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Titanium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Chromite, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Galena, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Diamond, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Uranium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Palladium, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 600, 250).duration(5 * MINUTES + 24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CallistoStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.CallistoIce, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Galena, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Topaz, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.BlueTopaz, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Lithium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Tungsten, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 900, 750, 250).duration(5 * MINUTES + 24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.IoStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Sulfur, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Tantalite, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Tungsten, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Jasper, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.InfusedGold, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Iridium, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 500, 250)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SulfuricGas,
                                Materials2FluidShapes.fluidGas,
                                (int) (3600L)))
                .duration(3 * MINUTES + 36 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.VenusStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Carbon, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Quantium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Mytryl, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Amethyst, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Mithril, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Draconium, Materials2Shapes.dust, (int) (4L)))
                .outputChances(10000, 3000, 1000, 750, 500, 250)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.CarbonDioxide,
                                Materials2FluidShapes.fluidGas,
                                (int) (18000L)))
                .duration(3 * MINUTES + 36 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MercuryStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Vanadium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Tungstate, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Draconium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Titanium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Jade, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Diamond, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 500, 250).fluidOutputs(Materials.Helium3.getGas(1800L))
                .duration(3 * MINUTES + 36 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MercuryCoreDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ilmenite, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Tungstate, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Draconium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Titanium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Jade, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Diamond, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 500, 250)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Helium,
                                Materials2FluidShapes.fluidGas,
                                (int) (9000L)))
                .duration(3 * MINUTES + 36 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EnceladusIceDust.get(36))
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.MysteriousCrystal, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Chrome, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Iridium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Ledox, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Trinium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Naquadah, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 400, 200)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (5400L)))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EnceladusStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Chrome, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Iridium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Osmium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.MysteriousCrystal, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Trinium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Naquadah, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 1000, 400, 100)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Nitrogen,
                                Materials2FluidShapes.fluidGas,
                                (int) (5400L)))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.TitanStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Nickel, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Iridium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Osmium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Emerald, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Gallium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Trinium, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 1000, 900, 500, 200)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Methane,
                                Materials2FluidShapes.fluidGas,
                                (int) (3600L)))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.OberonStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Iridium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Osmium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Naquadah, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Uranium235, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Plutonium241, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Trinium, Materials2Shapes.dust, (int) (4L)))
                .outputChances(4000, 2000, 800, 300, 150, 150)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Argon,
                                Materials2FluidShapes.fluidGas,
                                (int) (1800L)))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MirandaStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tin, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Tetrahedrite, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Iridium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Desh, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Chrome, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Osmium, Materials2Shapes.dust, (int) (4L)))
                .outputChances(4000, 2000, 1000, 750, 500, 350)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Argon,
                                Materials2FluidShapes.fluidGas,
                                (int) (1800L)))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.TritonStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Gold, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Neodymium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.RareEarth, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Niobium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Yttrium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Gallium, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 500, 350).duration(5 * MINUTES + 2 * SECONDS + 8 * TICKS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ProteusStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Uraninite, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Adamantium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Diamond, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Uranium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Plutonium, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 1000, 750, 500, 350)
                .fluidOutputs(
                        MaterialLibAPI
                                .getFluidStack(Materials2Materials.Radon, Materials2FluidShapes.fluidGas, (int) (360L)))
                .duration(5 * MINUTES + 2 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.PlutoIceDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Thorium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Uranium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Plutonium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.BlackPlutonium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Ledox, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Naquadah, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 1250, 750, 500, 400).duration(10 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.PlutoStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Thorium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Uranium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.BlackPlutonium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.GarnetRed, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.GarnetYellow, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Naquadah, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 850, 500, 500, 300).duration(10 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MakeMakeStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.GarnetRed, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.GarnetYellow, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.BlackPlutonium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Gallium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Yttrium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Niobium, Materials2Shapes.dust, (int) (4L)))
                .outputChances(2500, 2500, 1000, 750, 500, 350).duration(10 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.HaumeaStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.InfusedGold, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Naquadah, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.NetherStar, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Lanthanum, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Caesium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Cerium, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 850, 750, 500, 450).duration(10 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CentauriASurfaceDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Iridium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.NaquadahEnriched, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Draconium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Iridium, Materials2Shapes.dust, (int) (4L)),
                        getModItem(Avaritia.ID, "Resource", 36, 2),
                        MaterialLibAPI
                                .getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 1000, 100, 50)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Mercury,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (3600L)))
                .duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS).eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CentauriAStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Osmium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.NaquadahEnriched, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.BlackPlutonium, Materials2Shapes.dust, (int) (4L)),
                        getModItem(Avaritia.ID, "Resource", 36, 2),
                        MaterialLibAPI
                                .getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 2000, 500, 2500, 150, 80)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Mercury,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (7200L)))
                .duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS).eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.VegaBStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Uranium235, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Plutonium241, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Europium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Naquadria, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.DraconiumAwakened, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1500, 800, 500, 50).duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS)
                .eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.BarnardaEStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Niobium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Yttrium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Gallium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Bedrockium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Unstable, Materials2Shapes.dust, (int) (4L)))
                .outputChances(2500, 2000, 1500, 750, 250, 250).duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS)
                .eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.BarnardaFStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Gallium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Yttrium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Niobium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Bedrockium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Unstable, Materials2Shapes.dust, (int) (4L)))
                .outputChances(2500, 2000, 1500, 750, 250, 250).duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS)
                .eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.TCetiEStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Lapis, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Apatite, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Bedrockium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Draconium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Trinium, Materials2Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 1000, 750, 150, 50).duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS)
                .eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CokeOvenBrickDust.get(4))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Clay, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.QuartzSand, Materials2Shapes.dust, (int) (2L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdvancedCokeOvenBrickDust.get(36)).circuit(2)
                .itemOutputs(
                        NHItemList.CokeOvenBrickDust.get(36),
                        MaterialLibAPI.getStack(Materials2Materials.Netherrack, Materials2Shapes.dust, (int) (36L)),
                        MaterialLibAPI.getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Brick, Materials2Shapes.dust, (int) (4L)))
                .outputChances(10000, 9000, 7500, 6500).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopGrass", 1, 0))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials2Materials.Clay, Materials2Shapes.dustSmall, (int) (1L)))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 0))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials2Materials.Clay, Materials2Shapes.dustSmall, (int) (1L)))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 1))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials2Materials.Clay, Materials2Shapes.dustSmall, (int) (1L)))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 2))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials2Materials.Flint, Materials2Shapes.dustSmall, (int) (1L)))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 3))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials2Materials.Flint, Materials2Shapes.dustSmall, (int) (1L)))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopGrass", 1, 2))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials2Materials.QuartzSand, Materials2Shapes.dustSmall, (int) (1L)))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 4))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials2Materials.QuartzSand, Materials2Shapes.dustSmall, (int) (1L)))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 5))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials2Materials.QuartzSand, Materials2Shapes.dustSmall, (int) (1L)))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "driedDirt", 1, 0))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Clay, Materials2Shapes.dustSmall, (int) (1L)),
                        new ItemStack(Blocks.sand, 1, 0),
                        MaterialLibAPI.getStack(Materials2Materials.Ash, Materials2Shapes.dust, (int) (1L)))
                .outputChances(9000, 5000, 277).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockEldritch", 1, 4))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 1, 0),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14))
                .outputChances(10000, 3300, 1000, 200).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1, 0))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 2, 0),
                        NHItemList.CeresStoneDust.get(),
                        NHItemList.CeresStoneDust.get())
                .outputChances(10000, 9000, 7500).duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1, 4))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 2, 0),
                        NHItemList.PlutoStoneDust.get(),
                        NHItemList.PlutoStoneDust.get())
                .outputChances(10000, 9000, 7500).duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1, 1))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 2, 0),
                        NHItemList.IoStoneDust.get(),
                        NHItemList.IoStoneDust.get())
                .outputChances(10000, 9000, 7500).duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1, 2))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 2, 0),
                        NHItemList.EnceladusStoneDust.get(),
                        NHItemList.EnceladusStoneDust.get())
                .outputChances(10000, 9000, 7500).duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1, 3))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 2, 0),
                        NHItemList.ProteusStoneDust.get(),
                        NHItemList.ProteusStoneDust.get())
                .outputChances(10000, 9000, 7500).duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.QuartzSand, Materials2Shapes.dust, (int) (9L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Stone, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.CertusQuartz, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Quartzite, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Cassiterite, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.dust, (int) (1L)))
                .outputChances(9000, 3000, 2000, 1500, 1000, 750).duration(1 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust.get(Materials.DeepIron), 4L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials2Materials.Trinium, Materials2Shapes.dust, (int) (1L)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.BlackPlutonium, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(
                        getModItem(Avaritia.ID, "Resource", 1, 2),
                        getModItem(Avaritia.ID, "Resource", 1, 2),
                        getModItem(Avaritia.ID, "Resource", 1, 2))
                .outputChances(5000, 2000, 1000).duration(60 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MaceratedPlantmass.get())
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemBiochaff", 1, 0)).duration(15 * SECONDS).eut(4)
                .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Electrotine, Materials2Shapes.dust, (int) (8L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Redstone, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Electrum, Materials2Shapes.dust, (int) (1L)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Cell_Air.get(5L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Oxygen, Materials2CellShapes.cell, (int) (1)),
                        ItemList.Cell_Empty.get(4L))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Nitrogen,
                                Materials2FluidShapes.fluidGas,
                                (int) (3900L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(centrifugeRecipes);

        if (PamsHarvestCraft.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "coconutItem", 1, 0))
                    .itemOutputs(getModItem(PamsHarvestCraft.ID, "coconutmilkItem", 9, 0)).duration(5 * SECONDS).eut(2)
                    .addTo(centrifugeRecipes);

        }

        if (TinkerConstruct.isModLoaded()) {
            // Centrifuge

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "strangeFood", 1, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.RubberRaw, 2L))
                    .fluidOutputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Glue,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (50)))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.slime_ball, 1, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.RubberRaw, 2L))
                    .fluidOutputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Glue,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (50)))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "slime.gel", 1, 2))
                    .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Rubber, Materials2Shapes.dust, (int) (8L)))
                    .fluidOutputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Glue,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (200)))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "slime.gel", 1, 1))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.RubberRaw, 8L))
                    .fluidOutputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Glue,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (200)))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "slime.gel", 1, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.RubberRaw, 8L))
                    .fluidOutputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Glue,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (200)))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 0))
                    .itemOutputs(
                            new ItemStack(Blocks.dirt, 1, 32767),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.RubberRaw, 1L),
                            getModItem(TinkerConstruct.ID, "strangeFood", 1, 0))
                    .outputChances(10000, 10000, 1000)
                    .fluidOutputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Glue,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (25)))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

        }

        if (Gendustry.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(NHItemList.FieryBloodDrop.get())
                    .fluidOutputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.FierySteel,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (10L)))
                    .duration(12 * TICKS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);
        }
        if (Forestry.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(Forestry.ID, "beeCombs", 1, 9))
                    .itemOutputs(
                            getModItem(Forestry.ID, "beeswax", 1, 0),
                            MaterialLibAPI.getStack(Materials2Materials.Iridium, Materials2Shapes.dust, (int) (1L)))
                    .outputChances(10000, 11).duration(15 * SECONDS).eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);
            GTValues.RA.stdBuilder().itemInputs(GTBees.combs.getStackForType(CombType.INDIUM, 8)).circuit(2)
                    .fluidInputs(GGMaterial.thoriumBasedLiquidFuelDepleted.getFluidOrGas(1000))
                    .itemOutputs(
                            WerkstoffLoader.Thorium232.get(OrePrefixes.dust, 64),
                            WerkstoffLoader.Thorium232.get(OrePrefixes.dust, 16),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Praseodymium, Materials2Shapes.dust, (int) (64)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Praseodymium, Materials2Shapes.dust, (int) (32)),
                            MaterialLibAPI.getStack(Materials2Materials.Boron, Materials2Shapes.dust, (int) (2)),
                            MaterialLibAPI.getStack(Materials2Materials.Indium, Materials2Shapes.dust, (int) (12)))
                    .outputChances(10000, 8000, 10000, 8000, 3000, 5000).duration(1 * MINUTES + 15 * SECONDS)
                    .eut(TierEU.RECIPE_EV / 2).addTo(centrifugeRecipes);
        }
    }
}
