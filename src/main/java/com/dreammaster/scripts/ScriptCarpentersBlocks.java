package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.CarpentersBlocks;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
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
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 2, 0, missing),
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
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 8, 0, missing),
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
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 12, 0, missing),
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
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 16, 0, missing),
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
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 20, 0, missing),
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
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 24, 0, missing),
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
                getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                ItemList.Plank_Oak.get(1L),
                ItemList.Plank_Oak.get(1L),
                ItemList.Plank_Oak.get(1L),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "itemCarpentersChisel", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(TinkerConstruct.ID, "chiselHead", 1, 2, missing),
                "craftingToolSaw",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "stickAnyIron",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "stickAnyIron",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "itemCarpentersHammer", 1, 0, missing),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.toolHeadHammer, Materials.Iron, 1L),
                "craftingToolSaw",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "stickAnyIron",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "stickAnyIron",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersSafe", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersDaylightSensor", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(Minecraft.ID, "daylight_detector", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "dustRedstone",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "itemCarpentersBed", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, wildcard, missing),
                getModItem(Minecraft.ID, "carpet", 1, wildcard, missing),
                getModItem(Minecraft.ID, "carpet", 1, wildcard, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBarrier", 1, 0, missing),
                "craftingToolSoftHammer",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBarrier", 1, 0, missing));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersTorch", 2, 0, missing),
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(Minecraft.ID, "torch", 1, 0, missing));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersGarageDoor", 5, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "ringIron",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "ringIron",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "ringIron",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "ringIron",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersLadder", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(Minecraft.ID, "ladder", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersBarrier", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "fenceWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 2, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "springAnyIron",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L));
        addShapelessRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersButton", 1, 0, missing),
                "craftingToolSaw",
                getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0, missing));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersFlowerPot", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(Minecraft.ID, "flower_pot", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                null,
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersGate", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(Minecraft.ID, "fence_gate", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersHatch", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersLever", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(Minecraft.ID, "lever", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                null,
                "craftingToolScrewdriver",
                null);
        addShapelessRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 2, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "craftingToolSaw");
        addShapelessRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersStairs", 1, 0, missing),
                "craftingToolSaw",
                getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 1, 0, missing));
        addShapelessRecipe(
                getModItem(CarpentersBlocks.ID, "itemCarpentersTile", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0, missing),
                "craftingToolRollingPin",
                "itemClay");
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "itemCarpentersDoor", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 2L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 2L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 4, 0, missing))
                .duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 3L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 8, 0, missing))
                .duration(5 * SECONDS).eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 3L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 12, 0, missing))
                .duration(5 * SECONDS).eut(48).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 3L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Aluminium, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 16, 0, missing))
                .duration(5 * SECONDS).eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 3L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 20, 0, missing))
                .duration(5 * SECONDS).eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 3L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 24, 0, missing))
                .duration(5 * SECONDS).eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "fence", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBarrier", 2, 0, missing))
                .duration(10 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        ItemList.Plank_Oak.get(1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 1, 0, missing))
                .duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "flower_pot", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersFlowerPot", 1, 0, missing))
                .duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersGarageDoor", 2, 0, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersGarageDoor", 4, 0, missing))
                .duration(15 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "fence_gate", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersGate", 1, 0, missing))
                .duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersHatch", 1, 0, missing))
                .duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "ladder", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersLadder", 1, 0, missing))
                .duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "lever", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersLever", 1, 0, missing))
                .duration(2 * SECONDS + 10 * TICKS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 3, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSafe", 1, 0, missing))
                .duration(15 * SECONDS).eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "torch", 10, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersTorch", 10, 0, missing))
                .duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "chiselHead", 1, 2, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "itemCarpentersChisel", 1, 0, missing))
                .duration(10 * SECONDS).eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.toolHeadHammer, Materials.Iron, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "itemCarpentersHammer", 1, 0, missing))
                .duration(10 * SECONDS).eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0, missing),
                        getModItem(Minecraft.ID, "clay_ball", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "itemCarpentersTile", 2, 0, missing))
                .duration(2 * SECONDS + 10 * TICKS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "wooden_door", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "itemCarpentersDoor", 1, 0, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 2, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 2, 0, missing))
                .duration(5 * SECONDS).eut(8).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 2, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 2, 0, missing))
                .duration(5 * SECONDS).eut(8).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersButton", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 20)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersButton", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 10)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersButton", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(2 * SECONDS + 10 * TICKS).eut(30)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersStairs", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 20)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersStairs", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 10)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersStairs", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(2 * SECONDS + 10 * TICKS).eut(30)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 20)).duration(5 * SECONDS).eut(16)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 10)).duration(5 * SECONDS).eut(16)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(2 * SECONDS + 10 * TICKS).eut(16)
                .addTo(cutterRecipes);

    }
}
