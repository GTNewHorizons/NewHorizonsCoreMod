package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.MalisisDoors;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.block.BlockList;
import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

public class ScriptMalisDoors implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Malis Doors";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Mods.MalisisDoors.ID,
                BiomesOPlenty.ID,
                Natura.ID,
                ProjectRedIntegration.ID,
                TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "iron_trapdoor", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "plateAnyIron",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "plateAnyIron",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                "plateAnyIron",
                "craftingToolSaw",
                "plateAnyIron",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "sliding_trapdoor", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                null,
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "plateSteel",
                getModItem(MalisisDoors.ID, "iron_trapdoor", 1, 0, missing),
                "plateSteel",
                "craftingToolSaw",
                null,
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "player_sensor", 1, 0, missing),
                getModItem(Minecraft.ID, "stone_button", 1, 0, missing),
                getModItem(Minecraft.ID, "skull", 1, 3, missing),
                getModItem(Minecraft.ID, "stone_button", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "craftingToolSaw");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "vanishing_block", 1, 0, missing),
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
                getModItem(MalisisDoors.ID, "vanishing_block", 1, 1, missing),
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
                getModItem(MalisisDoors.ID, "vanishing_block", 1, 2, missing),
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
                getModItem(MalisisDoors.ID, "vanishing_block", 1, 3, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L),
                "plateRedstone",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L),
                "plateRedstone",
                BlockList.DiamondFrameBox.getIS(),
                "plateRedstone",
                "craftingToolSaw",
                "plateEnderPearl",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "block_mixer", 1, 0, missing),
                ItemList.Conveyor_Module_LV.get(1L),
                ItemList.Electric_Motor_LV.get(1L),
                ItemList.Conveyor_Module_LV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Iron, 1L),
                ItemList.Casing_SolidSteel.get(1L),
                GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "sticky_piston", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "door_factory", 1, 0, missing),
                ItemList.Conveyor_Module_LV.get(1L),
                ItemList.Electric_Motor_LV.get(1L),
                ItemList.Conveyor_Module_LV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Steel, 1L),
                ItemList.Casing_SolidSteel.get(1L),
                GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Steel, 1L),
                GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1L),
                getModItem(Minecraft.ID, "sticky_piston", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1L));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "rustyHatch", 1, 0, missing),
                "plateAnyIron",
                "plateAnyIron",
                "plateAnyIron",
                "craftingToolHardHammer",
                getModItem(MalisisDoors.ID, "item.rustyHandle", 1, 0, missing),
                "craftingToolWrench",
                "plateAnyIron",
                "plateAnyIron",
                "plateAnyIron");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "garage_door", 5, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 1L));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.rustyHandle", 1, 0, missing),
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
                getModItem(MalisisDoors.ID, "rustyLadder", 4, 0, missing),
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
                getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                getModItem(Minecraft.ID, "planks", 1, 4, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                getModItem(Minecraft.ID, "planks", 1, 4, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                getModItem(Minecraft.ID, "planks", 1, 4, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                getModItem(Minecraft.ID, "planks", 1, 4, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_birch", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                getModItem(Minecraft.ID, "planks", 1, 2, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_birch", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                getModItem(Minecraft.ID, "planks", 1, 2, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_birch", 1, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                getModItem(Minecraft.ID, "planks", 1, 2, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_birch", 1, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                getModItem(Minecraft.ID, "planks", 1, 2, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                getModItem(Minecraft.ID, "planks", 1, 5, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                getModItem(Minecraft.ID, "planks", 1, 5, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                getModItem(Minecraft.ID, "planks", 1, 5, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                getModItem(Minecraft.ID, "planks", 1, 5, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                getModItem(Minecraft.ID, "planks", 1, 3, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                getModItem(Minecraft.ID, "planks", 1, 3, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                getModItem(Minecraft.ID, "planks", 1, 3, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                getModItem(Minecraft.ID, "planks", 1, 3, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                getModItem(Minecraft.ID, "planks", 1, 1, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                getModItem(Minecraft.ID, "planks", 1, 1, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                "screwCopper",
                "ringCopper",
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                getModItem(Minecraft.ID, "planks", 1, 1, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                getModItem(Minecraft.ID, "planks", 1, 1, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_acacia", 1, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 4, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4, missing),
                "stickWood",
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_acacia", 2, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 4, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4, missing),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_acacia", 3, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 4, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4, missing),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 4, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_spruce", 1, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 1, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1, missing),
                "stickWood",
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_spruce", 2, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 1, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1, missing),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_spruce", 3, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 1, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1, missing),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 1, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_birch", 1, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 2, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2, missing),
                "stickWood",
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_birch", 2, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 2, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2, missing),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_birch", 3, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 2, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2, missing),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 2, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_jungle", 1, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 3, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3, missing),
                "stickWood",
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_jungle", 2, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 3, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3, missing),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_jungle", 3, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 3, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3, missing),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 3, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_dark_oak", 1, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 5, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5, missing),
                "stickWood",
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_dark_oak", 2, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 5, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5, missing),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "trapdoor_dark_oak", 3, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 5, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5, missing),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 5, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.wood_sliding_door", 1, 0, missing),
                null,
                "paneGlassColorless",
                null,
                "paneGlassColorless",
                getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                "paneGlassColorless",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.wood_sliding_door", 1, 0, missing),
                null,
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                null,
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.iron_sliding_door", 1, 0, missing),
                null,
                "paneGlassColorless",
                null,
                "paneGlassColorless",
                getModItem(Minecraft.ID, "iron_door", 1, 0, missing),
                "paneGlassColorless",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.iron_sliding_door", 1, 0, missing),
                null,
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                null,
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(Minecraft.ID, "iron_door", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.jail_door", 1, 0, missing),
                null,
                CustomItemList.SteelBars.get(1L),
                null,
                CustomItemList.SteelBars.get(1L),
                getModItem(Minecraft.ID, "iron_door", 1, 0, missing),
                CustomItemList.SteelBars.get(1L),
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.laboratory_door", 1, 0, missing),
                null,
                "plateAnyIron",
                null,
                "plateSteel",
                getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                "plateSteel",
                null,
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.factory_door", 1, 0, missing),
                null,
                "plateSteel",
                null,
                "plateAnyIron",
                getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                "plateAnyIron",
                null,
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.shoji_door", 1, 0, missing),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                "stickWood",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                "stickWood",
                "craftingToolSaw");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.shoji_door", 1, 0, missing),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                "stickWood",
                "craftingToolSaw",
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                "stickWood",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.shoji_door", 1, 0, missing),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                "stickWood",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                "ringCopper",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                "stickWood",
                "craftingToolSaw");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.shoji_door", 1, 0, missing),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                "stickWood",
                "craftingToolSaw",
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                "ringCopper",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                "stickWood",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_purple", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 10, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 10, missing),
                getModItem(Minecraft.ID, "carpet", 1, 10, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 10, missing),
                getModItem(Minecraft.ID, "carpet", 1, 10, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 10, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_yellow", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 4, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 4, missing),
                getModItem(Minecraft.ID, "carpet", 1, 4, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 4, missing),
                getModItem(Minecraft.ID, "carpet", 1, 4, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 4, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_magenta", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 2, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 2, missing),
                getModItem(Minecraft.ID, "carpet", 1, 2, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 2, missing),
                getModItem(Minecraft.ID, "carpet", 1, 2, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 2, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_pink", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 6, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 6, missing),
                getModItem(Minecraft.ID, "carpet", 1, 6, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 6, missing),
                getModItem(Minecraft.ID, "carpet", 1, 6, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 6, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_white", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_blue", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 11, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 11, missing),
                getModItem(Minecraft.ID, "carpet", 1, 11, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 11, missing),
                getModItem(Minecraft.ID, "carpet", 1, 11, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 11, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_gray", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 7, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 7, missing),
                getModItem(Minecraft.ID, "carpet", 1, 7, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 7, missing),
                getModItem(Minecraft.ID, "carpet", 1, 7, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 7, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_cyan", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 9, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 9, missing),
                getModItem(Minecraft.ID, "carpet", 1, 9, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 9, missing),
                getModItem(Minecraft.ID, "carpet", 1, 9, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 9, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_red", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 14, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 14, missing),
                getModItem(Minecraft.ID, "carpet", 1, 14, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 14, missing),
                getModItem(Minecraft.ID, "carpet", 1, 14, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 14, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_brown", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 12, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 12, missing),
                getModItem(Minecraft.ID, "carpet", 1, 12, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 12, missing),
                getModItem(Minecraft.ID, "carpet", 1, 12, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 12, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_lime", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 5, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 5, missing),
                getModItem(Minecraft.ID, "carpet", 1, 5, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 5, missing),
                getModItem(Minecraft.ID, "carpet", 1, 5, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 5, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_orange", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 1, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 1, missing),
                getModItem(Minecraft.ID, "carpet", 1, 1, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 1, missing),
                getModItem(Minecraft.ID, "carpet", 1, 1, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 1, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_silver", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 8, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 8, missing),
                getModItem(Minecraft.ID, "carpet", 1, 8, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 8, missing),
                getModItem(Minecraft.ID, "carpet", 1, 8, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 8, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_green", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 13, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 13, missing),
                getModItem(Minecraft.ID, "carpet", 1, 13, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 13, missing),
                getModItem(Minecraft.ID, "carpet", 1, 13, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 13, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_light_blue", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 3, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 3, missing),
                getModItem(Minecraft.ID, "carpet", 1, 3, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 3, missing),
                getModItem(Minecraft.ID, "carpet", 1, 3, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 3, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.curtain_black", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 15, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 15, missing),
                getModItem(Minecraft.ID, "carpet", 1, 15, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 15, missing),
                getModItem(Minecraft.ID, "carpet", 1, 15, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 15, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.saloon", 2, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Iron, 1L),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                null,
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "item.forcefieldItem", 1, 0, missing),
                "plateDiamond",
                "plateThaumium",
                "plateDiamond",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing),
                "lensEnderEye",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing),
                "plateDiamond",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 21, missing),
                "plateDiamond");
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "acaciaFenceGate", 1, 0, missing),
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 4, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "acaciaFenceGate", 2, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 4, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "acaciaFenceGate", 4, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                getModItem(Minecraft.ID, "planks", 1, 4, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 4, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "birchFenceGate", 1, 0, missing),
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 2, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "birchFenceGate", 2, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 2, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "birchFenceGate", 4, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                getModItem(Minecraft.ID, "planks", 1, 2, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 2, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "darkOakFenceGate", 1, 0, missing),
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 5, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "darkOakFenceGate", 2, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 5, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "darkOakFenceGate", 4, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                getModItem(Minecraft.ID, "planks", 1, 5, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 5, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "jungleFenceGate", 1, 0, missing),
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 3, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "jungleFenceGate", 2, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 3, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "jungleFenceGate", 4, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                getModItem(Minecraft.ID, "planks", 1, 3, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 3, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "spruceFenceGate", 1, 0, missing),
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 1, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "spruceFenceGate", 2, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 1, missing));
        addShapedRecipe(
                getModItem(MalisisDoors.ID, "spruceFenceGate", 4, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                getModItem(Minecraft.ID, "planks", 1, 1, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 1, missing));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(getModItem(MalisisDoors.ID, "iron_trapdoor", 1, 0, missing)).duration(5 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MalisisDoors.ID, "iron_trapdoor", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L))
                .itemOutputs(getModItem(MalisisDoors.ID, "sliding_trapdoor", 1, 0, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                        getModItem(Minecraft.ID, "skull", 1, 3, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "player_sensor", 2, 0, missing)).duration(5 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1L))
                .itemOutputs(getModItem(MalisisDoors.ID, "vanishing_block", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Iron, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1L))
                .itemOutputs(getModItem(MalisisDoors.ID, "vanishing_block", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(20 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Gold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1L))
                .itemOutputs(getModItem(MalisisDoors.ID, "vanishing_block", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(25 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        BlockList.DiamondFrameBox.getIS(),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1L))
                .itemOutputs(getModItem(MalisisDoors.ID, "vanishing_block", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                        getModItem(MalisisDoors.ID, "item.rustyHandle", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "rustyHatch", 1, 0, missing)).duration(10 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L))
                .itemOutputs(getModItem(MalisisDoors.ID, "garage_door", 2, 0, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 3L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(MalisisDoors.ID, "rustyLadder", 2, 0, missing)).duration(3 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "planks", 4, 4, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "planks", 4, 4, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "planks", 4, 2, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_birch", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "planks", 4, 2, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_birch", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "planks", 4, 5, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "planks", 4, 5, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "planks", 4, 3, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "planks", 4, 3, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "planks", 4, 1, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "planks", 4, 1, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                        getModItem(Minecraft.ID, "glass_pane", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.wood_sliding_door", 1, 0, missing))
                .duration(20 * SECONDS).eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.wood_sliding_door", 1, 0, missing))
                .duration(20 * SECONDS).eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "iron_door", 1, 0, missing),
                        getModItem(Minecraft.ID, "glass_pane", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.iron_sliding_door", 1, 0, missing))
                .duration(20 * SECONDS).eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "iron_door", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.iron_sliding_door", 1, 0, missing))
                .duration(20 * SECONDS).eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "iron_door", 1, 0, missing), CustomItemList.SteelBars.get(2L))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.jail_door", 1, 0, missing)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.laboratory_door", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 2L))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.factory_door", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 2, 0, missing),
                        getModItem(Minecraft.ID, "stick", 2, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.shoji_door", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 2, 0, missing),
                        getModItem(Minecraft.ID, "stick", 2, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.shoji_door", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 3, 10, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_purple", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 3, 4, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_yellow", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 3, 2, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_magenta", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 3, 6, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_pink", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 3, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_white", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 3, 11, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_blue", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 3, 9, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_cyan", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 3, 14, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_red", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 3, 7, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_gray", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 3, 12, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_brown", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 3, 5, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_lime", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 3, 1, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_orange", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 3, 8, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_silver", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 3, 13, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_green", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 3, 3, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_light_blue", 1, 0, missing))
                .duration(20 * SECONDS).eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 3, 15, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.curtain_black", 1, 0, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "trapdoor", 2, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Iron, 2L))
                .itemOutputs(getModItem(MalisisDoors.ID, "item.saloon", 1, 0, missing)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 2, 0, missing),
                        getModItem(Minecraft.ID, "planks", 2, 4, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "acaciaFenceGate", 1, 0, missing)).duration(15 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 2, 0, missing),
                        getModItem(Minecraft.ID, "planks", 2, 2, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "birchFenceGate", 1, 0, missing)).duration(15 * SECONDS).eut(8)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 2, 0, missing),
                        getModItem(Minecraft.ID, "planks", 2, 5, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "darkOakFenceGate", 1, 0, missing)).duration(15 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 2, 0, missing),
                        getModItem(Minecraft.ID, "planks", 2, 3, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "jungleFenceGate", 1, 0, missing)).duration(15 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 2, 0, missing),
                        getModItem(Minecraft.ID, "planks", 2, 1, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "spruceFenceGate", 1, 0, missing)).duration(15 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 4, missing),
                        getModItem(Minecraft.ID, "stick", 4, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_acacia", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 4, missing),
                        getModItem(Minecraft.ID, "stick", 4, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_acacia", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 2, missing),
                        getModItem(Minecraft.ID, "stick", 4, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_birch", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 2, missing),
                        getModItem(Minecraft.ID, "stick", 4, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_birch", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 5, missing),
                        getModItem(Minecraft.ID, "stick", 4, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_dark_oak", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 5, missing),
                        getModItem(Minecraft.ID, "stick", 4, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_dark_oak", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 3, missing),
                        getModItem(Minecraft.ID, "stick", 4, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_jungle", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 3, missing),
                        getModItem(Minecraft.ID, "stick", 4, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_jungle", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 1, missing),
                        getModItem(Minecraft.ID, "stick", 4, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_spruce", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 1, missing),
                        getModItem(Minecraft.ID, "stick", 4, 0, missing))
                .itemOutputs(getModItem(MalisisDoors.ID, "trapdoor_spruce", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);

    }
}
