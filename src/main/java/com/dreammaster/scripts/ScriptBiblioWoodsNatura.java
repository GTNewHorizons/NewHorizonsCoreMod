package com.dreammaster.scripts;

import static com.dreammaster.MissingModIDs.BiblioCraft;
import static com.dreammaster.MissingModIDs.BiblioWoodsNaturaEdition;
import static gregtech.api.enums.ModIDs.Minecraft;
import static gregtech.api.enums.ModIDs.Natura;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

public class ScriptBiblioWoodsNatura implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "BiblioWoodsNatura";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Natura.modID, BiblioWoodsNaturaEdition.modID, BiblioCraft.modID );
    }

    @Override
    public void loadRecipes() {
        ItemStack[] FClockN = new ItemStack[] { getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodClock", 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodClock", 1, 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodClock", 1, 2),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodClock", 1, 3),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodClock", 1, 4),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodClock", 1, 5),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodClock", 1, 6),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodClock", 1, 7),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodClock", 1, 8),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodClock", 1, 9),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodClock", 1, 10),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodClock", 1, 11),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodClock", 1, 12) };

        ItemStack[] Nwood = new ItemStack[] { getModItem(Natura.modID, "plankSlab1", 1, 4),
                getModItem(Natura.modID, "plankSlab2", 1, 3), getModItem(Natura.modID, "plankSlab1", 1),
                getModItem(Natura.modID, "plankSlab2", 1, 4), getModItem(Natura.modID, "plankSlab1", 1, 2),
                getModItem(Natura.modID, "plankSlab1", 1, 5), getModItem(Natura.modID, "plankSlab1", 1, 6),
                getModItem(Natura.modID, "plankSlab2", 1), getModItem(Natura.modID, "plankSlab1", 1, 3),
                getModItem(Natura.modID, "plankSlab1", 1, 7), getModItem(Natura.modID, "plankSlab1", 1, 1),
                getModItem(Natura.modID, "plankSlab2", 1, 1), getModItem(Natura.modID, "plankSlab2", 1, 2) };

        ItemStack[] PaintingN = new ItemStack[] { getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT0", 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT0", 1, 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT0", 1, 2),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT0", 1, 3),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT0", 1, 4),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT0", 1, 5),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT0", 1, 6),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT0", 1, 7),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT0", 1, 8),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT0", 1, 9),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT0", 1, 10),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT0", 1, 11),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT0", 1, 12) };

        ItemStack[] NPT1 = new ItemStack[] { getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT1", 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT1", 1, 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT1", 1, 2),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT1", 1, 3),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT1", 1, 4),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT1", 1, 5),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT1", 1, 6),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT1", 1, 7),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT1", 1, 8),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT1", 1, 9),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT1", 1, 10),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT1", 1, 11),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT1", 1, 12) };

        ItemStack[] NPT2 = new ItemStack[] { getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT2", 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT2", 1, 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT2", 1, 2),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT2", 1, 3),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT2", 1, 4),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT2", 1, 5),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT2", 1, 6),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT2", 1, 7),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT2", 1, 8),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT2", 1, 9),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT2", 1, 10),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT2", 1, 11),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT2", 1, 12) };

        ItemStack[] NPT3 = new ItemStack[] { getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT3", 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT3", 1, 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT3", 1, 2),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT3", 1, 3),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT3", 1, 4),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT3", 1, 5),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT3", 1, 6),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT3", 1, 7),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT3", 1, 8),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT3", 1, 9),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT3", 1, 10),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT3", 1, 11),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT3", 1, 12) };

        ItemStack[] NPT4 = new ItemStack[] { getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT4", 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT4", 1, 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT4", 1, 2),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT4", 1, 3),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT4", 1, 4),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT4", 1, 5),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT4", 1, 6),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT4", 1, 7),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT4", 1, 8),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT4", 1, 9),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT4", 1, 10),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT4", 1, 11),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodPaintingT4", 1, 12) };

        ItemStack[] FrameN = new ItemStack[] { getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodMapFrame", 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodMapFrame", 1, 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodMapFrame", 1, 2),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodMapFrame", 1, 3),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodMapFrame", 1, 4),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodMapFrame", 1, 5),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodMapFrame", 1, 6),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodMapFrame", 1, 7),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodMapFrame", 1, 8),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodMapFrame", 1, 9),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodMapFrame", 1, 10),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodMapFrame", 1, 11),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodMapFrame", 1, 12) };

        ItemStack[] fancySignNatura = new ItemStack[] { getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodFancySign", 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodFancySign", 1, 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodFancySign", 1, 2),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodFancySign", 1, 3),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodFancySign", 1, 4),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodFancySign", 1, 5),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodFancySign", 1, 6),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodFancySign", 1, 7),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodFancySign", 1, 8),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodFancySign", 1, 9),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodFancySign", 1, 10),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodFancySign", 1, 11),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodFancySign", 1, 12) };

        ItemStack[] LableN = new ItemStack[] { getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodlabel", 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodlabel", 1, 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodlabel", 1, 2),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodlabel", 1, 3),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodlabel", 1, 4),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodlabel", 1, 5),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodlabel", 1, 6),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodlabel", 1, 7),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodlabel", 1, 8),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodlabel", 1, 9),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodlabel", 1, 10),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodlabel", 1, 11),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodlabel", 1, 12) };

        ItemStack[] bookcaseNatura = new ItemStack[] { getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodBookcase", 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodBookcase", 1, 1),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodBookcase", 1, 2),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodBookcase", 1, 3),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodBookcase", 1, 4),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodBookcase", 1, 5),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodBookcase", 1, 6),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodBookcase", 1, 7),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodBookcase", 1, 8),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodBookcase", 1, 9),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodBookcase", 1, 10),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodBookcase", 1, 11),
                getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodBookcase", 1, 12) };

        ItemStack[] Nplanks = new ItemStack[] { getModItem(Natura.modID, "planks", 1, 4),
                getModItem(Natura.modID, "planks", 1, 11), getModItem(Natura.modID, "planks", 1, 0),
                getModItem(Natura.modID, "planks", 1, 12), getModItem(Natura.modID, "planks", 1, 2),
                getModItem(Natura.modID, "planks", 1, 5), getModItem(Natura.modID, "planks", 1, 6),
                getModItem(Natura.modID, "planks", 1, 8), getModItem(Natura.modID, "planks", 1, 3),
                getModItem(Natura.modID, "planks", 1, 7), getModItem(Natura.modID, "planks", 1, 1),
                getModItem(Natura.modID, "planks", 1, 9), getModItem(Natura.modID, "planks", 1, 10) };

        ItemStack torch = getModItem(Minecraft.modID, "torch", 1);
        ItemStack feather = getModItem(Minecraft.modID, "feather", 1);
        ItemStack ink = getModItem(Minecraft.modID, "dye", 1);
        ItemStack craftingTable = getModItem(Minecraft.modID, "crafting_table", 1);
        ItemStack emptyBottle = getModItem(Minecraft.modID, "glass_bottle", 1);
        ItemStack ironIngot = getModItem(Minecraft.modID, "iron_ingot", 1);
        ItemStack glass = getModItem(Minecraft.modID, "glass", 1);
        ItemStack whiteWool = getModItem(Minecraft.modID, "wool", 1);
        ItemStack stick = getModItem(Minecraft.modID, "stick", 1);
        ItemStack woodenPressurePlate = getModItem(Minecraft.modID, "wooden_pressure_plate", 1);

        for (int i = 0; i < 13; i++) {
            addShapelessCraftingRecipe(
                    fancySignNatura[i],
                    new Object[] { getModItem(Minecraft.modID, "paper", 1), getModItem(Minecraft.modID, "sign", 1),
                            LableN[i] });
            addShapedRecipe(
                    FClockN[i],
                    new Object[] { Nwood[i], getModItem(Minecraft.modID, "clock", 1), Nwood[i], Nwood[i], "stickWood",
                            Nwood[i], Nwood[i], "plateGold", Nwood[i] });
            addShapedRecipe(
                    PaintingN[i],
                    new Object[] { Nwood[i], Nwood[i], Nwood[i], Nwood[i],
                            getModItem(BiblioCraft.modID, "item.PaintingCanvas", 1), Nwood[i], Nwood[i], Nwood[i],
                            Nwood[i] });
            addShapedRecipe(
                    NPT1[i],
                    new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", PaintingN[i], "stickWood",
                            "stickWood", "stickWood", "stickWood" });
            addShapedRecipe(
                    NPT2[i],
                    new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", NPT1[i], "stickWood",
                            "stickWood", "stickWood", "stickWood" });
            addShapedRecipe(
                    NPT3[i],
                    new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", NPT2[i], "stickWood",
                            "stickWood", "stickWood", "stickWood" });
            addShapedRecipe(
                    NPT4[i],
                    new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", NPT3[i], "stickWood",
                            "stickWood", "stickWood", "stickWood" });
            addShapedRecipe(
                    LableN[i],
                    new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", FrameN[i], "stickWood",
                            "stickWood", "stickWood", "stickWood" });

            addShapedRecipe(
                    getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodcase0", 1, i),
                    new Object[] { Nwood[i], glass, Nwood[i], Nwood[i], whiteWool, Nwood[i], Nwood[i], Nwood[i],
                            Nwood[i], });

            addShapedRecipe(
                    bookcaseNatura[i],
                    new Object[] { Nplanks[i], Nwood[i], Nplanks[i], Nplanks[i], Nwood[i], Nplanks[i], Nplanks[i],
                            Nwood[i], Nplanks[i], });

            addShapedRecipe(
                    getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodpotshelf", 1, i),
                    new Object[] { Nwood[i], Nwood[i], Nwood[i], Nplanks[i], emptyBottle, Nplanks[i], Nwood[i],
                            Nwood[i], Nwood[i], });

            addShapedRecipe(
                    getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodshelf", 1, i),
                    new Object[] { Nwood[i], Nwood[i], Nwood[i], null, Nplanks[i], null, Nwood[i], Nwood[i],
                            Nwood[i], });

            addShapedRecipe(
                    getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodrack", 1, i),
                    new Object[] { Nwood[i], Nwood[i], Nwood[i], Nwood[i], ironIngot, Nwood[i], Nwood[i], Nwood[i],
                            Nwood[i], });

            addShapedRecipe(
                    getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodcase0", 1, i),
                    new Object[] { Nwood[i], glass, Nwood[i], Nwood[i], whiteWool, Nwood[i], Nwood[i], Nwood[i],
                            Nwood[i], });

            addShapedRecipe(
                    getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWooddesk", 1, i),
                    new Object[] { torch, null, feather, Nwood[i], Nwood[i], Nwood[i], Nplanks[i], null, Nplanks[i] });

            addShapedRecipe(
                    getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodtable", 1, i),
                    new Object[] { Nwood[i], Nwood[i], Nwood[i], null, Nplanks[i], null, null, Nplanks[i], null });

            addShapedRecipe(
                    getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodFancyWorkbench", 1, i),
                    new Object[] { ink, craftingTable, feather, Nwood[i],
                            getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodBookcase", 1, i), Nwood[i], Nwood[i], Nwood[i],
                            Nwood[i] });

            addShapedRecipe(
                    getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodFancyWorkbench", 1, i),
                    new Object[] { feather, craftingTable, ink, Nwood[i],
                            getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodBookcase", 1, i), Nwood[i], Nwood[i], Nwood[i],
                            Nwood[i] });

            addShapedRecipe(
                    getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodMapFrame", 1, i),
                    new Object[] { stick, stick, stick, stick, Nwood[i], stick, stick, stick, stick });

            addShapedRecipe(
                    getModItem(BiblioWoodsNaturaEdition.modID, "BiblioWoodSeat", 1, i),
                    new Object[] { null, whiteWool, null, null, Nwood[i], null, stick, woodenPressurePlate, stick });

            addShapedRecipe(
                    getModItem(BiblioWoodsNaturaEdition.modID, "seatBack1", 1, i),
                    new Object[] { null, whiteWool, null, null, Nwood[i], null, stick, null, stick });

            addShapedRecipe(
                    getModItem(BiblioWoodsNaturaEdition.modID, "seatBack2", 1, i),
                    new Object[] { stick, whiteWool, stick, stick, Nwood[i], stick, stick, null, stick });

            addShapedRecipe(
                    getModItem(BiblioWoodsNaturaEdition.modID, "seatBack4", 1, i),
                    new Object[] { null, whiteWool, null, null, Nwood[i], null, null, null, null });

            addShapelessCraftingRecipe(
                    getModItem(BiblioWoodsNaturaEdition.modID, "seatBack3", 1, i),
                    new Object[] { Nwood[i], getModItem(BiblioWoodsNaturaEdition.modID, "seatBack2", 1, i), });

            addShapelessCraftingRecipe(
                    getModItem(BiblioWoodsNaturaEdition.modID, "seatBack5", 1, i),
                    new Object[] { Nwood[i], Nwood[i], getModItem(BiblioWoodsNaturaEdition.modID, "seatBack2", 1, i), });
        }
    }
}
