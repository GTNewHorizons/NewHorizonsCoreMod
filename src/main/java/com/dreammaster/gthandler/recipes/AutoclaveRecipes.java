package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.EnderZoo;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.Gendustry;
import static gregtech.api.recipe.RecipeMaps.autoclaveRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.util.GTModHandler;
import gtPlusPlus.core.material.MaterialsElements;

public class AutoclaveRecipes implements Runnable {

    @Override
    public void run() {
        spaceRecipes();

        GTValues.RA.stdBuilder().itemInputs(NHItemList.LapotronDust.get(30))
                .itemOutputs(NHItemList.RawLapotronCrystal.get()).outputChances(10000)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.EnergeticAlloy,
                                Materials2FluidShapes.fluidMolten,
                                (int) (576L)))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_HV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.LapotronDust.get(30))
                .itemOutputs(NHItemList.RawLapotronCrystal.get()).outputChances(10000)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.VibrantAlloy,
                                Materials2FluidShapes.fluidMolten,
                                (int) (288L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EnderZoo.ID, "enderFragment", 4, 0)).circuit(1)
                .itemOutputs(new ItemStack(Items.ender_pearl, 1, 0)).outputChances(8000)
                .fluidInputs(Materials.Water.getFluid(100)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EnderZoo.ID, "enderFragment", 4, 0)).circuit(2)
                .itemOutputs(new ItemStack(Items.ender_pearl, 1, 0)).outputChances(9000)
                .fluidInputs(GTModHandler.getDistilledWater(50L)).duration(45 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EnderZoo.ID, "enderFragment", 4, 0)).circuit(3)
                .itemOutputs(new ItemStack(Items.ender_pearl, 1, 0)).outputChances(10000)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials2Materials.Void, Materials2FluidShapes.fluidMolten, (int) (18)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.EnderPearl, Materials2Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(new ItemStack(Items.ender_pearl, 1, 0)).outputChances(8000)
                .fluidInputs(Materials.Water.getFluid(100)).duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.EnderPearl, Materials2Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(new ItemStack(Items.ender_pearl, 1, 0)).outputChances(9000)
                .fluidInputs(GTModHandler.getDistilledWater(75L)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.EnderPearl, Materials2Shapes.dust, (int) (1L)))
                .circuit(3).itemOutputs(new ItemStack(Items.ender_pearl, 1, 0)).outputChances(10000)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials2Materials.Void, Materials2FluidShapes.fluidMolten, (int) (36)))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Parts_RawCrystalParts.get(1L))
                .itemOutputs(ItemList.Circuit_Parts_RawCrystalChip.get(1L)).outputChances(10000)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Europium,
                                Materials2FluidShapes.fluidMolten,
                                (int) (16)))
                .duration(10 * MINUTES).eut(TierEU.RECIPE_HV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.GalliumArsenide, Materials2Shapes.dust, (int) (2)))
                .itemOutputs(ItemList.GalliumArsenideCrystal.get(1L)).outputChances(8000)
                .fluidInputs(Materials.Water.getFluid(200L)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.GalliumArsenide, Materials2Shapes.dust, (int) (2)))
                .itemOutputs(ItemList.GalliumArsenideCrystal.get(1L)).outputChances(10000)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Void,
                                Materials2FluidShapes.fluidMolten,
                                (int) (36L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.GalliumArsenide, Materials2Shapes.dust, (int) (2)))
                .itemOutputs(ItemList.GalliumArsenideCrystal.get(1L)).outputChances(9000)
                .fluidInputs(GTModHandler.getDistilledWater(100L)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(autoclaveRecipes);

        if (GalacticraftMars.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Parts_RawCrystalParts.get(1L))
                    .itemOutputs(ItemList.Circuit_Parts_RawCrystalChip.get(1L)).outputChances(6000)
                    .fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 250)).duration(10 * MINUTES)
                    .eut(TierEU.RECIPE_HV).addTo(autoclaveRecipes);

        }
        if (Gendustry.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Parts_RawCrystalParts.get(1L))
                    .itemOutputs(ItemList.Circuit_Parts_RawCrystalChip.get(1L)).outputChances(8000)
                    .fluidInputs(FluidRegistry.getFluidStack("mutagen", 250)).duration(10 * MINUTES)
                    .eut(TierEU.RECIPE_HV).addTo(autoclaveRecipes);

        }

        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Silicon_Wafer6.get(1L), MaterialsElements.STANDALONE.HYPOGEN.getDust(1))
                .itemOutputs(ItemList.Circuit_Wafer_Bioware.get(1L)).outputChances(10000)
                .fluidInputs(Materials.BioMediumSterilized.getFluid(8_000L)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_UHV).addTo(autoclaveRecipes);

    }

    public static void spaceRecipes() {

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Emerald, Materials2Shapes.gemExquisite, (int) (1)))
                .itemOutputs(ItemList.Circuit_Parts_RawCrystalChip.get(1L)).outputChances(1000)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Europium,
                                Materials2FluidShapes.fluidMolten,
                                (int) (16)))
                .requiresCleanRoom().requiresLowGravity().duration(10 * MINUTES).eut(320).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Olivine, Materials2Shapes.gemExquisite, (int) (1)))
                .itemOutputs(ItemList.Circuit_Parts_RawCrystalChip.get(1L)).outputChances(1000)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Europium,
                                Materials2FluidShapes.fluidMolten,
                                (int) (16)))
                .requiresCleanRoom().requiresLowGravity().duration(10 * MINUTES).eut(320).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Emerald, Materials2Shapes.gemExquisite, (int) (12)))
                .itemOutputs(ItemList.Tool_DataOrb.get(1L)).outputChances(10000)
                .fluidInputs(Materials.UUMatter.getFluid(250L)).requiresCleanRoom().requiresLowGravity()
                .duration(10 * MINUTES).eut(TierEU.RECIPE_EV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Olivine, Materials2Shapes.gemExquisite, (int) (12)))
                .itemOutputs(ItemList.Tool_DataOrb.get(1L)).outputChances(10000)
                .fluidInputs(Materials.UUMatter.getFluid(250L)).requiresCleanRoom().requiresLowGravity()
                .duration(10 * MINUTES).eut(TierEU.RECIPE_EV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.StargateDustAncients.get().splitStack(64))
                .itemOutputs(NHItemList.StargateCrystalAncients.get()).outputChances(10000)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Silver,
                                Materials2FluidShapes.fluidPlasma,
                                (int) (8000L)))
                .requiresCleanRoom().requiresLowGravity().duration(3 * MINUTES).eut(TierEU.RECIPE_ZPM)
                .addTo(autoclaveRecipes);
    }
}
