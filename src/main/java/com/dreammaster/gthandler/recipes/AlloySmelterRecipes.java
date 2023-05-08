package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class AlloySmelterRecipes implements Runnable {

    @Override
    public void run() {

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.MicaBasedSheet.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L))
                .itemOutputs(CustomItemList.MicaInsulatorSheet.get(4L)).noFluidInputs().noFluidOutputs()
                .duration(20 * SECONDS).eut(15).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(15).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(15).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(15).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.MicaBasedSheet.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L))
                .itemOutputs(CustomItemList.MicaInsulatorSheet.get(4L)).noFluidInputs().noFluidOutputs()
                .duration(20 * SECONDS).eut(15).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(15).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(15).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(15).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.MicaBasedSheet.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L))
                .itemOutputs(CustomItemList.MicaInsulatorSheet.get(4L)).noFluidInputs().noFluidOutputs()
                .duration(20 * SECONDS).eut(15).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(15).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(15).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(15).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.MicaBasedSheet.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 2L))
                .itemOutputs(CustomItemList.MicaInsulatorSheet.get(4L)).noFluidInputs().noFluidOutputs()
                .duration(20 * SECONDS).eut(15).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 2L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(15).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 2L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(15).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 2L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(15).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1),
                        ItemList.Shape_Mold_Ball.get(0))
                .itemOutputs(ItemList.Circuit_Parts_Glass_Tube.get(1L)).noFluidInputs().noFluidOutputs()
                .duration(6 * SECONDS).eut(16).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian, 1, 0), ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Obsidian, 2L)).noFluidInputs()
                .noFluidOutputs().duration(6 * SECONDS + 10 * TICKS).eut(3).addTo(sAlloySmelterRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartIridium", 2L),
                        ItemList.Shape_Mold_Casing.get(0))
                .itemOutputs(com.dreammaster.item.ItemList.IridiumAlloyItemCasing.getIS().splitStack(3)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(256).addTo(sAlloySmelterRecipes);

        // recipes for everything that uses sand
        for (int i = 0; i < OreDictionary.getOres("sand").size(); ++i) {
            GT_Values.RA.stdBuilder().itemInputs(OreDictionary.getOres("sand").get(i), new ItemStack(Items.clay_ball))
                    .itemOutputs(com.dreammaster.item.ItemList.CokeOvenBrick.getIS().splitStack(2)).noFluidInputs()
                    .noFluidOutputs().duration(10 * SECONDS).eut(8).addTo(sAlloySmelterRecipes);
        }

        if (EnderIO.isModLoaded()) {
            // EnderIO Fused Quartz and Glass

            GT_Values.RA.stdBuilder().itemInputs(Materials.CertusQuartz.getDust(2), Materials.Glass.getDust(1))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).noFluidInputs()
                    .noFluidOutputs().duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAlloySmelterRecipes);

            GT_Values.RA.stdBuilder().itemInputs(Materials.NetherQuartz.getDust(2), Materials.Glass.getDust(1))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).noFluidInputs()
                    .noFluidOutputs().duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAlloySmelterRecipes);

            GT_Values.RA.stdBuilder().itemInputs(Materials.CertusQuartz.getDust(2), Materials.Quartzite.getDust(2))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).noFluidInputs()
                    .noFluidOutputs().duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAlloySmelterRecipes);

            GT_Values.RA.stdBuilder().itemInputs(Materials.NetherQuartz.getDust(2), Materials.Quartzite.getDust(2))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).noFluidInputs()
                    .noFluidOutputs().duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAlloySmelterRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(Materials.CertusQuartz.getDust(1), Materials.BorosilicateGlass.getDust(1))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).noFluidInputs()
                    .noFluidOutputs().duration(25 * SECONDS).eut(90).addTo(sAlloySmelterRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(Materials.NetherQuartz.getDust(1), Materials.BorosilicateGlass.getDust(1))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).noFluidInputs()
                    .noFluidOutputs().duration(25 * SECONDS).eut(90).addTo(sAlloySmelterRecipes);

            GT_Values.RA.stdBuilder().itemInputs(Materials.Glass.getDust(3), GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 1)).noFluidInputs()
                    .noFluidOutputs().duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAlloySmelterRecipes);

            GT_Values.RA.stdBuilder().itemInputs(Materials.Quartzite.getDust(4), GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 1)).noFluidInputs()
                    .noFluidOutputs().duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAlloySmelterRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(Materials.BorosilicateGlass.getDust(1), GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 2L, 1)).noFluidInputs()
                    .noFluidOutputs().duration(25 * SECONDS).eut(90).addTo(sAlloySmelterRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 1),
                            Materials.Glowstone.getDust(4))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 3)).noFluidInputs()
                    .noFluidOutputs().duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAlloySmelterRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 1),
                            new ItemStack(Blocks.glowstone))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 3)).noFluidInputs()
                    .noFluidOutputs().duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAlloySmelterRecipes);

            for (int i = 0; i < OreDictionary.getOres("dyeBlack").size(); i++) {

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 1),
                                OreDictionary.getOres("dyeBlack").get(i).splitStack(4))
                        .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 5)).noFluidInputs()
                        .noFluidOutputs().duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAlloySmelterRecipes);

            }
        }

        if (TinkerConstruct.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 3L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L))
                    .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 4L, 14)).noFluidInputs()
                    .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAlloySmelterRecipes);

        }

    }

}
