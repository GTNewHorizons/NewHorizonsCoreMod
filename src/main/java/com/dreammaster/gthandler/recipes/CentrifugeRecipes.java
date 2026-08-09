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

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.CellShapes;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.material.MaterialParts;
import gregtech.api.material.MaterialUtils;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gregtech.common.items.CombType;
import gregtech.loaders.misc.GTBees;

public class CentrifugeRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdsorptionFilterDirty.get()).circuit(1)
                .itemOutputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.DarkAsh, Shapes.dust, (int) (4L)))
                .outputChances(8000, 10000, 10000)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Pollution, FluidShapes.fluidLiquid, (int) (100)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdsorptionFilterDirty.get()).circuit(2)
                .itemOutputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, (int) (8L)),
                        MaterialLibAPI.getStack(Materials.DarkAsh, Shapes.dust, (int) (8L)))
                .outputChances(9000, 10000, 10000)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Pollution, FluidShapes.fluidLiquid, (int) (250)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdsorptionFilterDirty.get()).circuit(3)
                .itemOutputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, (int) (12L)),
                        MaterialLibAPI.getStack(Materials.DarkAsh, Shapes.dust, (int) (12L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Pollution, FluidShapes.fluidLiquid, (int) (500)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdsorptionFilterDirty.get()).circuit(4)
                .itemOutputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, (int) (16L)),
                        MaterialLibAPI.getStack(Materials.DarkAsh, Shapes.dust, (int) (16L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Pollution, FluidShapes.fluidLiquid, (int) (1000)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.BandedIron, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Rutile, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Quicklime, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.SodiumOxide, Shapes.dust, (int) (1L)))
                .outputChances(10000, 10000, 9000, 7500, 5000, 2500)
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.RedMud, FluidShapes.fluidLiquid, (int) (1000L)))
                .fluidOutputs(GTUtility.getWater(500L)).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.fire_charge, 1, 0))
                .itemOutputs(
                        new ItemStack(Items.blaze_powder, 1, 0),
                        new ItemStack(Items.gunpowder, 1, 0),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (1L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoonStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Olivine, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.RareEarth, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Platinum, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Tungstate, Shapes.dust, (int) (4L)))
                .outputChances(5000, 2000, 1000, 750, 500, 250).duration(2 * MINUTES + 42 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MarsStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.BandedIron, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Magnesium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Ruby, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 500, 250).duration(2 * MINUTES + 1 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.PhobosStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.BandedIron, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Bauxite, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Molybdenite, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Desh, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Plutonium, Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 1000, 750, 500, 150).duration(2 * MINUTES + 1 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.DeimosStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Magnesite, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Lapis, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Pitchblende, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Cooperite, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Neodymium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Tungstate, Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 650, 350)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(Materials.SulfuricAcid, FluidShapes.fluidLiquid, (int) (1800L)))
                .duration(2 * MINUTES + 1 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AsteroidsStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Lead, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Ruby, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 500, 150).duration(5 * MINUTES + 24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CeresStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.MeteoricIron, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Beryllium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Platinum, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 1000, 750, 500, 150).duration(5 * MINUTES + 24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EuropaIceDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Ledox, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Lapis, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Lazurite, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Oriharukon, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Barium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 1250, 750, 500, 150)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1800L)))
                .duration(5 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EuropaStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Ledox, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Sodalite, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Barium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 500, 300)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Nitrogen, FluidShapes.fluidGas, (int) (3600L)))
                .duration(5 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.GanymedeStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Chromite, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Galena, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Palladium, Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 600, 250).duration(5 * MINUTES + 24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CallistoStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.CallistoIce, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Galena, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Topaz, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.BlueTopaz, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Lithium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 900, 750, 250).duration(5 * MINUTES + 24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.IoStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Sulfur, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Tantalite, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Jasper, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.InfusedGold, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 500, 250)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.SulfuricGas, FluidShapes.fluidGas, (int) (3600L)))
                .duration(3 * MINUTES + 36 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.VenusStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Quantium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Mytryl, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Amethyst, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Mithril, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, (int) (4L)))
                .outputChances(10000, 3000, 1000, 750, 500, 250)
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(Materials.CarbonDioxide, FluidShapes.fluidGas, (int) (18000L)))
                .duration(3 * MINUTES + 36 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MercuryStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Vanadium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Tungstate, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Jade, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 500, 250)
                .fluidOutputs(MaterialUtils.gas(Materials.Helium3, 1800L)).duration(3 * MINUTES + 36 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MercuryCoreDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Ilmenite, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Tungstate, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Jade, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 500, 250)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Helium, FluidShapes.fluidGas, (int) (9000L)))
                .duration(3 * MINUTES + 36 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EnceladusIceDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Ledox, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Trinium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 400, 200)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (5400L)))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EnceladusStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Trinium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 1000, 400, 100)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Nitrogen, FluidShapes.fluidGas, (int) (5400L)))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.TitanStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Nickel, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Emerald, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Gallium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Trinium, Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 1000, 900, 500, 200)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Methane, FluidShapes.fluidGas, (int) (3600L)))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.OberonStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Uranium235, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Plutonium241, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Trinium, Shapes.dust, (int) (4L)))
                .outputChances(4000, 2000, 800, 300, 150, 150)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Argon, FluidShapes.fluidGas, (int) (1800L)))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MirandaStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Tetrahedrite, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Desh, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, (int) (4L)))
                .outputChances(4000, 2000, 1000, 750, 500, 350)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Argon, FluidShapes.fluidGas, (int) (1800L)))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.TritonStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Neodymium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.RareEarth, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Niobium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Yttrium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Gallium, Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 750, 500, 350).duration(5 * MINUTES + 2 * SECONDS + 8 * TICKS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ProteusStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Uraninite, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Adamantium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Plutonium, Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 1000, 750, 500, 350)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Radon, FluidShapes.fluidGas, (int) (360L)))
                .duration(5 * MINUTES + 2 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.PlutoIceDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Thorium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Plutonium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Ledox, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 1250, 750, 500, 400).duration(10 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.PlutoStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Thorium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.GarnetRed, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.GarnetYellow, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 850, 500, 500, 300).duration(10 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MakeMakeStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.GarnetRed, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.GarnetYellow, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Gallium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Yttrium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Niobium, Shapes.dust, (int) (4L)))
                .outputChances(2500, 2500, 1000, 750, 500, 350).duration(10 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.HaumeaStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.InfusedGold, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.NetherStar, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Lanthanum, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Caesium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Cerium, Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 850, 750, 500, 450).duration(10 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CentauriASurfaceDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.NaquadahEnriched, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (4L)),
                        getModItem(Avaritia.ID, "Resource", 36, 2),
                        MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1000, 1000, 100, 50)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Mercury, FluidShapes.fluidLiquid, (int) (3600L)))
                .duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS).eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CentauriAStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.NaquadahEnriched, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.dust, (int) (4L)),
                        getModItem(Avaritia.ID, "Resource", 36, 2),
                        MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.dust, (int) (4L)))
                .outputChances(5000, 2000, 500, 2500, 150, 80)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Mercury, FluidShapes.fluidLiquid, (int) (7200L)))
                .duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS).eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.VegaBStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Uranium235, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Plutonium241, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Europium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Naquadria, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.dust, (int) (4L)))
                .outputChances(5000, 3000, 1500, 800, 500, 50).duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS)
                .eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.BarnardaEStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Niobium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Yttrium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Gallium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Unstable, Shapes.dust, (int) (4L)))
                .outputChances(2500, 2000, 1500, 750, 250, 250).duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS)
                .eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.BarnardaFStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Gallium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Yttrium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Niobium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Unstable, Shapes.dust, (int) (4L)))
                .outputChances(2500, 2000, 1500, 750, 250, 250).duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS)
                .eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.TCetiEStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Lapis, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Apatite, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Trinium, Shapes.dust, (int) (4L)))
                .outputChances(5000, 2500, 1000, 750, 150, 50).duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS)
                .eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CokeOvenBrickDust.get(4))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Clay, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dust, (int) (2L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdvancedCokeOvenBrickDust.get(36)).circuit(2)
                .itemOutputs(
                        NHItemList.CokeOvenBrickDust.get(36),
                        MaterialLibAPI.getStack(Materials.Netherrack, Shapes.dust, (int) (36L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Brick, Shapes.dust, (int) (4L)))
                .outputChances(10000, 9000, 7500, 6500).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopGrass", 1, 0))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials.Clay, Shapes.dustSmall, (int) (1L)))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 0))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials.Clay, Shapes.dustSmall, (int) (1L)))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 1))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials.Clay, Shapes.dustSmall, (int) (1L)))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 2))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials.Flint, Shapes.dustSmall, (int) (1L)))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 3))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials.Flint, Shapes.dustSmall, (int) (1L)))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopGrass", 1, 2))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dustSmall, (int) (1L)))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 4))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dustSmall, (int) (1L)))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 5))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dustSmall, (int) (1L)))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "driedDirt", 1, 0))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Clay, Shapes.dustSmall, (int) (1L)),
                        new ItemStack(Blocks.sand, 1, 0),
                        MaterialLibAPI.getStack(Materials.Ash, Shapes.dust, (int) (1L)))
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

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dust, (int) (9L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Stone, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Quartzite, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Cassiterite, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (1L)))
                .outputChances(9000, 3000, 2000, 1500, 1000, 750).duration(1 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                GTOreDictUnificator.get(MaterialParts.craftIngredient(OrePrefixes.dust, Materials.DeepIron), 4L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Trinium, Shapes.dust, (int) (1L)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.dust, (int) (1L)))
                .itemOutputs(
                        getModItem(Avaritia.ID, "Resource", 1, 2),
                        getModItem(Avaritia.ID, "Resource", 1, 2),
                        getModItem(Avaritia.ID, "Resource", 1, 2))
                .outputChances(5000, 2000, 1000).duration(60 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MaceratedPlantmass.get())
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemBiochaff", 1, 0)).duration(15 * SECONDS).eut(4)
                .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Electrotine, Shapes.dust, (int) (8L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Redstone, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Electrum, Shapes.dust, (int) (1L)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Cell_Air.get(10L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Oxygen, CellShapes.cell, (int) (1)),
                        ItemList.Cell_Empty.get(9L))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Nitrogen, FluidShapes.fluidGas, (int) (3900L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(centrifugeRecipes);

        if (PamsHarvestCraft.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "coconutItem", 1, 0))
                    .itemOutputs(getModItem(PamsHarvestCraft.ID, "coconutmilkItem", 9, 0)).duration(5 * SECONDS).eut(2)
                    .addTo(centrifugeRecipes);

        }

        if (TinkerConstruct.isModLoaded()) {
            // Centrifuge

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "strangeFood", 1, 0))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.RawRubber, Shapes.dust, (int) (2L)))
                    .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (50)))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.slime_ball, 1, 0))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.RawRubber, Shapes.dust, (int) (2L)))
                    .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (50)))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "slime.gel", 1, 2))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Rubber, Shapes.dust, (int) (8L)))
                    .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (200)))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "slime.gel", 1, 1))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.RawRubber, Shapes.dust, (int) (8L)))
                    .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (200)))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "slime.gel", 1, 0))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.RawRubber, Shapes.dust, (int) (8L)))
                    .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (200)))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 0))
                    .itemOutputs(
                            new ItemStack(Blocks.dirt, 1, 32767),
                            MaterialLibAPI.getStack(Materials.RawRubber, Shapes.dust, (int) (1L)),
                            getModItem(TinkerConstruct.ID, "strangeFood", 1, 0))
                    .outputChances(10000, 10000, 1000)
                    .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (25)))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

        }

        if (Gendustry.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(NHItemList.FieryBloodDrop.get())
                    .fluidOutputs(
                            MaterialLibAPI.getFluidStack(Materials.FierySteel, FluidShapes.fluidLiquid, (int) (10L)))
                    .duration(12 * TICKS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);
        }
        if (Forestry.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(Forestry.ID, "beeCombs", 1, 9))
                    .itemOutputs(
                            getModItem(Forestry.ID, "beeswax", 1, 0),
                            MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (1L)))
                    .outputChances(10000, 11).duration(15 * SECONDS).eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);
            GTValues.RA.stdBuilder().itemInputs(GTBees.combs.getStackForType(CombType.INDIUM, 8)).circuit(2)
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials.ThoriumBasedLiquidFuelDepleted,
                                    FluidShapes.fluidLiquid,
                                    (int) (1000)))
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials.Thorium232, Shapes.dust, (int) (64)),
                            MaterialLibAPI.getStack(Materials.Thorium232, Shapes.dust, (int) (16)),
                            MaterialLibAPI.getStack(Materials.Praseodymium, Shapes.dust, (int) (64)),
                            MaterialLibAPI.getStack(Materials.Praseodymium, Shapes.dust, (int) (32)),
                            MaterialLibAPI.getStack(Materials.Boron, Shapes.dust, (int) (2)),
                            MaterialLibAPI.getStack(Materials.Indium, Shapes.dust, (int) (12)))
                    .outputChances(10000, 8000, 10000, 8000, 3000, 5000).duration(1 * MINUTES + 15 * SECONDS)
                    .eut(TierEU.RECIPE_EV / 2).addTo(centrifugeRecipes);
        }
    }
}
