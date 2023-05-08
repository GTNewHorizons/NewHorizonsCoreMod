package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersGregworks;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sExtruderRecipes;
import static gregtech.api.util.GT_RecipeBuilder.HOURS;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class ExtruderRecipes implements Runnable {

    @Override
    public void run() {
        registerTinkerParts();

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.AnnealedCopper, 1L),
                        ItemList.Shape_Extruder_Rod.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.AnnealedCopper, 2L)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(90).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L),
                        ItemList.Shape_Extruder_Rod.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 2L)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(90).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.BorosilicateGlass.getIngots(1), ItemList.Shape_Extruder_Wire.get(0))
                .itemOutputs(ItemList.Circuit_Parts_GlassFiber.get(8L)).noFluidInputs().noFluidOutputs()
                .duration(8 * SECONDS).eut(96).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.WroughtIron, 2L)).noFluidInputs()
                .noFluidOutputs().duration(4 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L),
                        ItemList.Shape_Extruder_Pipe_Small.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.WroughtIron, 1L)).noFluidInputs()
                .noFluidOutputs().duration(8 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 3L),
                        ItemList.Shape_Extruder_Pipe_Medium.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.WroughtIron, 1L))
                .noFluidInputs().noFluidOutputs().duration(1 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 6L),
                        ItemList.Shape_Extruder_Pipe_Large.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.WroughtIron, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 12L),
                        ItemList.Shape_Extruder_Pipe_Huge.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.WroughtIron, 1L)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 16 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.NetherStar, 2L)).noFluidInputs()
                .noFluidOutputs().duration(4 * TICKS).eut((int) TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 1L),
                        ItemList.Shape_Extruder_Pipe_Small.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.NetherStar, 1L)).noFluidInputs()
                .noFluidOutputs().duration(8 * TICKS).eut((int) TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 3L),
                        ItemList.Shape_Extruder_Pipe_Medium.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.NetherStar, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * SECONDS + 4 * TICKS).eut((int) TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 6L),
                        ItemList.Shape_Extruder_Pipe_Large.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.NetherStar, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * SECONDS + 8 * TICKS).eut((int) TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 12L),
                        ItemList.Shape_Extruder_Pipe_Huge.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.NetherStar, 1L)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 16 * TICKS).eut((int) TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 2L),
                        ItemList.Shape_Extruder_Hoe.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, Materials.StainlessSteel, 1L))
                .noFluidInputs().noFluidOutputs().duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        if (GTPlusPlus.isModLoaded()) { // GT++, remember to remove later

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 9L),
                            GT_ModHandler.getModItem(GTPlusPlus.ID, "MU-metaitem.01", 0L, 32040))
                    .itemOutputs(ItemList.IC2_ShaftIron.get(1L)).noFluidInputs().noFluidOutputs().duration(32 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 9L),
                            GT_ModHandler.getModItem(GTPlusPlus.ID, "MU-metaitem.01", 0L, 32040))
                    .itemOutputs(ItemList.IC2_ShaftIron.get(1L)).noFluidInputs().noFluidOutputs().duration(32 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.block, Materials.Iron, 1L),
                            GT_ModHandler.getModItem(GTPlusPlus.ID, "MU-metaitem.01", 0L, 32040))
                    .itemOutputs(ItemList.IC2_ShaftIron.get(1L)).noFluidInputs().noFluidOutputs().duration(32 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.block, Materials.WroughtIron, 1L),
                            GT_ModHandler.getModItem(GTPlusPlus.ID, "MU-metaitem.01", 0L, 32040))
                    .itemOutputs(ItemList.IC2_ShaftIron.get(1L)).noFluidInputs().noFluidOutputs().duration(32 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 9L),
                            GT_ModHandler.getModItem(GTPlusPlus.ID, "MU-metaitem.01", 0L, 32040))
                    .itemOutputs(ItemList.IC2_ShaftSteel.get(1L)).noFluidInputs().noFluidOutputs()
                    .duration(1 * MINUTES + 4 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.block, Materials.Steel, 1L),
                            GT_ModHandler.getModItem(GTPlusPlus.ID, "MU-metaitem.01", 0L, 32040))
                    .itemOutputs(ItemList.IC2_ShaftSteel.get(1L)).noFluidInputs().noFluidOutputs()
                    .duration(1 * MINUTES + 4 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);
        }
    }

    public static void registerTinkerParts() {
        if (!TinkerConstruct.isModLoaded()) {
            return;
        }

        // tinker construct only recipes

        // Tool Rods

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(8 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 1, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(6 * SECONDS + 2 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS + 6 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(9 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(19 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(27 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(33 * SECONDS + 6 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 1L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 17 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Pickaxe Heads

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(25 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(8 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 1, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(12 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 13 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(18 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(38 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(55 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 6 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(12 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 1L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(9 * SECONDS + 15 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Shovel Heads

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(25 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(8 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 1, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(12 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 13 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(18 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(38 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(55 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 6 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(12 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 1L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(9 * SECONDS + 15 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Axe Heads

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(25 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(8 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 1, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(12 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 13 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(18 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(38 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(55 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 6 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(12 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 1L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(9 * SECONDS + 15 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Sword Blade

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(25 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(8 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 1, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(12 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 13 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(18 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(38 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(55 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 6 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(12 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 1L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(9 * SECONDS + 15 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Wide Guards

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 1, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(6 * SECONDS + 2 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS + 6 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(9 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(19 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(27 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(33 * SECONDS + 6 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 1L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 17 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Hand Guards

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 1, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(6 * SECONDS + 2 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS + 6 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(9 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(19 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(27 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(33 * SECONDS + 6 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 1L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 17 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Crossbars

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 1, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(6 * SECONDS + 2 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS + 6 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(9 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(19 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(27 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(33 * SECONDS + 6 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 1L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 17 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Bindings

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 1, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(6 * SECONDS + 2 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS + 6 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(9 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(19 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(27 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(33 * SECONDS + 6 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 1L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 17 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Fryingpan Heads (Time for Dream to duck!)

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(25 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(8 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 1, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(12 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 13 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(18 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(38 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(55 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 6 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(12 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 1L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(9 * SECONDS + 15 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Sign Heads (To write on a wall)

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(25 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(8 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 1, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(12 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 13 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(18 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(38 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(55 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 6 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(12 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 1L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(9 * SECONDS + 15 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Knife Blades (There are no winners in a knife fight)

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 1, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(6 * SECONDS + 2 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS + 6 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(9 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(19 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(27 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(33 * SECONDS + 6 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 1L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 17 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Chisel Heads (Stonework galore)

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 1, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(6 * SECONDS + 2 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS + 6 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(9 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(19 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(27 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(33 * SECONDS + 6 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 1L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 17 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Tough Tool Rods (The Tougher the Better)

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 15 * SECONDS + 3 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(26 * SECONDS + 17 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 3, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(36 * SECONDS + 15 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(4 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 1 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(54 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 54 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 45 * SECONDS + 3 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 19 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 3L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 3L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 3L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(37 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 3L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(29 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 3L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(9 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Tough Bindings (To keep the toughness together)

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 15 * SECONDS + 3 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(26 * SECONDS + 17 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 3, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(36 * SECONDS + 15 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(4 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 1 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(54 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 54 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 45 * SECONDS + 3 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 19 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 3L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 3L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 3L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(37 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 3L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(29 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 3L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(9 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Large Plates (Different from Small Plates)

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 20 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 11 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 8, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 38 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(10 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(16 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(7 * MINUTES + 20 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(5 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(8 * MINUTES + 53 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 8L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(1 * HOURS + 40 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 8L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 18 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(24 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Broad Axe Heads (Cutting down a tree with every strike)

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 20 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 11 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 8, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 38 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(10 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(16 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(7 * MINUTES + 20 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(5 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(8 * MINUTES + 53 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 8L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(1 * HOURS + 40 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 8L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 18 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(24 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Scythe Heads (Cutting down a a farm with every strike, or Deaths favorite weapon)

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 20 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 11 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 8, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 38 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(10 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(16 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(7 * MINUTES + 20 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(5 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(8 * MINUTES + 53 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 8L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(1 * HOURS + 40 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 8L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 18 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(24 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Excavator Heads (Getting Dirty digging a hole)

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 20 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 11 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 8, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 38 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(10 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(16 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(7 * MINUTES + 20 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(5 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(8 * MINUTES + 53 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 8L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(1 * HOURS + 40 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 8L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 18 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(24 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Large Sword Blades (Who has the largest sword?)

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 20 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 11 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 8, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 38 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(10 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(16 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(7 * MINUTES + 20 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(5 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(8 * MINUTES + 53 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 8L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(1 * HOURS + 40 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 8L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 18 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(24 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Hammer Heads (It's Clobbering Time!)

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 20 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 11 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 8, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 38 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(10 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(16 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(7 * MINUTES + 20 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(5 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(8 * MINUTES + 53 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 8L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(1 * HOURS + 40 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 8L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 18 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 8L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(24 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Full Guards (To guard your grip)

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 15 * SECONDS + 3 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(26 * SECONDS + 17 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 3, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(36 * SECONDS + 15 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(4 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 1 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(54 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 54 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 45 * SECONDS + 3 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(3),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 19 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 3L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 3L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 3L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(37 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 3L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(29 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 3L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(9 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Arrowheads (Hey, flying metal)

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Iron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(25 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(8 * SECONDS + 19 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 1, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(12 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Cobalt.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Ardite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 13 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Copper.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(18 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Bronze.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(38 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Alumite.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(55 * SECONDS + 1 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.PigIron.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 6 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(12 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 1L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(9 * SECONDS + 15 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Shurikens (Hey, Oriental flying metal)

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Iron.getIngots(1), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 1, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(6 * SECONDS + 2 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Cobalt.getIngots(1), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Ardite.getIngots(1), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS + 6 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(1),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Copper.getIngots(1), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(9 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Bronze.getIngots(1), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(19 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Alumite.getIngots(1), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(27 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Steel.getIngots(1), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.PigIron.getIngots(1), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(33 * SECONDS + 6 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 1L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(4 * SECONDS + 17 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Crossbow Limbs (The Dragon's worst enemy)

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Iron.getIngots(4), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 40 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(35 * SECONDS + 16 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 4, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(49 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Cobalt.getIngots(4), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(5 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Ardite.getIngots(4), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(4 * MINUTES + 2 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(8 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Copper.getIngots(4), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 12 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Bronze.getIngots(4), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 32 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Alumite.getIngots(4), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 40 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Steel.getIngots(4), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.PigIron.getIngots(4), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(4 * MINUTES + 26 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 4L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 4L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 4L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(50 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 4L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(39 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 4L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(12 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Crossbow Body (The Dragon's worst enemy, part 2)

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Iron.getIngots(5), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 5 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(5),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(44 * SECONDS + 15 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 5, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 1 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Cobalt.getIngots(5), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(6 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Ardite.getIngots(5), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(5 * MINUTES + 3 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(5),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(10 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Copper.getIngots(5), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Bronze.getIngots(5), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Alumite.getIngots(5), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(4 * MINUTES + 35 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Steel.getIngots(5), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.PigIron.getIngots(5), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(5 * MINUTES + 33 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 5L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(50 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 5L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(50 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 5L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(1 * HOURS + 2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 5L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(48 * SECONDS + 15 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 5L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(15 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);
        // Bow Limbs (A skeletons favorite weapon, in pieces.)

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Iron.getIngots(2), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 2)).noFluidInputs()
                .noFluidOutputs().duration(37 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Obsidian.getIngots(2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 6)).noFluidInputs()
                .noFluidOutputs().duration(13 * SECONDS + 9 * TICKS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.netherbrick, 2, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 7)).noFluidInputs()
                .noFluidOutputs().duration(18 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Cobalt.getIngots(2), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 10)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Ardite.getIngots(2), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 11)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 31 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Manyullyn.getIngots(2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 12)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Copper.getIngots(2), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 13)).noFluidInputs()
                .noFluidOutputs().duration(27 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Bronze.getIngots(2), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 14)).noFluidInputs()
                .noFluidOutputs().duration(57 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Alumite.getIngots(2), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 15)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 22 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Steel.getIngots(2), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 16)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.PigIron.getIngots(2), GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 18)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 2L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(15 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 2L, 2),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 314)).noFluidInputs()
                .noFluidOutputs().duration(15 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 2L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 315)).noFluidInputs()
                .noFluidOutputs().duration(18 * MINUTES + 45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ExtraUtilities.ID, "decorativeBlock1", 2L, 8),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 316)).noFluidInputs()
                .noFluidOutputs().duration(14 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 2L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 251)).noFluidInputs()
                .noFluidOutputs().duration(4 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sExtruderRecipes);

        if (!Avaritia.isModLoaded()) {
            return;
        }

        // tinker construct and avaritia recipes

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 1L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolRod", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 2L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "pickaxeHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(15 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 2L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "shovelHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(15 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 2L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 4))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hatchetHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(15 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 2L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 5))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "swordBlade", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(15 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 1L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 6))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "wideGuard", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 1L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 7))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "handGuard", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 1L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 8))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "crossbar", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 1L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 9))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "binding", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 2L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 10))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "frypanHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(15 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 2L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 11))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "signHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(15 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 1L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 12))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "knifeBlade", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 1L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 13))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "chiselHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 3L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(15 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 6L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 14))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughRod", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 3L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(15 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 6L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 15))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toughBinding", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 8L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 16L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 16))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(50 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 8L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 16L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 17))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "broadAxeHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(50 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 8L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 16L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 18))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "scytheBlade", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(50 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 8L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 16L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 19))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "excavatorHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(50 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 8L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 16L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 20))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "largeSwordBlade", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(50 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 8L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(40 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 16L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 21))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "hammerHead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(50 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 3L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(15 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 6L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 22))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "fullGuard", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 3L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 6L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "metalPattern", 0L, 25))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "arrowhead", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(15 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 1L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "ShurikenPart", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 4L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 8L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(25 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 5L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 10L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(37 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 2L, 4),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(17 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 3L, 1671),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "Cast", 0L, 3))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "BowLimbPart", 1L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(22 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

        if (!TinkersGregworks.isModLoaded()) {
            return;
        }

        // TiCo + avaritia + Tinker gregworks
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 4),
                        GT_ModHandler.getModItem(TinkersGregworks.ID, "tgregworks.shardcast", 0L, 0))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "toolShard", 2L, 1671)).noFluidInputs()
                .noFluidOutputs().duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(sExtruderRecipes);

    }
}
