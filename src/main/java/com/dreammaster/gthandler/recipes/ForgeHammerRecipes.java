package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.ZTones;
import static gregtech.api.recipe.RecipeMaps.hammerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.block.BlockList;
import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.item.NHItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;

public class ForgeHammerRecipes implements Runnable {

    ItemStack missing = new ItemStack(Blocks.fire);

    @Override
    public void run() {
        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Parts_RawCrystalChip.get(1L))
                .itemOutputs(ItemList.Circuit_Parts_RawCrystalParts.get(9)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.GalliumArsenideCrystal.get(1L))
                .itemOutputs(ItemList.GalliumArsenideCrystalSmallPart.get(4L)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.ChromaticGemExquisite.get(1))
                .itemOutputs(CustomItemList.ChromaticGemFlawless.get(2)).duration(2 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.ChromaticGemFlawless.get(1))
                .itemOutputs(CustomItemList.ChromaticGem.get(2)).duration(2 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(hammerRecipes);

        // Uncompressed coal variants
        GTValues.RA.stdBuilder().itemInputs(BlockList.CompressedCharcoal.getIS(1))
                .itemOutputs(Materials.Charcoal.getBlocks(9)).duration(15 * SECONDS).eut(2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.CompressedCoal.getIS(1)).itemOutputs(Materials.Coal.getBlocks(9))
                .duration(15 * SECONDS).eut(2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.CompressedCoalCoke.getIS(1))
                .itemOutputs(getModItem(Railcraft.ID, "cube", 9, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(BlockList.DoubleCompressedCharcoal.getIS(1))
                .itemOutputs(BlockList.CompressedCharcoal.getIS(9)).duration(15 * SECONDS).eut(2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.DoubleCompressedCoal.getIS(1))
                .itemOutputs(BlockList.CompressedCoal.getIS(9)).duration(15 * SECONDS).eut(2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.DoubleCompressedCoalCoke.getIS(1))
                .itemOutputs(BlockList.CompressedCoalCoke.getIS(9)).duration(15 * SECONDS).eut(2).addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(BlockList.TripleCompressedCharcoal.getIS(1))
                .itemOutputs(BlockList.DoubleCompressedCharcoal.getIS(9)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.TripleCompressedCoal.getIS(1))
                .itemOutputs(BlockList.DoubleCompressedCoal.getIS(9)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.TripleCompressedCoalCoke.getIS(1))
                .itemOutputs(BlockList.DoubleCompressedCoalCoke.getIS(9)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(BlockList.QuadrupleCompressedCharcoal.getIS(1))
                .itemOutputs(BlockList.TripleCompressedCharcoal.getIS(9)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.QuadrupleCompressedCoal.getIS(1))
                .itemOutputs(BlockList.TripleCompressedCoal.getIS(9)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.QuadrupleCompressedCoalCoke.getIS(1))
                .itemOutputs(BlockList.TripleCompressedCoalCoke.getIS(9)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(BlockList.QuintupleCompressedCharcoal.getIS(1))
                .itemOutputs(BlockList.QuadrupleCompressedCharcoal.getIS(9)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.QuintupleCompressedCoal.getIS(1))
                .itemOutputs(BlockList.QuadrupleCompressedCoal.getIS(9)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.QuintupleCompressedCoalCoke.getIS(1))
                .itemOutputs(BlockList.QuadrupleCompressedCoalCoke.getIS(9)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CompressedBioBall.getIS(1))
                .itemOutputs(CustomItemList.BioBall.get(1L)).duration(15 * SECONDS).eut(2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.BioCarbonPlate.getIS(1))
                .itemOutputs(NHItemList.BioOrganicMesh.getIS(1)).duration(15 * SECONDS).eut(2).addTo(hammerRecipes);

        if (TinkerConstruct.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "Smeltery", 1L, 2))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "materials", 3L, 2)).duration(1 * SECONDS)
                    .eut(16).addTo(hammerRecipes);
        }

        if (ZTones.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.coal, 1, 0))
                    .itemOutputs(GTModHandler.getModItem(ZTones.ID, "minicoal", 9L, 0))
                    .duration(2 * SECONDS + 10 * TICKS).eut(8).addTo(hammerRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.coal, 1, 1))
                    .itemOutputs(GTModHandler.getModItem(ZTones.ID, "minicharcoal", 9L, 0))
                    .duration(2 * SECONDS + 10 * TICKS).eut(8).addTo(hammerRecipes);
        }

        if (Thaumcraft.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(Thaumcraft.ID, "ItemEldritchObject", 1L, 3))
                    .itemOutputs(CustomItemList.PrimordialPearlFragment.get(3L)).duration(16 * TICKS)
                    .eut(TierEU.RECIPE_IV).addTo(hammerRecipes);
        }
        if (Botania.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(BlockList.Gaia.getIS(1))
                    .itemOutputs(GTModHandler.getModItem(Botania.ID, "manaResource", 32L, 5))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("prismaticacid"), 1152)).duration(16 * TICKS)
                    .eut(TierEU.RECIPE_LuV).addTo(hammerRecipes);

            GTValues.RA.stdBuilder().itemInputs(BlockList.ManaPearl.getIS(1))
                    .itemOutputs(GTModHandler.getModItem(Botania.ID, "manaResource", 9L, 1)).duration(16 * TICKS)
                    .eut(TierEU.RECIPE_LV).addTo(hammerRecipes);

            GTValues.RA.stdBuilder().itemInputs(BlockList.ManaPowder.getIS(1))
                    .itemOutputs(GTModHandler.getModItem(Botania.ID, "manaResource", 9L, 23)).duration(16 * TICKS)
                    .eut(TierEU.RECIPE_LV).addTo(hammerRecipes);

            GTValues.RA.stdBuilder().itemInputs(BlockList.PixieDust.getIS(1))
                    .itemOutputs(GTModHandler.getModItem(Botania.ID, "manaResource", 9L, 8)).duration(16 * TICKS)
                    .eut(TierEU.RECIPE_LV).addTo(hammerRecipes);
        }
        if (Railcraft.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian, 1))
                    .itemOutputs(getModItem(Railcraft.ID, "cube", 1, 4, missing)).duration(2 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(hammerRecipes);
        }

        // Raw optical chip
        int chip_duration_ticks = 10 * SECONDS;
        long chip_eu_per_tick = TierEU.RECIPE_UEV;

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Silicon_Wafer7.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_Optical.get(8))
                .fluidInputs(Materials.Grade7PurifiedWater.getFluid(100L)).duration(chip_duration_ticks)
                .eut(chip_eu_per_tick).addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Silicon_Wafer7.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_Optical.get(12))
                .fluidInputs(Materials.Grade8PurifiedWater.getFluid(100L)).duration(chip_duration_ticks / 2)
                .eut(chip_eu_per_tick).addTo(hammerRecipes);
    }
}
