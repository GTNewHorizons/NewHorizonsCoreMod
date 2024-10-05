package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;

@SuppressWarnings("PointlessArithmeticExpression")
public class ExtruderRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder()
                .itemInputs(Materials.BorosilicateGlass.getIngots(1), ItemList.Shape_Extruder_Wire.get(0))
                .itemOutputs(ItemList.Circuit_Parts_GlassFiber.get(8L)).duration(8 * SECONDS).eut(96)
                .addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.pipeTiny, Materials.NetherStar, 2L))
                .duration(4 * TICKS).eut(TierEU.RECIPE_MV).addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 1L),
                        ItemList.Shape_Extruder_Pipe_Small.get(0L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.NetherStar, 1L))
                .duration(8 * TICKS).eut(TierEU.RECIPE_MV).addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 3L),
                        ItemList.Shape_Extruder_Pipe_Medium.get(0L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.NetherStar, 1L))
                .duration(1 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_MV).addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 6L),
                        ItemList.Shape_Extruder_Pipe_Large.get(0L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.NetherStar, 1L))
                .duration(2 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_MV).addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 12L),
                        ItemList.Shape_Extruder_Pipe_Huge.get(0L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.NetherStar, 1L))
                .duration(4 * SECONDS + 16 * TICKS).eut(TierEU.RECIPE_MV).addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 9L),
                        GregtechItemList.Shape_Extruder_WindmillShaft.get(0))
                .itemOutputs(ItemList.IC2_ShaftIron.get(1L)).duration(32 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 9L),
                        GregtechItemList.Shape_Extruder_WindmillShaft.get(0))
                .itemOutputs(ItemList.IC2_ShaftIron.get(1L)).duration(32 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Iron, 1L),
                        GregtechItemList.Shape_Extruder_WindmillShaft.get(0))
                .itemOutputs(ItemList.IC2_ShaftIron.get(1L)).duration(32 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.WroughtIron, 1L),
                        GregtechItemList.Shape_Extruder_WindmillShaft.get(0))
                .itemOutputs(ItemList.IC2_ShaftIron.get(1L)).duration(32 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 9L),
                        GregtechItemList.Shape_Extruder_WindmillShaft.get(0))
                .itemOutputs(ItemList.IC2_ShaftSteel.get(1L)).duration(1 * MINUTES + 4 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Steel, 1L),
                        GregtechItemList.Shape_Extruder_WindmillShaft.get(0))
                .itemOutputs(ItemList.IC2_ShaftSteel.get(1L)).duration(1 * MINUTES + 4 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Carbon, 4),
                        ItemList.Shape_Extruder_Gear.get(0L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.gear, Materials.Carbon, 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(extruderRecipes);
    }
}
