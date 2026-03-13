package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.SGCraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.item.NHItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;

public class ExtractorRecipes implements Runnable {

    @Override
    public void run() {
        if (IndustrialCraft2.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemCellHydrant", 1, WILDCARD))
                    .itemOutputs(ItemList.Cell_Empty.get(1L)).duration(5 * SECONDS).eut(2).addTo(extractorRecipes);
        }

        if (GalaxySpace.isModLoaded() && SGCraft.isModLoaded()) {
            for (int i = 0; i < 6; ++i) {

                GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "tcetiedandelions", 64, i))
                        .itemOutputs(NHItemList.TCetiESeaweedExtract.get()).duration(3 * MINUTES).eut(262144)
                        .addTo(extractorRecipes);

            }
        }

        if (TinkerConstruct.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "Smeltery", 1, 2))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 4, 2)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "slime.sapling", 1, 0))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "strangeFood", 1, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "slime.gel", 1, 0))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "strangeFood", 4, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "slime.gel", 1, 1))
                    .itemOutputs(new ItemStack(Items.slime_ball, 4, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "slime.leaves", 16, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.RubberRaw, 1L))
                    .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        }

        if (BiomesOPlenty.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 2, 3))
                    .itemOutputs(new ItemStack(Items.glowstone_dust, 1, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "mushrooms", 2, 3))
                    .itemOutputs(new ItemStack(Items.glowstone_dust, 1, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "coral1", 2, 15))
                    .itemOutputs(new ItemStack(Items.glowstone_dust, 1, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 2, 13))
                    .itemOutputs(new ItemStack(Items.spider_eye, 1, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "mudball", 1, 0))
                    .itemOutputs(new ItemStack(Items.clay_ball, 1, 0)).duration(10 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

        }

        if (PamsHarvestCraft.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "pamMaple", 1, 0))
                    .itemOutputs(getModItem(PamsHarvestCraft.ID, "maplesyrupItem", 1, 0)).duration(10 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

        }

        if (Natura.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "florasapling", 1, 5))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "floraleavesnocolor", 4, 2))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "bloodwood", 1, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "bloodwood", 1, 15))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "florasapling", 2, 7))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gunpowder, 1L))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Dark Leaves", 8, 3))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gunpowder, 1L))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Dark Tree", 2, 1))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gunpowder, 1L))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "florasapling", 2, 4))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bone, 1L)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "floraleavesnocolor", 4, 1))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bone, 1L)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "tree", 2, 2))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bone, 1L)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Glowshroom", 2, 0))
                    .itemOutputs(new ItemStack(Items.glowstone_dust, 1, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Glowshroom", 2, 1))
                    .itemOutputs(new ItemStack(Items.glowstone_dust, 1, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Glowshroom", 2, 2))
                    .itemOutputs(new ItemStack(Items.glowstone_dust, 1, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(extractorRecipes);

        }

        if (GalacticraftAmunRa.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftAmunRa.ID, "tile.baseBlockRock", 1, 14))
                    .itemOutputs(getModItem(GalacticraftAmunRa.ID, "item.baseItem", 64, 26)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_UMV).addTo(extractorRecipes);
        }

    }
}
