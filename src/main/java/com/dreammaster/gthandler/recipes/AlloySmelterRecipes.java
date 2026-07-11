package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IScriptLoader.wildcard;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.objects.OreDictItemStack;
import gtPlusPlus.core.material.MaterialsAlloy;

public class AlloySmelterRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.MicaBasedSheet.get(4),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (1L)))
                .itemOutputs(NHItemList.MicaInsulatorSheet.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ruby, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (1L)))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Sapphire, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (1L)))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.GreenSapphire, Materials2Shapes.shapeDust, (int) (1L)),
                MaterialLibAPI.getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (1L)))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.MicaBasedSheet.get(4),
                        MaterialLibAPI
                                .getStack(Materials2Materials.NetherQuartz, Materials2Shapes.shapeDust, (int) (1L)))
                .itemOutputs(NHItemList.MicaInsulatorSheet.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ruby, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.NetherQuartz, Materials2Shapes.shapeDust, (int) (1L)))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Sapphire, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.NetherQuartz, Materials2Shapes.shapeDust, (int) (1L)))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.GreenSapphire, Materials2Shapes.shapeDust, (int) (1L)),
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.shapeDust, (int) (1L)))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.MicaBasedSheet.get(4),
                        MaterialLibAPI
                                .getStack(Materials2Materials.CertusQuartz, Materials2Shapes.shapeDust, (int) (1L)))
                .itemOutputs(NHItemList.MicaInsulatorSheet.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ruby, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.CertusQuartz, Materials2Shapes.shapeDust, (int) (1L)))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Sapphire, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.CertusQuartz, Materials2Shapes.shapeDust, (int) (1L)))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.GreenSapphire, Materials2Shapes.shapeDust, (int) (1L)),
                MaterialLibAPI.getStack(Materials2Materials.CertusQuartz, Materials2Shapes.shapeDust, (int) (1L)))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.MicaBasedSheet.get(4),
                        MaterialLibAPI.getStack(Materials2Materials.Quartzite, Materials2Shapes.shapeDust, (int) (2L)))
                .itemOutputs(NHItemList.MicaInsulatorSheet.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ruby, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Quartzite, Materials2Shapes.shapeDust, (int) (2L)))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Sapphire, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Quartzite, Materials2Shapes.shapeDust, (int) (2L)))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.GreenSapphire, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Quartzite, Materials2Shapes.shapeDust, (int) (2L)))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.shapeDust, (int) (1)),
                        ItemList.Shape_Mold_Ball.get(0))
                .itemOutputs(ItemList.Circuit_Parts_Glass_Tube.get(1L)).duration(6 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(IndustrialCraft2.ID, "itemPartIridium", 2), ItemList.Shape_Mold_Casing.get(0))
                .itemOutputs(NHItemList.IridiumAlloyItemCasing.get().splitStack(3)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(alloySmelterRecipes);

        // GT++ Recipes
        ItemStack[] tumbagaInputs = {
                MaterialLibAPI.getStack(Materials2Materials.Gold, Materials2Shapes.shapeDust, (int) (7)), // 0
                Materials.Gold.getIngots(7), // 1
                MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.shapeDust, (int) (3)), // 2
                MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.shapeIngot, (int) (3)) // 3
        };
        int[][] tumbagaCombos = { { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
        for (int[] pair : tumbagaCombos) {
            GTValues.RA.stdBuilder().itemInputs(tumbagaInputs[pair[0]], tumbagaInputs[pair[1]])
                    .itemOutputs(MaterialsAlloy.TUMBAGA.getIngot(10)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(alloySmelterRecipes);
        }

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.sand, 1, wildcard), new ItemStack(Items.clay_ball))
                .itemOutputs(NHItemList.CokeOvenBrick.get().splitStack(2)).duration(10 * SECONDS).eut(TierEU.RECIPE_ULV)
                .addTo(alloySmelterRecipes);

        if (EnderIO.isModLoaded()) {
            // EnderIO Fused Quartz and Glass

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI
                                    .getStack(Materials2Materials.CertusQuartz, Materials2Shapes.shapeDust, (int) (2)),
                            MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.shapeDust, (int) (1)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI
                                    .getStack(Materials2Materials.NetherQuartz, Materials2Shapes.shapeDust, (int) (2)),
                            MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.shapeDust, (int) (1)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder().itemInputs(
                    MaterialLibAPI.getStack(Materials2Materials.CertusQuartz, Materials2Shapes.shapeDust, (int) (2)),
                    MaterialLibAPI.getStack(Materials2Materials.Quartzite, Materials2Shapes.shapeDust, (int) (2)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder().itemInputs(
                    MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.shapeDust, (int) (2)),
                    MaterialLibAPI.getStack(Materials2Materials.Quartzite, Materials2Shapes.shapeDust, (int) (2)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder().itemInputs(
                    MaterialLibAPI.getStack(Materials2Materials.CertusQuartz, Materials2Shapes.shapeDust, (int) (1)),
                    MaterialLibAPI
                            .getStack(Materials2Materials.BorosilicateGlass, Materials2Shapes.shapeDust, (int) (1)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(25 * SECONDS).eut(90)
                    .addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder().itemInputs(
                    MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.shapeDust, (int) (1)),
                    MaterialLibAPI
                            .getStack(Materials2Materials.BorosilicateGlass, Materials2Shapes.shapeDust, (int) (1)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(25 * SECONDS).eut(90)
                    .addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.shapeDust, (int) (3)))
                    .circuit(1).itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1, 1)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder().itemInputs(
                    MaterialLibAPI.getStack(Materials2Materials.Quartzite, Materials2Shapes.shapeDust, (int) (4)))
                    .circuit(1).itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1, 1)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder().itemInputs(
                    MaterialLibAPI
                            .getStack(Materials2Materials.BorosilicateGlass, Materials2Shapes.shapeDust, (int) (1)))
                    .circuit(1).itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 2, 1)).duration(25 * SECONDS)
                    .eut(90).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(EnderIO.ID, "blockFusedQuartz", 1, 1),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Glowstone, Materials2Shapes.shapeDust, (int) (4)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1, 3)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1, 1), new ItemStack(Blocks.glowstone))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1, 3)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1, 1), new OreDictItemStack("dyeBlack", 4))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1, 5)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        }

        // Sunnarium Alloys
        GTValues.RA.stdBuilder().requireMods(AdvancedSolarPanel)
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Sunnarium, Materials2Shapes.shapePlate, (int) (4L)),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 8, 0))
                .itemOutputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 1))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LuV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder().requireMods(AdvancedSolarPanel)
                .itemInputs(
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 1),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 8, 3))
                .itemOutputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 4)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder().requireMods(AdvancedSolarPanel)
                .itemInputs(
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 4),
                        MaterialLibAPI
                                .getStack(Materials2Materials.Naquadria, Materials2Shapes.shapePlateDense, (int) (1L)))
                .itemOutputs(NHItemList.EnrichedNaquadriaSunnariumAlloy.get(1)).duration(12 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_UV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EnrichedNaquadriaSunnariumAlloy.get(1),
                        MaterialLibAPI
                                .getStack(Materials2Materials.Neutronium, Materials2Shapes.shapePlateDense, (int) (1L)))
                .itemOutputs(NHItemList.EnrichedNaquadriaNeutroniumSunnariumAlloy.get(1)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_UHV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EnrichedNaquadriaNeutroniumSunnariumAlloy.get(1),
                        MaterialLibAPI
                                .getStack(Materials2Materials.Bedrockium, Materials2Shapes.shapePlate, (int) (18)))
                .itemOutputs(NHItemList.EnrichedXSunnariumAlloy.get(1)).duration(17 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_UEV).addTo(alloySmelterRecipes);
    }

}
