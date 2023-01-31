package com.dreammaster.gthandler.recipes;

import com.dreammaster.gthandler.CustomItemList;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class VacuumFreezerRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addVacuumFreezerRecipe(
                CustomItemList.GlowingMarshmallow.get(1L),
                CustomItemList.Marshmallow.get(1L),
                48000,
                1920);

        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Neutronium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Neutronium, 1L),
                1250,
                7860);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Bedrockium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bedrockium, 1L),
                1200,
                122880);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CosmicNeutronium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.CosmicNeutronium, 1L),
                1100,
                122880);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.StellarAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StellarAlloy, 1L),
                1000,
                7860);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadah, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadah, 1L),
                990,
                7860);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tritanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tritanium, 1L),
                969,
                7860);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Oriharukon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Oriharukon, 1L),
                603,
                7680);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MelodicAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MelodicAlloy, 1L),
                739,
                4096);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Americium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Americium, 1L),
                735,
                4096);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallinePinkSlime, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.CrystallinePinkSlime, 1L),
                580,
                1920);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Platinum, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Platinum, 1L),
                585,
                480);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Iridium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iridium, 1L),
                576,
                1920);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmiridium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Osmiridium, 1L),
                573,
                1920);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallineAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.CrystallineAlloy, 1L),
                572,
                1920);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Osmium, 1L),
                570,
                1920);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tungsten, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tungsten, 1L),
                549,
                1920);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tantalum, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tantalum, 1L),
                521,
                480);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Europium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Europium, 1L),
                453,
                1920);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Samarium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Samarium, 1L),
                450,
                1920);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnderiumBase, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnderiumBase, 1L),
                402,
                480);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSS, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSS, 1L),
                387,
                1920);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Enderium, 1L),
                378,
                480);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TungstenSteel, 1L),
                357,
                1920);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TPV, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TPV, 1L),
                333,
                1920);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VibrantAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.VibrantAlloy, 1L),
                321,
                480);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VividAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.VividAlloy, 1L),
                321,
                480);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Palladium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Palladium, 1L),
                318,
                480);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Draconium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Draconium, 1L),
                294,
                7860);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSG, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1L),
                294,
                480);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Quantium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Quantium, 1L),
                294,
                7860);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NaquadahAlloy, 1L),
                294,
                7860);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlackPlutonium, 1L),
                294,
                7860);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadria, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadria, 1L),
                294,
                7860);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahEnriched, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NaquadahEnriched, 1L),
                294,
                7860);
        if (Loader.isModLoaded("Avaritia")) GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infinity, 1L),
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 6),
                294,
                2000000);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.InfinityCatalyst, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.InfinityCatalyst, 1L),
                294,
                500000);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Adamantium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Adamantium, 1L),
                294,
                7860);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DeepIron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DeepIron, 1L),
                294,
                7860);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlackPlutonium, 1L),
                294,
                122880);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DraconiumAwakened, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DraconiumAwakened, 1L),
                294,
                30720);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MysteriousCrystal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MysteriousCrystal, 1L),
                294,
                7680);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.ElectrumFlux, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectrumFlux, 1L),
                294,
                7860);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Trinium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Trinium, 1L),
                294,
                7860);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenCarbide, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TungstenCarbide, 1L),
                291,
                1920);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSE, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1L),
                243,
                480);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NiobiumTitanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NiobiumTitanium, 1L),
                213,
                480);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Nichrome, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nichrome, 1L),
                168,
                480);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VanadiumGallium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.VanadiumGallium, 1L),
                165,
                480);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.YttriumBariumCuprate, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.YttriumBariumCuprate, 1L),
                153,
                1920);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Desh, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Desh, 1L),
                147,
                480);
        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 1L),
                144,
                480);
        GT_Values.RA.addVacuumFreezerRecipe(
                CustomItemList.HotNetherrackBrick.get(1L),
                CustomItemList.InfernalBrick.get(1L),
                200,
                120);
    }
}
