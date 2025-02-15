package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.RemoteIO;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.QFT_CATALYST;
import static gregtech.api.util.GTRecipeConstants.QFT_FOCUS_TIER;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.quantumForceTransformerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.item.NHItemList;

import cpw.mods.fml.common.Optional;
import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.item.chemistry.GenericChem;
import gtPlusPlus.core.material.MaterialsAlloy;
import gtPlusPlus.xmod.forestry.bees.items.FRItemRegistry;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;

public class ScriptGregtechPlusPlus implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "GT++";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Mods.GTPlusPlus.ID,
                Forestry.ID,
                IndustrialCraft2.ID,
                IronTanks.ID,
                RemoteIO.ID,
                EternalSingularity.ID,
                GregTech.ID);
    }

    @Override
    public void loadRecipes() {

        addShapedRecipe(
                MaterialsAlloy.TUMBAGA.getRod(1),
                "craftingToolFile",
                null,
                null,
                null,
                MaterialsAlloy.TUMBAGA.getIngot(1),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                MaterialsAlloy.TUMBAGA.getFrameBox(2),
                MaterialsAlloy.TUMBAGA.getRod(1),
                MaterialsAlloy.TUMBAGA.getRod(1),
                MaterialsAlloy.TUMBAGA.getRod(1),
                MaterialsAlloy.TUMBAGA.getRod(1),
                "craftingToolWrench",
                MaterialsAlloy.TUMBAGA.getRod(1),
                MaterialsAlloy.TUMBAGA.getRod(1),
                MaterialsAlloy.TUMBAGA.getRod(1),
                MaterialsAlloy.TUMBAGA.getRod(1));
        addShapedRecipe(
                MaterialsAlloy.TUMBAGA.getGear(1),
                MaterialsAlloy.TUMBAGA.getRod(1),
                MaterialsAlloy.TUMBAGA.getPlate(1),
                MaterialsAlloy.TUMBAGA.getRod(1),
                MaterialsAlloy.TUMBAGA.getPlate(1),
                "craftingToolWrench",
                MaterialsAlloy.TUMBAGA.getPlate(1),
                MaterialsAlloy.TUMBAGA.getRod(1),
                MaterialsAlloy.TUMBAGA.getPlate(1),
                MaterialsAlloy.TUMBAGA.getRod(1));

        // Fish Trap
        addShapedRecipe(
                GregtechItemList.FishTrap.get(1),
                NHItemList.SteelBars.getIS(),
                NHItemList.SteelBars.getIS(),
                NHItemList.SteelBars.getIS(),
                NHItemList.SteelBars.getIS(),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.WroughtIron, 1),
                NHItemList.SteelBars.getIS(),
                NHItemList.SteelBars.getIS(),
                NHItemList.SteelBars.getIS(),
                NHItemList.SteelBars.getIS());

        // Shirabon and Eternity
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EternalSingularity.ID, "combined_singularity", 1, 15, missing),
                        ItemList.EnergisedTesseract.get(1))
                .itemOutputs(GTOreDictUnificator.get("dustShirabon", 64), ItemList.Timepiece.get(1))
                .fluidInputs(MaterialsUEVplus.PrimordialMatter.getFluid(1152))
                .fluidOutputs(MaterialsUEVplus.Eternity.getMolten(9216), MaterialsUEVplus.Time.getMolten(18432))
                .metadata(QFT_CATALYST, GTUtility.copyAmount(0, GenericChem.TemporalHarmonyCatalyst))
                .metadata(QFT_FOCUS_TIER, 4).duration(20 * SECONDS).eut(TierEU.RECIPE_UMV)
                .addTo(quantumForceTransformerRecipes);
        addForestryRecipes();
    }

    @Optional.Method(modid = Mods.Names.FORESTRY)
    private void addForestryRecipes() {

        // Arborist Frame
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.WoodSealed, 4),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.WoodSealed, 4),
                        GTModHandler.getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        GTModHandler.getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing))
                .fluidInputs(Materials.Redstone.getMolten(576))
                .itemOutputs(new ItemStack(FRItemRegistry.hiveFrameArborist)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Stabilization Frame
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 4),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Osmiridium, 4),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Osmiridium, 1),
                        GTModHandler.getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing))
                .fluidInputs(Materials.Redstone.getMolten(576))
                .itemOutputs(new ItemStack(FRItemRegistry.hiveFrameStalilize)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Slowing Frame
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialsAlloy.TUMBAGA.getLongRod(4),
                        MaterialsAlloy.TUMBAGA.getRod(4),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 1),
                        GTModHandler.getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing))
                .fluidInputs(Materials.Redstone.getMolten(576))
                .itemOutputs(new ItemStack(FRItemRegistry.hiveFrameSlow, 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Decaying Frame
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.WroughtIron, 4),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 4),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.WroughtIron, 1),
                        GTModHandler.getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing))
                .fluidInputs(Materials.Redstone.getMolten(576))
                .itemOutputs(new ItemStack(FRItemRegistry.hiveFrameDecay)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Working Frame
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.BlueSteel, 4),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.BlueSteel, 4),
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 1),
                        GTModHandler.getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing))
                .fluidInputs(Materials.Redstone.getMolten(576)).itemOutputs(new ItemStack(FRItemRegistry.hiveFrameBusy))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Mutagenic Frame
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Uranium235, 4),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Plutonium241, 4),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Plutonium241, 1),
                        GTModHandler.getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing))
                .fluidInputs(Materials.Redstone.getMolten(576))
                .itemOutputs(new ItemStack(FRItemRegistry.hiveFrameMutagenic)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Accelerated Frame
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Electrum, 4),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 4),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 1),
                        GTModHandler.getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing))
                .fluidInputs(Materials.Redstone.getMolten(576))
                .itemOutputs(new ItemStack(FRItemRegistry.hiveFrameAccelerated)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        addShapelessRecipe(CustomItemList.CoinBeesI.get(16L), new ItemStack(FRItemRegistry.hiveFrameVoid));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                new ItemStack(FRItemRegistry.hiveFrameAccelerated, 1, 0),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Electrum, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1L),
                'c',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Electrum, 1L),
                'd',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1L),
                'e',
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 1L),
                'f',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1L),
                'g',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Electrum, 1L),
                'h',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1L),
                'i',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Electrum, 1L));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                new ItemStack(FRItemRegistry.hiveFrameMutagenic, 1, 0),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Uranium235, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Plutonium241, 1L),
                'c',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Uranium235, 1L),
                'd',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Plutonium241, 1L),
                'e',
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Plutonium241, 1L),
                'f',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Plutonium241, 1L),
                'g',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Uranium235, 1L),
                'h',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Plutonium241, 1L),
                'i',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Uranium235, 1L));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                new ItemStack(FRItemRegistry.hiveFrameBusy),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.BlueSteel, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.BlueSteel, 1L),
                'c',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.BlueSteel, 1L),
                'd',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.BlueSteel, 1L),
                'e',
                getModItem(Minecraft.ID, "nether_star", 1, 0, missing),
                'f',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.BlueSteel, 1L),
                'g',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.BlueSteel, 1L),
                'h',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.BlueSteel, 1L),
                'i',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.BlueSteel, 1L));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                new ItemStack(FRItemRegistry.hiveFrameDecay),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.WroughtIron, 1),
                'b',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 1),
                'c',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.WroughtIron, 1),
                'd',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 1),
                'e',
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.WroughtIron, 1),
                'f',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 1),
                'g',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.WroughtIron, 1),
                'h',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 1),
                'i',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.WroughtIron, 1));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                new ItemStack(FRItemRegistry.hiveFrameSlow),
                "abc",
                "def",
                "ghi",
                'a',
                MaterialsAlloy.TUMBAGA.getLongRod(1),
                'b',
                MaterialsAlloy.TUMBAGA.getRod(1),
                'c',
                MaterialsAlloy.TUMBAGA.getLongRod(1),
                'd',
                MaterialsAlloy.TUMBAGA.getRod(1),
                'e',
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 1L),
                'f',
                MaterialsAlloy.TUMBAGA.getRod(1),
                'g',
                MaterialsAlloy.TUMBAGA.getLongRod(1),
                'h',
                MaterialsAlloy.TUMBAGA.getRod(1),
                'i',
                MaterialsAlloy.TUMBAGA.getLongRod(1));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                new ItemStack(FRItemRegistry.hiveFrameStalilize),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Osmiridium, 1L),
                'c',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 1L),
                'd',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Osmiridium, 1L),
                'e',
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Osmiridium, 1L),
                'f',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Osmiridium, 1L),
                'g',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 1L),
                'h',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Osmiridium, 1L),
                'i',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 1L));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                new ItemStack(FRItemRegistry.hiveFrameArborist),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.WoodSealed, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.WoodSealed, 1L),
                'c',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.WoodSealed, 1L),
                'd',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.WoodSealed, 1L),
                'e',
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                'f',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.WoodSealed, 1L),
                'g',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.WoodSealed, 1L),
                'h',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.WoodSealed, 1L),
                'i',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.WoodSealed, 1L));
    }
}
