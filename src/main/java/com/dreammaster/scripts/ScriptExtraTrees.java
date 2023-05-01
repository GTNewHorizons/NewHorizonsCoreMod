package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.MalisisDoors;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMixerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.forestry.ForestryHelper;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GT_Values;

public class ScriptExtraTrees implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Extra Trees";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                ExtraTrees.ID,
                BuildCraftFactory.ID,
                Forestry.ID,
                MalisisDoors.ID,
                Railcraft.ID,
                RandomThings.ID);
    }

    @Override
    public void loadRecipes() {

        recipes1();
        recipes2();

        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.MushroomPowder", 5, 0, missing))
                .itemOutputs(getModItem(ExtraTrees.ID, "misc", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("potion.wheatyjuice", 1000)).noFluidOutputs().duration(400)
                .eut(16).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "misc", 1, 6, missing),
                        getModItem(ExtraTrees.ID, "misc", 4, 12, missing))
                .itemOutputs(getModItem(ExtraTrees.ID, "misc", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).noFluidOutputs().duration(600).eut(16)
                .addTo(sMixerRecipes);

    }

    public void recipes1() {

        addShapelessCraftingRecipe(
                getModItem(ExtraTrees.ID, "database", 1, 0, missing),
                new Object[] { getModItem(ExtraTrees.ID, "database", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(ExtraTrees.ID, "databaseMoth", 1, 0, missing),
                new Object[] { getModItem(ExtraTrees.ID, "databaseMoth", 1, 0, missing) });
        addShapedRecipe(
                getModItem(ExtraTrees.ID, "machine", 1, 0, missing),
                new Object[] { getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "plateSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32721, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(ExtraTrees.ID, "misc", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(ExtraTrees.ID, "misc", 1, 3, missing) });
        addShapedRecipe(
                getModItem(ExtraTrees.ID, "machine", 1, 1, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17889, missing), "plankWood",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17889, missing),
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        getModItem(ExtraTrees.ID, "misc", 1, 3, missing), "plankWood",
                        getModItem(ExtraTrees.ID, "misc", 1, 3, missing) });
        addShapedRecipe(
                getModItem(ExtraTrees.ID, "machine", 1, 2, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17889, missing), "slabWood",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17889, missing),
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        getModItem(ExtraTrees.ID, "misc", 1, 3, missing), "slabWood",
                        getModItem(ExtraTrees.ID, "misc", 1, 3, missing) });
        addShapedRecipe(
                getModItem(ExtraTrees.ID, "machine", 1, 4, missing),
                new Object[] { getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "plateSteel",
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing), "gearGtSmallBronze",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "gearGtSmallBronze" });
        addShapedRecipe(
                getModItem(ExtraTrees.ID, "misc", 1, 3, missing),
                new Object[] { getModItem(Forestry.ID, "oakStick", 1, 0, missing),
                        getModItem(Railcraft.ID, "cube", 1, 8, missing),
                        getModItem(Forestry.ID, "oakStick", 1, 0, missing),
                        getModItem(Railcraft.ID, "cube", 1, 8, missing), "craftingToolSaw",
                        getModItem(Railcraft.ID, "cube", 1, 8, missing),
                        getModItem(Forestry.ID, "oakStick", 1, 0, missing),
                        getModItem(Railcraft.ID, "cube", 1, 8, missing),
                        getModItem(Forestry.ID, "oakStick", 1, 0, missing) });
        addShapedRecipe(
                getModItem(ExtraTrees.ID, "hammer", 1, 0, missing),
                new Object[] { "plankWood", "plankWood", null, "ingotIron", "stickIron", "stickWood", "plankWood",
                        "plankWood", null });
        addShapedRecipe(
                getModItem(ExtraTrees.ID, "durableHammer", 1, 0, missing),
                new Object[] { "plateObsidian", "plateObsidian", null, "ingotGold",
                        getModItem(RandomThings.ID, "ingredient", 1, 1, missing), "stickWood", "plateObsidian",
                        "plateObsidian", null });
        addShapedRecipe(
                getModItem(ExtraTrees.ID, "misc", 5, 5, missing),
                new Object[] { "stickLongAnyIron", "craftingToolSaw", "stickLongAnyIron", null, "stickLongAnyIron",
                        null, "stickLongAnyIron", "craftingToolFile", "stickLongAnyIron" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 0, "{meta:0}", missing),
                new Object[] { getModItem(Minecraft.ID, "wooden_door", 1, 0, missing), null, null, null, null, null,
                        null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 256, "{meta:256}", missing),
                new Object[] { null, getModItem(Minecraft.ID, "wooden_door", 1, 0, missing), null, null, null, null,
                        null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 512, "{meta:512}", missing),
                new Object[] { null, null, getModItem(Minecraft.ID, "wooden_door", 1, 0, missing), null, null, null,
                        null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 768, "{meta:768}", missing),
                new Object[] { null, null, null, getModItem(Minecraft.ID, "wooden_door", 1, 0, missing), null, null,
                        null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 1, "{meta:1}", missing),
                new Object[] { getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0, missing), null, null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 257, "{meta:257}", missing),
                new Object[] { null, getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0, missing), null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 513, "{meta:513}", missing),
                new Object[] { null, null, getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0, missing), null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 769, "{meta:769}", missing),
                new Object[] { null, null, null, getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0, missing), null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 2, "{meta:2}", missing),
                new Object[] { getModItem(MalisisDoors.ID, "item.door_birch", 1, 0, missing), null, null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 258, "{meta:258}", missing),
                new Object[] { null, getModItem(MalisisDoors.ID, "item.door_birch", 1, 0, missing), null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 514, "{meta:514}", missing),
                new Object[] { null, null, getModItem(MalisisDoors.ID, "item.door_birch", 1, 0, missing), null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 770, "{meta:770}", missing),
                new Object[] { null, null, null, getModItem(MalisisDoors.ID, "item.door_birch", 1, 0, missing), null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 3, "{meta:3}", missing),
                new Object[] { getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0, missing), null, null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 259, "{meta:259}", missing),
                new Object[] { null, getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0, missing), null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 515, "{meta:515}", missing),
                new Object[] { null, null, getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0, missing), null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 771, "{meta:771}", missing),
                new Object[] { null, null, null, getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0, missing), null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 4, "{meta:4}", missing),
                new Object[] { getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0, missing), null, null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 260, "{meta:260}", missing),
                new Object[] { null, getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0, missing), null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 516, "{meta:516}", missing),
                new Object[] { null, null, getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0, missing), null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 772, "{meta:772}", missing),
                new Object[] { null, null, null, getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0, missing), null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 5, "{meta:5}", missing),
                new Object[] { getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0, missing), null, null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 261, "{meta:261}", missing),
                new Object[] { null, getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0, missing), null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 517, "{meta:517}", missing),
                new Object[] { null, null, getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0, missing), null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 773, "{meta:773}", missing),
                new Object[] { null, null, null, getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0, missing), null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 32, "{meta:32}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 32, "{meta:32}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 288, "{meta:288}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 32, "{meta:32}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 544, "{meta:544}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 32, "{meta:32}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 790, "{meta:790}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 32, "{meta:32}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 33, "{meta:33}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 33, "{meta:33}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 289, "{meta:289}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 33, "{meta:33}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 545, "{meta:545}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 33, "{meta:33}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 801, "{meta:801}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 33, "{meta:33}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 34, "{meta:34}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 34, "{meta:34}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 290, "{meta:290}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 34, "{meta:34}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 546, "{meta:546}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 34, "{meta:34}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 802, "{meta:802}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 34, "{meta:34}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 35, "{meta:35}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 35, "{meta:35}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 291, "{meta:291}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 35, "{meta:35}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 547, "{meta:547}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 35, "{meta:35}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 803, "{meta:803}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 35, "{meta:35}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 36, "{meta:36}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:4}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 36, "{meta:36}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 292, "{meta:292}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 36, "{meta:36}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 548, "{meta:548}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 36, "{meta:36}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 804, "{meta:804}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 36, "{meta:36}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 37, "{meta:37}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 37, "{meta:37}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 293, "{meta:293}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 37, "{meta:37}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 549, "{meta:549}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 37, "{meta:37}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 805, "{meta:805}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 37, "{meta:37}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 38, "{meta:38}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 38, "{meta:38}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 294, "{meta:294}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 38, "{meta:38}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 550, "{meta:550}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 38, "{meta:38}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 806, "{meta:806}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 38, "{meta:38}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 39, "{meta:39}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 39, "{meta:39}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 295, "{meta:295}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 39, "{meta:39}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 551, "{meta:551}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 39, "{meta:39}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 807, "{meta:807}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 39, "{meta:39}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 40, "{meta:40}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 40, "{meta:40}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 296, "{meta:296}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 40, "{meta:40}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 552, "{meta:552}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 40, "{meta:40}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 808, "{meta:808}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 40, "{meta:40}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 41, "{meta:41}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 41, "{meta:41}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 297, "{meta:297}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 41, "{meta:41}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 553, "{meta:553}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 41, "{meta:41}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 809, "{meta:809}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 41, "{meta:41}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 42, "{meta:42}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 42, "{meta:42}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 298, "{meta:298}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 42, "{meta:42}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 554, "{meta:554}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 42, "{meta:42}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 810, "{meta:810}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 42, "{meta:42}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 43, "{meta:43}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 43, "{meta:43}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 299, "{meta:299}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 43, "{meta:43}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 555, "{meta:555}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 43, "{meta:43}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 811, "{meta:811}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 43, "{meta:43}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 44, "{meta:44}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 44, "{meta:44}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 300, "{meta:300}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 44, "{meta:44}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 556, "{meta:556}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 44, "{meta:44}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 812, "{meta:812}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 44, "{meta:44}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 45, "{meta:45}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:12}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 45, "{meta:45}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 301, "{meta:301}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 45, "{meta:45}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 557, "{meta:557}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 45, "{meta:45}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 813, "{meta:813}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 45, "{meta:45}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 46, "{meta:46}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 46, "{meta:46}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 302, "{meta:302}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 46, "{meta:46}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 558, "{meta:558}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 46, "{meta:46}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 814, "{meta:814}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 46, "{meta:46}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 47, "{meta:47}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 47, "{meta:47}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 303, "{meta:303}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 47, "{meta:47}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 559, "{meta:559}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 47, "{meta:47}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 815, "{meta:815}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 47, "{meta:47}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 48, "{meta:48}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 48, "{meta:48}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 304, "{meta:304}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 48, "{meta:48}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 560, "{meta:560}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 48, "{meta:48}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 816, "{meta:816}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 48, "{meta:48}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 49, "{meta:49}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 49, "{meta:49}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 305, "{meta:305}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 49, "{meta:49}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 561, "{meta:561}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 49, "{meta:49}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 817, "{meta:817}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 49, "{meta:49}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 50, "{meta:50}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 50, "{meta:50}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 306, "{meta:306}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 50, "{meta:50}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 562, "{meta:562}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 50, "{meta:50}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 818, "{meta:818}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 50, "{meta:50}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 51, "{meta:51}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 51, "{meta:51}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 307, "{meta:307}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 51, "{meta:51}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 563, "{meta:563}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 51, "{meta:51}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 819, "{meta:819}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 51, "{meta:51}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 52, "{meta:52}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 52, "{meta:52}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 308, "{meta:308}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 52, "{meta:52}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 564, "{meta:564}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 52, "{meta:52}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 820, "{meta:820}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 52, "{meta:52}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 53, "{meta:53}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 53, "{meta:53}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 309, "{meta:309}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 53, "{meta:53}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 565, "{meta:565}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 53, "{meta:53}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 821, "{meta:821}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 53, "{meta:53}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 54, "{meta:54}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 54, "{meta:54}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 310, "{meta:310}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 54, "{meta:54}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 566, "{meta:566}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 54, "{meta:54}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 822, "{meta:822}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 54, "{meta:54}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 55, "{meta:55}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 55, "{meta:55}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 311, "{meta:311}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 55, "{meta:55}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 567, "{meta:567}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 55, "{meta:55}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 823, "{meta:823}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 55, "{meta:55}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 56, "{meta:56}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 56, "{meta:56}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 312, "{meta:312}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 56, "{meta:56}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 568, "{meta:568}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 56, "{meta:56}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 824, "{meta:824}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 56, "{meta:56}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 57, "{meta:57}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 57, "{meta:57}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 313, "{meta:313}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 57, "{meta:57}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 569, "{meta:569}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 57, "{meta:57}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 825, "{meta:825}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 57, "{meta:57}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 58, "{meta:58}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 58, "{meta:58}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 314, "{meta:314}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 58, "{meta:58}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 570, "{meta:570}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 58, "{meta:58}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 826, "{meta:826}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 58, "{meta:58}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 59, "{meta:59}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 59, "{meta:59}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 315, "{meta:315}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 59, "{meta:59}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 571, "{meta:571}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 59, "{meta:59}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 827, "{meta:827}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 59, "{meta:59}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 60, "{meta:60}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 60, "{meta:60}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 316, "{meta:316}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 60, "{meta:60}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 572, "{meta:572}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 60, "{meta:60}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 828, "{meta:828}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 60, "{meta:60}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 61, "{meta:61}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 61, "{meta:61}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 317, "{meta:317}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 61, "{meta:61}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 573, "{meta:573}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 61, "{meta:61}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 829, "{meta:829}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 61, "{meta:61}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 62, "{meta:62}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 62, "{meta:62}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 318, "{meta:318}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 62, "{meta:62}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 574, "{meta:574}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 62, "{meta:62}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 830, "{meta:830}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 62, "{meta:62}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 63, "{meta:63}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 63, "{meta:63}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 319, "{meta:319}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 63, "{meta:63}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 575, "{meta:575}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 63, "{meta:63}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 831, "{meta:831}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 63, "{meta:63}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 64, "{meta:64}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 64, "{meta:64}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 320, "{meta:320}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 64, "{meta:64}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 576, "{meta:576}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 64, "{meta:64}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 832, "{meta:832}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 64, "{meta:64}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 65, "{meta:65}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 65, "{meta:65}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 321, "{meta:321}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 65, "{meta:65}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 577, "{meta:577}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 65, "{meta:65}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 833, "{meta:833}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 65, "{meta:65}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 66, "{meta:66}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing), "ringAnyIron",
                        "screwAnyIron", createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 66, "{meta:66}", missing),
                new Object[] { createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing), "ringCopper",
                        "screwCopper", createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 322, "{meta:322}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 66, "{meta:66}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 578, "{meta:578}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 66, "{meta:66}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 834, "{meta:834}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 66, "{meta:66}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 128, "{meta:128}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 0, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 0, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 0, missing),
                        getModItem(Forestry.ID, "planks", 1, 0, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 128, "{meta:128}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 0, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 0, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 0, missing),
                        getModItem(Forestry.ID, "planks", 1, 0, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 384, "{meta:384}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 128, "{meta:128}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 640, "{meta:640}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 128, "{meta:128}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 896, "{meta:896}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 128, "{meta:128}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 129, "{meta:129}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 1, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 1, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 1, missing),
                        getModItem(Forestry.ID, "planks", 1, 1, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 129, "{meta:129}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 1, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 1, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 1, missing),
                        getModItem(Forestry.ID, "planks", 1, 1, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 385, "{meta:385}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 129, "{meta:129}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 641, "{meta:641}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 129, "{meta:129}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 897, "{meta:897}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 129, "{meta:129}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 130, "{meta:130}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 2, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 2, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 2, missing),
                        getModItem(Forestry.ID, "planks", 1, 2, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 130, "{meta:130}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 2, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 2, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 2, missing),
                        getModItem(Forestry.ID, "planks", 1, 2, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 386, "{meta:386}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 130, "{meta:130}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 642, "{meta:642}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 130, "{meta:130}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 898, "{meta:898}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 130, "{meta:130}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 131, "{meta:131}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 3, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 3, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 3, missing),
                        getModItem(Forestry.ID, "planks", 1, 3, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 131, "{meta:131}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 3, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 3, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 3, missing),
                        getModItem(Forestry.ID, "planks", 1, 3, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 387, "{meta:387}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 131, "{meta:131}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 643, "{meta:643}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 131, "{meta:131}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 899, "{meta:899}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 131, "{meta:131}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 132, "{meta:132}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 4, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 4, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 4, missing),
                        getModItem(Forestry.ID, "planks", 1, 4, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 132, "{meta:132}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 4, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 4, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 4, missing),
                        getModItem(Forestry.ID, "planks", 1, 4, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 388, "{meta:388}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 132, "{meta:132}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 644, "{meta:644}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 132, "{meta:132}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 900, "{meta:900}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 132, "{meta:132}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 133, "{meta:133}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 5, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 5, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 5, missing),
                        getModItem(Forestry.ID, "planks", 1, 5, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 133, "{meta:133}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 5, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 5, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 5, missing),
                        getModItem(Forestry.ID, "planks", 1, 5, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 389, "{meta:389}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 133, "{meta:133}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 645, "{meta:645}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 133, "{meta:133}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 901, "{meta:901}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 133, "{meta:133}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 134, "{meta:134}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 6, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 6, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 6, missing),
                        getModItem(Forestry.ID, "planks", 1, 6, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 134, "{meta:134}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 6, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 6, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 6, missing),
                        getModItem(Forestry.ID, "planks", 1, 6, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 390, "{meta:390}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 134, "{meta:134}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 646, "{meta:646}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 134, "{meta:134}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 902, "{meta:902}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 134, "{meta:134}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 135, "{meta:135}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 7, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 7, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 7, missing),
                        getModItem(Forestry.ID, "planks", 1, 7, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 135, "{meta:135}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 7, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 7, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 7, missing),
                        getModItem(Forestry.ID, "planks", 1, 7, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 391, "{meta:391}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 135, "{meta:135}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 647, "{meta:647}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 135, "{meta:135}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 903, "{meta:903}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 135, "{meta:135}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 136, "{meta:136}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 8, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 8, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 8, missing),
                        getModItem(Forestry.ID, "planks", 1, 8, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 136, "{meta:136}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 8, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 8, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 8, missing),
                        getModItem(Forestry.ID, "planks", 1, 8, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 392, "{meta:392}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 136, "{meta:136}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 648, "{meta:648}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 136, "{meta:136}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 904, "{meta:904}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 136, "{meta:136}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 137, "{meta:137}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 9, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 9, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 9, missing),
                        getModItem(Forestry.ID, "planks", 1, 9, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 137, "{meta:137}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 9, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 9, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 9, missing),
                        getModItem(Forestry.ID, "planks", 1, 9, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 393, "{meta:393}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 137, "{meta:137}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 649, "{meta:649}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 137, "{meta:137}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 905, "{meta:905}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 137, "{meta:137}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 138, "{meta:138}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 10, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 10, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 10, missing),
                        getModItem(Forestry.ID, "planks", 1, 10, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 138, "{meta:138}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 10, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 10, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 10, missing),
                        getModItem(Forestry.ID, "planks", 1, 10, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 394, "{meta:394}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 138, "{meta:138}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 650, "{meta:650}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 138, "{meta:138}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 906, "{meta:906}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 138, "{meta:138}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 139, "{meta:139}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 11, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 11, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 11, missing),
                        getModItem(Forestry.ID, "planks", 1, 11, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 139, "{meta:139}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 11, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 11, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 11, missing),
                        getModItem(Forestry.ID, "planks", 1, 11, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 395, "{meta:395}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 139, "{meta:139}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 651, "{meta:651}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 139, "{meta:139}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 907, "{meta:907}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 139, "{meta:139}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 140, "{meta:140}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 12, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 12, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 12, missing),
                        getModItem(Forestry.ID, "planks", 1, 12, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 140, "{meta:140}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 12, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 12, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 12, missing),
                        getModItem(Forestry.ID, "planks", 1, 12, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 396, "{meta:396}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 140, "{meta:140}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 652, "{meta:652}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 140, "{meta:140}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 908, "{meta:908}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 140, "{meta:140}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 141, "{meta:141}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 13, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 13, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 13, missing),
                        getModItem(Forestry.ID, "planks", 1, 13, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 141, "{meta:141}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 13, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 13, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 13, missing),
                        getModItem(Forestry.ID, "planks", 1, 13, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 397, "{meta:397}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 141, "{meta:141}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 653, "{meta:653}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 141, "{meta:141}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 909, "{meta:909}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 141, "{meta:141}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 142, "{meta:142}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 14, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 14, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 14, missing),
                        getModItem(Forestry.ID, "planks", 1, 14, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 142, "{meta:142}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 14, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 14, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 14, missing),
                        getModItem(Forestry.ID, "planks", 1, 14, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 398, "{meta:398}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 142, "{meta:142}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 654, "{meta:654}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 142, "{meta:142}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 910, "{meta:910}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 142, "{meta:142}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 143, "{meta:143}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 15, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 15, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 15, missing),
                        getModItem(Forestry.ID, "planks", 1, 15, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 143, "{meta:143}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 15, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 15, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 15, missing),
                        getModItem(Forestry.ID, "planks", 1, 15, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 399, "{meta:399}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 143, "{meta:143}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 655, "{meta:655}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 143, "{meta:143}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 911, "{meta:911}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 143, "{meta:143}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 144, "{meta:144}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 16, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 16, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 16, missing),
                        getModItem(Forestry.ID, "planks", 1, 16, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 144, "{meta:144}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 16, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 16, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 16, missing),
                        getModItem(Forestry.ID, "planks", 1, 16, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 400, "{meta:400}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 144, "{meta:144}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 656, "{meta:656}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 144, "{meta:144}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 912, "{meta:912}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 144, "{meta:144}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 145, "{meta:145}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 17, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 17, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 17, missing),
                        getModItem(Forestry.ID, "planks", 1, 17, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 145, "{meta:145}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 17, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 17, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 17, missing),
                        getModItem(Forestry.ID, "planks", 1, 17, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 401, "{meta:401}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 145, "{meta:145}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 657, "{meta:657}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 145, "{meta:145}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 913, "{meta:913}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 145, "{meta:145}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 146, "{meta:146}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 18, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 18, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 18, missing),
                        getModItem(Forestry.ID, "planks", 1, 18, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 146, "{meta:146}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 18, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 18, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 18, missing),
                        getModItem(Forestry.ID, "planks", 1, 18, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 402, "{meta:402}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 146, "{meta:146}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 658, "{meta:658}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 146, "{meta:146}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 914, "{meta:914}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 146, "{meta:146}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 147, "{meta:147}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 19, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 19, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 19, missing),
                        getModItem(Forestry.ID, "planks", 1, 19, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 147, "{meta:147}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 19, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 19, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 19, missing),
                        getModItem(Forestry.ID, "planks", 1, 19, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 403, "{meta:403}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 147, "{meta:147}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 659, "{meta:659}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 147, "{meta:147}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 915, "{meta:915}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 147, "{meta:147}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 148, "{meta:148}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 20, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 20, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 20, missing),
                        getModItem(Forestry.ID, "planks", 1, 20, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 148, "{meta:148}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 20, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 20, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 20, missing),
                        getModItem(Forestry.ID, "planks", 1, 20, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 404, "{meta:404}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 148, "{meta:148}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 660, "{meta:660}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 148, "{meta:148}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 916, "{meta:916}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 148, "{meta:148}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 149, "{meta:149}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 21, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 21, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 21, missing),
                        getModItem(Forestry.ID, "planks", 1, 21, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 149, "{meta:149}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 21, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 21, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 21, missing),
                        getModItem(Forestry.ID, "planks", 1, 21, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 405, "{meta:405}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 149, "{meta:149}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 661, "{meta:661}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 149, "{meta:149}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 917, "{meta:917}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 149, "{meta:149}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 150, "{meta:150}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 22, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 22, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 22, missing),
                        getModItem(Forestry.ID, "planks", 1, 22, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 150, "{meta:150}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 22, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 22, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 22, missing),
                        getModItem(Forestry.ID, "planks", 1, 22, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 406, "{meta:406}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 150, "{meta:150}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 662, "{meta:662}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 150, "{meta:150}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 918, "{meta:918}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 150, "{meta:150}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 151, "{meta:151}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 23, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 23, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 23, missing),
                        getModItem(Forestry.ID, "planks", 1, 23, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 151, "{meta:151}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 23, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 23, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 23, missing),
                        getModItem(Forestry.ID, "planks", 1, 23, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 407, "{meta:407}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 151, "{meta:151}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 663, "{meta:663}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 151, "{meta:151}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 919, "{meta:919}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 151, "{meta:151}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 152, "{meta:152}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 24, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 24, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 24, missing),
                        getModItem(Forestry.ID, "planks", 1, 24, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 152, "{meta:152}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 24, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 24, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 24, missing),
                        getModItem(Forestry.ID, "planks", 1, 24, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 408, "{meta:408}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 152, "{meta:152}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 664, "{meta:664}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 152, "{meta:152}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 920, "{meta:920}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 152, "{meta:152}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 153, "{meta:153}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 25, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 25, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 25, missing),
                        getModItem(Forestry.ID, "planks", 1, 25, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 153, "{meta:153}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 25, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 25, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 25, missing),
                        getModItem(Forestry.ID, "planks", 1, 25, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 409, "{meta:409}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 153, "{meta:153}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 665, "{meta:665}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 153, "{meta:153}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 921, "{meta:921}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 153, "{meta:153}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 154, "{meta:154}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 26, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 26, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 26, missing),
                        getModItem(Forestry.ID, "planks", 1, 26, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 154, "{meta:154}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 26, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 26, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 26, missing),
                        getModItem(Forestry.ID, "planks", 1, 26, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 410, "{meta:410}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 154, "{meta:154}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 666, "{meta:666}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 154, "{meta:154}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 922, "{meta:922}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 154, "{meta:154}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 155, "{meta:155}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 27, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 27, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 27, missing),
                        getModItem(Forestry.ID, "planks", 1, 27, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 155, "{meta:155}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 27, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 27, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 27, missing),
                        getModItem(Forestry.ID, "planks", 1, 27, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 411, "{meta:411}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 155, "{meta:155}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 667, "{meta:667}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 155, "{meta:155}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 923, "{meta:923}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 155, "{meta:155}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 156, "{meta:156}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 28, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 28, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Forestry.ID, "planks", 1, 28, missing),
                        getModItem(Forestry.ID, "planks", 1, 28, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 156, "{meta:156}", missing),
                new Object[] { getModItem(Forestry.ID, "planks", 1, 28, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Forestry.ID, "planks", 1, 28, missing), "ringCopper", "screwCopper",
                        getModItem(Forestry.ID, "planks", 1, 28, missing),
                        getModItem(Forestry.ID, "planks", 1, 28, missing), "craftingToolSaw" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 412, "{meta:412}", missing),
                new Object[] { null, createItemStack(ExtraTrees.ID, "door", 1, 156, "{meta:156}", missing), null, null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 668, "{meta:668}", missing),
                new Object[] { null, null, createItemStack(ExtraTrees.ID, "door", 1, 156, "{meta:156}", missing), null,
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "door", 1, 924, "{meta:924}", missing),
                new Object[] { null, null, null, createItemStack(ExtraTrees.ID, "door", 1, 156, "{meta:156}", missing),
                        null, null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 1, "{meta:1}", missing),
                new Object[] { getModItem(MalisisDoors.ID, "spruceFenceGate", 1, 0, missing), null, null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 2, "{meta:2}", missing),
                new Object[] { getModItem(MalisisDoors.ID, "birchFenceGate", 1, 0, missing), null, null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 3, "{meta:3}", missing),
                new Object[] { getModItem(MalisisDoors.ID, "jungleFenceGate", 1, 0, missing), null, null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 4, "{meta:4}", missing),
                new Object[] { getModItem(MalisisDoors.ID, "acaciaFenceGate", 1, 0, missing), null, null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 5, "{meta:5}", missing),
                new Object[] { getModItem(MalisisDoors.ID, "darkOakFenceGate", 1, 0, missing), null, null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 32, "{meta:32}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 32, "{meta:32}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 32, "{meta:32}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 33, "{meta:33}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 33, "{meta:33}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 33, "{meta:33}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 34, "{meta:34}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 34, "{meta:34}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing) });

        ForestryHelper.removeCarpenterRecipe(getModItem(ExtraTrees.ID, "database", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(ExtraTrees.ID, "databaseMoth", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 1440),
                getModItem(Forestry.ID, "treealyzer", 1, 0, missing),
                getModItem(ExtraTrees.ID, "database", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'b',
                "itemCasingGold",
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                'e',
                "circuitAdvanced",
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17501, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'h',
                "itemCasingGold",
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 1440),
                getModItem(Forestry.ID, "flutterlyzer", 1, 0, missing),
                getModItem(ExtraTrees.ID, "databaseMoth", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'b',
                "itemCasingGold",
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17501, missing),
                'e',
                "circuitAdvanced",
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'h',
                "itemCasingGold",
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing));

    }

    public void recipes2() {
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 34, "{meta:34}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 35, "{meta:35}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 35, "{meta:35}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 35, "{meta:35}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 36, "{meta:36}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 36, "{meta:36}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 36, "{meta:36}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 37, "{meta:37}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 37, "{meta:37}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 37, "{meta:37}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 38, "{meta:38}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 38, "{meta:38}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 38, "{meta:38}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 39, "{meta:39}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 39, "{meta:39}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 39, "{meta:39}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 40, "{meta:40}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 40, "{meta:40}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 40, "{meta:40}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 41, "{meta:41}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 41, "{meta:41}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 41, "{meta:41}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 42, "{meta:42}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 42, "{meta:42}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 42, "{meta:42}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 43, "{meta:43}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 43, "{meta:43}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 43, "{meta:43}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 44, "{meta:44}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 44, "{meta:44}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 44, "{meta:44}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 45, "{meta:45}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 45, "{meta:45}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 45, "{meta:45}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 46, "{meta:46}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 46, "{meta:46}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 46, "{meta:46}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 47, "{meta:47}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 47, "{meta:47}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 47, "{meta:47}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 48, "{meta:48}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 48, "{meta:48}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 48, "{meta:48}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 49, "{meta:49}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 49, "{meta:49}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 49, "{meta:49}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 50, "{meta:50}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 50, "{meta:50}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 50, "{meta:50}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 51, "{meta:51}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 51, "{meta:51}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 51, "{meta:51}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 52, "{meta:52}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 52, "{meta:52}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 52, "{meta:52}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 53, "{meta:53}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 53, "{meta:53}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 53, "{meta:53}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 54, "{meta:54}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 54, "{meta:54}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 54, "{meta:54}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 55, "{meta:55}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 55, "{meta:55}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 55, "{meta:55}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 56, "{meta:56}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 56, "{meta:56}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 56, "{meta:56}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 57, "{meta:57}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 57, "{meta:57}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 57, "{meta:57}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 58, "{meta:58}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 58, "{meta:58}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 58, "{meta:58}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 59, "{meta:59}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 59, "{meta:59}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 59, "{meta:59}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 60, "{meta:60}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 60, "{meta:60}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 60, "{meta:60}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 61, "{meta:61}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 61, "{meta:61}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 61, "{meta:61}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 62, "{meta:62}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 62, "{meta:62}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 62, "{meta:62}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 63, "{meta:63}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 63, "{meta:63}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 63, "{meta:63}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 64, "{meta:64}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 64, "{meta:64}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 64, "{meta:64}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 65, "{meta:65}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 65, "{meta:65}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 65, "{meta:65}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 66, "{meta:66}", missing),
                new Object[] { "itemFlint", null, "itemFlint",
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 66, "{meta:66}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 66, "{meta:66}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing),
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 128, "{meta:128}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 0, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 0, missing),
                        getModItem(Forestry.ID, "planks", 1, 0, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 0, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 128, "{meta:128}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 0, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 0, missing),
                        getModItem(Forestry.ID, "planks", 1, 0, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 0, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 128, "{meta:128}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 0, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 0, missing),
                        getModItem(Forestry.ID, "planks", 1, 0, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 0, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 129, "{meta:129}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 1, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 1, missing),
                        getModItem(Forestry.ID, "planks", 1, 1, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 1, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 129, "{meta:129}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 1, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 1, missing),
                        getModItem(Forestry.ID, "planks", 1, 1, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 1, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 129, "{meta:129}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 1, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 1, missing),
                        getModItem(Forestry.ID, "planks", 1, 1, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 1, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 130, "{meta:130}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 2, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 2, missing),
                        getModItem(Forestry.ID, "planks", 1, 2, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 2, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 130, "{meta:130}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 2, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 2, missing),
                        getModItem(Forestry.ID, "planks", 1, 2, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 2, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 130, "{meta:130}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 2, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 2, missing),
                        getModItem(Forestry.ID, "planks", 1, 2, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 2, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 131, "{meta:131}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 3, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 3, missing),
                        getModItem(Forestry.ID, "planks", 1, 3, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 3, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 131, "{meta:131}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 3, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 3, missing),
                        getModItem(Forestry.ID, "planks", 1, 3, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 3, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 131, "{meta:131}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 3, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 3, missing),
                        getModItem(Forestry.ID, "planks", 1, 3, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 3, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 132, "{meta:132}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 4, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 4, missing),
                        getModItem(Forestry.ID, "planks", 1, 4, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 4, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 132, "{meta:132}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 4, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 4, missing),
                        getModItem(Forestry.ID, "planks", 1, 4, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 4, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 132, "{meta:132}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 4, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 4, missing),
                        getModItem(Forestry.ID, "planks", 1, 4, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 4, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 133, "{meta:133}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 5, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 5, missing),
                        getModItem(Forestry.ID, "planks", 1, 5, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 5, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 133, "{meta:133}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 5, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 5, missing),
                        getModItem(Forestry.ID, "planks", 1, 5, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 5, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 133, "{meta:133}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 5, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 5, missing),
                        getModItem(Forestry.ID, "planks", 1, 5, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 5, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 134, "{meta:134}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 6, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 6, missing),
                        getModItem(Forestry.ID, "planks", 1, 6, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 6, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 134, "{meta:134}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 6, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 6, missing),
                        getModItem(Forestry.ID, "planks", 1, 6, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 6, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 134, "{meta:134}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 6, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 6, missing),
                        getModItem(Forestry.ID, "planks", 1, 6, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 6, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 135, "{meta:135}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 7, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 7, missing),
                        getModItem(Forestry.ID, "planks", 1, 7, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 7, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 135, "{meta:135}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 7, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 7, missing),
                        getModItem(Forestry.ID, "planks", 1, 7, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 7, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 135, "{meta:135}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 7, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 7, missing),
                        getModItem(Forestry.ID, "planks", 1, 7, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 7, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 136, "{meta:136}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 8, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 8, missing),
                        getModItem(Forestry.ID, "planks", 1, 8, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 8, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 136, "{meta:136}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 8, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 8, missing),
                        getModItem(Forestry.ID, "planks", 1, 8, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 8, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 136, "{meta:136}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 8, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 8, missing),
                        getModItem(Forestry.ID, "planks", 1, 8, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 8, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 137, "{meta:137}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 9, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 9, missing),
                        getModItem(Forestry.ID, "planks", 1, 9, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 9, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 137, "{meta:137}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 9, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 9, missing),
                        getModItem(Forestry.ID, "planks", 1, 9, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 9, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 137, "{meta:137}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 9, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 9, missing),
                        getModItem(Forestry.ID, "planks", 1, 9, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 9, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 138, "{meta:138}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 10, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 10, missing),
                        getModItem(Forestry.ID, "planks", 1, 10, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 10, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 138, "{meta:138}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 10, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 10, missing),
                        getModItem(Forestry.ID, "planks", 1, 10, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 10, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 138, "{meta:138}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 10, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 10, missing),
                        getModItem(Forestry.ID, "planks", 1, 10, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 10, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 139, "{meta:139}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 11, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 11, missing),
                        getModItem(Forestry.ID, "planks", 1, 11, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 11, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 139, "{meta:139}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 11, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 11, missing),
                        getModItem(Forestry.ID, "planks", 1, 11, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 11, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 139, "{meta:139}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 11, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 11, missing),
                        getModItem(Forestry.ID, "planks", 1, 11, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 11, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 140, "{meta:140}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 12, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 12, missing),
                        getModItem(Forestry.ID, "planks", 1, 12, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 12, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 140, "{meta:140}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 12, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 12, missing),
                        getModItem(Forestry.ID, "planks", 1, 12, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 12, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 140, "{meta:140}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 12, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 12, missing),
                        getModItem(Forestry.ID, "planks", 1, 12, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 12, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 141, "{meta:141}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 13, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 13, missing),
                        getModItem(Forestry.ID, "planks", 1, 13, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 13, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 141, "{meta:141}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 13, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 13, missing),
                        getModItem(Forestry.ID, "planks", 1, 13, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 13, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 141, "{meta:141}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 13, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 13, missing),
                        getModItem(Forestry.ID, "planks", 1, 13, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 13, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 142, "{meta:142}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 14, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 14, missing),
                        getModItem(Forestry.ID, "planks", 1, 14, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 14, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 142, "{meta:142}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 14, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 14, missing),
                        getModItem(Forestry.ID, "planks", 1, 14, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 14, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 142, "{meta:142}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 14, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 14, missing),
                        getModItem(Forestry.ID, "planks", 1, 14, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 14, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 143, "{meta:143}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 15, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 15, missing),
                        getModItem(Forestry.ID, "planks", 1, 15, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 15, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 143, "{meta:143}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 15, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 15, missing),
                        getModItem(Forestry.ID, "planks", 1, 15, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 15, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 143, "{meta:143}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 15, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 15, missing),
                        getModItem(Forestry.ID, "planks", 1, 15, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 15, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 144, "{meta:144}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 16, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 16, missing),
                        getModItem(Forestry.ID, "planks", 1, 16, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 16, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 144, "{meta:144}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 16, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 16, missing),
                        getModItem(Forestry.ID, "planks", 1, 16, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 16, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 144, "{meta:144}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 16, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 16, missing),
                        getModItem(Forestry.ID, "planks", 1, 16, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 16, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 145, "{meta:145}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 17, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 17, missing),
                        getModItem(Forestry.ID, "planks", 1, 17, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 17, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 145, "{meta:145}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 17, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 17, missing),
                        getModItem(Forestry.ID, "planks", 1, 17, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 17, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 145, "{meta:145}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 17, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 17, missing),
                        getModItem(Forestry.ID, "planks", 1, 17, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 17, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 146, "{meta:146}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 18, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 18, missing),
                        getModItem(Forestry.ID, "planks", 1, 18, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 18, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 146, "{meta:146}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 18, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 18, missing),
                        getModItem(Forestry.ID, "planks", 1, 18, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 18, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 146, "{meta:146}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 18, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 18, missing),
                        getModItem(Forestry.ID, "planks", 1, 18, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 18, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 147, "{meta:147}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 19, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 19, missing),
                        getModItem(Forestry.ID, "planks", 1, 19, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 19, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 147, "{meta:147}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 19, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 19, missing),
                        getModItem(Forestry.ID, "planks", 1, 19, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 19, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 147, "{meta:147}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 19, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 19, missing),
                        getModItem(Forestry.ID, "planks", 1, 19, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 19, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 148, "{meta:148}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 20, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 20, missing),
                        getModItem(Forestry.ID, "planks", 1, 20, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 20, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 148, "{meta:148}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 20, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 20, missing),
                        getModItem(Forestry.ID, "planks", 1, 20, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 20, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 148, "{meta:148}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 20, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 20, missing),
                        getModItem(Forestry.ID, "planks", 1, 20, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 20, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 149, "{meta:149}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 21, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 21, missing),
                        getModItem(Forestry.ID, "planks", 1, 21, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 21, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 149, "{meta:149}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 21, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 21, missing),
                        getModItem(Forestry.ID, "planks", 1, 21, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 21, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 149, "{meta:149}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 21, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 21, missing),
                        getModItem(Forestry.ID, "planks", 1, 21, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 21, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 150, "{meta:150}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 22, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 22, missing),
                        getModItem(Forestry.ID, "planks", 1, 22, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 22, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 150, "{meta:150}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 22, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 22, missing),
                        getModItem(Forestry.ID, "planks", 1, 22, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 22, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 150, "{meta:150}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 22, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 22, missing),
                        getModItem(Forestry.ID, "planks", 1, 22, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 22, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 151, "{meta:151}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 23, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 23, missing),
                        getModItem(Forestry.ID, "planks", 1, 23, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 23, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 151, "{meta:151}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 23, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 23, missing),
                        getModItem(Forestry.ID, "planks", 1, 23, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 23, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 151, "{meta:151}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 23, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 23, missing),
                        getModItem(Forestry.ID, "planks", 1, 23, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 23, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 152, "{meta:152}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 24, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 24, missing),
                        getModItem(Forestry.ID, "planks", 1, 24, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 24, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 152, "{meta:152}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 24, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 24, missing),
                        getModItem(Forestry.ID, "planks", 1, 24, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 24, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 152, "{meta:152}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 24, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 24, missing),
                        getModItem(Forestry.ID, "planks", 1, 24, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 24, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 153, "{meta:153}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 25, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 25, missing),
                        getModItem(Forestry.ID, "planks", 1, 25, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 25, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 153, "{meta:153}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 25, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 25, missing),
                        getModItem(Forestry.ID, "planks", 1, 25, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 25, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 153, "{meta:153}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 25, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 25, missing),
                        getModItem(Forestry.ID, "planks", 1, 25, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 25, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 154, "{meta:154}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 26, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 26, missing),
                        getModItem(Forestry.ID, "planks", 1, 26, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 26, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 154, "{meta:154}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 26, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 26, missing),
                        getModItem(Forestry.ID, "planks", 1, 26, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 26, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 154, "{meta:154}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 26, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 26, missing),
                        getModItem(Forestry.ID, "planks", 1, 26, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 26, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 155, "{meta:155}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 27, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 27, missing),
                        getModItem(Forestry.ID, "planks", 1, 27, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 27, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 155, "{meta:155}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 27, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 27, missing),
                        getModItem(Forestry.ID, "planks", 1, 27, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 27, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 155, "{meta:155}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 27, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 27, missing),
                        getModItem(Forestry.ID, "planks", 1, 27, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 27, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 1, 156, "{meta:156}", missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Forestry.ID, "planks", 1, 28, missing),
                        "stickWood", getModItem(Forestry.ID, "planks", 1, 28, missing),
                        getModItem(Forestry.ID, "planks", 1, 28, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 28, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 2, 156, "{meta:156}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Forestry.ID, "planks", 1, 28, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 28, missing),
                        getModItem(Forestry.ID, "planks", 1, 28, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 28, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "gate", 4, 156, "{meta:156}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Forestry.ID, "planks", 1, 28, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 28, missing),
                        getModItem(Forestry.ID, "planks", 1, 28, missing), "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 28, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 32, "{meta:32}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 32, "{meta:32}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 32, "{meta:32}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 33, "{meta:33}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 33, "{meta:33}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 33, "{meta:33}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 34, "{meta:34}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 34, "{meta:34}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 34, "{meta:34}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 35, "{meta:35}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 35, "{meta:35}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 35, "{meta:35}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 36, "{meta:36}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 36, "{meta:36}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 36, "{meta:36}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 37, "{meta:37}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 37, "{meta:37}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 37, "{meta:37}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 38, "{meta:38}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 38, "{meta:38}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 38, "{meta:38}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 39, "{meta:39}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 39, "{meta:39}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 39, "{meta:39}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 40, "{meta:40}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 40, "{meta:40}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 40, "{meta:40}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 41, "{meta:41}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 41, "{meta:41}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 41, "{meta:41}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 42, "{meta:42}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 42, "{meta:42}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 42, "{meta:42}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 43, "{meta:43}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 43, "{meta:43}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 43, "{meta:43}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 44, "{meta:44}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 44, "{meta:44}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 44, "{meta:44}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 45, "{meta:45}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 45, "{meta:45}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 45, "{meta:45}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 46, "{meta:46}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 46, "{meta:46}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 46, "{meta:46}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 47, "{meta:47}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 47, "{meta:47}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 47, "{meta:47}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 48, "{meta:48}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 48, "{meta:48}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 48, "{meta:48}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 49, "{meta:49}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 49, "{meta:49}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 49, "{meta:49}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 50, "{meta:50}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 50, "{meta:50}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 50, "{meta:50}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 51, "{meta:51}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 51, "{meta:51}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 51, "{meta:51}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 52, "{meta:52}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 52, "{meta:52}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 52, "{meta:52}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 53, "{meta:53}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 53, "{meta:53}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 53, "{meta:53}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 54, "{meta:54}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 54, "{meta:54}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 54, "{meta:54}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 55, "{meta:55}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 55, "{meta:55}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 55, "{meta:55}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 56, "{meta:56}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 56, "{meta:56}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 56, "{meta:56}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 57, "{meta:57}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 57, "{meta:57}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 57, "{meta:57}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 58, "{meta:58}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 58, "{meta:58}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 58, "{meta:58}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 59, "{meta:59}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 59, "{meta:59}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 59, "{meta:59}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 60, "{meta:60}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 60, "{meta:60}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 60, "{meta:60}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 61, "{meta:61}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 61, "{meta:61}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 61, "{meta:61}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 62, "{meta:62}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 62, "{meta:62}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 62, "{meta:62}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 63, "{meta:63}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 63, "{meta:63}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 63, "{meta:63}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 64, "{meta:64}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 64, "{meta:64}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 64, "{meta:64}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 65, "{meta:65}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 65, "{meta:65}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 65, "{meta:65}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 66, "{meta:66}", missing),
                new Object[] { "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing),
                        "stickWood", "stickWood", createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing),
                        "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 66, "{meta:66}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 66, "{meta:66}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing), "stickWood", "stickWood",
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing), "stickWood" });
        addShapelessCraftingRecipe(
                createItemStack(ExtraTrees.ID, "multifence", 1, 0, "{meta:0}", missing),
                new Object[] { getModItem(Minecraft.ID, "fence", 1, 0, missing) });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 1, "{meta:1}", missing),
                new Object[] { "stickWood", getModItem(Minecraft.ID, "planks", 1, 1, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 1, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 1, missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 1, "{meta:1}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 1, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 1, missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 1, "{meta:1}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 1, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 1, missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 2, "{meta:2}", missing),
                new Object[] { "stickWood", getModItem(Minecraft.ID, "planks", 1, 2, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 2, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 2, missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 2, "{meta:2}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 2, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 2, missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 2, "{meta:2}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 2, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 2, missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 3, "{meta:3}", missing),
                new Object[] { "stickWood", getModItem(Minecraft.ID, "planks", 1, 3, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 3, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 3, missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 3, "{meta:3}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 3, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 3, missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 3, "{meta:3}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 3, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 3, missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 4, "{meta:4}", missing),
                new Object[] { "stickWood", getModItem(Minecraft.ID, "planks", 1, 4, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 4, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 4, missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 4, "{meta:4}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 4, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 4, missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 4, "{meta:4}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 4, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 4, missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 1, 5, "{meta:5}", missing),
                new Object[] { "stickWood", getModItem(Minecraft.ID, "planks", 1, 5, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 5, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 5, missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 2, 5, "{meta:5}", missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 5, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 5, missing), "stickWood" });
        addShapedRecipe(
                createItemStack(ExtraTrees.ID, "fence", 4, 5, "{meta:5}", missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 5, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 5, missing), "stickWood" });
    }
}
