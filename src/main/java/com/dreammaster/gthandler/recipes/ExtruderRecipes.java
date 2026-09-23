package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.util.GTRecipeBuilder.HOURS;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.BlockShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.enums.materials.TEBlockShapes;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;

@SuppressWarnings("PointlessArithmeticExpression")
public class ExtruderRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.BorosilicateGlass, Shapes.ingot, 1),
                        ItemList.Shape_Extruder_Wire.get(0))
                .itemOutputs(ItemList.Circuit_Parts_GlassFiber.get(8L)).duration(8 * SECONDS).eut(96)
                .addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.NetherStar, Shapes.plate, 1),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(MaterialLibAPI.getStack(Materials.NetherStar, TEBlockShapes.pipeTiny, 2))
                .duration(4 * TICKS).eut(TierEU.RECIPE_MV).addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.NetherStar, Shapes.plate, 1),
                        ItemList.Shape_Extruder_Pipe_Small.get(0L))
                .itemOutputs(MaterialLibAPI.getStack(Materials.NetherStar, TEBlockShapes.pipeSmall, 1))
                .duration(8 * TICKS).eut(TierEU.RECIPE_MV).addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.NetherStar, Shapes.plate, 3),
                        ItemList.Shape_Extruder_Pipe_Medium.get(0L))
                .itemOutputs(MaterialLibAPI.getStack(Materials.NetherStar, TEBlockShapes.pipeMedium, 1))
                .duration(1 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_MV).addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.NetherStar, Shapes.plate, 6),
                        ItemList.Shape_Extruder_Pipe_Large.get(0L))
                .itemOutputs(MaterialLibAPI.getStack(Materials.NetherStar, TEBlockShapes.pipeLarge, 1))
                .duration(2 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_MV).addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.NetherStar, Shapes.plate, 12),
                        ItemList.Shape_Extruder_Pipe_Huge.get(0L))
                .itemOutputs(MaterialLibAPI.getStack(Materials.NetherStar, TEBlockShapes.pipeHuge, 1))
                .duration(4 * SECONDS + 16 * TICKS).eut(TierEU.RECIPE_MV).addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.ingot, 9),
                        GregtechItemList.Shape_Extruder_WindmillShaft.get(0))
                .itemOutputs(ItemList.IC2_ShaftIron.get(1L)).duration(32 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.CastIron, Shapes.ingot, 9),
                        GregtechItemList.Shape_Extruder_WindmillShaft.get(0))
                .itemOutputs(ItemList.IC2_ShaftIron.get(1L)).duration(32 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iron, BlockShapes.block, 1),
                        GregtechItemList.Shape_Extruder_WindmillShaft.get(0))
                .itemOutputs(ItemList.IC2_ShaftIron.get(1L)).duration(32 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.CastIron, BlockShapes.block, 1),
                        GregtechItemList.Shape_Extruder_WindmillShaft.get(0))
                .itemOutputs(ItemList.IC2_ShaftIron.get(1L)).duration(32 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.ingot, 9),
                        GregtechItemList.Shape_Extruder_WindmillShaft.get(0))
                .itemOutputs(ItemList.IC2_ShaftSteel.get(1L)).duration(1 * MINUTES + 4 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, BlockShapes.block, 1),
                        GregtechItemList.Shape_Extruder_WindmillShaft.get(0))
                .itemOutputs(ItemList.IC2_ShaftSteel.get(1L)).duration(1 * MINUTES + 4 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.ingot, 4),
                        ItemList.Shape_Extruder_Gear.get(0L))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Carbon, Shapes.gearGt, 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Neutronium, BlockShapes.block, 64),
                        MaterialLibAPI.getStack(Materials.Neutronium, BlockShapes.block, 64))
                .itemOutputs(NHItemList.NANCertificate.get(1))
                .duration(29826 * HOURS + 9 * MINUTES + 7 * SECONDS + 7 * TICKS)
                // not using recipe EUt on purpose
                .eut(TierEU.ULV).addTo(extruderRecipes);
    }
}
