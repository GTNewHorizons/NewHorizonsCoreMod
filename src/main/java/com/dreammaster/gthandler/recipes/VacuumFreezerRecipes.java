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

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Neutronium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Neutronium, Shapes.ingot, 1))
                .duration(1 * MINUTES + 2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.ingot, 1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.CosmicNeutronium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.CosmicNeutronium, Shapes.ingot, 1))
                .duration(55 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.StellarAlloy, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.StellarAlloy, Shapes.ingot, 1)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Tritanium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Tritanium, Shapes.ingot, 1))
                .duration(48 * SECONDS + 9 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Oriharukon, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Oriharukon, Shapes.ingot, 1))
                .duration(30 * SECONDS + 3 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.MelodicAlloy, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.MelodicAlloy, Shapes.ingot, 1))
                .duration(36 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_IV / 2).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.CrystallinePinkSlime, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.CrystallinePinkSlime, Shapes.ingot, 1))
                .duration(29 * SECONDS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Iridium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Iridium, Shapes.ingot, 1))
                .duration(28 * SECONDS + 16 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Osmiridium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Osmiridium, Shapes.ingot, 1))
                .duration(28 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.CrystallineAlloy, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.CrystallineAlloy, Shapes.ingot, 1))
                .duration(28 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Osmium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Osmium, Shapes.ingot, 1))
                .duration(28 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Tungsten, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Tungsten, Shapes.ingot, 1))
                .duration(27 * SECONDS + 9 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Tantalum, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Tantalum, Shapes.ingot, 1))
                .duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.EnderiumBase, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.EnderiumBase, Shapes.ingot, 1))
                .duration(20 * SECONDS + 2 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.HSSS, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.HSSS, Shapes.ingot, 1))
                .duration(19 * SECONDS + 7 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Enderium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Enderium, Shapes.ingot, 1))
                .duration(18 * SECONDS + 18 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.ingot, 1))
                .duration(17 * SECONDS + 17 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.TPVAlloy, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.TPVAlloy, Shapes.ingot, 1))
                .duration(16 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.ingot, 1))
                .duration(16 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VividAlloy, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.VividAlloy, Shapes.ingot, 1))
                .duration(16 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Palladium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Palladium, Shapes.ingot, 1))
                .duration(15 * SECONDS + 18 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Draconium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Draconium, Shapes.ingot, 1))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.HSSG, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.HSSG, Shapes.ingot, 1))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Quantium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Quantium, Shapes.ingot, 1))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.ingot, 1))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Naquadria, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Naquadria, Shapes.ingot, 1))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.NaquadahEnriched, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.NaquadahEnriched, Shapes.ingot, 1))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        if (Avaritia.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Infinity, Shapes.ingotHot, 1))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 1, 6)).duration(14 * SECONDS + 14 * TICKS)
                    .eut(TierEU.RECIPE_UHV).addTo(vacuumFreezerRecipes);

        }

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.ingot, 1))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_UV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Adamantium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Adamantium, Shapes.ingot, 1))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.DeepIron, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.DeepIron, Shapes.ingot, 1))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.ingot, 1))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.ingot, 1))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_LuV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.ingot, 1))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.ElectrumFlux, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.ElectrumFlux, Shapes.ingot, 1))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Trinium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Trinium, Shapes.ingot, 1))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.TungstenCarbide, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.TungstenCarbide, Shapes.ingot, 1))
                .duration(14 * SECONDS + 11 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.HSSE, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.HSSE, Shapes.ingot, 1))
                .duration(12 * SECONDS + 3 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.NiobiumTitanium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.NiobiumTitanium, Shapes.ingot, 1))
                .duration(10 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Nichrome, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Nichrome, Shapes.ingot, 1))
                .duration(8 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VanadiumGallium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.VanadiumGallium, Shapes.ingot, 1))
                .duration(8 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.YttriumBariumCuprate, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.YttriumBariumCuprate, Shapes.ingot, 1))
                .duration(7 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_EV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Desh, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Desh, Shapes.ingot, 1)).duration(7 * SECONDS + 7 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Titanium, Shapes.ingotHot, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Titanium, Shapes.ingot, 1))
                .duration(7 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_HV).addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.HotNetherrackBrick.get())
                .itemOutputs(NHItemList.InfernalBrick.get()).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(vacuumFreezerRecipes);

    }
}
