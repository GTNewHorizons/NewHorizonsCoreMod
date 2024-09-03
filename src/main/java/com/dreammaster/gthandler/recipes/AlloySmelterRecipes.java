package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IScriptLoader.wildcard;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

public class AlloySmelterRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.MicaBasedSheet.get(4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L))
                .itemOutputs(CustomItemList.MicaInsulatorSheet.get(4L)).duration(20 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).duration(60 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).duration(60 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).duration(60 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.MicaBasedSheet.get(4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L))
                .itemOutputs(CustomItemList.MicaInsulatorSheet.get(4L)).duration(20 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).duration(60 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).duration(60 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).duration(60 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.MicaBasedSheet.get(4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L))
                .itemOutputs(CustomItemList.MicaInsulatorSheet.get(4L)).duration(20 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).duration(60 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).duration(60 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).duration(60 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.MicaBasedSheet.get(4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 2L))
                .itemOutputs(CustomItemList.MicaInsulatorSheet.get(4L)).duration(20 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 2L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).duration(60 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 2L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).duration(60 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 2L))
                .itemOutputs(CustomItemList.AluminoSilicateWool.get(2L)).duration(60 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1),
                        ItemList.Shape_Mold_Ball.get(0))
                .itemOutputs(ItemList.Circuit_Parts_Glass_Tube.get(1L)).duration(6 * SECONDS).eut(16)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTModHandler.getModItem(IndustrialCraft2.ID, "itemPartIridium", 2L),
                        ItemList.Shape_Mold_Casing.get(0))
                .itemOutputs(com.dreammaster.item.ItemList.IridiumAlloyItemCasing.getIS().splitStack(3))
                .duration(60 * SECONDS).eut(256).addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.sand, 1, wildcard), new ItemStack(Items.clay_ball))
                .itemOutputs(com.dreammaster.item.ItemList.CokeOvenBrick.getIS().splitStack(2)).duration(10 * SECONDS)
                .eut(8).addTo(alloySmelterRecipes);

        if (EnderIO.isModLoaded()) {
            // EnderIO Fused Quartz and Glass

            GTValues.RA.stdBuilder().itemInputs(Materials.CertusQuartz.getDust(2), Materials.Glass.getDust(1))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder().itemInputs(Materials.NetherQuartz.getDust(2), Materials.Glass.getDust(1))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder().itemInputs(Materials.CertusQuartz.getDust(2), Materials.Quartzite.getDust(2))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder().itemInputs(Materials.NetherQuartz.getDust(2), Materials.Quartzite.getDust(2))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(Materials.CertusQuartz.getDust(1), Materials.BorosilicateGlass.getDust(1))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).duration(25 * SECONDS)
                    .eut(90).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(Materials.NetherQuartz.getDust(1), Materials.BorosilicateGlass.getDust(1))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).duration(25 * SECONDS)
                    .eut(90).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder().itemInputs(Materials.Glass.getDust(3), GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 1)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder().itemInputs(Materials.Quartzite.getDust(4), GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 1)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(Materials.BorosilicateGlass.getDust(1), GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 2L, 1)).duration(25 * SECONDS)
                    .eut(90).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 1),
                            Materials.Glowstone.getDust(4))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 3)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 1),
                            new ItemStack(Blocks.glowstone))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 3)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            for (int i = 0; i < OreDictionary.getOres("dyeBlack").size(); i++) {

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 1),
                                OreDictionary.getOres("dyeBlack").get(i).splitStack(4))
                        .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 5))
                        .duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            }
        }

        if (TinkerConstruct.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 3L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "materials", 4L, 14)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(alloySmelterRecipes);

        }

    }

}
