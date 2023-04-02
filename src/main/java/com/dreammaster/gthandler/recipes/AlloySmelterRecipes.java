package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.ModIDs.EnderIO;
import static gregtech.api.enums.ModIDs.TinkerConstruct;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class AlloySmelterRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addAlloySmelterRecipe(
                CustomItemList.MicaBasedSheet.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L),
                CustomItemList.MicaInsulatorSheet.get(4L),
                400,
                15);
        GT_Values.RA.addAlloySmelterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L),
                CustomItemList.AluminoSilicateWool.get(2L),
                1200,
                15);
        GT_Values.RA.addAlloySmelterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L),
                CustomItemList.AluminoSilicateWool.get(2L),
                1200,
                15);
        GT_Values.RA.addAlloySmelterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L),
                CustomItemList.AluminoSilicateWool.get(2L),
                1200,
                15);
        GT_Values.RA.addAlloySmelterRecipe(
                CustomItemList.MicaBasedSheet.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L),
                CustomItemList.MicaInsulatorSheet.get(4L),
                400,
                15);
        GT_Values.RA.addAlloySmelterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L),
                CustomItemList.AluminoSilicateWool.get(2L),
                1200,
                15);
        GT_Values.RA.addAlloySmelterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L),
                CustomItemList.AluminoSilicateWool.get(2L),
                1200,
                15);
        GT_Values.RA.addAlloySmelterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L),
                CustomItemList.AluminoSilicateWool.get(2L),
                1200,
                15);
        GT_Values.RA.addAlloySmelterRecipe(
                CustomItemList.MicaBasedSheet.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L),
                CustomItemList.MicaInsulatorSheet.get(4L),
                400,
                15);
        GT_Values.RA.addAlloySmelterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L),
                CustomItemList.AluminoSilicateWool.get(2L),
                1200,
                15);
        GT_Values.RA.addAlloySmelterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L),
                CustomItemList.AluminoSilicateWool.get(2L),
                1200,
                15);
        GT_Values.RA.addAlloySmelterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L),
                CustomItemList.AluminoSilicateWool.get(2L),
                1200,
                15);
        GT_Values.RA.addAlloySmelterRecipe(
                CustomItemList.MicaBasedSheet.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 2L),
                CustomItemList.MicaInsulatorSheet.get(4L),
                400,
                15);
        GT_Values.RA.addAlloySmelterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 2L),
                CustomItemList.AluminoSilicateWool.get(2L),
                1200,
                15);
        GT_Values.RA.addAlloySmelterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 2L),
                CustomItemList.AluminoSilicateWool.get(2L),
                1200,
                15);
        GT_Values.RA.addAlloySmelterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 2L),
                CustomItemList.AluminoSilicateWool.get(2L),
                1200,
                15);

        GT_Values.RA.addAlloySmelterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1),
                ItemList.Shape_Mold_Ball.get(0),
                ItemList.Circuit_Parts_Glass_Tube.get(1L),
                120,
                16);
        GT_Values.RA.addAlloySmelterRecipe(
                new ItemStack(Blocks.obsidian, 1, 0),
                ItemList.Shape_Mold_Ingot.get(0L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Obsidian, 2L),
                130,
                3);

        GT_Values.RA.addAlloySmelterRecipe(
                GT_ModHandler.getModItem("IC2", "itemPartIridium", 2L),
                ItemList.Shape_Mold_Casing.get(0),
                com.dreammaster.item.ItemList.IridiumAlloyItemCasing.getIS().splitStack(3),
                1200,
                256);

        // recipes for everything that uses sand
        for (int i = 0; i < OreDictionary.getOres("sand").size(); ++i) {

            GT_Values.RA.addAlloySmelterRecipe(
                    OreDictionary.getOres("sand").get(i),
                    new ItemStack(Items.clay_ball),
                    com.dreammaster.item.ItemList.CokeOvenBrick.getIS().splitStack(2),
                    200,
                    8);
        }

        if (EnderIO.isModLoaded()) {
            // EnderIO Fused Quartz and Glass
            GT_Values.RA.addAlloySmelterRecipe(
                    Materials.CertusQuartz.getDust(2),
                    Materials.Glass.getDust(1),
                    GT_ModHandler.getModItem(EnderIO.modID, "blockFusedQuartz", 1L),
                    500,
                    30);
            GT_Values.RA.addAlloySmelterRecipe(
                    Materials.NetherQuartz.getDust(2),
                    Materials.Glass.getDust(1),
                    GT_ModHandler.getModItem(EnderIO.modID, "blockFusedQuartz", 1L),
                    500,
                    30);
            GT_Values.RA.addAlloySmelterRecipe(
                    Materials.CertusQuartz.getDust(2),
                    Materials.Quartzite.getDust(2),
                    GT_ModHandler.getModItem(EnderIO.modID, "blockFusedQuartz", 1L),
                    500,
                    30);
            GT_Values.RA.addAlloySmelterRecipe(
                    Materials.NetherQuartz.getDust(2),
                    Materials.Quartzite.getDust(2),
                    GT_ModHandler.getModItem(EnderIO.modID, "blockFusedQuartz", 1L),
                    500,
                    30);
            GT_Values.RA.addAlloySmelterRecipe(
                    Materials.CertusQuartz.getDust(1),
                    Materials.BorosilicateGlass.getDust(1),
                    GT_ModHandler.getModItem(EnderIO.modID, "blockFusedQuartz", 1L),
                    500,
                    90);
            GT_Values.RA.addAlloySmelterRecipe(
                    Materials.NetherQuartz.getDust(1),
                    Materials.BorosilicateGlass.getDust(1),
                    GT_ModHandler.getModItem(EnderIO.modID, "blockFusedQuartz", 1L),
                    500,
                    90);

            GT_Values.RA.addAlloySmelterRecipe(
                    Materials.Glass.getDust(3),
                    GT_Utility.getIntegratedCircuit(1),
                    GT_ModHandler.getModItem(EnderIO.modID, "blockFusedQuartz", 1L, 1),
                    500,
                    30);
            GT_Values.RA.addAlloySmelterRecipe(
                    Materials.Quartzite.getDust(4),
                    GT_Utility.getIntegratedCircuit(1),
                    GT_ModHandler.getModItem(EnderIO.modID, "blockFusedQuartz", 1L, 1),
                    500,
                    30);
            GT_Values.RA.addAlloySmelterRecipe(
                    Materials.BorosilicateGlass.getDust(1),
                    GT_Utility.getIntegratedCircuit(1),
                    GT_ModHandler.getModItem(EnderIO.modID, "blockFusedQuartz", 2L, 1),
                    500,
                    90);

            GT_Values.RA.addAlloySmelterRecipe(
                    GT_ModHandler.getModItem(EnderIO.modID, "blockFusedQuartz", 1L, 1),
                    Materials.Glowstone.getDust(4),
                    GT_ModHandler.getModItem(EnderIO.modID, "blockFusedQuartz", 1L, 3),
                    500,
                    30);
            GT_Values.RA.addAlloySmelterRecipe(
                    GT_ModHandler.getModItem(EnderIO.modID, "blockFusedQuartz", 1L, 1),
                    new ItemStack(Blocks.glowstone),
                    GT_ModHandler.getModItem(EnderIO.modID, "blockFusedQuartz", 1L, 3),
                    500,
                    30);

            for (int i = 0; i < OreDictionary.getOres("dyeBlack").size(); i++) {
                GT_Values.RA.addAlloySmelterRecipe(
                        GT_ModHandler.getModItem(EnderIO.modID, "blockFusedQuartz", 1L, 1),
                        OreDictionary.getOres("dyeBlack").get(i).splitStack(4),
                        GT_ModHandler.getModItem(EnderIO.modID, "blockFusedQuartz", 1L, 5),
                        500,
                        30);
            }
        }

        if (TinkerConstruct.isModLoaded()) {
            GT_Values.RA.addAlloySmelterRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 3L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "materials", 4L, 14),
                    100,
                    120);
        }

    }

}
