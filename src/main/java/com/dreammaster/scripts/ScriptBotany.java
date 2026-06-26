package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Botany;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.forestry.ForestryHelper;
import com.dreammaster.item.NHItemList;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;

public class ScriptBotany implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Botany";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.Botany.ID, Forestry.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessRecipe(getModItem(Botany.ID, "database", 1, 0), getModItem(Botany.ID, "database", 1, 0));
        addShapedRecipe(
                getModItem(Botany.ID, "trowelWood", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "craftingToolHardHammer",
                null,
                "craftingToolFile",
                "stickWood",
                null,
                null,
                null,
                "stickWood");
        addShapedRecipe(
                getModItem(Botany.ID, "trowelStone", 1, 0),
                "plateStone",
                "craftingToolHardHammer",
                null,
                "craftingToolFile",
                "stickWood",
                null,
                null,
                null,
                "stickWood");
        addShapedRecipe(
                getModItem(Botany.ID, "trowelIron", 1, 0),
                "plateIron",
                "craftingToolHardHammer",
                null,
                "craftingToolFile",
                "stickWood",
                null,
                null,
                null,
                "stickWood");
        addShapedRecipe(
                getModItem(Botany.ID, "trowelGold", 1, 0),
                "plateGold",
                "craftingToolHardHammer",
                null,
                "craftingToolFile",
                "stickWood",
                null,
                null,
                null,
                "stickWood");
        addShapedRecipe(
                getModItem(Botany.ID, "trowelDiamond", 1, 0),
                "plateDiamond",
                "craftingToolHardHammer",
                null,
                "craftingToolFile",
                "stickWood",
                null,
                null,
                null,
                "stickWood");
        addShapelessRecipe(
                getModItem(Botany.ID, "misc", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Ash, 1L));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Ash, 1L),
                getModItem(Botany.ID, "misc", 1, 0));
        addShapelessRecipe(
                getModItem(Botany.ID, "misc", 1, 1),
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1L));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1L),
                getModItem(Botany.ID, "misc", 1, 1));
        addShapelessRecipe(
                getModItem(Botany.ID, "misc", 1, 3),
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Sulfur, 1L));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Sulfur, 1L),
                getModItem(Botany.ID, "misc", 1, 3));

        ForestryHelper.removeCarpenterRecipe(getModItem(Botany.ID, "database", 1, 0));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 1440),
                NHItemList.Display.get(),
                getModItem(Botany.ID, "database", 1, 0),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                'c',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L),
                'd',
                "itemCasingGold",
                'e',
                "circuitAdvanced",
                'f',
                "itemCasingGold",
                'g',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L),
                'h',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 1L),
                'i',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L));

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "clay", 4, 0), getModItem(Forestry.ID, "thermionicTubes", 1, 0))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "cobblestone", 4, 0),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 0))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 128))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "sand", 4, 0), getModItem(Forestry.ID, "thermionicTubes", 1, 0))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 256))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "hardened_clay", 4, 0),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 0))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 384))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "stone", 4, 0), getModItem(Forestry.ID, "thermionicTubes", 1, 0))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 512))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "sandstone", 4, 0),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 0))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 640))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "clay", 4, 0), getModItem(Forestry.ID, "thermionicTubes", 1, 1))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "cobblestone", 4, 0),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 1))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 129))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "sand", 4, 0), getModItem(Forestry.ID, "thermionicTubes", 1, 1))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 257))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "hardened_clay", 4, 0),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 1))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 385))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "stone", 4, 0), getModItem(Forestry.ID, "thermionicTubes", 1, 1))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 513))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "sandstone", 4, 0),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 1))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 641))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "clay", 4, 0), getModItem(Forestry.ID, "thermionicTubes", 1, 2))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "cobblestone", 4, 0),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 2))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 130))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "sand", 4, 0), getModItem(Forestry.ID, "thermionicTubes", 1, 2))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 258))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "hardened_clay", 4, 0),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 2))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 386))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "stone", 4, 0), getModItem(Forestry.ID, "thermionicTubes", 1, 2))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 514))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "sandstone", 4, 0),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 2))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 642))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "clay", 4, 0), getModItem(Forestry.ID, "thermionicTubes", 1, 3))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 3))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "cobblestone", 4, 0),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 3))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 131))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "sand", 4, 0), getModItem(Forestry.ID, "thermionicTubes", 1, 3))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 259))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "hardened_clay", 4, 0),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 3))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 387))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "stone", 4, 0), getModItem(Forestry.ID, "thermionicTubes", 1, 3))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 515))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "sandstone", 4, 0),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 3))
                .itemOutputs(getModItem(Botany.ID, "insulatedTube", 1, 643))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 4L))
                .itemOutputs(getModItem(Botany.ID, "soilMeter", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);

    }
}
