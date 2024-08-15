package com.dreammaster.gthandler;

import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_EV;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_EV_Full;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_IV;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_IV_Full;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_LuV;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_LuV_Full;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_UEV;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_UEV_Full;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_UHV;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_UHV_Full;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_UIV;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_UIV_Full;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_UMV;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_UMV_Full;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_UV;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_UV_Full;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_UxV;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_UxV_Full;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_ZPM;
import static com.dreammaster.gthandler.GT_Loader_Batteries_IDs.BatteryHull_ZPM_Full;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.cannerRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;
import static gregtech.client.GT_TooltipHandler.Tier.*;
import static gregtech.client.GT_TooltipHandler.registerTieredTooltip;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TC_Aspects;
import gregtech.api.enums.TierEU;
import gregtech.api.objects.ItemData;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.common.items.GT_MetaGenerated_Item_01;

/*
 *
 */
public class GT_Loader_Batteries {

    public void run() {
        GT = GT_MetaGenerated_Item_01.INSTANCE;
        registerBatteries();
    }

    private GT_MetaGenerated_Item_01 GT;

    private void registerBatteries() {
        // Empty battery hulls
        CustomItemList.BatteryHull_EV.set(
                GT.addItem(
                        BatteryHull_EV.ID,
                        "Small Sunnarium Battery (Empty)",
                        "An empty EV Battery Container",
                        new ItemData(Materials.BlueSteel, OrePrefixes.plate.mMaterialAmount * 2L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 8L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 8L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 8L)));
        CustomItemList.BatteryHull_IV.set(
                GT.addItem(
                        BatteryHull_IV.ID,
                        "Medium Sunnarium Battery (Empty)",
                        "An empty IV Battery Container",
                        new ItemData(Materials.RoseGold, OrePrefixes.plate.mMaterialAmount * 6L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 16L)));
        CustomItemList.BatteryHull_LuV.set(
                GT.addItem(
                        BatteryHull_LuV.ID,
                        "Large Sunnarium Battery (Empty)",
                        "An empty LuV Battery Container",
                        new ItemData(Materials.RedSteel, OrePrefixes.plate.mMaterialAmount * 18L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 32L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 32L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 32L)));
        CustomItemList.BatteryHull_ZPM.set(
                GT.addItem(
                        BatteryHull_ZPM.ID,
                        "Medium Naquadria Battery (Empty)",
                        "An empty ZPM Energy Storage",
                        new ItemData(Materials.Europium, OrePrefixes.plate.mMaterialAmount * 6L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 64L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 64L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 64L)));
        CustomItemList.BatteryHull_UV.set(
                GT.addItem(
                        BatteryHull_UV.ID,
                        "Large Naquadria Battery (Empty)",
                        "An empty UV Energy Storage",
                        new ItemData(Materials.Americium, OrePrefixes.plate.mMaterialAmount * 18L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 128L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 128L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 128L)));
        CustomItemList.BatteryHull_UHV.set(
                GT.addItem(
                        BatteryHull_UHV.ID,
                        "Small Neutronium Battery (Empty)",
                        "An empty UHV Energy Storage",
                        new ItemData(Materials.Naquadah, OrePrefixes.plate.mMaterialAmount * 24L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 256L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 256L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 256L)));
        CustomItemList.BatteryHull_UEV.set(
                GT.addItem(
                        BatteryHull_UEV.ID,
                        "Medium Neutronium Battery (Empty)",
                        "An empty UEV Energy Storage",
                        new ItemData(Materials.NaquadahEnriched, OrePrefixes.plate.mMaterialAmount * 36L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 512L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 512L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 512L)));
        CustomItemList.BatteryHull_UIV.set(
                GT.addItem(
                        BatteryHull_UIV.ID,
                        "Large Neutronium Battery (Empty)",
                        "An empty UIV Energy Storage",
                        new ItemData(Materials.NaquadahAlloy, OrePrefixes.plate.mMaterialAmount * 48L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 1024L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 1024L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 1024L)));
        CustomItemList.BatteryHull_UMV.set(
                GT.addItem(
                        BatteryHull_UMV.ID,
                        "Medium Plasma Battery (Empty)",
                        "An empty UMV Energy Storage",
                        new ItemData(Materials.Neutronium, OrePrefixes.plate.mMaterialAmount * 56L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 2048L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2048L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 2048L)));
        CustomItemList.BatteryHull_UxV.set(
                GT.addItem(
                        BatteryHull_UxV.ID,
                        "Large Plasma Battery (Empty)",
                        "An empty UXV Energy Storage",
                        new ItemData(Materials.DraconiumAwakened, OrePrefixes.plate.mMaterialAmount * 64L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 4096L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 4096L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 4096L)));

        // Recipes

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlueSteel, 2L))
                .itemOutputs(CustomItemList.BatteryHull_EV.get(1L))
                .fluidInputs(Materials.Polytetrafluoroethylene.getMolten(144L)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Platinum, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 6L))
                .itemOutputs(CustomItemList.BatteryHull_IV.get(1L))
                .fluidInputs(Materials.Polytetrafluoroethylene.getMolten(288L)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Naquadah, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedSteel, 18L))
                .itemOutputs(CustomItemList.BatteryHull_LuV.get(1L))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(144L)).duration(15 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.NaquadahAlloy, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Europium, 6L))
                .itemOutputs(CustomItemList.BatteryHull_ZPM.get(1L))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(288L)).duration(10 * SECONDS).eut(TierEU.RECIPE_LuV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.ElectrumFlux, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Americium, 18L))
                .itemOutputs(CustomItemList.BatteryHull_UV.get(1L))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(576L)).duration(15 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.ElectrumFlux, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 24L))
                .itemOutputs(CustomItemList.BatteryHull_UHV.get(1L))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(1152L)).duration(5 * SECONDS).eut(500000)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.ElectrumFlux, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahEnriched, 36L))
                .itemOutputs(CustomItemList.BatteryHull_UEV.get(1L))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(2304L)).duration(10 * SECONDS).eut(2000000)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.ElectrumFlux, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 48L))
                .itemOutputs(CustomItemList.BatteryHull_UIV.get(1L))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(4608L)).duration(15 * SECONDS).eut(2000000)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUHV, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 56L))
                .itemOutputs(CustomItemList.BatteryHull_UMV.get(1L))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(9216L)).duration(30 * SECONDS).eut(2000000)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUHV, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 64L))
                .itemOutputs(CustomItemList.BatteryHull_UxV.get(1L))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(18432L)).duration(60 * SECONDS).eut(2000000)
                .addTo(assemblerRecipes);

        // Actually filled hulls.
        // I added a gap of 5 to each filled hull, so 4 additional batteries are possible for each voltage tierELECTRUM
        CustomItemList.BatteryHull_EV_Full.set(
                GT.addItem(
                        BatteryHull_EV_Full.ID,
                        "Small Sunnarium Battery",
                        "Reusable",
                        "batteryEV",
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 32L)));
        GT.setElectricStats(32000 + BatteryHull_EV_Full.ID, 6400000L, GT_Values.V[4], 4L, -3L, true);
        registerTieredTooltip(CustomItemList.BatteryHull_EV_Full.get(1), EV);

        CustomItemList.BatteryHull_IV_Full.set(
                GT.addItem(
                        BatteryHull_IV_Full.ID,
                        "Medium Sunnarium Battery",
                        "Reusable",
                        "batteryIV",
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 32L)));
        GT.setElectricStats(32000 + BatteryHull_IV_Full.ID, 25600000L, GT_Values.V[5], 5L, -3L, true);
        registerTieredTooltip(CustomItemList.BatteryHull_IV_Full.get(1), IV);

        CustomItemList.BatteryHull_LuV_Full.set(
                GT.addItem(
                        BatteryHull_LuV_Full.ID,
                        "Large Sunnarium Battery",
                        "Reusable",
                        "batteryLuV",
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 32L)));
        GT.setElectricStats(32000 + BatteryHull_LuV_Full.ID, 102400000L, GT_Values.V[6], 6L, -3L, true);
        registerTieredTooltip(CustomItemList.BatteryHull_LuV_Full.get(1), LuV);

        CustomItemList.BatteryHull_ZPM_Full.set(
                GT.addItem(
                        BatteryHull_ZPM_Full.ID,
                        "Medium Naquadria Battery",
                        "Reusable",
                        "batteryZPM",
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 32L)));
        GT.setElectricStats(32000 + BatteryHull_ZPM_Full.ID, 409600000L, GT_Values.V[7], 7L, -3L, true);
        registerTieredTooltip(CustomItemList.BatteryHull_ZPM_Full.get(1), ZPM);

        CustomItemList.BatteryHull_UV_Full.set(
                GT.addItem(
                        BatteryHull_UV_Full.ID,
                        "Large Naquadria Battery",
                        "Reusable",
                        "batteryUV",
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 32L)));
        GT.setElectricStats(32000 + BatteryHull_UV_Full.ID, 1638400000L, GT_Values.V[8], 8L, -3L, true);
        registerTieredTooltip(CustomItemList.BatteryHull_UV_Full.get(1), UV);

        CustomItemList.BatteryHull_UHV_Full.set(
                GT.addItem(
                        BatteryHull_UHV_Full.ID,
                        "Small Neutronium Battery",
                        "Reusable",
                        "batteryUHV",
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 32L)));
        GT.setElectricStats(32000 + BatteryHull_UHV_Full.ID, 6553600000L, GT_Values.V[9], 9L, -3L, true);
        registerTieredTooltip(CustomItemList.BatteryHull_UHV_Full.get(1), UHV);

        CustomItemList.BatteryHull_UEV_Full.set(
                GT.addItem(
                        BatteryHull_UEV_Full.ID,
                        "Medium Neutronium Battery",
                        "Reusable",
                        "batteryUEV",
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 32L)));
        GT.setElectricStats(32000 + BatteryHull_UEV_Full.ID, 26214400000L, GT_Values.V[10], 10L, -3L, true);
        registerTieredTooltip(CustomItemList.BatteryHull_UEV_Full.get(1), UEV);

        CustomItemList.BatteryHull_UIV_Full.set(
                GT.addItem(
                        BatteryHull_UIV_Full.ID,
                        "Large Neutronium Battery",
                        "Reusable",
                        "batteryUIV",
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 32L)));
        GT.setElectricStats(32000 + BatteryHull_UIV_Full.ID, 104857600000L, GT_Values.V[11], 11L, -3L, true);
        registerTieredTooltip(CustomItemList.BatteryHull_UIV_Full.get(1), UIV);

        CustomItemList.BatteryHull_UMV_Full.set(
                GT.addItem(
                        BatteryHull_UMV_Full.ID,
                        "Medium Infinity Battery",
                        "Reusable",
                        "batteryUMV",
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 32L)));
        GT.setElectricStats(32000 + BatteryHull_UMV_Full.ID, 419430400000L, GT_Values.V[12], 12L, -3L, true);
        registerTieredTooltip(CustomItemList.BatteryHull_UMV_Full.get(1), UMV);

        CustomItemList.BatteryHull_UxV_Full.set(
                GT.addItem(
                        BatteryHull_UxV_Full.ID,
                        "Large Infinity Battery",
                        "Reusable",
                        "batteryUXV",
                        new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 16L),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 32L)));
        GT.setElectricStats(32000 + BatteryHull_UxV_Full.ID, 1677721600000L, GT_Values.V[13], 13L, -3L, true);
        registerTieredTooltip(CustomItemList.BatteryHull_UxV_Full.get(1), UXV);

        // Just to be complete, extractor recipes for the filled hulls
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.BatteryHull_EV_Full.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_EV.get(1L)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.BatteryHull_IV_Full.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_IV.get(1L)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.BatteryHull_LuV_Full.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_LuV.get(1L)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.BatteryHull_ZPM_Full.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_ZPM.get(1L)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.BatteryHull_UV_Full.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_UV.get(1L)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.BatteryHull_UHV_Full.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_UHV.get(1L)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.BatteryHull_UEV_Full.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_UEV.get(1L)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.BatteryHull_UIV_Full.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_UIV.get(1L)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.BatteryHull_UMV_Full.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_UMV.get(1L)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.BatteryHull_UxV_Full.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_UxV.get(1L)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);

        // Recipes to actually fill the empty hulls with content
        // IV 2048

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 4L),
                        CustomItemList.BatteryHull_EV.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_EV_Full.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(cannerRecipes);
        // EV 8192

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 16L),
                        CustomItemList.BatteryHull_IV.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_IV_Full.get(1L)).duration(7 * SECONDS + 10 * TICKS).eut(1024)
                .addTo(cannerRecipes);
        // LuV 32768

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 32L),
                        CustomItemList.BatteryHull_LuV.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_LuV_Full.get(1L)).duration(10 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(cannerRecipes);
        // ZPM 131072

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 16L),
                        CustomItemList.BatteryHull_ZPM.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_ZPM_Full.get(1L)).duration(12 * SECONDS + 10 * TICKS).eut(4096)
                .addTo(cannerRecipes);
        // UV 524288

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 32L),
                        CustomItemList.BatteryHull_UV.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_UV_Full.get(1L)).duration(15 * SECONDS).eut(7860)
                .addTo(cannerRecipes);
        // UHV 2097152

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 16L),
                        CustomItemList.BatteryHull_UHV.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_UHV_Full.get(1L)).duration(17 * SECONDS + 10 * TICKS).eut(15720)
                .addTo(cannerRecipes);
        // UEV 8388608

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 32L),
                        CustomItemList.BatteryHull_UEV.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_UEV_Full.get(1L)).duration(20 * SECONDS).eut(31440)
                .addTo(cannerRecipes);
        // UIV 33554432

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 64L),
                        CustomItemList.BatteryHull_UIV.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_UIV_Full.get(1L)).duration(22 * SECONDS + 10 * TICKS).eut(62880)
                .addTo(cannerRecipes);
        // UMV 134217728

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 4L),
                        CustomItemList.BatteryHull_UMV.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_UMV_Full.get(1L)).duration(25 * SECONDS).eut(125760)
                .addTo(cannerRecipes);
        // UxV 536870912

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 8L),
                        CustomItemList.BatteryHull_UxV.get(1L))
                .itemOutputs(CustomItemList.BatteryHull_UxV_Full.get(1L)).duration(30 * SECONDS).eut(251520)
                .addTo(cannerRecipes);

    }
}
