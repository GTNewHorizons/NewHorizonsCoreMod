package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.CarpentersBlocks;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.util.GTOreDictUnificator;

public class ScriptCarpentersBlocks implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Carpenters Blocks";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.CarpentersBlocks.ID, IndustrialCraft2.ID, TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 2, 0),
                "frameGtWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "frameGtWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "frameGtWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "frameGtWood");
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 8, 0),
                "frameGtWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "frameGtWood",
                "frameGtWood",
                "craftingToolScrewdriver",
                "frameGtWood",
                "frameGtWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "frameGtWood");
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 12, 0),
                "frameGtWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "frameGtWood",
                "frameGtWood",
                "craftingToolScrewdriver",
                "frameGtWood",
                "frameGtWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "frameGtWood");
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 16, 0),
                "frameGtWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Aluminium, 1L),
                "frameGtWood",
                "frameGtWood",
                "craftingToolScrewdriver",
                "frameGtWood",
                "frameGtWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Aluminium, 1L),
                "frameGtWood");
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 20, 0),
                "frameGtWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1L),
                "frameGtWood",
                "frameGtWood",
                "craftingToolScrewdriver",
                "frameGtWood",
                "frameGtWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1L),
                "frameGtWood");
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 24, 0),
                "frameGtWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 1L),
                "frameGtWood",
                "frameGtWood",
                "craftingToolScrewdriver",
                "frameGtWood",
                "frameGtWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 1L),
                "frameGtWood");
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                ItemList.Plank_Oak.get(1L),
                ItemList.Plank_Oak.get(1L),
                ItemList.Plank_Oak.get(1L),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "itemCarpentersChisel", 1, 0),
                "craftingToolScrewdriver",
                getModItem(TinkerConstruct.ID, "chiselHead", 1, 2),
                "craftingToolSaw",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "stickAnyIron",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "stickAnyIron",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "itemCarpentersHammer", 1, 0),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.toolHeadHammer, Materials.Iron, 1L),
                "craftingToolSaw",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "stickAnyIron",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "stickAnyIron",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersSafe", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 1, 0),
                getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersDaylightSensor", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(Minecraft.ID, "daylight_detector", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "dustRedstone",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "itemCarpentersBed", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, wildcard),
                getModItem(Minecraft.ID, "carpet", 1, wildcard),
                getModItem(Minecraft.ID, "carpet", 1, wildcard),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBarrier", 1, 0),
                ToolDictNames.craftingToolSoftMallet.name(),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBarrier", 1, 0));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersTorch", 2, 0),
                getModItem(Minecraft.ID, "torch", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(Minecraft.ID, "torch", 1, 0));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersGarageDoor", 5, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "ringIron",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "ringIron",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "ringIron",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "ringIron",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersLadder", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(Minecraft.ID, "ladder", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersBarrier", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "fenceWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 2, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "springAnyIron",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L));
        addShapelessRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersButton", 1, 0),
                "craftingToolSaw",
                getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersFlowerPot", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(Minecraft.ID, "flower_pot", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                null,
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                null);
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersGate", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(Minecraft.ID, "fence_gate", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersHatch", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersLever", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(Minecraft.ID, "lever", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                null,
                "craftingToolScrewdriver",
                null);
        addShapelessRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 2, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "craftingToolSaw");
        addShapelessRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersStairs", 1, 0),
                "craftingToolSaw",
                getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 1, 0));
        addShapelessRecipe(
                getModItem(CarpentersBlocks.ID, "itemCarpentersTile", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0),
                "craftingToolRollingPin",
                "itemClay");
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "itemCarpentersDoor", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(Minecraft.ID, "wooden_door", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 2L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 2L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 4, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 3L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 8, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 3L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 12, 0))
                .duration(5 * SECONDS).eut(48).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 3L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Aluminium, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 16, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 3L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 20, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 3L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 24, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "fence", 1, 0),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBarrier", 2, 0))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                        ItemList.Plank_Oak.get(1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 1, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                        getModItem(Minecraft.ID, "flower_pot", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersFlowerPot", 1, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersGarageDoor", 2, 0))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersGarageDoor", 4, 0))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "fence_gate", 1, 0),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersGate", 1, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersHatch", 1, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                        getModItem(Minecraft.ID, "ladder", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersLadder", 1, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                        getModItem(Minecraft.ID, "lever", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersLever", 1, 0))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 3, 0),
                        getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSafe", 1, 0))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                        getModItem(Minecraft.ID, "torch", 10, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersTorch", 10, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                        getModItem(TinkerConstruct.ID, "chiselHead", 1, 2))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "itemCarpentersChisel", 1, 0))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.toolHeadHammer, Materials.Iron, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "itemCarpentersHammer", 1, 0))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0),
                        getModItem(Minecraft.ID, "clay_ball", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "itemCarpentersTile", 2, 0))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                        getModItem(Minecraft.ID, "wooden_door", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "itemCarpentersDoor", 1, 0))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 2, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 2, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersButton", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 20)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersButton", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 10)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersButton", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersButton", 4, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(10 * TICKS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersStairs", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 20)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersStairs", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 10)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersStairs", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersStairs", 4, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(10 * TICKS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 20)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 10)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 4, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(cutterRecipes);

    }
}
