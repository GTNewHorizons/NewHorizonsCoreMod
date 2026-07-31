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
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;

public class VacuumFreezerRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder().itemInputs(NHItemList.GlowingMarshmallow.get())
                .itemOutputs(NHItemList.Marshmallow.get()).duration(40 * MINUTES).eut(TierEU.RECIPE_EV)
                .addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Neutronium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Neutronium, Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.ingot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.CosmicNeutronium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.CosmicNeutronium, Shapes.ingot, (int) (1L)))
                .duration(55 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.StellarAlloy, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.StellarAlloy, Shapes.ingot, (int) (1L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Tritanium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Tritanium, Shapes.ingot, (int) (1L)))
                .duration(48 * SECONDS + 9 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Oriharukon, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Oriharukon, Shapes.ingot, (int) (1L)))
                .duration(30 * SECONDS + 3 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.MelodicAlloy, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.MelodicAlloy, Shapes.ingot, (int) (1L)))
                .duration(36 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_IV / 2).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.CrystallinePinkSlime, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.CrystallinePinkSlime, Shapes.ingot, (int) (1L)))
                .duration(29 * SECONDS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Iridium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Iridium, Shapes.ingot, (int) (1L)))
                .duration(28 * SECONDS + 16 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Osmiridium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Osmiridium, Shapes.ingot, (int) (1L)))
                .duration(28 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.CrystallineAlloy, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.CrystallineAlloy, Shapes.ingot, (int) (1L)))
                .duration(28 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Osmium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Osmium, Shapes.ingot, (int) (1L)))
                .duration(28 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Tungsten, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Tungsten, Shapes.ingot, (int) (1L)))
                .duration(27 * SECONDS + 9 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Tantalum, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Tantalum, Shapes.ingot, (int) (1L)))
                .duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.EnderiumBase, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.EnderiumBase, Shapes.ingot, (int) (1L)))
                .duration(20 * SECONDS + 2 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.HSSS, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.HSSS, Shapes.ingot, (int) (1L)))
                .duration(19 * SECONDS + 7 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Enderium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Enderium, Shapes.ingot, (int) (1L)))
                .duration(18 * SECONDS + 18 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.ingot, (int) (1L)))
                .duration(17 * SECONDS + 17 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.TPVAlloy, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.TPVAlloy, Shapes.ingot, (int) (1L)))
                .duration(16 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.ingot, (int) (1L)))
                .duration(16 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VividAlloy, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.VividAlloy, Shapes.ingot, (int) (1L)))
                .duration(16 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Palladium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Palladium, Shapes.ingot, (int) (1L)))
                .duration(15 * SECONDS + 18 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Draconium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Draconium, Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.HSSG, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.HSSG, Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Quantium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Quantium, Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Naquadria, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Naquadria, Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.NaquadahEnriched, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.NaquadahEnriched, Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        if (Avaritia.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(MaterialLibAPI.getStack(Materials.Infinity, Shapes.ingotHot, (int) (1L)))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 1, 6)).duration(14 * SECONDS + 14 * TICKS)
                    .eut(TierEU.RECIPE_UHV).addTo(vacuumFreezerRecipes);

        }

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_UV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Adamantium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Adamantium, Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.DeepIron, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.DeepIron, Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_LuV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.ElectrumFlux, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.ElectrumFlux, Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Trinium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Trinium, Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.TungstenCarbide, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.TungstenCarbide, Shapes.ingot, (int) (1L)))
                .duration(14 * SECONDS + 11 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.HSSE, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.HSSE, Shapes.ingot, (int) (1L)))
                .duration(12 * SECONDS + 3 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.NiobiumTitanium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.NiobiumTitanium, Shapes.ingot, (int) (1L)))
                .duration(10 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Nichrome, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Nichrome, Shapes.ingot, (int) (1L)))
                .duration(8 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.VanadiumGallium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.VanadiumGallium, Shapes.ingot, (int) (1L)))
                .duration(8 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.YttriumBariumCuprate, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.YttriumBariumCuprate, Shapes.ingot, (int) (1L)))
                .duration(7 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Desh, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Desh, Shapes.ingot, (int) (1L)))
                .duration(7 * SECONDS + 7 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Titanium, Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Titanium, Shapes.ingot, (int) (1L)))
                .duration(7 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.HotNetherrackBrick.get())
                .itemOutputs(NHItemList.InfernalBrick.get()).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(vacuumFreezerRecipes);

    }
}
