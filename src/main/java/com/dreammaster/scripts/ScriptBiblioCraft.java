package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BiblioCraft;
import static gregtech.api.enums.Mods.FloodLights;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_ModHandler;

public class ScriptBiblioCraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "BiblioCraft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                BiblioCraft.ID,
                PamsHarvestCraft.ID,
                FloodLights.ID,
                IndustrialCraft2.ID,
                OpenComputers.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack[] TypeWriterB = new ItemStack[16];
        ItemStack[] Pedestals = new ItemStack[16];
        ItemStack[] cwool16 = new ItemStack[16];
        ItemStack[] FPT1 = new ItemStack[7]; // FPT1
        ItemStack[] FPT2 = new ItemStack[7]; // FPT2
        ItemStack[] FPT3 = new ItemStack[7]; // FPT3
        ItemStack[] FPT4 = new ItemStack[7]; // FPT4
        ItemStack[] LableB = new ItemStack[7];
        ItemStack[] FrameB = new ItemStack[7];
        ItemStack[] PaintingB = new ItemStack[7];
        ItemStack[] FClockB = new ItemStack[7];
        ItemStack[] Swood = new ItemStack[] { getModItem(Minecraft.ID, "wooden_slab", 1, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 1), getModItem(Minecraft.ID, "wooden_slab", 1, 2),
                getModItem(Minecraft.ID, "wooden_slab", 1, 3), getModItem(Minecraft.ID, "wooden_slab", 1, 4),
                getModItem(Minecraft.ID, "wooden_slab", 1, 5),
                getModItem(BiblioCraft.ID, "item.FramingSheet", 1, 0) };

        String[] colorsLamp = new String[] { "dyeLightGray", "dyeGray", "dyeBlack", "dyeRed", "dyeOrange", "dyeYellow",
                "dyeLime", "dyeGreen", "dyeCyan", "dyeLightBlue", "dyeBlue", "dyePurple", "dyeMagenta", "dyePink",
                "dyeBrown" };

        ItemStack[] Bwood = new ItemStack[] { getModItem(Minecraft.ID, "wooden_slab", 1, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 1), getModItem(Minecraft.ID, "wooden_slab", 1, 2),
                getModItem(Minecraft.ID, "wooden_slab", 1, 3), getModItem(Minecraft.ID, "wooden_slab", 1, 4),
                getModItem(Minecraft.ID, "wooden_slab", 1, 5),
                getModItem(BiblioCraft.ID, "item.FramingBoard", 1, 0) };

        ItemStack[] planks = new ItemStack[] { getModItem(Minecraft.ID, "planks", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 1), getModItem(Minecraft.ID, "planks", 1, 2),
                getModItem(Minecraft.ID, "planks", 1, 3), getModItem(Minecraft.ID, "planks", 1, 4),
                getModItem(Minecraft.ID, "planks", 1, 5), getModItem(BiblioCraft.ID, "item.FramingSheet", 1, 0) };

        ItemStack[] color16 = new ItemStack[] { getMeta02(32429), // white
                getMeta02(32421), // light grey
                getMeta02(32422), // grey
                getMeta02(32414), // black
                getMeta02(32415), // red
                getMeta02(32428), // orange
                getMeta02(32425), // yellow
                getMeta02(32424), // lime
                getMeta02(32416), // green
                getMeta02(32420), // cyan
                getMeta02(32426), // light blue
                getMeta02(32418), // blue
                getMeta02(32419), // purple
                getMeta02(32427), // magenta
                getMeta02(32423), // pink
                getMeta02(32417) // brown
        };

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

        for (int i = 0; i < 16; i++) {
            TypeWriterB[i] = getModItem(BiblioCraft.ID, "BiblioTypewriter", 1, i);
            Pedestals[i] = getModItem(BiblioCraft.ID, "BiblioSwordPedestal", 1, i);
            cwool16[i] = getModItem(Minecraft.ID, "wool", 1, i);

            if (i < 7) {
                FPT1[i] = getModItem(BiblioCraft.ID, "BiblioFlatPainting", 1, i);
                FPT2[i] = getModItem(BiblioCraft.ID, "BiblioSimplePainting", 1, i);
                FPT3[i] = getModItem(BiblioCraft.ID, "BiblioMiddlePainting", 1, i);
                FPT4[i] = getModItem(BiblioCraft.ID, "BiblioFancyPainting", 1, i);
                LableB[i] = getModItem(BiblioCraft.ID, "BiblioLabel", 1, i);
                FrameB[i] = getModItem(BiblioCraft.ID, "BiblioMapFrames", 1, i);
                PaintingB[i] = getModItem(BiblioCraft.ID, "BiblioBorderlessPainting", 1, i);
                FClockB[i] = getModItem(BiblioCraft.ID, "BiblioClock", 1, i);

                addShapelessCraftingRecipe(
                        getModItem(BiblioCraft.ID, "BiblioFancySign", 1, i),
                        new Object[] { getModItem(Minecraft.ID, "paper", 1), getModItem(Minecraft.ID, "sign", 1),
                                LableB[i] });

                addShapedRecipe(
                        getModItem(BiblioCraft.ID, "BiblioWorkbench", 1, i),
                        new Object[] { ink, craftingTable, feather, Bwood[i],
                                getModItem(BiblioCraft.ID, "Bibliotheca", 1, i), Bwood[i], Bwood[i], Bwood[i],
                                Bwood[i] });

                addShapedRecipe(
                        getModItem(BiblioCraft.ID, "BiblioWorkbench", 1, i),
                        new Object[] { feather, craftingTable, ink, Bwood[i],
                                getModItem(BiblioCraft.ID, "Bibliotheca", 1, i), Bwood[i], Bwood[i], Bwood[i],
                                Bwood[i] });

                addShapedRecipe(
                        getModItem(BiblioCraft.ID, "Bibliotheca", 1, i),
                        new Object[] { planks[i], Bwood[i], planks[i], planks[i], Bwood[i], planks[i], planks[i],
                                Bwood[i], planks[i], });

                addShapedRecipe(
                        getModItem(BiblioCraft.ID, "BiblioPotionShelf", 1, i),
                        new Object[] { Bwood[i], Bwood[i], Bwood[i], planks[i], emptyBottle, planks[i], Bwood[i],
                                Bwood[i], Bwood[i], });

                addShapedRecipe(
                        getModItem(BiblioCraft.ID, "BiblioShelf", 1, i),
                        new Object[] { Bwood[i], Bwood[i], Bwood[i], null, planks[i], null, Bwood[i], Bwood[i],
                                Bwood[i], });

                addShapedRecipe(
                        getModItem(BiblioCraft.ID, "BiblioRack", 1, i),
                        new Object[] { Bwood[i], Bwood[i], Bwood[i], Bwood[i], ironIngot, Bwood[i], Bwood[i], Bwood[i],
                                Bwood[i], });

                addShapedRecipe(
                        getModItem(BiblioCraft.ID, "BiblioCase", 1, i),
                        new Object[] { Bwood[i], glass, Bwood[i], Bwood[i], whiteWool, Bwood[i], Bwood[i], Bwood[i],
                                Bwood[i], });

                addShapedRecipe(
                        getModItem(BiblioCraft.ID, "BiblioDesk", 1, i),
                        new Object[] { torch, null, feather, Bwood[i], Bwood[i], Bwood[i], planks[i], null,
                                planks[i] });

                addShapedRecipe(
                        getModItem(BiblioCraft.ID, "BiblioTable", 1, i),
                        new Object[] { Bwood[i], Bwood[i], Bwood[i], null, planks[i], null, null, planks[i], null });

                addShapedRecipe(
                        getModItem(BiblioCraft.ID, "BiblioMapFrames", 1, i),
                        new Object[] { stick, stick, stick, stick, Bwood[i], stick, stick, stick, stick });

                addShapedRecipe(
                        getModItem(BiblioCraft.ID, "BiblioSeats", 1, i),
                        new Object[] { null, whiteWool, null, null, Bwood[i], null, stick, woodenPressurePlate,
                                stick });

                addShapedRecipe(
                        getModItem(BiblioCraft.ID, "item.seatBack", 1, i),
                        new Object[] { null, whiteWool, null, null, Bwood[i], null, stick, null, stick });

                addShapedRecipe(
                        getModItem(BiblioCraft.ID, "item.seatBack2", 1, i),
                        new Object[] { stick, whiteWool, stick, stick, Bwood[i], stick, stick, null, stick });

                addShapedRecipe(
                        getModItem(BiblioCraft.ID, "item.seatBack4", 1, i),
                        new Object[] { null, whiteWool, null, null, Bwood[i], null, null, null, null });

                addShapelessCraftingRecipe(
                        getModItem(BiblioCraft.ID, "item.seatBack3", 1, i),
                        new Object[] { Bwood[i], getModItem(BiblioCraft.ID, "item.seatBack2", 1, i), });

                addShapelessCraftingRecipe(
                        getModItem(BiblioCraft.ID, "item.seatBack5", 1, i),
                        new Object[] { Bwood[i], Bwood[i], getModItem(BiblioCraft.ID, "item.seatBack2", 1, i), });
            }
        }
        addShapedRecipe(
                getModItem(BiblioCraft.ID, "BiblioStuffs", 1, 3),
                new Object[] { "stickWood", "stickWood", "stickWood", "slabWood", "slabWood", "slabWood", null, null,
                        null });

        ItemStack paper = getModItem(Minecraft.ID, "paper", 1);
        ItemStack bookAndQuill = getModItem(Minecraft.ID, "writable_book", 1);
        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.StockroomCatalog", 1),
                new Object[] { paper, "dyeGreen", paper, paper, bookAndQuill, paper, paper, paper, paper });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.BigBook", 1),
                new Object[] { paper, paper, paper, paper, bookAndQuill, paper, paper, paper, paper });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "Printing Press", 1),
                new Object[] { "plateThaumium", "stickBlaze", "plateThaumium", "plateAluminium", getMeta01(32601),
                        "plateAluminium", "blockSteel", "blockSteel", "blockSteel" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.BiblioChase", 1),
                new Object[] { "stickWoodSealed", "stickWoodSealed", "stickWoodSealed", "stickWoodSealed", null,
                        "stickWoodSealed", "stickWoodSealed", "stickWoodSealed", "stickWoodSealed" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "Typesetting Machine", 1),
                new Object[] { "plateAluminium", getModItem(BiblioCraft.ID, "item.BiblioChase", 1), "plateAluminium",
                        "plateWoodSealed", "frameGtWoodSealed", "plateWoodSealed", "plateWoodSealed", "plateWoodSealed",
                        "plateWoodSealed" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "tile.BiblioFramedChest", 1),
                new Object[] { getModItem(BiblioCraft.ID, "item.FramingSheet", 1),
                        getModItem(BiblioCraft.ID, "item.FramingSheet", 1),
                        getModItem(BiblioCraft.ID, "item.FramingSheet", 1), "screwIron",
                        getModItem(BiblioCraft.ID, "BiblioLabel", 1, 6), "screwIron",
                        getModItem(BiblioCraft.ID, "item.FramingSheet", 1),
                        getModItem(BiblioCraft.ID, "item.FramingSheet", 1),
                        getModItem(BiblioCraft.ID, "item.FramingSheet", 1) });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "BiblioPaneler", 1),
                new Object[] { "plateIron", "craftingToolSaw", "plateIron",
                        getModItem(Minecraft.ID, "wooden_slab", 1), getMeta02(32470),
                        getModItem(Minecraft.ID, "wooden_slab", 1), getModItem(Minecraft.ID, "planks", 1),
                        getModItem(Minecraft.ID, "planks", 1), getModItem(Minecraft.ID, "planks", 1) });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "BiblioPaneler", 1, 1),
                new Object[] { "plateIron", "craftingToolSaw", "plateIron",
                        getModItem(Minecraft.ID, "wooden_slab", 1, 1), getMeta02(32471),
                        getModItem(Minecraft.ID, "wooden_slab", 1, 1), getModItem(Minecraft.ID, "planks", 1, 1),
                        getModItem(Minecraft.ID, "planks", 1, 1), getModItem(Minecraft.ID, "planks", 1, 1) });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "BiblioPaneler", 1, 2),
                new Object[] { "plateIron", "craftingToolSaw", "plateIron",
                        getModItem(Minecraft.ID, "wooden_slab", 1, 2), getMeta02(32472),
                        getModItem(Minecraft.ID, "wooden_slab", 1, 2), getModItem(Minecraft.ID, "planks", 1, 2),
                        getModItem(Minecraft.ID, "planks", 1, 2), getModItem(Minecraft.ID, "planks", 1, 2) });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "BiblioPaneler", 1, 3),
                new Object[] { "plateIron", "craftingToolSaw", "plateIron",
                        getModItem(Minecraft.ID, "wooden_slab", 1, 3), getMeta02(32473),
                        getModItem(Minecraft.ID, "wooden_slab", 1, 3), getModItem(Minecraft.ID, "planks", 1, 3),
                        getModItem(Minecraft.ID, "planks", 1, 3), getModItem(Minecraft.ID, "planks", 1, 3) });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "BiblioPaneler", 1, 4),
                new Object[] { "plateIron", "craftingToolSaw", "plateIron",
                        getModItem(Minecraft.ID, "wooden_slab", 1, 4), getMeta02(32474),
                        getModItem(Minecraft.ID, "wooden_slab", 1, 4), getModItem(Minecraft.ID, "planks", 1, 4),
                        getModItem(Minecraft.ID, "planks", 1, 4), getModItem(Minecraft.ID, "planks", 1, 4) });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "BiblioPaneler", 1, 5),
                new Object[] { "plateIron", "craftingToolSaw", "plateIron",
                        getModItem(Minecraft.ID, "wooden_slab", 1, 5), getMeta02(32475),
                        getModItem(Minecraft.ID, "wooden_slab", 1, 5), getModItem(Minecraft.ID, "planks", 1, 5),
                        getModItem(Minecraft.ID, "planks", 1, 5), getModItem(Minecraft.ID, "planks", 1, 5) });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "BiblioPaneler", 1, 6),
                new Object[] { "plateIron", "craftingToolSaw", "plateIron",
                        getModItem(BiblioCraft.ID, "item.FramingBoard", 1),
                        getModItem(BiblioCraft.ID, "item.FramingSheet", 1),
                        getModItem(BiblioCraft.ID, "item.FramingBoard", 1),
                        getModItem(BiblioCraft.ID, "item.FramingSheet", 1),
                        getModItem(BiblioCraft.ID, "item.FramingSheet", 1),
                        getModItem(BiblioCraft.ID, "item.FramingSheet", 1) });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.AtlasBook", 1),
                new Object[] { "platePaper", getModItem(BiblioCraft.ID, "item.BiblioMapTool", 1), "platePaper",
                        "platePaper", "craftingBook", "platePaper", "platePaper", "paperMap", "platePaper" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "BiblioPaintPress", 1),
                new Object[] { "plateIron", "plateIron", "boltIron", "ringIron", null, null, "blockIron", "blockIron",
                        "blockIron" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "BiblioLantern", 1),
                new Object[] { "plateGold", "dustGlowstone", "plateGold", "paneGlassColorless",
                        getModItem(PamsHarvestCraft.ID, "pamcandleDeco1", 1), "paneGlassColorless", "plateGold",
                        "plateGold", "plateGold" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "BiblioIronLantern", 1),
                new Object[] { "plateIron", "dustGlowstone", "plateIron", "paneGlassColorless",
                        getModItem(PamsHarvestCraft.ID, "pamcandleDeco1", 1), "paneGlassColorless", "plateIron",
                        "plateIron", "plateIron" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "BiblioLamp", 1),
                new Object[] { "plateGold", getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1),
                        "plateGold", null, "stickGold", null, "plateGold", "plateGold", "plateGold" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "BiblioIronLamp", 1),
                new Object[] { "plateIron", getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1),
                        "plateIron", null, "stickGold", null, "plateIron", "plateIron", "plateIron" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "Armor Stand", 1),
                new Object[] { "boltIron", "stickIron", "boltIron", "craftingToolHardHammer", "stickIron",
                        "craftingToolSaw", "plateIron", getModItem(Minecraft.ID, "stone_pressure_plate", 1),
                        "plateIron" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "BiblioBell", 1),
                new Object[] { null, getModItem(Minecraft.ID, "stone_button", 1), null, null, "plateIron", null,
                        "plateIron", null, "plateIron" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "BiblioStuffs", 1),
                new Object[] { null, "plateAnyRubber", null, getModItem(Minecraft.ID, "glass_pane", 1), null,
                        getModItem(Minecraft.ID, "glass_pane", 1), getModItem(Minecraft.ID, "glass_pane", 1),
                        getModItem(Minecraft.ID, "glass_pane", 1), getModItem(Minecraft.ID, "glass_pane", 1) });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "BiblioStuffs", 1, 2),
                new Object[] { null, null, null, "plateNetherQuartz", null, "plateNetherQuartz", null,
                        "plateNetherQuartz", null });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.FramingSheet", 2),
                new Object[] { getMeta02(32470), "craftingToolSaw", null, null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.FramingBoard", 2),
                new Object[] { getModItem(BiblioCraft.ID, "item.FramingSheet", 1), "craftingToolSaw", null, null,
                        null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.BiblioMapTool", 1),
                new Object[] { "stickIron", "screwIron", "stickIron", "stickIron", "stickIron", "craftingToolFile",
                        "stickIron", "screwIron", "craftingToolScrewdriver" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.BiblioMapTool", 1),
                new Object[] { "stickIron", "screwIron", "stickIron", "stickIron", "stickIron", "craftingToolFile",
                        "stickIron", "screwIron", "craftingToolScrewdriver" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.BiblioGlasses", 1, 2),
                new Object[] { "ringGold", "wireFineGold", "wireFineGold", "lensGlass", "craftingToolSoftHammer",
                        "wireFineGold", null, "wireFineGold", null });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.PlumbLine", 1),
                new Object[] { "wireFineSteel", "wireFineSteel", "wireFineSteel", "plateLead", "craftingToolSoftHammer",
                        "wireFineSteel", "roundLead", null, "wireFineSteel" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.BiblioGlasses", 1),
                new Object[] { "stickIron", "screwIron", "stickIron", "ringIron", "boltIron", "ringIron", "lensGlass",
                        "craftingToolScrewdriver", "lensGlass" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.BiblioDrill", 1),
                new Object[] { "screwIron", "boltIron", "craftingToolScrewdriver", "gearGtSmallIron",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 3), "gearGtSmallIron", "plateIron",
                        getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1), "plateIron" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.tape", 1),
                new Object[] { "wireFineIron", "wireFineIron", "wireFineIron", "wireFineIron", "dyeYellow",
                        "wireFineIron", "wireFineIron", "wireFineIron", "wireFineIron" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.tapeMeasure", 1),
                new Object[] { getModItem(BiblioCraft.ID, "item.tape", 1),
                        getModItem(BiblioCraft.ID, "item.tape", 1), getModItem(BiblioCraft.ID, "item.tape", 1),
                        "stickIron", "stickIron", "stickIron", null, null, null });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.BiblioClipboard", 1),
                new Object[] { "screwIron", "springSmallIron", "screwIron", "craftingToolScrewdriver", getMeta01(17809),
                        "craftingToolSaw", getModItem(Minecraft.ID, "paper", 1),
                        getModItem(Minecraft.ID, "paper", 1), getModItem(Minecraft.ID, "paper", 1) });

        addShapelessCraftingRecipe(
                getModItem(BiblioCraft.ID, "item.BiblioRedBook", 1),
                new Object[] { getModItem(Minecraft.ID, "redstone_torch", 1),
                        getModItem(Minecraft.ID, "book", 1) });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.BiblioWayPointCompass", 1),
                new Object[] { "stickGold", "ringGold", "craftingToolFile", "screwGold",
                        getModItem(Minecraft.ID, "compass", 1), "screwGold", "craftingToolScrewdriver", "ringGold",
                        "stickGold" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.PaintingCanvas", 1),
                new Object[] { "stickWood", getModItem(Minecraft.ID, "string", 1), "stickWood",
                        getModItem(Minecraft.ID, "string", 1), getModItem(Minecraft.ID, "wool", 1),
                        getModItem(Minecraft.ID, "string", 1), "stickWood", getModItem(Minecraft.ID, "string", 1),
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioCraft.ID, "item.BiblioGlasses", 1, 1),
                new Object[] { null, getModItem(BiblioCraft.ID, "item.BiblioGlasses", 1), null, null, "dyeGray",
                        null, null, null, null });

        for (int i = 1; i < 16; i++) {
            addShapelessCraftingRecipe(
                    getModItem(BiblioCraft.ID, "BiblioLantern", 1, i),
                    new Object[] { getModItem(BiblioCraft.ID, "BiblioLantern", 1, 32767), colorsLamp[i - 1] });
            addShapelessCraftingRecipe(
                    getModItem(BiblioCraft.ID, "BiblioIronLantern", 1, i),
                    new Object[] { getModItem(BiblioCraft.ID, "BiblioIronLantern", 1, 32767), colorsLamp[i - 1] });
            addShapelessCraftingRecipe(
                    getModItem(BiblioCraft.ID, "BiblioLamp", 1, i),
                    new Object[] { getModItem(BiblioCraft.ID, "BiblioLamp", 1, 32767), colorsLamp[i - 1] });
            addShapelessCraftingRecipe(
                    getModItem(BiblioCraft.ID, "BiblioIronLamp", 1, i),
                    new Object[] { getModItem(BiblioCraft.ID, "BiblioIronLamp", 1, 32767), colorsLamp[i - 1] });
        }
        for (int i = 0; i < 16; i++) {
            addShapedRecipe(
                    TypeWriterB[i],
                    new Object[] { "plateRubber", getModItem(OpenComputers.ID, "item", 1, 20), "plateRubber",
                            "ringIron", color16[i], "ringIron", "plateIron", "blockIron", "plateIron" });
            if (i < 7) {
                addShapedRecipe(
                        FClockB[i],
                        new Object[] { Swood[i], getModItem(Minecraft.ID, "clock", 1), Swood[i], Swood[i],
                                "stickWood", Swood[i], Swood[i], "plateGold", Swood[i] });
                addShapedRecipe(
                        PaintingB[i],
                        new Object[] { Swood[i], Swood[i], Swood[i], Swood[i],
                                getModItem(BiblioCraft.ID, "item.PaintingCanvas", 1), Swood[i], Swood[i], Swood[i],
                                Swood[i] });
                addShapedRecipe(
                        FPT1[i],
                        new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", PaintingB[i], "stickWood",
                                "stickWood", "stickWood", "stickWood" });
                addShapedRecipe(
                        FPT2[i],
                        new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", FPT1[i], "stickWood",
                                "stickWood", "stickWood", "stickWood" });
                addShapedRecipe(
                        FPT3[i],
                        new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", FPT2[i], "stickWood",
                                "stickWood", "stickWood", "stickWood" });
                addShapedRecipe(
                        FPT4[i],
                        new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", FPT3[i], "stickWood",
                                "stickWood", "stickWood", "stickWood" });
                addShapedRecipe(
                        Pedestals[i],
                        new Object[] { null, null, null, "plateIron", "ringIron", "plateIron", "slabStone", cwool16[i],
                                "slabStone" });
                addShapedRecipe(
                        LableB[i],
                        new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", FrameB[i], "stickWood",
                                "stickWood", "stickWood", "stickWood" });
            }
        }
        loadCuttingRecipes();
        loadShapelessRecipes();
    }

    public void loadCuttingRecipes() {
        // --- Frame Sheet
        GT_Values.RA.addCutterRecipe(
                getMeta02(32470),
                Materials.Water.getFluid(4),
                GT_ModHandler.getModItem(BiblioCraft.ID, "item.FramingSheet", 4),
                GT_Values.NI,
                50,
                4);
        GT_Values.RA.addCutterRecipe(
                getMeta02(32470),
                GT_ModHandler.getDistilledWater(2),
                GT_ModHandler.getModItem(BiblioCraft.ID, "item.FramingSheet", 4),
                GT_Values.NI,
                50,
                4);
        GT_Values.RA.addCutterRecipe(
                getMeta02(32470),
                Materials.Lubricant.getFluid(1),
                GT_ModHandler.getModItem(BiblioCraft.ID, "item.FramingSheet", 4),
                GT_Values.NI,
                25,
                4);
        // --- Frame Board
        GT_Values.RA.addCutterRecipe(
                getModItem(BiblioCraft.ID, "item.FramingSheet", 1),
                Materials.Water.getFluid(4),
                GT_ModHandler.getModItem(BiblioCraft.ID, "item.FramingBoard", 4),
                GT_Values.NI,
                50,
                4);
        GT_Values.RA.addCutterRecipe(
                getModItem(BiblioCraft.ID, "item.FramingSheet", 1),
                GT_ModHandler.getDistilledWater(2),
                GT_ModHandler.getModItem(BiblioCraft.ID, "item.FramingBoard", 4),
                GT_Values.NI,
                50,
                4);
        GT_Values.RA.addCutterRecipe(
                getModItem(BiblioCraft.ID, "item.FramingSheet", 1),
                Materials.Lubricant.getFluid(1),
                GT_ModHandler.getModItem(BiblioCraft.ID, "item.FramingBoard", 4),
                GT_Values.NI,
                25,
                4);
    }

    public void loadShapelessRecipes() {
        addShapelessCraftingRecipe(
                getModItem(BiblioCraft.ID, "item.BiblioClipboard", 1),
                new Object[] { "platePaper", getModItem(BiblioCraft.ID, "item.BiblioClipboard", 1, 32767) });
    }
}
