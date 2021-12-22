package com.dreammaster.scripts;

import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.List;

import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptBiblioWoodsForestry implements IScriptLoader {
    private long startTime;
    private long endTime;
    private static final String scriptName = "BiblioWoodsForestry";
    private static final List<String> dependencies = Arrays.asList("BiblioCraft", "Forestry","BiblioWoodsForestry");

    @Override
    public void loadRecipe() {
        startTime = System.currentTimeMillis();
        ItemStack[] F1wood= new ItemStack[]{
                getModItem("Forestry", "slabs", 1, 2),
                getModItem("Forestry", "slabs", 1, 11),
                getModItem("Forestry", "slabs", 1, 6),
                getModItem("Forestry", "slabs", 1, 15),
                getModItem("Forestry", "slabs", 1, 4),
                getModItem("Forestry", "slabs", 1, 23),
                getModItem("Forestry", "slabs", 1, 9),
                getModItem("Forestry", "slabs", 1, 14),
                getModItem("Forestry", "slabs", 1, 8),
                getModItem("Forestry", "slabs", 1),
                getModItem("Forestry", "slabs", 1, 3),
                getModItem("Forestry", "slabs", 1, 16),
                getModItem("Forestry", "slabs", 1, 10),
                getModItem("Forestry", "slabs", 1, 22),
                getModItem("Forestry", "slabs", 1, 18),
                getModItem("Forestry", "slabs", 1, 19)};
        ItemStack[] F2wood= new ItemStack[]{
                getModItem("Forestry", "slabs", 1, 20),
                getModItem("Forestry", "slabs", 1, 21),
                getModItem("Forestry", "slabs", 1, 17),
                getModItem("Forestry", "slabs", 1, 7),
                getModItem("Forestry", "slabs", 1, 1),
                getModItem("Forestry", "slabs", 1, 13),
                getModItem("Forestry", "slabs", 1, 5),
                getModItem("Forestry", "slabs", 1, 12)};
        ItemStack[] FClockF1= new ItemStack[]{
                getModItem("BiblioWoodsForestry", "BiblioWoodClock", 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock", 1, 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock", 1, 2),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock", 1, 3),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock", 1, 4),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock", 1, 5),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock", 1, 6),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock", 1, 7),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock", 1, 8),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock", 1, 9),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock", 1, 10),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock", 1, 11),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock", 1, 12),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock", 1, 13),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock", 1, 14),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock", 1, 15)};
        ItemStack[] FClockF2= new ItemStack[]{
                getModItem("BiblioWoodsForestry", "BiblioWoodClock2", 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock2", 1, 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock2", 1, 2),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock2", 1, 3),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock2", 1, 4),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock2", 1, 5),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock2", 1, 6),
                getModItem("BiblioWoodsForestry", "BiblioWoodClock2", 1, 7)};
        ItemStack[] PaintingF1= new ItemStack[]{
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0", 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0", 1, 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0", 1, 2),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0", 1, 3),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0", 1, 4),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0", 1, 5),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0", 1, 6),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0", 1, 7),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0", 1, 8),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0", 1, 9),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0", 1, 10),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0", 1, 11),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0", 1, 12),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0", 1, 13),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0", 1, 14),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0", 1, 15)};
        ItemStack[] PaintingF2= new ItemStack[]{
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0b", 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0b", 1, 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0b", 1, 2),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0b", 1, 3),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0b", 1, 4),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0b", 1, 5),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0b", 1, 6),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT0b", 1, 7)};
        ItemStack[] FPT1a= new ItemStack[]{
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1", 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1", 1, 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1", 1, 2),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1", 1, 3),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1", 1, 4),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1", 1, 5),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1", 1, 6),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1", 1, 7),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1", 1, 8),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1", 1, 9),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1", 1, 10),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1", 1, 11),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1", 1, 12),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1", 1, 13),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1", 1, 14),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1", 1, 15)};
        ItemStack[] FPT1b= new ItemStack[]{
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1b", 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1b", 1, 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1b", 1, 2),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1b", 1, 3),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1b", 1, 4),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1b", 1, 5),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1b", 1, 6),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT1b", 1, 1)};
        ItemStack[] FPT2a= new ItemStack[]{
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2", 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2", 1, 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2", 1, 2),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2", 1, 3),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2", 1, 4),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2", 1, 5),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2", 1, 6),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2", 1, 7),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2", 1, 8),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2", 1, 9),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2", 1, 10),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2", 1, 11),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2", 1, 12),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2", 1, 13),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2", 1, 14),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2", 1, 15)};
        ItemStack[] FPT2b= new ItemStack[]{
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2b", 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2b", 1, 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2b", 1, 2),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2b", 1, 3),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2b", 1, 4),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2b", 1, 5),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2b", 1, 6),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT2b", 1, 1)};
        ItemStack[] FPT3a= new ItemStack[]{
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3", 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3", 1, 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3", 1, 2),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3", 1, 3),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3", 1, 4),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3", 1, 5),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3", 1, 6),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3", 1, 7),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3", 1, 8),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3", 1, 9),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3", 1, 10),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3", 1, 11),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3", 1, 12),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3", 1, 13),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3", 1, 14),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3", 1, 15)};
        ItemStack[] FPT3b= new ItemStack[]{
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3b", 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3b", 1, 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3b", 1, 2),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3b", 1, 3),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3b", 1, 4),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3b", 1, 5),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3b", 1, 6),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT3b", 1, 1)};
        ItemStack[] FPT4a= new ItemStack[]{
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4", 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4", 1, 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4", 1, 2),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4", 1, 3),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4", 1, 4),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4", 1, 5),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4", 1, 6),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4", 1, 7),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4", 1, 8),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4", 1, 9),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4", 1, 10),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4", 1, 11),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4", 1, 12),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4", 1, 13),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4", 1, 14),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4", 1, 15)};
        ItemStack[] FPT4b= new ItemStack[]{
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4b", 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4b", 1, 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4b", 1, 2),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4b", 1, 3),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4b", 1, 4),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4b", 1, 5),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4b", 1, 6),
                getModItem("BiblioWoodsForestry", "BiblioWoodPaintingT4b", 1, 1)};
        ItemStack[] FrameF1= new ItemStack[]{
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame", 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame", 1, 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame", 1, 2),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame", 1, 3),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame", 1, 4),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame", 1, 5),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame", 1, 6),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame", 1, 7),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame", 1, 8),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame", 1, 9),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame", 1, 10),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame", 1, 11),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame", 1, 12),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame", 1, 13),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame", 1, 14),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame", 1, 15)};
        ItemStack[] LableF1= new ItemStack[]{
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel", 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel", 1, 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel", 1, 2),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel", 1, 3),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel", 1, 4),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel", 1, 5),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel", 1, 6),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel", 1, 7),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel", 1, 8),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel", 1, 9),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel", 1, 10),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel", 1, 11),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel", 1, 12),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel", 1, 13),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel", 1, 14),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel", 1, 15)};
        ItemStack[] FrameF2= new ItemStack[]{
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame2", 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame2", 1, 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame2", 1, 2),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame2", 1, 3),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame2", 1, 4),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame2", 1, 5),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame2", 1, 6),
                getModItem("BiblioWoodsForestry", "BiblioWoodMapFrame2", 1, 7)};
        ItemStack[] LableF2= new ItemStack[]{
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel2", 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel2", 1, 1),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel2", 1, 2),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel2", 1, 3),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel2", 1, 4),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel2", 1, 5),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel2", 1, 6),
                getModItem("BiblioWoodsForestry", "BiblioWoodFstlabel2", 1, 7)};

        for (int i =0; i<16;i++){
            addShapedRecipe(FClockF1[i], new Object[]{
                    F1wood[i], getModItem("minecraft", "clock", 1), F1wood[i],
                    F1wood[i], "stickWood", F1wood[i],
                    F1wood[i], "plateGold", F1wood[i]});
            addShapedRecipe(PaintingF1[i], new Object[]{
                    F1wood[i], F1wood[i], F1wood[i],
                    F1wood[i], getModItem("BiblioCraft", "item.PaintingCanvas", 1), F1wood[i],
                    F1wood[i], F1wood[i], F1wood[i]});
            addShapedRecipe(FPT1a[i], new Object[]{
                    "stickWood", "stickWood", "stickWood",
                    "stickWood", PaintingF1[i], "stickWood",
                    "stickWood", "stickWood", "stickWood"});
            addShapedRecipe(FPT2a[i], new Object[]{
                    "stickWood", "stickWood", "stickWood",
                    "stickWood", FPT1a[i], "stickWood",
                    "stickWood", "stickWood", "stickWood"});
            addShapedRecipe(FPT3a[i], new Object[]{
                    "stickWood", "stickWood", "stickWood",
                    "stickWood", FPT2a[i], "stickWood",
                    "stickWood", "stickWood", "stickWood"});
            addShapedRecipe(FPT4a[i], new Object[]{
                    "stickWood", "stickWood", "stickWood",
                    "stickWood", FPT3a[i], "stickWood",
                    "stickWood", "stickWood", "stickWood"});
            addShapedRecipe(LableF1[i], new Object[]{
                    "stickWood", "stickWood", "stickWood",
                    "stickWood", FrameF1[i], "stickWood",
                    "stickWood", "stickWood", "stickWood"});
            if (i<8){
                addShapedRecipe(LableF2[i], new Object[]{
                        "stickWood", "stickWood", "stickWood",
                        "stickWood", FrameF2[i], "stickWood",
                        "stickWood", "stickWood", "stickWood"});
                addShapedRecipe(FPT4b[i], new Object[]{
                        "stickWood", "stickWood", "stickWood",
                        "stickWood", FPT3b[i], "stickWood",
                        "stickWood", "stickWood", "stickWood"});
                addShapedRecipe(FPT3b[i], new Object[]{
                        "stickWood", "stickWood", "stickWood",
                        "stickWood", FPT2b[i], "stickWood",
                        "stickWood", "stickWood", "stickWood"});
                addShapedRecipe(FPT2b[i], new Object[]{
                        "stickWood", "stickWood", "stickWood",
                        "stickWood", FPT1b[i], "stickWood",
                        "stickWood", "stickWood", "stickWood"});
                addShapedRecipe(FPT1b[i], new Object[]{
                        "stickWood", "stickWood", "stickWood",
                        "stickWood", PaintingF2[i], "stickWood",
                        "stickWood", "stickWood", "stickWood"});
                addShapedRecipe(FClockF2[i], new Object[]{
                        F2wood[i], getModItem("minecraft", "clock", 1), F2wood[i],
                        F2wood[i], "stickWood", F2wood[i],
                        F2wood[i], "plateGold", F2wood[i]});
                addShapedRecipe(PaintingF2[i], new Object[]{
                        F2wood[i], F2wood[i], F2wood[i],
                        F2wood[i], getModItem("BiblioCraft", "item.PaintingCanvas", 1), F2wood[i],
                        F2wood[i], F2wood[i], F2wood[i]});
            }
        }
        endTime = System.currentTimeMillis();
    }

    @Override
    public long getExecutionTime() {
        return endTime - startTime;
    }

    @Override
    public List<String> getDependencies() {
        return dependencies;
    }

    @Override
    public String getScriptName() {
        return scriptName;
    }
}
