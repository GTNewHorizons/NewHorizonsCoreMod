package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.MalisisDoors;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.block.BlockList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;

public class ScriptMalisDoors implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Malis Doors";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays
                .asList(BiomesOPlenty.ID, MalisisDoors.ID, Natura.ID, ProjectRedIntegration.ID, TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "iron_trapdoor", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "plateAnyIron",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "plateAnyIron",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                "plateAnyIron",
                "craftingToolSaw",
                "plateAnyIron",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "sliding_trapdoor", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                null,
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "plateSteel",
                getModItem(MalisisDoors.ID, "iron_trapdoor", 1, 0),
                "plateSteel",
                "craftingToolSaw",
                null,
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "player_sensor", 1, 0),
                getModItem(Minecraft.ID, "stone_button", 1, 0),
                getModItem(Minecraft.ID, "skull", 1, 3),
                getModItem(Minecraft.ID, "stone_button", 1, 0),
                "craftingToolHardHammer",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "craftingToolSaw");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "vanishing_block", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "plateRedstone",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                "plateRedstone",
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                "plateRedstone",
                "craftingToolSaw",
                "plateEnderPearl",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "vanishing_block", 1, 1),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "plateRedstone",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "plateRedstone",
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Iron, 1L),
                "plateRedstone",
                "craftingToolSaw",
                "plateEnderPearl",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "vanishing_block", 1, 2),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Gold, 1L),
                "plateRedstone",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Gold, 1L),
                "plateRedstone",
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Gold, 1L),
                "plateRedstone",
                "craftingToolSaw",
                "plateEnderPearl",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "vanishing_block", 1, 3),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L),
                "plateRedstone",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L),
                "plateRedstone",
                BlockList.DiamondFrameBox.get(),
                "plateRedstone",
                "craftingToolSaw",
                "plateEnderPearl",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "block_mixer", 1, 0),
                ItemList.Conveyor_Module_LV.get(1L),
                ItemList.Electric_Motor_LV.get(1L),
                ItemList.Conveyor_Module_LV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Iron, 1L),
                ItemList.Casing_SolidSteel.get(1L),
                GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "sticky_piston", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "door_factory", 1, 0),
                ItemList.Conveyor_Module_LV.get(1L),
                ItemList.Electric_Motor_LV.get(1L),
                ItemList.Conveyor_Module_LV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Steel, 1L),
                ItemList.Casing_SolidSteel.get(1L),
                GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Steel, 1L),
                GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1L),
                getModItem(Minecraft.ID, "sticky_piston", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1L));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "rustyHatch", 1, 0),
                "plateAnyIron",
                "plateAnyIron",
                "plateAnyIron",
                "craftingToolHardHammer",
                getModItem(MalisisDoors.ID, "item.rustyHandle", 1, 0),
                "craftingToolWrench",
                "plateAnyIron",
                "plateAnyIron",
                "plateAnyIron");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "garage_door", 5, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Polyethylene, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Polyethylene, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Polyethylene, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Polyethylene, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Polyethylene, 1L));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.rustyHandle", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                "craftingToolWrench",
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 1L));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "rustyLadder", 4, 0),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "craftingToolWrench",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 1L));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 4),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 4),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 4),
                getModItem(Minecraft.ID, "planks", 1, 4));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 4),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 4),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 4),
                getModItem(Minecraft.ID, "planks", 1, 4));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 4),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 4),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 4),
                getModItem(Minecraft.ID, "planks", 1, 4));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 4),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 4),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 4),
                getModItem(Minecraft.ID, "planks", 1, 4));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_birch", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 2),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 2),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 2),
                getModItem(Minecraft.ID, "planks", 1, 2));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_birch", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 2),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 2),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 2),
                getModItem(Minecraft.ID, "planks", 1, 2));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_birch", 1, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 2),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 2),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 2),
                getModItem(Minecraft.ID, "planks", 1, 2));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_birch", 1, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 2),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 2),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 2),
                getModItem(Minecraft.ID, "planks", 1, 2));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 5),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 5),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 5),
                getModItem(Minecraft.ID, "planks", 1, 5));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 5),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 5),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 5),
                getModItem(Minecraft.ID, "planks", 1, 5));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 5),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 5),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 5),
                getModItem(Minecraft.ID, "planks", 1, 5));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 5),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 5),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 5),
                getModItem(Minecraft.ID, "planks", 1, 5));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 3),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 3),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 3),
                getModItem(Minecraft.ID, "planks", 1, 3));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 3),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 3),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 3),
                getModItem(Minecraft.ID, "planks", 1, 3));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 3),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 3),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 3),
                getModItem(Minecraft.ID, "planks", 1, 3));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 3),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 3),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 3),
                getModItem(Minecraft.ID, "planks", 1, 3));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 1),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 1),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 1),
                getModItem(Minecraft.ID, "planks", 1, 1));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 1),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 1),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 1),
                getModItem(Minecraft.ID, "planks", 1, 1));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 1),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 1),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 1),
                getModItem(Minecraft.ID, "planks", 1, 1));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 1),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 1),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 1),
                getModItem(Minecraft.ID, "planks", 1, 1));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_acacia", 1, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 4),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4),
                "stickWood",
                getModItem(Minecraft.ID, "flint", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_acacia", 2, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 4),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_acacia", 3, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 4),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_spruce", 1, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 1),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1),
                "stickWood",
                getModItem(Minecraft.ID, "flint", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_spruce", 2, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 1),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_spruce", 3, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 1),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_birch", 1, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 2),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2),
                "stickWood",
                getModItem(Minecraft.ID, "flint", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_birch", 2, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 2),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_birch", 3, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 2),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_jungle", 1, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 3),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3),
                "stickWood",
                getModItem(Minecraft.ID, "flint", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_jungle", 2, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 3),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_jungle", 3, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 3),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_dark_oak", 1, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 5),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5),
                "stickWood",
                getModItem(Minecraft.ID, "flint", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_dark_oak", 2, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 5),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_dark_oak", 3, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 5),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.wood_sliding_door", 1, 0),
                null,
                "paneGlassColorless",
                null,
                "paneGlassColorless",
                getModItem(Minecraft.ID, "wooden_door", 1, 0),
                "paneGlassColorless",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.wood_sliding_door", 1, 0),
                null,
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                null,
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                getModItem(Minecraft.ID, "wooden_door", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.iron_sliding_door", 1, 0),
                null,
                "paneGlassColorless",
                null,
                "paneGlassColorless",
                getModItem(Minecraft.ID, "iron_door", 1, 0),
                "paneGlassColorless",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.iron_sliding_door", 1, 0),
                null,
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                null,
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                getModItem(Minecraft.ID, "iron_door", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.jail_door", 1, 0),
                null,
                BlockList.SteelBars.get(),
                null,
                BlockList.SteelBars.get(),
                getModItem(Minecraft.ID, "iron_door", 1, 0),
                BlockList.SteelBars.get(),
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.laboratory_door", 1, 0),
                null,
                "plateAnyIron",
                null,
                "plateSteel",
                getModItem(Minecraft.ID, "wooden_door", 1, 0),
                "plateSteel",
                null,
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.factory_door", 1, 0),
                null,
                "plateSteel",
                null,
                "plateAnyIron",
                getModItem(Minecraft.ID, "wooden_door", 1, 0),
                "plateAnyIron",
                null,
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.shoji_door", 1, 0),
                getModItem(Minecraft.ID, "paper", 1, 0),
                "stickWood",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "paper", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "paper", 1, 0),
                "stickWood",
                "craftingToolSaw");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.shoji_door", 1, 0),
                getModItem(Minecraft.ID, "paper", 1, 0),
                "stickWood",
                "craftingToolSaw",
                getModItem(Minecraft.ID, "paper", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "paper", 1, 0),
                "stickWood",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.shoji_door", 1, 0),
                getModItem(Minecraft.ID, "paper", 1, 0),
                "stickWood",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "paper", 1, 0),
                "ringCopper",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "paper", 1, 0),
                "stickWood",
                "craftingToolSaw");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.shoji_door", 1, 0),
                getModItem(Minecraft.ID, "paper", 1, 0),
                "stickWood",
                "craftingToolSaw",
                getModItem(Minecraft.ID, "paper", 1, 0),
                "ringCopper",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "paper", 1, 0),
                "stickWood",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_purple", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 10),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 10),
                getModItem(Minecraft.ID, "carpet", 1, 10),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 10),
                getModItem(Minecraft.ID, "carpet", 1, 10),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 10));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_yellow", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 4),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 4),
                getModItem(Minecraft.ID, "carpet", 1, 4),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 4),
                getModItem(Minecraft.ID, "carpet", 1, 4),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 4));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_magenta", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 2),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 2),
                getModItem(Minecraft.ID, "carpet", 1, 2),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 2),
                getModItem(Minecraft.ID, "carpet", 1, 2),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 2));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_pink", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 6),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 6),
                getModItem(Minecraft.ID, "carpet", 1, 6),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 6),
                getModItem(Minecraft.ID, "carpet", 1, 6),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 6));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_white", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 0));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_blue", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 11),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 11),
                getModItem(Minecraft.ID, "carpet", 1, 11),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 11),
                getModItem(Minecraft.ID, "carpet", 1, 11),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 11));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_gray", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 7),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 7),
                getModItem(Minecraft.ID, "carpet", 1, 7),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 7),
                getModItem(Minecraft.ID, "carpet", 1, 7),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 7));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_cyan", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 9),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 9),
                getModItem(Minecraft.ID, "carpet", 1, 9),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 9),
                getModItem(Minecraft.ID, "carpet", 1, 9),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 9));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_red", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 14),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 14),
                getModItem(Minecraft.ID, "carpet", 1, 14),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 14),
                getModItem(Minecraft.ID, "carpet", 1, 14),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 14));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_brown", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 12),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 12),
                getModItem(Minecraft.ID, "carpet", 1, 12),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 12),
                getModItem(Minecraft.ID, "carpet", 1, 12),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 12));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_lime", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 5),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 5),
                getModItem(Minecraft.ID, "carpet", 1, 5),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 5),
                getModItem(Minecraft.ID, "carpet", 1, 5),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 5));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_orange", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 1),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 1),
                getModItem(Minecraft.ID, "carpet", 1, 1),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 1),
                getModItem(Minecraft.ID, "carpet", 1, 1),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 1));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_silver", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 8),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 8),
                getModItem(Minecraft.ID, "carpet", 1, 8),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 8),
                getModItem(Minecraft.ID, "carpet", 1, 8),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 8));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_green", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 13),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 13),
                getModItem(Minecraft.ID, "carpet", 1, 13),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 13),
                getModItem(Minecraft.ID, "carpet", 1, 13),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 13));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_light_blue", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 3),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 3),
                getModItem(Minecraft.ID, "carpet", 1, 3),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 3),
                getModItem(Minecraft.ID, "carpet", 1, 3),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 3));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_black", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 15),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 15),
                getModItem(Minecraft.ID, "carpet", 1, 15),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 15),
                getModItem(Minecraft.ID, "carpet", 1, 15),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 15));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.saloon", 2, 0),
                GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Iron, 1L),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                null,
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.forcefieldItem", 1, 0),
                "plateDiamond",
                "plateThaumium",
                "plateDiamond",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26),
                "lensEnderEye",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26),
                "plateDiamond",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 21),
                "plateDiamond");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "acaciaFenceGate", 1, 0),
                getModItem(Minecraft.ID, "flint", 1, 0),
                null,
                getModItem(Minecraft.ID, "flint", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 4),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 4),
                getModItem(Minecraft.ID, "planks", 1, 4),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 4));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "acaciaFenceGate", 2, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 4),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 4),
                getModItem(Minecraft.ID, "planks", 1, 4),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 4));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "acaciaFenceGate", 4, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                getModItem(Minecraft.ID, "planks", 1, 4),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 4),
                getModItem(Minecraft.ID, "planks", 1, 4),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 4));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "birchFenceGate", 1, 0),
                getModItem(Minecraft.ID, "flint", 1, 0),
                null,
                getModItem(Minecraft.ID, "flint", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 2),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 2),
                getModItem(Minecraft.ID, "planks", 1, 2),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 2));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "birchFenceGate", 2, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 2),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 2),
                getModItem(Minecraft.ID, "planks", 1, 2),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 2));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "birchFenceGate", 4, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                getModItem(Minecraft.ID, "planks", 1, 2),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 2),
                getModItem(Minecraft.ID, "planks", 1, 2),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 2));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "darkOakFenceGate", 1, 0),
                getModItem(Minecraft.ID, "flint", 1, 0),
                null,
                getModItem(Minecraft.ID, "flint", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 5),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 5),
                getModItem(Minecraft.ID, "planks", 1, 5),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 5));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "darkOakFenceGate", 2, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 5),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 5),
                getModItem(Minecraft.ID, "planks", 1, 5),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 5));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "darkOakFenceGate", 4, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                getModItem(Minecraft.ID, "planks", 1, 5),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 5),
                getModItem(Minecraft.ID, "planks", 1, 5),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 5));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "jungleFenceGate", 1, 0),
                getModItem(Minecraft.ID, "flint", 1, 0),
                null,
                getModItem(Minecraft.ID, "flint", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 3),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 3),
                getModItem(Minecraft.ID, "planks", 1, 3),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 3));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "jungleFenceGate", 2, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 3),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 3),
                getModItem(Minecraft.ID, "planks", 1, 3),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 3));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "jungleFenceGate", 4, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                getModItem(Minecraft.ID, "planks", 1, 3),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 3),
                getModItem(Minecraft.ID, "planks", 1, 3),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 3));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "spruceFenceGate", 1, 0),
                getModItem(Minecraft.ID, "flint", 1, 0),
                null,
                getModItem(Minecraft.ID, "flint", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 1),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 1),
                getModItem(Minecraft.ID, "planks", 1, 1),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 1));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "spruceFenceGate", 2, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 1),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 1),
                getModItem(Minecraft.ID, "planks", 1, 1),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 1));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "spruceFenceGate", 4, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                getModItem(Minecraft.ID, "planks", 1, 1),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 1),
                getModItem(Minecraft.ID, "planks", 1, 1),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 1));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "trapdoor", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(getModItem(MalisisDoors.ID, "iron_trapdoor", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MalisisDoors.ID, "iron_trapdoor", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L))
                .itemOutputs(getModItem(MalisisDoors.ID, "sliding_trapdoor", 1, 0)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                        getModItem(Minecraft.ID, "skull", 1, 3))
                .itemOutputs(getModItem(MalisisDoors.ID, "player_sensor", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1L))
                .itemOutputs(getModItem(MalisisDoors.ID, "vanishing_block", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Iron, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1L))
                .itemOutputs(getModItem(MalisisDoors.ID, "vanishing_block", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Gold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1L))
                .itemOutputs(getModItem(MalisisDoors.ID, "vanishing_block", 1, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        BlockList.DiamondFrameBox.get(),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1L))
                .itemOutputs(getModItem(MalisisDoors.ID, "vanishing_block", 1, 3))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                        getModItem(MalisisDoors.ID, "item.rustyHandle", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "rustyHatch", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Polyethylene, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L))
                .itemOutputs(getModItem(MalisisDoors.ID, "garage_door", 2, 0)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 3L))
                .circuit(5).itemOutputs(getModItem(MalisisDoors.ID, "rustyLadder", 2, 0)).duration(3 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "planks", 4, 4), getModItem(Minecraft.ID, "trapdoor", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "planks", 4, 4), getModItem(Minecraft.ID, "trapdoor", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "planks", 4, 2), getModItem(Minecraft.ID, "trapdoor", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_birch", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "planks", 4, 2), getModItem(Minecraft.ID, "trapdoor", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_birch", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "planks", 4, 5), getModItem(Minecraft.ID, "trapdoor", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "planks", 4, 5), getModItem(Minecraft.ID, "trapdoor", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "planks", 4, 3), getModItem(Minecraft.ID, "trapdoor", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "planks", 4, 3), getModItem(Minecraft.ID, "trapdoor", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "planks", 4, 1), getModItem(Minecraft.ID, "trapdoor", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "planks", 4, 1), getModItem(Minecraft.ID, "trapdoor", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "wooden_door", 1, 0), getModItem(Minecraft.ID, "glass_pane", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.wood_sliding_door", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_door", 1, 0),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.wood_sliding_door", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "iron_door", 1, 0), getModItem(Minecraft.ID, "glass_pane", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.iron_sliding_door", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "iron_door", 1, 0),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.iron_sliding_door", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "iron_door", 1, 0), BlockList.SteelBars.get(2))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.jail_door", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_door", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.laboratory_door", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_door", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 2L))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.factory_door", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "paper", 2, 0), getModItem(Minecraft.ID, "stick", 2, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.shoji_door", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "paper", 2, 0), getModItem(Minecraft.ID, "stick", 2, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.shoji_door", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "carpet", 3, 10), getModItem(Minecraft.ID, "string", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_purple", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "carpet", 3, 4), getModItem(Minecraft.ID, "string", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_yellow", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "carpet", 3, 2), getModItem(Minecraft.ID, "string", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_magenta", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "carpet", 3, 6), getModItem(Minecraft.ID, "string", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_pink", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "carpet", 3, 0), getModItem(Minecraft.ID, "string", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_white", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "carpet", 3, 11), getModItem(Minecraft.ID, "string", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_blue", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "carpet", 3, 9), getModItem(Minecraft.ID, "string", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_cyan", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "carpet", 3, 14), getModItem(Minecraft.ID, "string", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_red", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "carpet", 3, 7), getModItem(Minecraft.ID, "string", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_gray", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "carpet", 3, 12), getModItem(Minecraft.ID, "string", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_brown", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "carpet", 3, 5), getModItem(Minecraft.ID, "string", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_lime", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "carpet", 3, 1), getModItem(Minecraft.ID, "string", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_orange", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "carpet", 3, 8), getModItem(Minecraft.ID, "string", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_silver", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "carpet", 3, 13), getModItem(Minecraft.ID, "string", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_green", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "carpet", 3, 3), getModItem(Minecraft.ID, "string", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_light_blue", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "carpet", 3, 15), getModItem(Minecraft.ID, "string", 1, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_black", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "trapdoor", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Iron, 2L))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.saloon", 1, 0)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "stick", 2, 0), getModItem(Minecraft.ID, "planks", 2, 4))
                .itemOutputs(getModItem(MalisisDoors.ID, "acaciaFenceGate", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "stick", 2, 0), getModItem(Minecraft.ID, "planks", 2, 2))
                .itemOutputs(getModItem(MalisisDoors.ID, "birchFenceGate", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "stick", 2, 0), getModItem(Minecraft.ID, "planks", 2, 5))
                .itemOutputs(getModItem(MalisisDoors.ID, "darkOakFenceGate", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "stick", 2, 0), getModItem(Minecraft.ID, "planks", 2, 3))
                .itemOutputs(getModItem(MalisisDoors.ID, "jungleFenceGate", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "stick", 2, 0), getModItem(Minecraft.ID, "planks", 2, 1))
                .itemOutputs(getModItem(MalisisDoors.ID, "spruceFenceGate", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "wooden_slab", 4, 4), getModItem(Minecraft.ID, "stick", 4, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_acacia", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "wooden_slab", 4, 4), getModItem(Minecraft.ID, "stick", 4, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_acacia", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "wooden_slab", 4, 2), getModItem(Minecraft.ID, "stick", 4, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_birch", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "wooden_slab", 4, 2), getModItem(Minecraft.ID, "stick", 4, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_birch", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "wooden_slab", 4, 5), getModItem(Minecraft.ID, "stick", 4, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_dark_oak", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "wooden_slab", 4, 5), getModItem(Minecraft.ID, "stick", 4, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_dark_oak", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "wooden_slab", 4, 3), getModItem(Minecraft.ID, "stick", 4, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_jungle", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "wooden_slab", 4, 3), getModItem(Minecraft.ID, "stick", 4, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_jungle", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "wooden_slab", 4, 1), getModItem(Minecraft.ID, "stick", 4, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_spruce", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "wooden_slab", 4, 1), getModItem(Minecraft.ID, "stick", 4, 0))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_spruce", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);

    }
}
