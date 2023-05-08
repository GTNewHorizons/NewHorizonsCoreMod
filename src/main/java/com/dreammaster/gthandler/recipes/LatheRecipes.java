package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sLatheRecipes;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.gthandler.GT_CoreModSupport;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class LatheRecipes implements Runnable {

    @Override
    public void run() {

        GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GTPlusPlus.ID, "itemPlateChromaticGlass", 1))
                .itemOutputs(CustomItemList.ChromaticLens.get(1)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(sLatheRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_CoreModSupport.RadoxPolymer.getPlates(1))
                .itemOutputs(CustomItemList.RadoxPolymerLens.get(1)).noFluidInputs().noFluidOutputs()
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_UEV).addTo(sLatheRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.ReinforcedGlassPLate.get(1L))
                .itemOutputs(
                        CustomItemList.ReinforcedGlassLense.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Glass, 1L))
                .noFluidInputs().noFluidOutputs().duration(20 * SECONDS).eut(16).addTo(sLatheRecipes);

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.wooden_slab, 1, 0))
                .itemOutputs(
                        new ItemStack(Items.bowl, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1))
                .noFluidInputs().noFluidOutputs().duration(2 * SECONDS + 10 * TICKS).eut(8).addTo(sLatheRecipes);

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.wooden_slab, 1, 1))
                .itemOutputs(
                        new ItemStack(Items.bowl, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1))
                .noFluidInputs().noFluidOutputs().duration(2 * SECONDS + 10 * TICKS).eut(8).addTo(sLatheRecipes);

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.wooden_slab, 1, 2))
                .itemOutputs(
                        new ItemStack(Items.bowl, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1))
                .noFluidInputs().noFluidOutputs().duration(2 * SECONDS + 10 * TICKS).eut(8).addTo(sLatheRecipes);

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.wooden_slab, 1, 3))
                .itemOutputs(
                        new ItemStack(Items.bowl, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1))
                .noFluidInputs().noFluidOutputs().duration(2 * SECONDS + 10 * TICKS).eut(8).addTo(sLatheRecipes);

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.wooden_slab, 1, 4))
                .itemOutputs(
                        new ItemStack(Items.bowl, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1))
                .noFluidInputs().noFluidOutputs().duration(2 * SECONDS + 10 * TICKS).eut(8).addTo(sLatheRecipes);

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.wooden_slab, 1, 5))
                .itemOutputs(
                        new ItemStack(Items.bowl, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1))
                .noFluidInputs().noFluidOutputs().duration(2 * SECONDS + 10 * TICKS).eut(8).addTo(sLatheRecipes);

        if (Forestry.isModLoaded()) {
            // todo: investigate why getModItem is null here
            for (int i = 0; i < 8; i++) {
                GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Forestry.ID, "slabs1", 1, i))
                        .itemOutputs(
                                new ItemStack(Items.bowl, 1),
                                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1))
                        .noFluidInputs().noFluidOutputs().duration(2 * SECONDS + 10 * TICKS).eut(8)
                        .addTo(sLatheRecipes);

                GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Forestry.ID, "slabs2", 1, i))
                        .itemOutputs(
                                new ItemStack(Items.bowl, 1),
                                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1))
                        .noFluidInputs().noFluidOutputs().duration(2 * SECONDS + 10 * TICKS).eut(8)
                        .addTo(sLatheRecipes);

                GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Forestry.ID, "slabs3", 1, i))
                        .itemOutputs(
                                new ItemStack(Items.bowl, 1),
                                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1))
                        .noFluidInputs().noFluidOutputs().duration(2 * SECONDS + 10 * TICKS).eut(8)
                        .addTo(sLatheRecipes);
            }
        }
    }
}
