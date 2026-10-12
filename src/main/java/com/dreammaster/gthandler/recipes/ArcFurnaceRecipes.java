package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.recipe.RecipeMaps.arcFurnaceRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeConstants.UniversalArcFurnace;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import goodgenerator.util.ItemRefer;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;

public class ArcFurnaceRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Steel, Shapes.nugget, 2))
                .duration(2 * SECONDS + 10 * TICKS).eut(90).addTo(UniversalArcFurnace);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.sand, 1, 0))
                .itemOutputs(new ItemStack(Blocks.glass, 2)).duration(1 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(UniversalArcFurnace);

        // red sand
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.sand, 1, 1))
                .itemOutputs(new ItemStack(Blocks.glass, 2), MaterialLibAPI.getStack(Materials.Ash, Shapes.dustTiny, 1))
                .duration(1 * SECONDS).eut(TierEU.RECIPE_MV).addTo(UniversalArcFurnace);

        // Awful dimensionally transcendent residue recipe for mk5 fusion pre-dtpf (mostly a meme)
        GTValues.RA.stdBuilder().itemInputs(ItemRefer.Radioactive_Waste.get(64))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.ExcitedDTEC, FluidShapes.fluidLiquid, 1000))
                .fluidOutputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.DimensionallyTranscendentResidue, FluidShapes.fluidLiquid, 50))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_UEV / 2).addTo(arcFurnaceRecipes);

        if (GalacticraftAmunRa.isModLoaded()) {
            // Zero Point Module recycling

            GTValues.RA.stdBuilder().itemInputs(ItemList.ZPM.get(1))
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.dust, 8),
                            MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.dust, 32),
                            MaterialLibAPI.getStack(Materials.Firestone, Shapes.plate, 32),
                            MaterialLibAPI.getStack(Materials.Dilithium, Shapes.dust, 32),
                            MaterialLibAPI.getStack(Materials.Ichorium, Shapes.itemCasing, 16),
                            MaterialLibAPI.getStack(Materials.Ardite, Shapes.plateDense, 64),
                            getModItem(GalacticraftAmunRa.ID, "item.baseItem", 4, 3),
                            NHItemList.ChaoticDust.get(2),
                            getModItem(GalacticraftAmunRa.ID, "item.baseItem", 1, 26))
                    .outputChances(5000, 5000, 5000, 5000, 5000, 3000, 2000, 500, 250)
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.CelestialTungsten, FluidShapes.fluidMolten, 144))
                    .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Tungsten, FluidShapes.fluidMolten, 144))
                    .duration(50 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(arcFurnaceRecipes);
        }
    }
}
