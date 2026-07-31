package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.recipe.RecipeMaps.vacuumFreezerRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;

public class VacuumFreezerRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder().itemInputs(NHItemList.GlowingMarshmallow.get())
                .itemOutputs(NHItemList.Marshmallow.get()).duration(40 * MINUTES).eut(TierEU.RECIPE_EV)
                .addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Bedrockium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Bedrockium, Materials2Shapes.ingot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.ingot, (int) (1L)))
                .duration(55 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.StellarAlloy, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.StellarAlloy, Materials2Shapes.ingot, (int) (1L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tritanium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Tritanium, Materials2Shapes.ingot, (int) (1L)))
                .duration(48 * SECONDS + 9 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Oriharukon, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Oriharukon, Materials2Shapes.ingot, (int) (1L)))
                .duration(30 * SECONDS + 3 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.MelodicAlloy, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.MelodicAlloy, Materials2Shapes.ingot, (int) (1L)))
                .duration(36 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_IV / 2).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI
                        .getStack(Materials2Materials.CrystallinePinkSlime, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.CrystallinePinkSlime, Materials2Shapes.ingot, (int) (1L)))
                .duration(29 * SECONDS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Iridium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Iridium, Materials2Shapes.ingot, (int) (1L)))
                .duration(28 * SECONDS + 16 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.ingot, (int) (1L)))
                .duration(28 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.CrystallineAlloy, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.CrystallineAlloy, Materials2Shapes.ingot, (int) (1L)))
                .duration(28 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Osmium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Osmium, Materials2Shapes.ingot, (int) (1L)))
                .duration(28 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tungsten, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Tungsten, Materials2Shapes.ingot, (int) (1L)))
                .duration(27 * SECONDS + 9 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tantalum, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Tantalum, Materials2Shapes.ingot, (int) (1L)))
                .duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.EnderiumBase, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnderiumBase, Materials2Shapes.ingot, (int) (1L)))
                .duration(20 * SECONDS + 2 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.HSSS, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.HSSS, Materials2Shapes.ingot, (int) (1L)))
                .duration(19 * SECONDS + 7 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Enderium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Enderium, Materials2Shapes.ingot, (int) (1L)))
                .duration(18 * SECONDS + 18 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.TungstenSteel, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.TungstenSteel, Materials2Shapes.ingot, (int) (1L)))
                .duration(17 * SECONDS + 17 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.TPVAlloy, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.TPVAlloy, Materials2Shapes.ingot, (int) (1L)))
                .duration(16 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.VibrantAlloy, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.VibrantAlloy, Materials2Shapes.ingot, (int) (1L)))
                .duration(16 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.VividAlloy, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.VividAlloy, Materials2Shapes.ingot, (int) (1L)))
                .duration(16 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Palladium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Palladium, Materials2Shapes.ingot, (int) (1L)))
                .duration(15 * SECONDS + 18 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Draconium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Draconium, Materials2Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.HSSG, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.HSSG, Materials2Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Quantium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Quantium, Materials2Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.NaquadahAlloy, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.NaquadahAlloy, Materials2Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Naquadria, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Naquadria, Materials2Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.NaquadahEnriched, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.NaquadahEnriched, Materials2Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        if (Avaritia.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(
                    MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.ingotHot, (int) (1L)))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 1, 6)).duration(14 * SECONDS + 14 * TICKS)
                    .eut(TierEU.RECIPE_UHV).addTo(vacuumFreezerRecipes);

        }

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_UV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Adamantium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Adamantium, Materials2Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.DeepIron, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.DeepIron, Materials2Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.BlackPlutonium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.BlackPlutonium, Materials2Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.DraconiumAwakened, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.DraconiumAwakened, Materials2Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_LuV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.MysteriousCrystal, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.MysteriousCrystal, Materials2Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.ElectrumFlux, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.ElectrumFlux, Materials2Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Trinium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Trinium, Materials2Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.TungstenCarbide, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.TungstenCarbide, Materials2Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 11 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.HSSE, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.HSSE, Materials2Shapes.ingot, (int) (1L)))
                .duration(12 * SECONDS + 3 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.NiobiumTitanium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.NiobiumTitanium, Materials2Shapes.ingot, (int) (1L)))
                .duration(10 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Nichrome, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Nichrome, Materials2Shapes.ingot, (int) (1L)))
                .duration(8 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.VanadiumGallium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.VanadiumGallium, Materials2Shapes.ingot, (int) (1L)))
                .duration(8 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI
                        .getStack(Materials2Materials.YttriumBariumCuprate, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.YttriumBariumCuprate, Materials2Shapes.ingot, (int) (1L)))
                .duration(7 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Desh, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Desh, Materials2Shapes.ingot, (int) (1L)))
                .duration(7 * SECONDS + 7 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Titanium, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Titanium, Materials2Shapes.ingot, (int) (1L)))
                .duration(7 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.HotNetherrackBrick.get())
                .itemOutputs(NHItemList.InfernalBrick.get()).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(vacuumFreezerRecipes);

    }
}
