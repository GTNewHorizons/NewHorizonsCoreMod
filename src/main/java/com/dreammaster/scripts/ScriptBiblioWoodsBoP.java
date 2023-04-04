package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BiblioCraft;
import static gregtech.api.enums.Mods.BiblioWoodsBoPEdition;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

public class ScriptBiblioWoodsBoP implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "BiblioWoodsBoP";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(BiomesOPlenty.ID, BiblioWoodsBoPEdition.ID, BiblioCraft.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack[] BOBwood = new ItemStack[] { getModItem(BiomesOPlenty.ID, "woodenSingleSlab1", 1),
                getModItem(BiomesOPlenty.ID, "woodenSingleSlab1", 1, 1),
                getModItem(BiomesOPlenty.ID, "woodenSingleSlab1", 1, 2),
                getModItem(BiomesOPlenty.ID, "woodenSingleSlab1", 1, 3),
                getModItem(BiomesOPlenty.ID, "woodenSingleSlab2", 1, 3),
                getModItem(BiomesOPlenty.ID, "woodenSingleSlab1", 1, 4),
                getModItem(BiomesOPlenty.ID, "woodenSingleSlab2", 1, 4),
                getModItem(BiomesOPlenty.ID, "woodenSingleSlab1", 1, 5),
                getModItem(BiomesOPlenty.ID, "woodenSingleSlab1", 1, 6),
                getModItem(BiomesOPlenty.ID, "woodenSingleSlab1", 1, 7),
                getModItem(BiomesOPlenty.ID, "woodenSingleSlab2", 1, 2),
                getModItem(BiomesOPlenty.ID, "woodenSingleSlab2", 1),
                getModItem(BiomesOPlenty.ID, "woodenSingleSlab2", 1, 1),
                getModItem(BiomesOPlenty.ID, "woodenSingleSlab2", 1, 5) };

        ItemStack[] BOPplanks = new ItemStack[] { getModItem(BiomesOPlenty.ID, "planks", 1, 0),
                getModItem(BiomesOPlenty.ID, "planks", 1, 1), getModItem(BiomesOPlenty.ID, "planks", 1, 2),
                getModItem(BiomesOPlenty.ID, "planks", 1, 3), getModItem(BiomesOPlenty.ID, "planks", 1, 12),
                getModItem(BiomesOPlenty.ID, "planks", 1, 4), getModItem(BiomesOPlenty.ID, "planks", 1, 13),
                getModItem(BiomesOPlenty.ID, "planks", 1, 5), getModItem(BiomesOPlenty.ID, "planks", 1, 6),
                getModItem(BiomesOPlenty.ID, "planks", 1, 7), getModItem(BiomesOPlenty.ID, "planks", 1, 11),
                getModItem(BiomesOPlenty.ID, "planks", 1, 8), getModItem(BiomesOPlenty.ID, "planks", 1, 9),
                getModItem(BiomesOPlenty.ID, "planks", 1, 14) };

        ItemStack[] FClockBOP = new ItemStack[] { getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodClock", 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodClock", 1, 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodClock", 1, 2),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodClock", 1, 3),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodClock", 1, 4),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodClock", 1, 5),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodClock", 1, 6),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodClock", 1, 7),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodClock", 1, 8),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodClock", 1, 9),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodClock", 1, 10),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodClock", 1, 11),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodClock", 1, 12),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodClock", 1, 13) };

        ItemStack[] PaintingBOP = new ItemStack[] { getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT0", 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT0", 1, 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT0", 1, 2),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT0", 1, 3),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT0", 1, 4),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT0", 1, 5),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT0", 1, 6),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT0", 1, 7),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT0", 1, 8),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT0", 1, 9),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT0", 1, 10),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT0", 1, 11),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT0", 1, 12),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT0", 1, 13) };

        ItemStack[] BOBPT1 = new ItemStack[] { getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT1", 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT1", 1, 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT1", 1, 2),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT1", 1, 3),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT1", 1, 4),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT1", 1, 5),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT1", 1, 6),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT1", 1, 7),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT1", 1, 8),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT1", 1, 9),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT1", 1, 10),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT1", 1, 11),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT1", 1, 12),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT1", 1, 13) };

        ItemStack[] BOBPT2 = new ItemStack[] { getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT2", 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT2", 1, 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT2", 1, 2),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT2", 1, 3),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT2", 1, 4),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT2", 1, 5),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT2", 1, 6),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT2", 1, 7),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT2", 1, 8),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT2", 1, 9),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT2", 1, 10),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT2", 1, 11),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT2", 1, 12),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT2", 1, 13) };

        ItemStack[] BOBPT3 = new ItemStack[] { getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT3", 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT3", 1, 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT3", 1, 2),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT3", 1, 3),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT3", 1, 4),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT3", 1, 5),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT3", 1, 6),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT3", 1, 7),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT3", 1, 8),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT3", 1, 9),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT3", 1, 10),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT3", 1, 11),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT3", 1, 12),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT3", 1, 13) };

        ItemStack[] BOBPT4 = new ItemStack[] { getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT4", 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT4", 1, 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT4", 1, 2),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT4", 1, 3),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT4", 1, 4),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT4", 1, 5),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT4", 1, 6),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT4", 1, 7),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT4", 1, 8),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT4", 1, 9),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT4", 1, 10),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT4", 1, 11),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT4", 1, 12),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodPaintingT4", 1, 13) };

        ItemStack[] FrameBOP = new ItemStack[] { getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodMapFrame", 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodMapFrame", 1, 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodMapFrame", 1, 2),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodMapFrame", 1, 3),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodMapFrame", 1, 4),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodMapFrame", 1, 5),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodMapFrame", 1, 6),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodMapFrame", 1, 7),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodMapFrame", 1, 8),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodMapFrame", 1, 9),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodMapFrame", 1, 10),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodMapFrame", 1, 11),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodMapFrame", 1, 12),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodMapFrame", 1, 13) };

        ItemStack[] LableBOP = new ItemStack[] { getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodlabel", 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodlabel", 1, 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodlabel", 1, 2),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodlabel", 1, 3),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodlabel", 1, 4),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodlabel", 1, 5),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodlabel", 1, 6),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodlabel", 1, 7),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodlabel", 1, 8),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodlabel", 1, 9),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodlabel", 1, 10),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodlabel", 1, 11),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodlabel", 1, 12),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodlabel", 1, 13) };

        ItemStack[] fancySignBOP = new ItemStack[] { getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodFancySign", 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodFancySign", 1, 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodFancySign", 1, 2),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodFancySign", 1, 3),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodFancySign", 1, 4),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodFancySign", 1, 5),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodFancySign", 1, 6),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodFancySign", 1, 7),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodFancySign", 1, 8),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodFancySign", 1, 9),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodFancySign", 1, 10),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodFancySign", 1, 11),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodFancySign", 1, 12),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodFancySign", 1, 13) };

        ItemStack[] bookCaseBOP = new ItemStack[] { getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodBookcase", 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodBookcase", 1, 1),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodBookcase", 1, 2),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodBookcase", 1, 3),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodBookcase", 1, 4),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodBookcase", 1, 5),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodBookcase", 1, 6),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodBookcase", 1, 7),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodBookcase", 1, 8),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodBookcase", 1, 9),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodBookcase", 1, 10),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodBookcase", 1, 11),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodBookcase", 1, 12),
                getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodBookcase", 1, 13) };

        ItemStack torch = getModItem(Minecraft.ID, "torch", 1);
        ItemStack feather = getModItem(Minecraft.ID, "feather", 1);
        ItemStack ink = getModItem(Minecraft.ID, "dye", 1);
        ItemStack craftingTable = getModItem(Minecraft.ID, "crafting_table", 1);
        ItemStack emptyBottle = getModItem(Minecraft.ID, "glass_bottle", 1);
        ItemStack ironIngot = getModItem(Minecraft.ID, "iron_ingot", 1);
        ItemStack glass = getModItem(Minecraft.ID, "glass", 1);
        ItemStack whiteWool = getModItem(Minecraft.ID, "wool", 1);
        ItemStack stick = getModItem(Minecraft.ID, "stick", 1);
        ItemStack woodenPressurePlate = getModItem(Minecraft.ID, "wooden_pressure_plate", 1);

        for (int i = 0; i < 14; i++) {
            addShapedRecipe(
                    FClockBOP[i],
                    new Object[] { BOBwood[i], getModItem(Minecraft.ID, "clock", 1), BOBwood[i], BOBwood[i],
                            "stickWood", BOBwood[i], BOBwood[i], "plateGold", BOBwood[i] });
            addShapedRecipe(
                    PaintingBOP[i],
                    new Object[] { BOBwood[i], BOBwood[i], BOBwood[i], BOBwood[i],
                            getModItem(BiblioCraft.ID, "item.PaintingCanvas", 1), BOBwood[i], BOBwood[i], BOBwood[i],
                            BOBwood[i] });
            addShapedRecipe(
                    BOBPT1[i],
                    new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", PaintingBOP[i], "stickWood",
                            "stickWood", "stickWood", "stickWood" });
            addShapedRecipe(
                    BOBPT2[i],
                    new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", BOBPT1[i], "stickWood",
                            "stickWood", "stickWood", "stickWood" });
            addShapedRecipe(
                    BOBPT3[i],
                    new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", BOBPT2[i], "stickWood",
                            "stickWood", "stickWood", "stickWood" });
            addShapedRecipe(
                    BOBPT4[i],
                    new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", BOBPT3[i], "stickWood",
                            "stickWood", "stickWood", "stickWood" });
            addShapedRecipe(
                    LableBOP[i],
                    new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", FrameBOP[i], "stickWood",
                            "stickWood", "stickWood", "stickWood" });
            addShapedRecipe(
                    getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodtable", 1, i),
                    new Object[] { BOBwood[i], BOBwood[i], BOBwood[i], null, BOPplanks[i], null, null, BOPplanks[i],
                            null });
            addShapedRecipe(
                    getModItem(BiblioWoodsBoPEdition.ID, "BiblioWooddesk", 1, i),
                    new Object[] { torch, null, feather, BOBwood[i], BOBwood[i], BOBwood[i], BOPplanks[i], null,
                            BOPplanks[i] });
            addShapedRecipe(
                    getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodFancyWorkbench", 1, i),
                    new Object[] { ink, craftingTable, feather, BOBwood[i], bookCaseBOP[i], BOBwood[i], BOBwood[i],
                            null, BOBwood[i] });

            addShapedRecipe(
                    getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodFancyWorkbench", 1, i),
                    new Object[] { feather, craftingTable, ink, BOBwood[i], bookCaseBOP[i], BOBwood[i], BOBwood[i],
                            BOBwood[i], BOBwood[i] });

            addShapedRecipe(
                    bookCaseBOP[i],
                    new Object[] { BOPplanks[i], BOBwood[i], BOPplanks[i], BOPplanks[i], BOBwood[i], BOPplanks[i],
                            BOPplanks[i], BOBwood[i], BOPplanks[i], });

            addShapedRecipe(
                    getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodpotshelf", 1, i),
                    new Object[] { BOBwood[i], BOBwood[i], BOBwood[i], BOPplanks[i], emptyBottle, BOPplanks[i],
                            BOBwood[i], BOBwood[i], BOBwood[i], });

            addShapedRecipe(
                    getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodshelf", 1, i),
                    new Object[] { BOBwood[i], BOBwood[i], BOBwood[i], null, BOPplanks[i], null, BOBwood[i], BOBwood[i],
                            BOBwood[i], });

            addShapedRecipe(
                    getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodrack", 1, i),
                    new Object[] { BOBwood[i], BOBwood[i], BOBwood[i], BOBwood[i], ironIngot, BOBwood[i], BOBwood[i],
                            BOBwood[i], BOBwood[i], });

            addShapedRecipe(
                    getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodcase", 1, i),
                    new Object[] { BOBwood[i], glass, BOBwood[i], BOBwood[i], whiteWool, BOBwood[i], BOBwood[i],
                            BOBwood[i], BOBwood[i], });

            addShapedRecipe(
                    getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodMapFrame", 1, i),
                    new Object[] { stick, stick, stick, stick, BOBwood[i], stick, stick, stick, stick });

            addShapedRecipe(
                    getModItem(BiblioWoodsBoPEdition.ID, "BiblioWoodSeat", 1, i),
                    new Object[] { null, whiteWool, null, null, BOBwood[i], null, stick, woodenPressurePlate, stick });

            addShapedRecipe(
                    getModItem(BiblioWoodsBoPEdition.ID, "seatBack1", 1, i),
                    new Object[] { null, whiteWool, null, null, BOBwood[i], null, stick, null, stick });

            addShapedRecipe(
                    getModItem(BiblioWoodsBoPEdition.ID, "seatBack2", 1, i),
                    new Object[] { stick, whiteWool, stick, stick, BOBwood[i], stick, stick, null, stick });

            addShapedRecipe(
                    getModItem(BiblioWoodsBoPEdition.ID, "seatBack4", 1, i),
                    new Object[] { null, whiteWool, null, null, BOBwood[i], null, null, null, null });

            addShapelessCraftingRecipe(
                    getModItem(BiblioWoodsBoPEdition.ID, "seatBack3", 1, i),
                    new Object[] { BOBwood[i], getModItem(BiblioWoodsBoPEdition.ID, "seatBack2", 1, i), });

            addShapelessCraftingRecipe(
                    getModItem(BiblioWoodsBoPEdition.ID, "seatBack5", 1, i),
                    new Object[] { BOBwood[i], BOBwood[i],
                            getModItem(BiblioWoodsBoPEdition.ID, "seatBack2", 1, i), });

            addShapelessCraftingRecipe(
                    fancySignBOP[i],
                    new Object[] { getModItem(Minecraft.ID, "paper", 1), getModItem(Minecraft.ID, "sign", 1),
                            LableBOP[i] });
        }
    }
}
