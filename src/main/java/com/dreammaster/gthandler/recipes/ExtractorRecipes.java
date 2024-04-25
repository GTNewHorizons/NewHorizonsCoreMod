package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.SGCraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class ExtractorRecipes implements Runnable {

    @Override
    public void run() {
        if (IndustrialCraft2.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemCellHydrant", 1L, GT_Values.W))
                    .itemOutputs(ItemList.Cell_Empty.get(1L)).duration(5 * SECONDS).eut(2).addTo(extractorRecipes);
        }

        if (GalaxySpace.isModLoaded() && SGCraft.isModLoaded()) {
            for (int i = 0; i < 6; ++i) {

                GT_Values.RA.stdBuilder()
                        .itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "tcetiedandelions", 64L, i))
                        .itemOutputs(com.dreammaster.item.ItemList.TCetiESeaweedExtract.getIS()).duration(3 * MINUTES)
                        .eut(262144).addTo(extractorRecipes);

            }
        }

        if (TinkerConstruct.isModLoaded()) {

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "Smeltery", 1L, 2))
                    .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 4L, 2))
                    .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "slime.sapling", 1L, 0))
                    .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "strangeFood", 1L, 0))
                    .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "slime.gel", 1L, 0))
                    .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "strangeFood", 4L, 0))
                    .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "slime.gel", 1L, 1))
                    .itemOutputs(new ItemStack(Items.slime_ball, 4, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "slime.leaves", 16L, 0))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 1L))
                    .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        }

        if (BiomesOPlenty.isModLoaded()) {

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(BiomesOPlenty.ID, "flowers", 2L, 3))
                    .itemOutputs(new ItemStack(Items.glowstone_dust, 1, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(BiomesOPlenty.ID, "mushrooms", 2L, 3))
                    .itemOutputs(new ItemStack(Items.glowstone_dust, 1, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(BiomesOPlenty.ID, "coral1", 2L, 15))
                    .itemOutputs(new ItemStack(Items.glowstone_dust, 1, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(BiomesOPlenty.ID, "flowers", 2L, 13))
                    .itemOutputs(new ItemStack(Items.spider_eye, 1, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(BiomesOPlenty.ID, "mudball", 1L, 0))
                    .itemOutputs(new ItemStack(Items.clay_ball, 1, 0)).duration(10 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

        }

        if (PamsHarvestCraft.isModLoaded()) {

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "pamMaple", 1L, 0))
                    .itemOutputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "maplesyrupItem", 1L, 0))
                    .duration(10 * SECONDS).eut(2).addTo(extractorRecipes);

        }

        if (Natura.isModLoaded()) {

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "florasapling", 1L, 5))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "floraleavesnocolor", 4L, 2))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "bloodwood", 1L, 0))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "bloodwood", 1L, 15))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "florasapling", 2L, 7))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gunpowder, 1L))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "Dark Leaves", 8L, 3))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gunpowder, 1L))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "Dark Tree", 2L, 1))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gunpowder, 1L))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "florasapling", 2L, 6))
                    .itemOutputs(ItemList.IC2_Fertilizer.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "Dark Leaves", 8L, 0))
                    .itemOutputs(ItemList.IC2_Fertilizer.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "Dark Tree", 2L, 0))
                    .itemOutputs(ItemList.IC2_Fertilizer.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "Natura.netherfood", 1L, 0))
                    .itemOutputs(ItemList.IC2_Fertilizer.get(4)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "florasapling", 2L, 4))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bone, 1L)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "floraleavesnocolor", 4L, 1))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bone, 1L)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "tree", 2L, 2))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bone, 1L)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "Glowshroom", 2L, 0))
                    .itemOutputs(new ItemStack(Items.glowstone_dust, 1, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "Glowshroom", 2L, 1))
                    .itemOutputs(new ItemStack(Items.glowstone_dust, 1, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Natura.ID, "Glowshroom", 2L, 2))
                    .itemOutputs(new ItemStack(Items.glowstone_dust, 1, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

        }

    }
}
