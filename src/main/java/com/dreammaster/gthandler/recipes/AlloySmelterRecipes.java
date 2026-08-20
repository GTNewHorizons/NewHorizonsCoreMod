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
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.objects.OreDictItemStack;
import gregtech.api.util.GTOreDictUnificator;

public class AlloySmelterRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.MicaBasedSheet.get(4),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, 1))
                .itemOutputs(NHItemList.MicaInsulatorSheet.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Ruby, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, 1))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Sapphire, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, 1))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.GreenSapphire, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, 1))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.MicaBasedSheet.get(4),
                        MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, 1))
                .itemOutputs(NHItemList.MicaInsulatorSheet.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Ruby, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, 1))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Sapphire, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, 1))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.GreenSapphire, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, 1))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.MicaBasedSheet.get(4),
                        MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.dust, 1))
                .itemOutputs(NHItemList.MicaInsulatorSheet.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Ruby, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.dust, 1))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Sapphire, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.dust, 1))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.GreenSapphire, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.dust, 1))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.MicaBasedSheet.get(4),
                        MaterialLibAPI.getStack(Materials.Quartzite, Shapes.dust, 2))
                .itemOutputs(NHItemList.MicaInsulatorSheet.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Ruby, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.Quartzite, Shapes.dust, 2))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Sapphire, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.Quartzite, Shapes.dust, 2))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.GreenSapphire, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.Quartzite, Shapes.dust, 2))
                .itemOutputs(NHItemList.AluminoSilicateWool.get(2)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.Glass, Shapes.dust, 1), ItemList.Shape_Mold_Ball.get(0))
                .itemOutputs(ItemList.Circuit_Parts_Glass_Tube.get(1L)).duration(6 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(IndustrialCraft2.ID, "itemPartIridium", 2), ItemList.Shape_Mold_Casing.get(0))
                .itemOutputs(NHItemList.IridiumAlloyItemCasing.get().splitStack(3)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(alloySmelterRecipes);

        // GT++ Recipes
        ItemStack[] tumbagaInputs = { MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, 7), // 0
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Gold, 7), // 1
                MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, 3), // 2
                MaterialLibAPI.getStack(Materials.Copper, Shapes.ingot, 3) // 3
        };
        int[][] tumbagaCombos = { { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
        for (int[] pair : tumbagaCombos) {
            GTValues.RA.stdBuilder().itemInputs(tumbagaInputs[pair[0]], tumbagaInputs[pair[1]])
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Tumbaga, Shapes.ingot, 10)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        }

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.sand, 1, wildcard), new ItemStack(Items.clay_ball))
                .itemOutputs(NHItemList.CokeOvenBrick.get().splitStack(2)).duration(10 * SECONDS).eut(TierEU.RECIPE_ULV)
                .addTo(alloySmelterRecipes);

        if (EnderIO.isModLoaded()) {
            // EnderIO Fused Quartz and Glass

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.dust, 2),
                            MaterialLibAPI.getStack(Materials.Glass, Shapes.dust, 1))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, 2),
                            MaterialLibAPI.getStack(Materials.Glass, Shapes.dust, 1))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.dust, 2),
                            MaterialLibAPI.getStack(Materials.Quartzite, Shapes.dust, 2))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, 2),
                            MaterialLibAPI.getStack(Materials.Quartzite, Shapes.dust, 2))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.dust, 1),
                            MaterialLibAPI.getStack(Materials.BorosilicateGlass, Shapes.dust, 1))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(25 * SECONDS).eut(90)
                    .addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, 1),
                            MaterialLibAPI.getStack(Materials.BorosilicateGlass, Shapes.dust, 1))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(25 * SECONDS).eut(90)
                    .addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Glass, Shapes.dust, 3)).circuit(1)
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1, 1)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Quartzite, Shapes.dust, 4)).circuit(1)
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1, 1)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.BorosilicateGlass, Shapes.dust, 1))
                    .circuit(1).itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 2, 1)).duration(25 * SECONDS)
                    .eut(90).addTo(alloySmelterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(EnderIO.ID, "blockFusedQuartz", 1, 1),
                            MaterialLibAPI.getStack(Materials.Glowstone, Shapes.dust, 4))
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
                        MaterialLibAPI.getStack(Materials.Sunnarium, Shapes.plate, 4),
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
                        MaterialLibAPI.getStack(Materials.Naquadria, Shapes.plateDense, 1))
                .itemOutputs(NHItemList.EnrichedNaquadriaSunnariumAlloy.get(1)).duration(12 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_UV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EnrichedNaquadriaSunnariumAlloy.get(1),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.plateDense, 1))
                .itemOutputs(NHItemList.EnrichedNaquadriaNeutroniumSunnariumAlloy.get(1)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_UHV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EnrichedNaquadriaNeutroniumSunnariumAlloy.get(1),
                        MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.plate, 18))
                .itemOutputs(NHItemList.EnrichedXSunnariumAlloy.get(1)).duration(17 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_UEV).addTo(alloySmelterRecipes);
    }

}
