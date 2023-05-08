package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sVacuumRecipes;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class VacuumFreezerRecipes implements Runnable {

    @Override
    public void run() {

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.GlowingMarshmallow.get(1L))
                .itemOutputs(CustomItemList.Marshmallow.get(1L)).noFluidInputs().noFluidOutputs().duration(40 * MINUTES)
                .eut(TierEU.RECIPE_EV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Neutronium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Neutronium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_IV)
                .addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Bedrockium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bedrockium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CosmicNeutronium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.CosmicNeutronium, 1L))
                .noFluidInputs().noFluidOutputs().duration(55 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.StellarAlloy, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StellarAlloy, 1L)).noFluidInputs()
                .noFluidOutputs().duration(50 * SECONDS).eut(TierEU.RECIPE_IV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadah, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadah, 1L)).noFluidInputs()
                .noFluidOutputs().duration(49 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_IV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tritanium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tritanium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(48 * SECONDS + 9 * TICKS).eut(TierEU.RECIPE_IV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Oriharukon, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Oriharukon, 1L)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS + 3 * TICKS).eut(TierEU.RECIPE_IV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MelodicAlloy, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MelodicAlloy, 1L)).noFluidInputs()
                .noFluidOutputs().duration(36 * SECONDS + 19 * TICKS).eut(4096).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Americium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Americium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(36 * SECONDS + 15 * TICKS).eut(4096).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallinePinkSlime, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.CrystallinePinkSlime, 1L))
                .noFluidInputs().noFluidOutputs().duration(29 * SECONDS).eut(TierEU.RECIPE_EV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Platinum, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Platinum, 1L)).noFluidInputs()
                .noFluidOutputs().duration(29 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_HV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Iridium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iridium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(28 * SECONDS + 16 * TICKS).eut(TierEU.RECIPE_EV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmiridium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Osmiridium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(28 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_EV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallineAlloy, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.CrystallineAlloy, 1L))
                .noFluidInputs().noFluidOutputs().duration(28 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_EV)
                .addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Osmium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(28 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tungsten, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tungsten, 1L)).noFluidInputs()
                .noFluidOutputs().duration(27 * SECONDS + 9 * TICKS).eut(TierEU.RECIPE_EV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tantalum, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tantalum, 1L)).noFluidInputs()
                .noFluidOutputs().duration(26 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_HV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Europium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Europium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(22 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_EV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Samarium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Samarium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(22 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnderiumBase, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnderiumBase, 1L)).noFluidInputs()
                .noFluidOutputs().duration(20 * SECONDS + 2 * TICKS).eut(TierEU.RECIPE_HV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSS, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSS, 1L)).noFluidInputs()
                .noFluidOutputs().duration(19 * SECONDS + 7 * TICKS).eut(TierEU.RECIPE_EV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Enderium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(18 * SECONDS + 18 * TICKS).eut(TierEU.RECIPE_HV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenSteel, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TungstenSteel, 1L)).noFluidInputs()
                .noFluidOutputs().duration(17 * SECONDS + 17 * TICKS).eut(TierEU.RECIPE_EV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TPV, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TPV, 1L)).noFluidInputs()
                .noFluidOutputs().duration(16 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_EV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VibrantAlloy, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.VibrantAlloy, 1L)).noFluidInputs()
                .noFluidOutputs().duration(16 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_HV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VividAlloy, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.VividAlloy, 1L)).noFluidInputs()
                .noFluidOutputs().duration(16 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_HV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Palladium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Palladium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(15 * SECONDS + 18 * TICKS).eut(TierEU.RECIPE_HV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Draconium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Draconium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSG, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1L)).noFluidInputs()
                .noFluidOutputs().duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_HV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Quantium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Quantium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahAlloy, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NaquadahAlloy, 1L)).noFluidInputs()
                .noFluidOutputs().duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlackPlutonium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadria, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadria, 1L)).noFluidInputs()
                .noFluidOutputs().duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahEnriched, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NaquadahEnriched, 1L))
                .noFluidInputs().noFluidOutputs().duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV)
                .addTo(sVacuumRecipes);

        if (Avaritia.isModLoaded()) {

            GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infinity, 1L))
                    .itemOutputs(GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 6)).noFluidInputs()
                    .noFluidOutputs().duration(14 * SECONDS + 14 * TICKS).eut(2000000).addTo(sVacuumRecipes);

        }

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.InfinityCatalyst, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.InfinityCatalyst, 1L))
                .noFluidInputs().noFluidOutputs().duration(14 * SECONDS + 14 * TICKS).eut(500000).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Adamantium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Adamantium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DeepIron, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DeepIron, 1L)).noFluidInputs()
                .noFluidOutputs().duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlackPlutonium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DraconiumAwakened, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DraconiumAwakened, 1L))
                .noFluidInputs().noFluidOutputs().duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_LuV)
                .addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MysteriousCrystal, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MysteriousCrystal, 1L))
                .noFluidInputs().noFluidOutputs().duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV)
                .addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.ElectrumFlux, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectrumFlux, 1L)).noFluidInputs()
                .noFluidOutputs().duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Trinium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Trinium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_IV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenCarbide, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TungstenCarbide, 1L)).noFluidInputs()
                .noFluidOutputs().duration(14 * SECONDS + 11 * TICKS).eut(TierEU.RECIPE_EV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSE, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1L)).noFluidInputs()
                .noFluidOutputs().duration(12 * SECONDS + 3 * TICKS).eut(TierEU.RECIPE_HV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NiobiumTitanium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NiobiumTitanium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_HV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Nichrome, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nichrome, 1L)).noFluidInputs()
                .noFluidOutputs().duration(8 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_HV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VanadiumGallium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.VanadiumGallium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(8 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_HV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.YttriumBariumCuprate, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.YttriumBariumCuprate, 1L))
                .noFluidInputs().noFluidOutputs().duration(7 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_EV)
                .addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Desh, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Desh, 1L)).noFluidInputs()
                .noFluidOutputs().duration(7 * SECONDS + 7 * TICKS).eut(TierEU.RECIPE_HV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(7 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_HV).addTo(sVacuumRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.HotNetherrackBrick.get(1L))
                .itemOutputs(CustomItemList.InfernalBrick.get(1L)).noFluidInputs().noFluidOutputs()
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sVacuumRecipes);

    }
}
