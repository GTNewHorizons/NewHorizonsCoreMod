package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.ZTones;
import static gregtech.api.recipe.RecipeMaps.hammerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.block.BlockList;
import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.objects.OreDictItemStack;
import gregtech.api.util.GTOreDictUnificator;

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

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ChromaticGemExquisite.get())
                .itemOutputs(NHItemList.ChromaticGemFlawless.get(2)).duration(2 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ChromaticGemFlawless.get())
                .itemOutputs(NHItemList.ChromaticGem.get(2)).duration(2 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(hammerRecipes);

        // Uncompressed coal variants
        GTValues.RA.stdBuilder().itemInputs(BlockList.CompressedCharcoal.get(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.block, Materials.Charcoal, 9)).duration(15 * SECONDS)
                .eut(2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.CompressedCoal.get(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.block, Materials.Coal, 9)).duration(15 * SECONDS)
                .eut(2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.CompressedCoalCoke.get(1))
                .itemOutputs(getModItem(Railcraft.ID, "cube", 9, 0)).duration(15 * SECONDS).eut(2).addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(BlockList.DoubleCompressedCharcoal.get(1))
                .itemOutputs(BlockList.CompressedCharcoal.get(9)).duration(15 * SECONDS).eut(2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.DoubleCompressedCoal.get(1))
                .itemOutputs(BlockList.CompressedCoal.get(9)).duration(15 * SECONDS).eut(2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.DoubleCompressedCoalCoke.get(1))
                .itemOutputs(BlockList.CompressedCoalCoke.get(9)).duration(15 * SECONDS).eut(2).addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(BlockList.TripleCompressedCharcoal.get(1))
                .itemOutputs(BlockList.DoubleCompressedCharcoal.get(9)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.TripleCompressedCoal.get(1))
                .itemOutputs(BlockList.DoubleCompressedCoal.get(9)).duration(15 * SECONDS).eut(2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.TripleCompressedCoalCoke.get(1))
                .itemOutputs(BlockList.DoubleCompressedCoalCoke.get(9)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(BlockList.QuadrupleCompressedCharcoal.get(1))
                .itemOutputs(BlockList.TripleCompressedCharcoal.get(9)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.QuadrupleCompressedCoal.get(1))
                .itemOutputs(BlockList.TripleCompressedCoal.get(9)).duration(15 * SECONDS).eut(2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.QuadrupleCompressedCoalCoke.get(1))
                .itemOutputs(BlockList.TripleCompressedCoalCoke.get(9)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(BlockList.QuintupleCompressedCharcoal.get(1))
                .itemOutputs(BlockList.QuadrupleCompressedCharcoal.get(9)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.QuintupleCompressedCoal.get(1))
                .itemOutputs(BlockList.QuadrupleCompressedCoal.get(9)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(BlockList.QuintupleCompressedCoalCoke.get(1))
                .itemOutputs(BlockList.QuadrupleCompressedCoalCoke.get(9)).duration(15 * SECONDS).eut(2)
                .addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CompressedBioBall.get(1)).itemOutputs(NHItemList.BioBall.get())
                .duration(15 * SECONDS).eut(2).addTo(hammerRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.BioCarbonPlate.get(1))
                .itemOutputs(NHItemList.BioOrganicMesh.get(1)).duration(15 * SECONDS).eut(2).addTo(hammerRecipes);

        if (TinkerConstruct.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "Smeltery", 1, 2))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 3, 2)).duration(1 * SECONDS)
                    .eut(TierEU.RECIPE_LV / 2).addTo(hammerRecipes);
        }

        if (ZTones.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.coal, 1, 0))
                    .itemOutputs(getModItem(ZTones.ID, "minicoal", 9, 0)).duration(2 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_ULV).addTo(hammerRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.coal, 1, 1))
                    .itemOutputs(getModItem(ZTones.ID, "minicharcoal", 9, 0)).duration(2 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_ULV).addTo(hammerRecipes);
        }

        if (Thaumcraft.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3))
                    .itemOutputs(NHItemList.PrimordialPearlFragment.get(3)).duration(16 * TICKS).eut(TierEU.RECIPE_IV)
                    .addTo(hammerRecipes);
        }
        if (Botania.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(BlockList.Gaia.get(1))
                    .itemOutputs(getModItem(Botania.ID, "manaResource", 32, 5))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("prismaticacid"), 1152)).duration(16 * TICKS)
                    .eut(TierEU.RECIPE_LuV).addTo(hammerRecipes);

            GTValues.RA.stdBuilder().itemInputs(BlockList.ManaPearl.get(1))
                    .itemOutputs(getModItem(Botania.ID, "manaResource", 9, 1)).duration(16 * TICKS)
                    .eut(TierEU.RECIPE_LV).addTo(hammerRecipes);

            GTValues.RA.stdBuilder().itemInputs(BlockList.ManaPowder.get(1))
                    .itemOutputs(getModItem(Botania.ID, "manaResource", 9, 23)).duration(16 * TICKS)
                    .eut(TierEU.RECIPE_LV).addTo(hammerRecipes);

            GTValues.RA.stdBuilder().itemInputs(BlockList.PixieDust.get(1))
                    .itemOutputs(getModItem(Botania.ID, "manaResource", 9, 8)).duration(16 * TICKS)
                    .eut(TierEU.RECIPE_LV).addTo(hammerRecipes);
        }
        if (Railcraft.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian, 1))
                    .itemOutputs(getModItem(Railcraft.ID, "cube", 1, 4)).duration(2 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(hammerRecipes);
        }

        GTValues.RA.stdBuilder().itemInputs(new OreDictItemStack("record", 1))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(hammerRecipes);

        // Raw optical chip
        int chip_duration_ticks = 10 * SECONDS;
        long chip_eu_per_tick = TierEU.RECIPE_UEV;

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Silicon_Wafer7.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_Optical.get(8))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Grade7PurifiedWater, FluidShapes.fluidLiquid, (int) (100L)))
                .duration(chip_duration_ticks).eut(chip_eu_per_tick).addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Silicon_Wafer7.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_Optical.get(12))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Grade8PurifiedWater, FluidShapes.fluidLiquid, (int) (100L)))
                .duration(chip_duration_ticks / 2).eut(chip_eu_per_tick).addTo(hammerRecipes);

        // The charged certus quartz dust is this mod's item, so GregTech's crushed ore pass does not cover it.
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.crushedCentrifuged, Materials.ChargedCertusQuartz, 1))
                .itemOutputs(NHItemList.ChargedCertusQuartzDust.get(1)).duration(10 * TICKS).eut(TierEU.RECIPE_LV / 2)
                .addTo(hammerRecipes);
    }
}
