package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BiblioCraft;
import static gregtech.api.enums.Mods.BiblioWoodsForestryEdition;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import gregtech.api.util.GT_OreDictUnificator;

public class ScriptBiblioWoodsForestry implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "BiblioWoodsForestry";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(BiblioCraft.ID, Forestry.ID, BiblioWoodsForestryEdition.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack[] F1wood = new ItemStack[] { getModItem(Forestry.ID, "slabs", 1, 2),
                getModItem(Forestry.ID, "slabs", 1, 11), getModItem(Forestry.ID, "slabs", 1, 6),
                getModItem(Forestry.ID, "slabs", 1, 15), getModItem(Forestry.ID, "slabs", 1, 4),
                getModItem(Forestry.ID, "slabs", 1, 23), getModItem(Forestry.ID, "slabs", 1, 9),
                getModItem(Forestry.ID, "slabs", 1, 14), getModItem(Forestry.ID, "slabs", 1, 8),
                getModItem(Forestry.ID, "slabs", 1), getModItem(Forestry.ID, "slabs", 1, 3),
                getModItem(Forestry.ID, "slabs", 1, 16), getModItem(Forestry.ID, "slabs", 1, 10),
                getModItem(Forestry.ID, "slabs", 1, 22), getModItem(Forestry.ID, "slabs", 1, 18),
                getModItem(Forestry.ID, "slabs", 1, 19) };
        ItemStack[] F2wood = new ItemStack[] { getModItem(Forestry.ID, "slabs", 1, 20),
                getModItem(Forestry.ID, "slabs", 1, 21), getModItem(Forestry.ID, "slabs", 1, 17),
                getModItem(Forestry.ID, "slabs", 1, 7), getModItem(Forestry.ID, "slabs", 1, 1),
                getModItem(Forestry.ID, "slabs", 1, 13), getModItem(Forestry.ID, "slabs", 1, 5),
                getModItem(Forestry.ID, "slabs", 1, 12) };

        ItemStack[] fancySignF1 = new ItemStack[] {
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign", 1, 7),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign", 1, 8),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign", 1, 9),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign", 1, 10),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign", 1, 11),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign", 1, 12),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign", 1, 13),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign", 1, 14),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign", 1, 15) };
        ItemStack[] fancySignF2 = new ItemStack[] {
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign2", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign2", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign2", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign2", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign2", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign2", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign2", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancySign2", 1, 7) };

        ItemStack[] FClockF1 = new ItemStack[] { getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock", 1, 7),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock", 1, 8),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock", 1, 9),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock", 1, 10),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock", 1, 11),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock", 1, 12),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock", 1, 13),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock", 1, 14),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock", 1, 15) };
        ItemStack[] FClockF2 = new ItemStack[] { getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock2", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock2", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock2", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock2", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock2", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock2", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock2", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodClock2", 1, 7) };
        ItemStack[] PaintingF1 = new ItemStack[] {
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0", 1, 7),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0", 1, 8),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0", 1, 9),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0", 1, 10),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0", 1, 11),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0", 1, 12),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0", 1, 13),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0", 1, 14),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0", 1, 15) };
        ItemStack[] PaintingF2 = new ItemStack[] {
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0b", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0b", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0b", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0b", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0b", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0b", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0b", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT0b", 1, 7) };
        ItemStack[] FPT1a = new ItemStack[] { getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1", 1, 7),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1", 1, 8),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1", 1, 9),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1", 1, 10),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1", 1, 11),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1", 1, 12),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1", 1, 13),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1", 1, 14),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1", 1, 15) };
        ItemStack[] FPT1b = new ItemStack[] { getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1b", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1b", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1b", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1b", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1b", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1b", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1b", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT1b", 1, 1) };
        ItemStack[] FPT2a = new ItemStack[] { getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2", 1, 7),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2", 1, 8),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2", 1, 9),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2", 1, 10),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2", 1, 11),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2", 1, 12),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2", 1, 13),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2", 1, 14),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2", 1, 15) };
        ItemStack[] FPT2b = new ItemStack[] { getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2b", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2b", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2b", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2b", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2b", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2b", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2b", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT2b", 1, 1) };
        ItemStack[] FPT3a = new ItemStack[] { getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3", 1, 7),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3", 1, 8),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3", 1, 9),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3", 1, 10),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3", 1, 11),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3", 1, 12),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3", 1, 13),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3", 1, 14),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3", 1, 15) };
        ItemStack[] FPT3b = new ItemStack[] { getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3b", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3b", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3b", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3b", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3b", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3b", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3b", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT3b", 1, 1) };
        ItemStack[] FPT4a = new ItemStack[] { getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4", 1, 7),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4", 1, 8),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4", 1, 9),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4", 1, 10),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4", 1, 11),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4", 1, 12),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4", 1, 13),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4", 1, 14),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4", 1, 15) };
        ItemStack[] FPT4b = new ItemStack[] { getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4b", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4b", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4b", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4b", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4b", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4b", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4b", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodPaintingT4b", 1, 1) };
        ItemStack[] FrameF1 = new ItemStack[] { getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 7),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 8),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 9),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 10),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 11),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 12),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 13),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 14),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 15) };
        ItemStack[] LableF1 = new ItemStack[] { getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel", 1, 7),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel", 1, 8),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel", 1, 9),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel", 1, 10),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel", 1, 11),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel", 1, 12),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel", 1, 13),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel", 1, 14),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel", 1, 15) };
        ItemStack[] FrameF2 = new ItemStack[] { getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame2", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame2", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame2", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame2", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame2", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame2", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame2", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame2", 1, 7) };
        ItemStack[] LableF2 = new ItemStack[] { getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel2", 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel2", 1, 1),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel2", 1, 2),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel2", 1, 3),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel2", 1, 4),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel2", 1, 5),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel2", 1, 6),
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstlabel2", 1, 7) };

        for (int i = 0; i < 16; i++) {
            addShapedRecipe(
                    FClockF1[i],
                    new Object[] { F1wood[i], getModItem(Minecraft.ID, "clock", 1), F1wood[i], F1wood[i],
                            "stickWood", F1wood[i], F1wood[i], "plateGold", F1wood[i] });
            addShapedRecipe(
                    PaintingF1[i],
                    new Object[] { F1wood[i], F1wood[i], F1wood[i], F1wood[i],
                            getModItem(BiblioCraft.ID, "item.PaintingCanvas", 1), F1wood[i], F1wood[i], F1wood[i],
                            F1wood[i] });
            addShapedRecipe(
                    FPT1a[i],
                    new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", PaintingF1[i], "stickWood",
                            "stickWood", "stickWood", "stickWood" });
            addShapedRecipe(
                    FPT2a[i],
                    new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", FPT1a[i], "stickWood",
                            "stickWood", "stickWood", "stickWood" });
            addShapedRecipe(
                    FPT3a[i],
                    new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", FPT2a[i], "stickWood",
                            "stickWood", "stickWood", "stickWood" });
            addShapedRecipe(
                    FPT4a[i],
                    new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", FPT3a[i], "stickWood",
                            "stickWood", "stickWood", "stickWood" });
            addShapedRecipe(
                    LableF1[i],
                    new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", FrameF1[i], "stickWood",
                            "stickWood", "stickWood", "stickWood" });
            addShapelessCraftingRecipe(
                    fancySignF1[i],
                    new Object[] { getModItem(Minecraft.ID, "paper", 1), getModItem(Minecraft.ID, "sign", 1),
                            LableF1[i] });
            if (i < 8) {
                addShapedRecipe(
                        LableF2[i],
                        new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", FrameF2[i], "stickWood",
                                "stickWood", "stickWood", "stickWood" });
                addShapedRecipe(
                        FPT4b[i],
                        new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", FPT3b[i], "stickWood",
                                "stickWood", "stickWood", "stickWood" });
                addShapedRecipe(
                        FPT3b[i],
                        new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", FPT2b[i], "stickWood",
                                "stickWood", "stickWood", "stickWood" });
                addShapedRecipe(
                        FPT2b[i],
                        new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", FPT1b[i], "stickWood",
                                "stickWood", "stickWood", "stickWood" });
                addShapedRecipe(
                        FPT1b[i],
                        new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", PaintingF2[i], "stickWood",
                                "stickWood", "stickWood", "stickWood" });
                addShapedRecipe(
                        FClockF2[i],
                        new Object[] { F2wood[i], getModItem(Minecraft.ID, "clock", 1), F2wood[i], F2wood[i],
                                "stickWood", F2wood[i], F2wood[i], "plateGold", F2wood[i] });
                addShapedRecipe(
                        PaintingF2[i],
                        new Object[] { F2wood[i], F2wood[i], F2wood[i], F2wood[i],
                                getModItem(BiblioCraft.ID, "item.PaintingCanvas", 1), F2wood[i], F2wood[i],
                                F2wood[i], F2wood[i] });
                addShapelessCraftingRecipe(
                        fancySignF2[i],
                        new Object[] { getModItem(Minecraft.ID, "paper", 1), getModItem(Minecraft.ID, "sign", 1),
                                LableF2[i] });
            }
        }
        // todo: rewrite this to match the other bibliowoods scripts

        // the 2.4k lines that i auto generated
        // oredicts
        GT_OreDictUnificator.registerOre("PlumPlanks", getModItem(Forestry.ID, "planks", 1, 21));
        GT_OreDictUnificator.registerOre("PlumPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 21));
        GT_OreDictUnificator.registerOre("PlumSlab", getModItem(Forestry.ID, "slabs", 1, 21));
        GT_OreDictUnificator.registerOre("PlumSlab", getModItem(Forestry.ID, "slabsFireproof", 1, 21));
        GT_OreDictUnificator.registerOre("PinePlanks", getModItem(Forestry.ID, "planks", 1, 20));
        GT_OreDictUnificator.registerOre("PinePlanks", getModItem(Forestry.ID, "planksFireproof", 1, 20));
        GT_OreDictUnificator.registerOre("PineSlab", getModItem(Forestry.ID, "slabs", 1, 20));
        GT_OreDictUnificator.registerOre("PineSlab", getModItem(Forestry.ID, "slabsFireproof", 1, 20));
        GT_OreDictUnificator.registerOre("PoplarPlanks", getModItem(Forestry.ID, "planks", 1, 22));
        GT_OreDictUnificator.registerOre("PoplarPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 22));
        GT_OreDictUnificator.registerOre("PoplarSlab", getModItem(Forestry.ID, "slabs", 1, 22));
        GT_OreDictUnificator.registerOre("PoplarSlab", getModItem(Forestry.ID, "slabsFireproof", 1, 22));
        GT_OreDictUnificator.registerOre("SequoiaPlanks", getModItem(Forestry.ID, "planks", 1, 7));
        GT_OreDictUnificator.registerOre("SequoiaPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 7));
        GT_OreDictUnificator.registerOre("SequoiaSlab", getModItem(Forestry.ID, "slabs", 1, 7));
        GT_OreDictUnificator.registerOre("SequoiaSlab", getModItem(Forestry.ID, "slabsFireproof", 1, 7));
        GT_OreDictUnificator.registerOre("TeakPlanks", getModItem(Forestry.ID, "planks", 1, 1));
        GT_OreDictUnificator.registerOre("TeakPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 1));
        GT_OreDictUnificator.registerOre("TeakSlab", getModItem(Forestry.ID, "slabs", 1, 1));
        GT_OreDictUnificator.registerOre("TeakSlab", getModItem(Forestry.ID, "slabsFireproof", 1, 1));
        GT_OreDictUnificator.registerOre("WalnutPlanks", getModItem(Forestry.ID, "planks", 1, 13));
        GT_OreDictUnificator.registerOre("WalnutPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 13));
        GT_OreDictUnificator.registerOre("WalnutSlab", getModItem(Forestry.ID, "slabs", 1, 13));
        GT_OreDictUnificator.registerOre("WalnutSlab", getModItem(Forestry.ID, "slabsFireproof", 1, 13));
        GT_OreDictUnificator.registerOre("WengePlanks", getModItem(Forestry.ID, "planks", 1, 5));
        GT_OreDictUnificator.registerOre("WengePlanks", getModItem(Forestry.ID, "planksFireproof", 1, 5));
        GT_OreDictUnificator.registerOre("WengeSlab", getModItem(Forestry.ID, "slabs", 1, 5));
        GT_OreDictUnificator.registerOre("WengeSlab", getModItem(Forestry.ID, "slabsFireproof", 1, 5));
        GT_OreDictUnificator.registerOre("WillowPlanks", getModItem(Forestry.ID, "planks", 1, 12));
        GT_OreDictUnificator.registerOre("WillowPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 12));
        GT_OreDictUnificator.registerOre("WillowSlab", getModItem(Forestry.ID, "slabs", 1, 12));
        GT_OreDictUnificator.registerOre("WillowSlab", getModItem(Forestry.ID, "slabsFireproof", 1, 12));
        GT_OreDictUnificator.registerOre("AcaciaPlanks", getModItem(Forestry.ID, "planks", 1, 2));
        GT_OreDictUnificator.registerOre("AcaciaPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 2));
        GT_OreDictUnificator.registerOre("AcaciaSlab", getModItem(Forestry.ID, "slabs", 1, 2));
        GT_OreDictUnificator.registerOre("AcaciaSlab", getModItem(Forestry.ID, "slabsFireproof", 1, 2));
        GT_OreDictUnificator.registerOre("BalsaPlanks", getModItem(Forestry.ID, "planks", 1, 11));
        GT_OreDictUnificator.registerOre("BalsaPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 11));
        GT_OreDictUnificator.registerOre("BalsaSlab", getModItem(Forestry.ID, "slabs", 1, 11));
        GT_OreDictUnificator.registerOre("BalsaSlab", getModItem(Forestry.ID, "slabsFireproof", 1, 11));
        GT_OreDictUnificator.registerOre("BaobabPlanks", getModItem(Forestry.ID, "planks", 1, 6));
        GT_OreDictUnificator.registerOre("BaobabPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 6));
        GT_OreDictUnificator.registerOre("BaobabSlab", getModItem(Forestry.ID, "slabs", 1, 6));
        GT_OreDictUnificator.registerOre("BaobabSlab", getModItem(Forestry.ID, "slabsFireproof", 1, 6));
        GT_OreDictUnificator.registerOre("CherryPlanks", getModItem(Forestry.ID, "planks", 1, 15));
        GT_OreDictUnificator.registerOre("CherryPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 15));
        GT_OreDictUnificator.registerOre("CherrySlab", getModItem(Forestry.ID, "slabs", 1, 15));
        GT_OreDictUnificator.registerOre("CherrySlab", getModItem(Forestry.ID, "slabsFireproof", 1, 15));
        GT_OreDictUnificator.registerOre("ChestnutPlanks", getModItem(Forestry.ID, "planks", 1, 4));
        GT_OreDictUnificator.registerOre("ChestnutPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 4));
        GT_OreDictUnificator.registerOre("ChestnutSlab", getModItem(Forestry.ID, "slabs", 1, 4));
        GT_OreDictUnificator.registerOre("ChestnutSlab", getModItem(Forestry.ID, "slabsFireproof", 1, 4));
        GT_OreDictUnificator.registerOre("CitrusPlanks", getModItem(Forestry.ID, "planks", 1, 23));
        GT_OreDictUnificator.registerOre("CitrusPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 23));
        GT_OreDictUnificator.registerOre("CitrusSlab", getModItem(Forestry.ID, "slabs", 1, 23));
        GT_OreDictUnificator.registerOre("CitrusSlab", getModItem(Forestry.ID, "slabsFireproof", 1, 23));
        GT_OreDictUnificator.registerOre("EbonyPlanks", getModItem(Forestry.ID, "planks", 1, 9));
        GT_OreDictUnificator.registerOre("EbonyPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 9));
        GT_OreDictUnificator.registerOre("EbonySlab", getModItem(Forestry.ID, "slabs", 1, 9));
        GT_OreDictUnificator.registerOre("EbonySlab", getModItem(Forestry.ID, "slabsFireproof", 1, 9));
        GT_OreDictUnificator.registerOre("GreenheartPlanks", getModItem(Forestry.ID, "planks", 1, 14));
        GT_OreDictUnificator.registerOre("GreenheartPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 14));
        GT_OreDictUnificator.registerOre("GreenheartSlabs", getModItem(Forestry.ID, "slabs", 1, 14));
        GT_OreDictUnificator.registerOre("GreenheartSlabs", getModItem(Forestry.ID, "slabsFireproof", 1, 14));
        GT_OreDictUnificator.registerOre("KapokPlanks", getModItem(Forestry.ID, "planks", 1, 8));
        GT_OreDictUnificator.registerOre("KapokPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 8));
        GT_OreDictUnificator.registerOre("KapokSlabs", getModItem(Forestry.ID, "slabs", 1, 8));
        GT_OreDictUnificator.registerOre("KapokSlabs", getModItem(Forestry.ID, "slabsFireproof", 1, 8));
        GT_OreDictUnificator.registerOre("LarchPlanks", getModItem(Forestry.ID, "planks", 1, 0));
        GT_OreDictUnificator.registerOre("LarchPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 0));
        GT_OreDictUnificator.registerOre("LarchSlabs", getModItem(Forestry.ID, "slabs", 1, 0));
        GT_OreDictUnificator.registerOre("LarchSlabs", getModItem(Forestry.ID, "slabsFireproof", 1, 0));
        GT_OreDictUnificator.registerOre("LimePlanks", getModItem(Forestry.ID, "planks", 1, 3));
        GT_OreDictUnificator.registerOre("LimePlanks", getModItem(Forestry.ID, "planksFireproof", 1, 3));
        GT_OreDictUnificator.registerOre("LimeSlabs", getModItem(Forestry.ID, "slabs", 1, 3));
        GT_OreDictUnificator.registerOre("LimeSlabs", getModItem(Forestry.ID, "slabsFireproof", 1, 3));
        GT_OreDictUnificator.registerOre("MahoePlanks", getModItem(Forestry.ID, "planks", 1, 16));
        GT_OreDictUnificator.registerOre("MahoePlanks", getModItem(Forestry.ID, "planksFireproof", 1, 16));
        GT_OreDictUnificator.registerOre("MahoeSlabs", getModItem(Forestry.ID, "slabs", 1, 16));
        GT_OreDictUnificator.registerOre("MahoeSlabs", getModItem(Forestry.ID, "slabsFireproof", 1, 16));
        GT_OreDictUnificator.registerOre("MahoganyPlanks", getModItem(Forestry.ID, "planks", 1, 10));
        GT_OreDictUnificator.registerOre("MahoganyPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 10));
        GT_OreDictUnificator.registerOre("MahoganySlabs", getModItem(Forestry.ID, "slabs", 1, 10));
        GT_OreDictUnificator.registerOre("MahoganySlabs", getModItem(Forestry.ID, "slabsFireproof", 1, 10));
        GT_OreDictUnificator.registerOre("MapplePlanks", getModItem(Forestry.ID, "planks", 1, 22));
        GT_OreDictUnificator.registerOre("MapplePlanks", getModItem(Forestry.ID, "planksFireproof", 1, 22));
        GT_OreDictUnificator.registerOre("MappleSlabs", getModItem(Forestry.ID, "slabs", 1, 22));
        GT_OreDictUnificator.registerOre("MappleSlabs", getModItem(Forestry.ID, "slabsFireproof", 1, 22));
        GT_OreDictUnificator.registerOre("PalmPlanks", getModItem(Forestry.ID, "planks", 1, 18));
        GT_OreDictUnificator.registerOre("PalmPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 18));
        GT_OreDictUnificator.registerOre("PalmSlabs", getModItem(Forestry.ID, "slabs", 1, 18));
        GT_OreDictUnificator.registerOre("PalmSlabs", getModItem(Forestry.ID, "slabsFireproof", 1, 18));
        GT_OreDictUnificator.registerOre("PapayaPlanks", getModItem(Forestry.ID, "planks", 1, 19));
        GT_OreDictUnificator.registerOre("PapayaPlanks", getModItem(Forestry.ID, "planksFireproof", 1, 19));
        GT_OreDictUnificator.registerOre("PapayaSlabs", getModItem(Forestry.ID, "slabs", 1, 19));
        GT_OreDictUnificator.registerOre("PapayaSlabs", getModItem(Forestry.ID, "slabsFireproof", 1, 19));

        // recipes
        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase2", 1, 1),
                new Object[] { "PlumPlanks", "PlumSlab", "PlumPlanks", "PlumPlanks", "PlumSlab", "PlumPlanks",
                        "PlumPlanks", "PlumSlab", "PlumPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf2", 1, 1),
                new Object[] { "PlumSlab", "PlumSlab", "PlumSlab", "PlumPlanks", "bottleEmpty", "PlumPlanks",
                        "PlumSlab", "PlumSlab", "PlumSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf2", 1, 1),
                new Object[] { "PlumSlab", "PlumSlab", "PlumSlab", null, "PlumPlanks", null, "PlumSlab", "PlumSlab",
                        "PlumSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack2", 1, 1),
                new Object[] { "PlumSlab", "PlumSlab", "PlumSlab", "PlumSlab", "ingotIron", "PlumSlab", "PlumSlab",
                        "PlumSlab", "PlumSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase1", 1, 1),
                new Object[] { "PlumSlab", "glass", "PlumSlab", "PlumSlab", "blockWool", "PlumSlab", "PlumSlab",
                        "PlumSlab", "PlumSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk2", 1, 1),
                new Object[] { "blockTorch", null, "craftingFeather", "PlumSlab", "PlumSlab", "PlumSlab", "PlumPlanks",
                        null, "PlumPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat2", 1, 1),
                new Object[] { null, "slabCloth", null, null, "PlumSlab", null, "stickWood", "PlumSlab", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable2", 1, 1),
                new Object[] { "PlumSlab", "PlumSlab", "PlumSlab", null, "PlumPlanks", null, null, "PlumPlanks",
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame2", 1, 1),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "PlumSlab", "stickWood", "stickWood",
                        "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench2", 1, 1),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "PlumSlab", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase2", 1, 1),
                        "PlumSlab", "PlumSlab", "PlumSlab", "PlumSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 17),
                new Object[] { null, "blockWool", null, null, "PlumSlab", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 17),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "PlumSlab", "stickWood", "stickWood",
                        null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 17),
                new Object[] { "PlumSlab", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 17), null, null,
                        null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 17),
                new Object[] { null, "blockWool", null, null, "PlumSlab", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 17),
                new Object[] { "PlumSlab", "PlumSlab", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 17), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase2", 1, 0),
                new Object[] { "PinePlanks", "PineSlab", "PinePlanks", "PinePlanks", "PineSlab", "PinePlanks",
                        "PinePlanks", "PineSlab", "PinePlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf2", 1, 0),
                new Object[] { "PineSlab", "PineSlab", "PineSlab", "PinePlanks", "bottleEmpty", "PinePlanks",
                        "PineSlab", "PineSlab", "PineSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf2", 1, 0),
                new Object[] { "PineSlab", "PineSlab", "PineSlab", null, "PinePlanks", null, "PineSlab", "PineSlab",
                        "PineSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack2", 1, 0),
                new Object[] { "PineSlab", "PineSlab", "PineSlab", "PineSlab", "ingotIron", "PineSlab", "PineSlab",
                        "PineSlab", "PineSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase1", 1, 0),
                new Object[] { "PineSlab", "glass", "PineSlab", "PineSlab", "blockWool", "PineSlab", "PineSlab",
                        "PineSlab", "PineSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk2", 1, 0),
                new Object[] { "blockTorch", null, "craftingFeather", "PineSlab", "PineSlab", "PineSlab", "PinePlanks",
                        null, "PinePlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat2", 1, 0),
                new Object[] { null, "slabCloth", null, null, "PineSlab", null, "stickWood", "PineSlab", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable2", 1, 0),
                new Object[] { "PineSlab", "PineSlab", "PineSlab", null, "PinePlanks", null, null, "PinePlanks",
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame2", 1, 0),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "PineSlab", "stickWood", "stickWood",
                        "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench2", 1, 0),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "PineSlab", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase2", 1, 0),
                        "PineSlab", "PineSlab", "PineSlab", "PineSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 16),
                new Object[] { null, "blockWool", null, null, "PineSlab", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 16),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "PineSlab", "stickWood", "stickWood",
                        null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 16),
                new Object[] { "PineSlab", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 16), null, null,
                        null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 16),
                new Object[] { null, "blockWool", null, null, "PineSlab", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 16),
                new Object[] { "PineSlab", "PineSlab", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 16), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase2", 1, 2),
                new Object[] { "PoplarPlanks", "PoplarSlab", "PoplarPlanks", "PoplarPlanks", "PoplarSlab",
                        "PoplarPlanks", "PoplarPlanks", "PoplarSlab", "PoplarPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf2", 1, 2),
                new Object[] { "PoplarSlab", "PoplarSlab", "PoplarSlab", "PoplarPlanks", "bottleEmpty", "PoplarPlanks",
                        "PoplarSlab", "PoplarSlab", "PoplarSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf2", 1, 2),
                new Object[] { "PoplarSlab", "PoplarSlab", "PoplarSlab", null, "PoplarPlanks", null, "PoplarSlab",
                        "PoplarSlab", "PoplarSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack2", 1, 2),
                new Object[] { "PoplarSlab", "PoplarSlab", "PoplarSlab", "PoplarSlab", "ingotIron", "PoplarSlab",
                        "PoplarSlab", "PoplarSlab", "PoplarSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase1", 1, 2),
                new Object[] { "PoplarSlab", "glass", "PoplarSlab", "PoplarSlab", "blockWool", "PoplarSlab",
                        "PoplarSlab", "PoplarSlab", "PoplarSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk2", 1, 2),
                new Object[] { "blockTorch", null, "craftingFeather", "PoplarSlab", "PoplarSlab", "PoplarSlab",
                        "PoplarPlanks", null, "PoplarPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat2", 1, 2),
                new Object[] { null, "slabCloth", null, null, "PoplarSlab", null, "stickWood", "PoplarSlab",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable2", 1, 2),
                new Object[] { "PoplarSlab", "PoplarSlab", "PoplarSlab", null, "PoplarPlanks", null, null,
                        "PoplarPlanks", null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame2", 1, 2),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "PoplarSlab", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench2", 1, 2),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "PoplarSlab", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase2", 1, 2),
                        "PoplarSlab", "PoplarSlab", "PoplarSlab", "PoplarSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 18),
                new Object[] { null, "blockWool", null, null, "PoplarSlab", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 18),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "PoplarSlab", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 18),
                new Object[] { "PoplarSlab", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 18), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 18),
                new Object[] { null, "blockWool", null, null, "PoplarSlab", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 18),
                new Object[] { "PoplarSlab", "PoplarSlab", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 18), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase2", 1, 3),
                new Object[] { "SequoiaPlanks", "SequoiaSlab", "SequoiaPlanks", "SequoiaPlanks", "SequoiaSlab",
                        "SequoiaPlanks", "SequoiaPlanks", "SequoiaSlab", "SequoiaPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf2", 1, 3),
                new Object[] { "SequoiaSlab", "SequoiaSlab", "SequoiaSlab", "SequoiaPlanks", "bottleEmpty",
                        "SequoiaPlanks", "SequoiaSlab", "SequoiaSlab", "SequoiaSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf2", 1, 3),
                new Object[] { "SequoiaSlab", "SequoiaSlab", "SequoiaSlab", null, "SequoiaPlanks", null, "SequoiaSlab",
                        "SequoiaSlab", "SequoiaSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack2", 1, 3),
                new Object[] { "SequoiaSlab", "SequoiaSlab", "SequoiaSlab", "SequoiaSlab", "ingotIron", "SequoiaSlab",
                        "SequoiaSlab", "SequoiaSlab", "SequoiaSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase1", 1, 3),
                new Object[] { "SequoiaSlab", "glass", "SequoiaSlab", "SequoiaSlab", "blockWool", "SequoiaSlab",
                        "SequoiaSlab", "SequoiaSlab", "SequoiaSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk2", 1, 3),
                new Object[] { "blockTorch", null, "craftingFeather", "SequoiaSlab", "SequoiaSlab", "SequoiaSlab",
                        "SequoiaPlanks", null, "SequoiaPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat2", 1, 3),
                new Object[] { null, "slabCloth", null, null, "SequoiaSlab", null, "stickWood", "SequoiaSlab",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable2", 1, 3),
                new Object[] { "SequoiaSlab", "SequoiaSlab", "SequoiaSlab", null, "SequoiaPlanks", null, null,
                        "SequoiaPlanks", null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame2", 1, 3),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "SequoiaSlab", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench2", 1, 3),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "SequoiaSlab", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase2", 1, 3),
                        "SequoiaSlab", "SequoiaSlab", "SequoiaSlab", "SequoiaSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 19),
                new Object[] { null, "blockWool", null, null, "SequoiaSlab", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 19),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "SequoiaSlab", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 19),
                new Object[] { "SequoiaSlab", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 19), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 19),
                new Object[] { null, "blockWool", null, null, "SequoiaSlab", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 19),
                new Object[] { "SequoiaSlab", "SequoiaSlab", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 19), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase2", 1, 4),
                new Object[] { "TeakPlanks", "TeakSlab", "TeakPlanks", "TeakPlanks", "TeakSlab", "TeakPlanks",
                        "TeakPlanks", "TeakSlab", "TeakPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf2", 1, 4),
                new Object[] { "TeakSlab", "TeakSlab", "TeakSlab", "TeakPlanks", "bottleEmpty", "TeakPlanks",
                        "TeakSlab", "TeakSlab", "TeakSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf2", 1, 4),
                new Object[] { "TeakSlab", "TeakSlab", "TeakSlab", null, "TeakPlanks", null, "TeakSlab", "TeakSlab",
                        "TeakSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack2", 1, 4),
                new Object[] { "TeakSlab", "TeakSlab", "TeakSlab", "TeakSlab", "ingotIron", "TeakSlab", "TeakSlab",
                        "TeakSlab", "TeakSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase1", 1, 4),
                new Object[] { "TeakSlab", "glass", "TeakSlab", "TeakSlab", "blockWool", "TeakSlab", "TeakSlab",
                        "TeakSlab", "TeakSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk2", 1, 4),
                new Object[] { "blockTorch", null, "craftingFeather", "TeakSlab", "TeakSlab", "TeakSlab", "TeakPlanks",
                        null, "TeakPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat2", 1, 4),
                new Object[] { null, "slabCloth", null, null, "TeakSlab", null, "stickWood", "TeakSlab", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable2", 1, 4),
                new Object[] { "TeakSlab", "TeakSlab", "TeakSlab", null, "TeakPlanks", null, null, "TeakPlanks",
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame2", 1, 4),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "TeakSlab", "stickWood", "stickWood",
                        "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench2", 1, 4),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "TeakSlab", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase2", 1, 4),
                        "TeakSlab", "TeakSlab", "TeakSlab", "TeakSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 20),
                new Object[] { null, "blockWool", null, null, "TeakSlab", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 20),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "TeakSlab", "stickWood", "stickWood",
                        null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 20),
                new Object[] { "TeakSlab", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 20), null, null,
                        null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 20),
                new Object[] { null, "blockWool", null, null, "TeakSlab", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 20),
                new Object[] { "TeakSlab", "TeakSlab", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 20), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase2", 1, 5),
                new Object[] { "WalnutPlanks", "WalnutSlab", "WalnutPlanks", "WalnutPlanks", "WalnutSlab",
                        "WalnutPlanks", "WalnutPlanks", "WalnutSlab", "WalnutPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf2", 1, 5),
                new Object[] { "WalnutSlab", "WalnutSlab", "WalnutSlab", "WalnutPlanks", "bottleEmpty", "WalnutPlanks",
                        "WalnutSlab", "WalnutSlab", "WalnutSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf2", 1, 5),
                new Object[] { "WalnutSlab", "WalnutSlab", "WalnutSlab", null, "WalnutPlanks", null, "WalnutSlab",
                        "WalnutSlab", "WalnutSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack2", 1, 5),
                new Object[] { "WalnutSlab", "WalnutSlab", "WalnutSlab", "WalnutSlab", "ingotIron", "WalnutSlab",
                        "WalnutSlab", "WalnutSlab", "WalnutSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase1", 1, 5),
                new Object[] { "WalnutSlab", "glass", "WalnutSlab", "WalnutSlab", "blockWool", "WalnutSlab",
                        "WalnutSlab", "WalnutSlab", "WalnutSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk2", 1, 5),
                new Object[] { "blockTorch", null, "craftingFeather", "WalnutSlab", "WalnutSlab", "WalnutSlab",
                        "WalnutPlanks", null, "WalnutPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat2", 1, 5),
                new Object[] { null, "slabCloth", null, null, "WalnutSlab", null, "stickWood", "WalnutSlab",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable2", 1, 5),
                new Object[] { "WalnutSlab", "WalnutSlab", "WalnutSlab", null, "WalnutPlanks", null, null,
                        "WalnutPlanks", null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame2", 1, 5),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "WalnutSlab", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench2", 1, 5),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "WalnutSlab", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase2", 1, 5),
                        "WalnutSlab", "WalnutSlab", "WalnutSlab", "WalnutSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 21),
                new Object[] { null, "blockWool", null, null, "WalnutSlab", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 21),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "WalnutSlab", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 21),
                new Object[] { "WalnutSlab", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 21), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 21),
                new Object[] { null, "blockWool", null, null, "WalnutSlab", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 21),
                new Object[] { "WalnutSlab", "WalnutSlab", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 21), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase2", 1, 6),
                new Object[] { "WengePlanks", "WengeSlab", "WengePlanks", "WengePlanks", "WengeSlab", "WengePlanks",
                        "WengePlanks", "WengeSlab", "WengePlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf2", 1, 6),
                new Object[] { "WengeSlab", "WengeSlab", "WengeSlab", "WengePlanks", "bottleEmpty", "WengePlanks",
                        "WengeSlab", "WengeSlab", "WengeSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf2", 1, 6),
                new Object[] { "WengeSlab", "WengeSlab", "WengeSlab", null, "WengePlanks", null, "WengeSlab",
                        "WengeSlab", "WengeSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack2", 1, 6),
                new Object[] { "WengeSlab", "WengeSlab", "WengeSlab", "WengeSlab", "ingotIron", "WengeSlab",
                        "WengeSlab", "WengeSlab", "WengeSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase1", 1, 6),
                new Object[] { "WengeSlab", "glass", "WengeSlab", "WengeSlab", "blockWool", "WengeSlab", "WengeSlab",
                        "WengeSlab", "WengeSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk2", 1, 6),
                new Object[] { "blockTorch", null, "craftingFeather", "WengeSlab", "WengeSlab", "WengeSlab",
                        "WengePlanks", null, "WengePlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat2", 1, 6),
                new Object[] { null, "slabCloth", null, null, "WengeSlab", null, "stickWood", "WengeSlab",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable2", 1, 6),
                new Object[] { "WengeSlab", "WengeSlab", "WengeSlab", null, "WengePlanks", null, null, "WengePlanks",
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame2", 1, 6),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "WengeSlab", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench2", 1, 6),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "WengeSlab", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase2", 1, 6),
                        "WengeSlab", "WengeSlab", "WengeSlab", "WengeSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 22),
                new Object[] { null, "blockWool", null, null, "WengeSlab", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 22),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "WengeSlab", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 22),
                new Object[] { "WengeSlab", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 22), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 22),
                new Object[] { null, "blockWool", null, null, "WengeSlab", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 22),
                new Object[] { "WengeSlab", "WengeSlab", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 22), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase2", 1, 7),
                new Object[] { "WillowPlanks", "WillowSlab", "WillowPlanks", "WillowPlanks", "WillowSlab",
                        "WillowPlanks", "WillowPlanks", "WillowSlab", "WillowPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf2", 1, 7),
                new Object[] { "WillowSlab", "WillowSlab", "WillowSlab", "WillowPlanks", "bottleEmpty", "WillowPlanks",
                        "WillowSlab", "WillowSlab", "WillowSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf2", 1, 7),
                new Object[] { "WillowSlab", "WillowSlab", "WillowSlab", null, "WillowPlanks", null, "WillowSlab",
                        "WillowSlab", "WillowSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack2", 1, 7),
                new Object[] { "WillowSlab", "WillowSlab", "WillowSlab", "WillowSlab", "ingotIron", "WillowSlab",
                        "WillowSlab", "WillowSlab", "WillowSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase1", 1, 7),
                new Object[] { "WillowSlab", "glass", "WillowSlab", "WillowSlab", "blockWool", "WillowSlab",
                        "WillowSlab", "WillowSlab", "WillowSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk2", 1, 7),
                new Object[] { "blockTorch", null, "craftingFeather", "WillowSlab", "WillowSlab", "WillowSlab",
                        "WillowPlanks", null, "WillowPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat2", 1, 7),
                new Object[] { null, "slabCloth", null, null, "WillowSlab", null, "stickWood", "WillowSlab",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable2", 1, 7),
                new Object[] { "WillowSlab", "WillowSlab", "WillowSlab", null, "WillowPlanks", null, null,
                        "WillowPlanks", null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame2", 1, 7),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "WillowSlab", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench2", 1, 7),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "WillowSlab", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase2", 1, 7),
                        "WillowSlab", "WillowSlab", "WillowSlab", "WillowSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 23),
                new Object[] { null, "blockWool", null, null, "WillowSlab", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 23),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "WillowSlab", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 23),
                new Object[] { "WillowSlab", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 23), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 23),
                new Object[] { null, "blockWool", null, null, "WillowSlab", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 23),
                new Object[] { "WillowSlab", "WillowSlab", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 23), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 0),
                new Object[] { "AcaciaPlanks", "AcaciaSlab", "AcaciaPlanks", "AcaciaPlanks", "AcaciaSlab",
                        "AcaciaPlanks", "AcaciaPlanks", "AcaciaSlab", "AcaciaPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf", 1, 0),
                new Object[] { "AcaciaSlab", "AcaciaSlab", "AcaciaSlab", "AcaciaPlanks", "bottleEmpty", "AcaciaPlanks",
                        "AcaciaSlab", "AcaciaSlab", "AcaciaSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf", 1, 0),
                new Object[] { "AcaciaSlab", "AcaciaSlab", "AcaciaSlab", null, "AcaciaPlanks", null, "AcaciaSlab",
                        "AcaciaSlab", "AcaciaSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack", 1, 0),
                new Object[] { "AcaciaSlab", "AcaciaSlab", "AcaciaSlab", "AcaciaSlab", "ingotIron", "AcaciaSlab",
                        "AcaciaSlab", "AcaciaSlab", "AcaciaSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase0", 1, 0),
                new Object[] { "AcaciaSlab", "glass", "AcaciaSlab", "AcaciaSlab", "blockWool", "AcaciaSlab",
                        "AcaciaSlab", "AcaciaSlab", "AcaciaSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk", 1, 0),
                new Object[] { "blockTorch", null, "craftingFeather", "AcaciaSlab", "AcaciaSlab", "AcaciaSlab",
                        "AcaciaPlanks", null, "AcaciaPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat", 1, 0),
                new Object[] { null, "slabCloth", null, null, "AcaciaSlab", null, "stickWood", "AcaciaSlab",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable", 1, 0),
                new Object[] { "AcaciaSlab", "AcaciaSlab", "AcaciaSlab", null, "AcaciaPlanks", null, null,
                        "AcaciaPlanks", null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 0),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "AcaciaSlab", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench", 1, 0),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "AcaciaSlab", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 0),
                        "AcaciaSlab", "AcaciaSlab", "AcaciaSlab", "AcaciaSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 0),
                new Object[] { null, "blockWool", null, null, "AcaciaSlab", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 0),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "AcaciaSlab", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 0),
                new Object[] { "AcaciaSlab", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 0), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 0),
                new Object[] { null, "blockWool", null, null, "AcaciaSlab", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 0),
                new Object[] { "AcaciaSlab", "AcaciaSlab", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 0), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 1),
                new Object[] { "BalsaPlanks", "BalsaSlab", "BalsaPlanks", "BalsaPlanks", "BalsaSlab", "BalsaPlanks",
                        "BalsaPlanks", "BalsaSlab", "BalsaPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf", 1, 1),
                new Object[] { "BalsaSlab", "BalsaSlab", "BalsaSlab", "BalsaPlanks", "bottleEmpty", "BalsaPlanks",
                        "BalsaSlab", "BalsaSlab", "BalsaSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf", 1, 1),
                new Object[] { "BalsaSlab", "BalsaSlab", "BalsaSlab", null, "BalsaPlanks", null, "BalsaSlab",
                        "BalsaSlab", "BalsaSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack", 1, 1),
                new Object[] { "BalsaSlab", "BalsaSlab", "BalsaSlab", "BalsaSlab", "ingotIron", "BalsaSlab",
                        "BalsaSlab", "BalsaSlab", "BalsaSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase0", 1, 1),
                new Object[] { "BalsaSlab", "glass", "BalsaSlab", "BalsaSlab", "blockWool", "BalsaSlab", "BalsaSlab",
                        "BalsaSlab", "BalsaSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk", 1, 1),
                new Object[] { "blockTorch", null, "craftingFeather", "BalsaSlab", "BalsaSlab", "BalsaSlab",
                        "BalsaPlanks", null, "BalsaPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat", 1, 1),
                new Object[] { null, "slabCloth", null, null, "BalsaSlab", null, "stickWood", "BalsaSlab",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable", 1, 1),
                new Object[] { "BalsaSlab", "BalsaSlab", "BalsaSlab", null, "BalsaPlanks", null, null, "BalsaPlanks",
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 1),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "BalsaSlab", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench", 1, 1),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "BalsaSlab", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 1),
                        "BalsaSlab", "BalsaSlab", "BalsaSlab", "BalsaSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 1),
                new Object[] { null, "blockWool", null, null, "BalsaSlab", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 1),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "BalsaSlab", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 1),
                new Object[] { "BalsaSlab", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 1), null, null,
                        null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 1),
                new Object[] { null, "blockWool", null, null, "BalsaSlab", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 1),
                new Object[] { "BalsaSlab", "BalsaSlab", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 1), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 2),
                new Object[] { "BaobabPlanks", "BaobabSlab", "BaobabPlanks", "BaobabPlanks", "BaobabSlab",
                        "BaobabPlanks", "BaobabPlanks", "BaobabSlab", "BaobabPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf", 1, 2),
                new Object[] { "BaobabSlab", "BaobabSlab", "BaobabSlab", "BaobabPlanks", "bottleEmpty", "BaobabPlanks",
                        "BaobabSlab", "BaobabSlab", "BaobabSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf", 1, 2),
                new Object[] { "BaobabSlab", "BaobabSlab", "BaobabSlab", null, "BaobabPlanks", null, "BaobabSlab",
                        "BaobabSlab", "BaobabSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack", 1, 2),
                new Object[] { "BaobabSlab", "BaobabSlab", "BaobabSlab", "BaobabSlab", "ingotIron", "BaobabSlab",
                        "BaobabSlab", "BaobabSlab", "BaobabSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase0", 1, 2),
                new Object[] { "BaobabSlab", "glass", "BaobabSlab", "BaobabSlab", "blockWool", "BaobabSlab",
                        "BaobabSlab", "BaobabSlab", "BaobabSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk", 1, 2),
                new Object[] { "blockTorch", null, "craftingFeather", "BaobabSlab", "BaobabSlab", "BaobabSlab",
                        "BaobabPlanks", null, "BaobabPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat", 1, 2),
                new Object[] { null, "slabCloth", null, null, "BaobabSlab", null, "stickWood", "BaobabSlab",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable", 1, 2),
                new Object[] { "BaobabSlab", "BaobabSlab", "BaobabSlab", null, "BaobabPlanks", null, null,
                        "BaobabPlanks", null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 2),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "BaobabSlab", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench", 1, 2),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "BaobabSlab", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 2),
                        "BaobabSlab", "BaobabSlab", "BaobabSlab", "BaobabSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 2),
                new Object[] { null, "blockWool", null, null, "BaobabSlab", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 2),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "BaobabSlab", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 2),
                new Object[] { "BaobabSlab", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 2), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 2),
                new Object[] { null, "blockWool", null, null, "BaobabSlab", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 2),
                new Object[] { "BaobabSlab", "BaobabSlab", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 2), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 3),
                new Object[] { "CherryPlanks", "CherrySlab", "CherryPlanks", "CherryPlanks", "CherrySlab",
                        "CherryPlanks", "CherryPlanks", "CherrySlab", "CherryPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf", 1, 3),
                new Object[] { "CherrySlab", "CherrySlab", "CherrySlab", "CherryPlanks", "bottleEmpty", "CherryPlanks",
                        "CherrySlab", "CherrySlab", "CherrySlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf", 1, 3),
                new Object[] { "CherrySlab", "CherrySlab", "CherrySlab", null, "CherryPlanks", null, "CherrySlab",
                        "CherrySlab", "CherrySlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack", 1, 3),
                new Object[] { "CherrySlab", "CherrySlab", "CherrySlab", "CherrySlab", "ingotIron", "CherrySlab",
                        "CherrySlab", "CherrySlab", "CherrySlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase0", 1, 3),
                new Object[] { "CherrySlab", "glass", "CherrySlab", "CherrySlab", "blockWool", "CherrySlab",
                        "CherrySlab", "CherrySlab", "CherrySlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk", 1, 3),
                new Object[] { "blockTorch", null, "craftingFeather", "CherrySlab", "CherrySlab", "CherrySlab",
                        "CherryPlanks", null, "CherryPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat", 1, 3),
                new Object[] { null, "slabCloth", null, null, "CherrySlab", null, "stickWood", "CherrySlab",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable", 1, 3),
                new Object[] { "CherrySlab", "CherrySlab", "CherrySlab", null, "CherryPlanks", null, null,
                        "CherryPlanks", null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 3),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "CherrySlab", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench", 1, 3),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "CherrySlab", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 3),
                        "CherrySlab", "CherrySlab", "CherrySlab", "CherrySlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 3),
                new Object[] { null, "blockWool", null, null, "CherrySlab", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 3),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "CherrySlab", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 3),
                new Object[] { "CherrySlab", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 3), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 3),
                new Object[] { null, "blockWool", null, null, "CherrySlab", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 3),
                new Object[] { "CherrySlab", "CherrySlab", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 3), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 4),
                new Object[] { "ChestnutPlanks", "ChestnutSlab", "ChestnutPlanks", "ChestnutPlanks", "ChestnutSlab",
                        "ChestnutPlanks", "ChestnutPlanks", "ChestnutSlab", "ChestnutPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf", 1, 4),
                new Object[] { "ChestnutSlab", "ChestnutSlab", "ChestnutSlab", "ChestnutPlanks", "bottleEmpty",
                        "ChestnutPlanks", "ChestnutSlab", "ChestnutSlab", "ChestnutSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf", 1, 4),
                new Object[] { "ChestnutSlab", "ChestnutSlab", "ChestnutSlab", null, "ChestnutPlanks", null,
                        "ChestnutSlab", "ChestnutSlab", "ChestnutSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack", 1, 4),
                new Object[] { "ChestnutSlab", "ChestnutSlab", "ChestnutSlab", "ChestnutSlab", "ingotIron",
                        "ChestnutSlab", "ChestnutSlab", "ChestnutSlab", "ChestnutSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase0", 1, 4),
                new Object[] { "ChestnutSlab", "glass", "ChestnutSlab", "ChestnutSlab", "blockWool", "ChestnutSlab",
                        "ChestnutSlab", "ChestnutSlab", "ChestnutSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk", 1, 4),
                new Object[] { "blockTorch", null, "craftingFeather", "ChestnutSlab", "ChestnutSlab", "ChestnutSlab",
                        "ChestnutPlanks", null, "ChestnutPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat", 1, 4),
                new Object[] { null, "slabCloth", null, null, "ChestnutSlab", null, "stickWood", "ChestnutSlab",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable", 1, 4),
                new Object[] { "ChestnutSlab", "ChestnutSlab", "ChestnutSlab", null, "ChestnutPlanks", null, null,
                        "ChestnutPlanks", null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 4),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "ChestnutSlab", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench", 1, 4),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "ChestnutSlab", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 4),
                        "ChestnutSlab", "ChestnutSlab", "ChestnutSlab", "ChestnutSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 4),
                new Object[] { null, "blockWool", null, null, "ChestnutSlab", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 4),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "ChestnutSlab", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 4),
                new Object[] { "ChestnutSlab", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 4), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 4),
                new Object[] { null, "blockWool", null, null, "ChestnutSlab", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 4),
                new Object[] { "ChestnutSlab", "ChestnutSlab", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 4), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 5),
                new Object[] { "CitrusPlanks", "CitrusSlab", "CitrusPlanks", "CitrusPlanks", "CitrusSlab",
                        "CitrusPlanks", "CitrusPlanks", "CitrusSlab", "CitrusPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf", 1, 5),
                new Object[] { "CitrusSlab", "CitrusSlab", "CitrusSlab", "CitrusPlanks", "bottleEmpty", "CitrusPlanks",
                        "CitrusSlab", "CitrusSlab", "CitrusSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf", 1, 5),
                new Object[] { "CitrusSlab", "CitrusSlab", "CitrusSlab", null, "CitrusPlanks", null, "CitrusSlab",
                        "CitrusSlab", "CitrusSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack", 1, 5),
                new Object[] { "CitrusSlab", "CitrusSlab", "CitrusSlab", "CitrusSlab", "ingotIron", "CitrusSlab",
                        "CitrusSlab", "CitrusSlab", "CitrusSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase0", 1, 5),
                new Object[] { "CitrusSlab", "glass", "CitrusSlab", "CitrusSlab", "blockWool", "CitrusSlab",
                        "CitrusSlab", "CitrusSlab", "CitrusSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk", 1, 5),
                new Object[] { "blockTorch", null, "craftingFeather", "CitrusSlab", "CitrusSlab", "CitrusSlab",
                        "CitrusPlanks", null, "CitrusPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat", 1, 5),
                new Object[] { null, "slabCloth", null, null, "CitrusSlab", null, "stickWood", "CitrusSlab",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable", 1, 5),
                new Object[] { "CitrusSlab", "CitrusSlab", "CitrusSlab", null, "CitrusPlanks", null, null,
                        "CitrusPlanks", null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 5),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "CitrusSlab", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench", 1, 5),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "CitrusSlab", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 5),
                        "CitrusSlab", "CitrusSlab", "CitrusSlab", "CitrusSlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 5),
                new Object[] { null, "blockWool", null, null, "CitrusSlab", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 5),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "CitrusSlab", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 5),
                new Object[] { "CitrusSlab", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 5), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 5),
                new Object[] { null, "blockWool", null, null, "CitrusSlab", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 5),
                new Object[] { "CitrusSlab", "CitrusSlab", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 5), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 6),
                new Object[] { "EbonyPlanks", "EbonySlab", "EbonyPlanks", "EbonyPlanks", "EbonySlab", "EbonyPlanks",
                        "EbonyPlanks", "EbonySlab", "EbonyPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf", 1, 6),
                new Object[] { "EbonySlab", "EbonySlab", "EbonySlab", "EbonyPlanks", "bottleEmpty", "EbonyPlanks",
                        "EbonySlab", "EbonySlab", "EbonySlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf", 1, 6),
                new Object[] { "EbonySlab", "EbonySlab", "EbonySlab", null, "EbonyPlanks", null, "EbonySlab",
                        "EbonySlab", "EbonySlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack", 1, 6),
                new Object[] { "EbonySlab", "EbonySlab", "EbonySlab", "EbonySlab", "ingotIron", "EbonySlab",
                        "EbonySlab", "EbonySlab", "EbonySlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase0", 1, 6),
                new Object[] { "EbonySlab", "glass", "EbonySlab", "EbonySlab", "blockWool", "EbonySlab", "EbonySlab",
                        "EbonySlab", "EbonySlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk", 1, 6),
                new Object[] { "blockTorch", null, "craftingFeather", "EbonySlab", "EbonySlab", "EbonySlab",
                        "EbonyPlanks", null, "EbonyPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat", 1, 6),
                new Object[] { null, "slabCloth", null, null, "EbonySlab", null, "stickWood", "EbonySlab",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable", 1, 6),
                new Object[] { "EbonySlab", "EbonySlab", "EbonySlab", null, "EbonyPlanks", null, null, "EbonyPlanks",
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 6),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "EbonySlab", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench", 1, 6),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "EbonySlab", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 6),
                        "EbonySlab", "EbonySlab", "EbonySlab", "EbonySlab" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 6),
                new Object[] { null, "blockWool", null, null, "EbonySlab", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 6),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "EbonySlab", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 6),
                new Object[] { "EbonySlab", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 6), null, null,
                        null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 6),
                new Object[] { null, "blockWool", null, null, "EbonySlab", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 6),
                new Object[] { "EbonySlab", "EbonySlab", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 6), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 7),
                new Object[] { "GreenheartPlanks", "GreenheartSlabs", "GreenheartPlanks", "GreenheartPlanks",
                        "GreenheartSlabs", "GreenheartPlanks", "GreenheartPlanks", "GreenheartSlabs",
                        "GreenheartPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf", 1, 7),
                new Object[] { "GreenheartSlabs", "GreenheartSlabs", "GreenheartSlabs", "GreenheartPlanks",
                        "bottleEmpty", "GreenheartPlanks", "GreenheartSlabs", "GreenheartSlabs", "GreenheartSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf", 1, 7),
                new Object[] { "GreenheartSlabs", "GreenheartSlabs", "GreenheartSlabs", null, "GreenheartPlanks", null,
                        "GreenheartSlabs", "GreenheartSlabs", "GreenheartSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack", 1, 7),
                new Object[] { "GreenheartSlabs", "GreenheartSlabs", "GreenheartSlabs", "GreenheartSlabs", "ingotIron",
                        "GreenheartSlabs", "GreenheartSlabs", "GreenheartSlabs", "GreenheartSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase0", 1, 7),
                new Object[] { "GreenheartSlabs", "glass", "GreenheartSlabs", "GreenheartSlabs", "blockWool",
                        "GreenheartSlabs", "GreenheartSlabs", "GreenheartSlabs", "GreenheartSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk", 1, 7),
                new Object[] { "blockTorch", null, "craftingFeather", "GreenheartSlabs", "GreenheartSlabs",
                        "GreenheartSlabs", "GreenheartPlanks", null, "GreenheartPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat", 1, 7),
                new Object[] { null, "slabCloth", null, null, "GreenheartSlabs", null, "stickWood", "GreenheartSlabs",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable", 1, 7),
                new Object[] { "GreenheartSlabs", "GreenheartSlabs", "GreenheartSlabs", null, "GreenheartPlanks", null,
                        null, "GreenheartPlanks", null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 7),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "GreenheartSlabs", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench", 1, 7),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "GreenheartSlabs", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 7),
                        "GreenheartSlabs", "GreenheartSlabs", "GreenheartSlabs", "GreenheartSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 7),
                new Object[] { null, "blockWool", null, null, "GreenheartSlabs", null, "stickWood", null,
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 7),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "GreenheartSlabs", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 7),
                new Object[] { "GreenheartSlabs", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 7), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 7),
                new Object[] { null, "blockWool", null, null, "GreenheartSlabs", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 7),
                new Object[] { "GreenheartSlabs", "GreenheartSlabs", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 7), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 8),
                new Object[] { "KapokPlanks", "KapokSlabs", "KapokPlanks", "KapokPlanks", "KapokSlabs", "KapokPlanks",
                        "KapokPlanks", "KapokSlabs", "KapokPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf", 1, 8),
                new Object[] { "KapokSlabs", "KapokSlabs", "KapokSlabs", "KapokPlanks", "bottleEmpty", "KapokPlanks",
                        "KapokSlabs", "KapokSlabs", "KapokSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf", 1, 8),
                new Object[] { "KapokSlabs", "KapokSlabs", "KapokSlabs", null, "KapokPlanks", null, "KapokSlabs",
                        "KapokSlabs", "KapokSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack", 1, 8),
                new Object[] { "KapokSlabs", "KapokSlabs", "KapokSlabs", "KapokSlabs", "ingotIron", "KapokSlabs",
                        "KapokSlabs", "KapokSlabs", "KapokSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase0", 1, 8),
                new Object[] { "KapokSlabs", "glass", "KapokSlabs", "KapokSlabs", "blockWool", "KapokSlabs",
                        "KapokSlabs", "KapokSlabs", "KapokSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk", 1, 8),
                new Object[] { "blockTorch", null, "craftingFeather", "KapokSlabs", "KapokSlabs", "KapokSlabs",
                        "KapokPlanks", null, "KapokPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat", 1, 8),
                new Object[] { null, "slabCloth", null, null, "KapokSlabs", null, "stickWood", "KapokSlabs",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable", 1, 8),
                new Object[] { "KapokSlabs", "KapokSlabs", "KapokSlabs", null, "KapokPlanks", null, null, "KapokPlanks",
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 8),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "KapokSlabs", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench", 1, 8),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "KapokSlabs", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 8),
                        "KapokSlabs", "KapokSlabs", "KapokSlabs", "KapokSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 8),
                new Object[] { null, "blockWool", null, null, "KapokSlabs", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 8),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "KapokSlabs", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 8),
                new Object[] { "KapokSlabs", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 8), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 8),
                new Object[] { null, "blockWool", null, null, "KapokSlabs", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 8),
                new Object[] { "KapokSlabs", "KapokSlabs", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 8), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 9),
                new Object[] { "LarchPlanks", "LarchSlabs", "LarchPlanks", "LarchPlanks", "LarchSlabs", "LarchPlanks",
                        "LarchPlanks", "LarchSlabs", "LarchPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf", 1, 9),
                new Object[] { "LarchSlabs", "LarchSlabs", "LarchSlabs", "LarchPlanks", "bottleEmpty", "LarchPlanks",
                        "LarchSlabs", "LarchSlabs", "LarchSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf", 1, 9),
                new Object[] { "LarchSlabs", "LarchSlabs", "LarchSlabs", null, "LarchPlanks", null, "LarchSlabs",
                        "LarchSlabs", "LarchSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack", 1, 9),
                new Object[] { "LarchSlabs", "LarchSlabs", "LarchSlabs", "LarchSlabs", "ingotIron", "LarchSlabs",
                        "LarchSlabs", "LarchSlabs", "LarchSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase0", 1, 9),
                new Object[] { "LarchSlabs", "glass", "LarchSlabs", "LarchSlabs", "blockWool", "LarchSlabs",
                        "LarchSlabs", "LarchSlabs", "LarchSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk", 1, 9),
                new Object[] { "blockTorch", null, "craftingFeather", "LarchSlabs", "LarchSlabs", "LarchSlabs",
                        "LarchPlanks", null, "LarchPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat", 1, 9),
                new Object[] { null, "slabCloth", null, null, "LarchSlabs", null, "stickWood", "LarchSlabs",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable", 1, 9),
                new Object[] { "LarchSlabs", "LarchSlabs", "LarchSlabs", null, "LarchPlanks", null, null, "LarchPlanks",
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 9),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "LarchSlabs", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench", 1, 9),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "LarchSlabs", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 9),
                        "LarchSlabs", "LarchSlabs", "LarchSlabs", "LarchSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 9),
                new Object[] { null, "blockWool", null, null, "LarchSlabs", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 9),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "LarchSlabs", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 9),
                new Object[] { "LarchSlabs", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 9), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 9),
                new Object[] { null, "blockWool", null, null, "LarchSlabs", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 9),
                new Object[] { "LarchSlabs", "LarchSlabs", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 9), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 10),
                new Object[] { "LimePlanks", "LimeSlabs", "LimePlanks", "LimePlanks", "LimeSlabs", "LimePlanks",
                        "LimePlanks", "LimeSlabs", "LimePlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf", 1, 10),
                new Object[] { "LimeSlabs", "LimeSlabs", "LimeSlabs", "LimePlanks", "bottleEmpty", "LimePlanks",
                        "LimeSlabs", "LimeSlabs", "LimeSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf", 1, 10),
                new Object[] { "LimeSlabs", "LimeSlabs", "LimeSlabs", null, "LimePlanks", null, "LimeSlabs",
                        "LimeSlabs", "LimeSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack", 1, 10),
                new Object[] { "LimeSlabs", "LimeSlabs", "LimeSlabs", "LimeSlabs", "ingotIron", "LimeSlabs",
                        "LimeSlabs", "LimeSlabs", "LimeSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase0", 1, 10),
                new Object[] { "LimeSlabs", "glass", "LimeSlabs", "LimeSlabs", "blockWool", "LimeSlabs", "LimeSlabs",
                        "LimeSlabs", "LimeSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk", 1, 10),
                new Object[] { "blockTorch", null, "craftingFeather", "LimeSlabs", "LimeSlabs", "LimeSlabs",
                        "LimePlanks", null, "LimePlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat", 1, 10),
                new Object[] { null, "slabCloth", null, null, "LimeSlabs", null, "stickWood", "LimeSlabs",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable", 1, 10),
                new Object[] { "LimeSlabs", "LimeSlabs", "LimeSlabs", null, "LimePlanks", null, null, "LimePlanks",
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 10),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "LimeSlabs", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench", 1, 10),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "LimeSlabs", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 10),
                        "LimeSlabs", "LimeSlabs", "LimeSlabs", "LimeSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 10),
                new Object[] { null, "blockWool", null, null, "LimeSlabs", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 10),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "LimeSlabs", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 10),
                new Object[] { "LimeSlabs", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 10), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 10),
                new Object[] { null, "blockWool", null, null, "LimeSlabs", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 10),
                new Object[] { "LimeSlabs", "LimeSlabs", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 10), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 11),
                new Object[] { "MahoePlanks", "MahoeSlabs", "MahoePlanks", "MahoePlanks", "MahoeSlabs", "MahoePlanks",
                        "MahoePlanks", "MahoeSlabs", "MahoePlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf", 1, 11),
                new Object[] { "MahoeSlabs", "MahoeSlabs", "MahoeSlabs", "MahoePlanks", "bottleEmpty", "MahoePlanks",
                        "MahoeSlabs", "MahoeSlabs", "MahoeSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf", 1, 11),
                new Object[] { "MahoeSlabs", "MahoeSlabs", "MahoeSlabs", null, "MahoePlanks", null, "MahoeSlabs",
                        "MahoeSlabs", "MahoeSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack", 1, 11),
                new Object[] { "MahoeSlabs", "MahoeSlabs", "MahoeSlabs", "MahoeSlabs", "ingotIron", "MahoeSlabs",
                        "MahoeSlabs", "MahoeSlabs", "MahoeSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase0", 1, 11),
                new Object[] { "MahoeSlabs", "glass", "MahoeSlabs", "MahoeSlabs", "blockWool", "MahoeSlabs",
                        "MahoeSlabs", "MahoeSlabs", "MahoeSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk", 1, 11),
                new Object[] { "blockTorch", null, "craftingFeather", "MahoeSlabs", "MahoeSlabs", "MahoeSlabs",
                        "MahoePlanks", null, "MahoePlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat", 1, 11),
                new Object[] { null, "slabCloth", null, null, "MahoeSlabs", null, "stickWood", "MahoeSlabs",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable", 1, 11),
                new Object[] { "MahoeSlabs", "MahoeSlabs", "MahoeSlabs", null, "MahoePlanks", null, null, "MahoePlanks",
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 11),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "MahoeSlabs", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench", 1, 11),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "MahoeSlabs", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 11),
                        "MahoeSlabs", "MahoeSlabs", "MahoeSlabs", "MahoeSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 11),
                new Object[] { null, "blockWool", null, null, "MahoeSlabs", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 11),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "MahoeSlabs", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 11),
                new Object[] { "MahoeSlabs", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 11), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 11),
                new Object[] { null, "blockWool", null, null, "MahoeSlabs", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 11),
                new Object[] { "MahoeSlabs", "MahoeSlabs", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 11), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 12),
                new Object[] { "MahoganyPlanks", "MahoganySlabs", "MahoganyPlanks", "MahoganyPlanks", "MahoganySlabs",
                        "MahoganyPlanks", "MahoganyPlanks", "MahoganySlabs", "MahoganyPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf", 1, 12),
                new Object[] { "MahoganySlabs", "MahoganySlabs", "MahoganySlabs", "MahoganyPlanks", "bottleEmpty",
                        "MahoganyPlanks", "MahoganySlabs", "MahoganySlabs", "MahoganySlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf", 1, 12),
                new Object[] { "MahoganySlabs", "MahoganySlabs", "MahoganySlabs", null, "MahoganyPlanks", null,
                        "MahoganySlabs", "MahoganySlabs", "MahoganySlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack", 1, 12),
                new Object[] { "MahoganySlabs", "MahoganySlabs", "MahoganySlabs", "MahoganySlabs", "ingotIron",
                        "MahoganySlabs", "MahoganySlabs", "MahoganySlabs", "MahoganySlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase0", 1, 12),
                new Object[] { "MahoganySlabs", "glass", "MahoganySlabs", "MahoganySlabs", "blockWool", "MahoganySlabs",
                        "MahoganySlabs", "MahoganySlabs", "MahoganySlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk", 1, 12),
                new Object[] { "blockTorch", null, "craftingFeather", "MahoganySlabs", "MahoganySlabs", "MahoganySlabs",
                        "MahoganyPlanks", null, "MahoganyPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat", 1, 12),
                new Object[] { null, "slabCloth", null, null, "MahoganySlabs", null, "stickWood", "MahoganySlabs",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable", 1, 12),
                new Object[] { "MahoganySlabs", "MahoganySlabs", "MahoganySlabs", null, "MahoganyPlanks", null, null,
                        "MahoganyPlanks", null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 12),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "MahoganySlabs", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench", 1, 12),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "MahoganySlabs", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 12),
                        "MahoganySlabs", "MahoganySlabs", "MahoganySlabs", "MahoganySlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 12),
                new Object[] { null, "blockWool", null, null, "MahoganySlabs", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 12),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "MahoganySlabs", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 12),
                new Object[] { "MahoganySlabs", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 12), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 12),
                new Object[] { null, "blockWool", null, null, "MahoganySlabs", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 12),
                new Object[] { "MahoganySlabs", "MahoganySlabs", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 12), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 13),
                new Object[] { "MapplePlanks", "MappleSlabs", "MapplePlanks", "MapplePlanks", "MappleSlabs",
                        "MapplePlanks", "MapplePlanks", "MappleSlabs", "MapplePlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf", 1, 13),
                new Object[] { "MappleSlabs", "MappleSlabs", "MappleSlabs", "MapplePlanks", "bottleEmpty",
                        "MapplePlanks", "MappleSlabs", "MappleSlabs", "MappleSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf", 1, 13),
                new Object[] { "MappleSlabs", "MappleSlabs", "MappleSlabs", null, "MapplePlanks", null, "MappleSlabs",
                        "MappleSlabs", "MappleSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack", 1, 13),
                new Object[] { "MappleSlabs", "MappleSlabs", "MappleSlabs", "MappleSlabs", "ingotIron", "MappleSlabs",
                        "MappleSlabs", "MappleSlabs", "MappleSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase0", 1, 13),
                new Object[] { "MappleSlabs", "glass", "MappleSlabs", "MappleSlabs", "blockWool", "MappleSlabs",
                        "MappleSlabs", "MappleSlabs", "MappleSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk", 1, 13),
                new Object[] { "blockTorch", null, "craftingFeather", "MappleSlabs", "MappleSlabs", "MappleSlabs",
                        "MapplePlanks", null, "MapplePlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat", 1, 13),
                new Object[] { null, "slabCloth", null, null, "MappleSlabs", null, "stickWood", "MappleSlabs",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable", 1, 13),
                new Object[] { "MappleSlabs", "MappleSlabs", "MappleSlabs", null, "MapplePlanks", null, null,
                        "MapplePlanks", null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 13),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "MappleSlabs", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench", 1, 13),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "MappleSlabs", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 13),
                        "MappleSlabs", "MappleSlabs", "MappleSlabs", "MappleSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 13),
                new Object[] { null, "blockWool", null, null, "MappleSlabs", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 13),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "MappleSlabs", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 13),
                new Object[] { "MappleSlabs", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 13), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 13),
                new Object[] { null, "blockWool", null, null, "MappleSlabs", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 13),
                new Object[] { "MappleSlabs", "MappleSlabs", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 13), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 14),
                new Object[] { "PalmPlanks", "PalmSlabs", "PalmPlanks", "PalmPlanks", "PalmSlabs", "PalmPlanks",
                        "PalmPlanks", "PalmSlabs", "PalmPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf", 1, 14),
                new Object[] { "PalmSlabs", "PalmSlabs", "PalmSlabs", "PalmPlanks", "bottleEmpty", "PalmPlanks",
                        "PalmSlabs", "PalmSlabs", "PalmSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf", 1, 14),
                new Object[] { "PalmSlabs", "PalmSlabs", "PalmSlabs", null, "PalmPlanks", null, "PalmSlabs",
                        "PalmSlabs", "PalmSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack", 1, 14),
                new Object[] { "PalmSlabs", "PalmSlabs", "PalmSlabs", "PalmSlabs", "ingotIron", "PalmSlabs",
                        "PalmSlabs", "PalmSlabs", "PalmSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase0", 1, 14),
                new Object[] { "PalmSlabs", "glass", "PalmSlabs", "PalmSlabs", "blockWool", "PalmSlabs", "PalmSlabs",
                        "PalmSlabs", "PalmSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk", 1, 14),
                new Object[] { "blockTorch", null, "craftingFeather", "PalmSlabs", "PalmSlabs", "PalmSlabs",
                        "PalmPlanks", null, "PalmPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat", 1, 14),
                new Object[] { null, "slabCloth", null, null, "PalmSlabs", null, "stickWood", "PalmSlabs",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable", 1, 14),
                new Object[] { "PalmSlabs", "PalmSlabs", "PalmSlabs", null, "PalmPlanks", null, null, "PalmPlanks",
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 14),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "PalmSlabs", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench", 1, 14),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "PalmSlabs", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 14),
                        "PalmSlabs", "PalmSlabs", "PalmSlabs", "PalmSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 14),
                new Object[] { null, "blockWool", null, null, "PalmSlabs", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 14),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "PalmSlabs", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 14),
                new Object[] { "PalmSlabs", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 14), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 14),
                new Object[] { null, "blockWool", null, null, "PalmSlabs", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 14),
                new Object[] { "PalmSlabs", "PalmSlabs", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 14), null, null, null, null,
                        null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 15),
                new Object[] { "PapayaPlanks", "PapayaSlabs", "PapayaPlanks", "PapayaPlanks", "PapayaSlabs",
                        "PapayaPlanks", "PapayaPlanks", "PapayaSlabs", "PapayaPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstpotshelf", 1, 15),
                new Object[] { "PapayaSlabs", "PapayaSlabs", "PapayaSlabs", "PapayaPlanks", "bottleEmpty",
                        "PapayaPlanks", "PapayaSlabs", "PapayaSlabs", "PapayaSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstshelf", 1, 15),
                new Object[] { "PapayaSlabs", "PapayaSlabs", "PapayaSlabs", null, "PapayaPlanks", null, "PapayaSlabs",
                        "PapayaSlabs", "PapayaSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstrack", 1, 15),
                new Object[] { "PapayaSlabs", "PapayaSlabs", "PapayaSlabs", "PapayaSlabs", "ingotIron", "PapayaSlabs",
                        "PapayaSlabs", "PapayaSlabs", "PapayaSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstcase0", 1, 15),
                new Object[] { "PapayaSlabs", "glass", "PapayaSlabs", "PapayaSlabs", "blockWool", "PapayaSlabs",
                        "PapayaSlabs", "PapayaSlabs", "PapayaSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstdesk", 1, 15),
                new Object[] { "blockTorch", null, "craftingFeather", "PapayaSlabs", "PapayaSlabs", "PapayaSlabs",
                        "PapayaPlanks", null, "PapayaPlanks" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodSeat", 1, 15),
                new Object[] { null, "slabCloth", null, null, "PapayaSlabs", null, "stickWood", "PapayaSlabs",
                        "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFsttable", 1, 15),
                new Object[] { "PapayaSlabs", "PapayaSlabs", "PapayaSlabs", null, "PapayaPlanks", null, null,
                        "PapayaPlanks", null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodMapFrame", 1, 15),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood", "PapayaSlabs", "stickWood",
                        "stickWood", "stickWood", "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFancyWorkbench", 1, 15),
                new Object[] { "dyeBlack", getModItem(Minecraft.ID, "crafting_table", 1), "craftingFeather",
                        "PapayaSlabs", getModItem(BiblioWoodsForestryEdition.ID, "BiblioWoodFstBookcase", 1, 15),
                        "PapayaSlabs", "PapayaSlabs", "PapayaSlabs", "PapayaSlabs" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack1", 1, 15),
                new Object[] { null, "blockWool", null, null, "PapayaSlabs", null, "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 15),
                new Object[] { "stickWood", "blockWool", "stickWood", "stickWood", "PapayaSlabs", "stickWood",
                        "stickWood", null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack3", 1, 15),
                new Object[] { "PapayaSlabs", getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 15), null,
                        null, null, null, null, null, null });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack4", 1, 15),
                new Object[] { null, "blockWool", null, null, "PapayaSlabs", null, null, null, "stickWood" });

        addShapedRecipe(
                getModItem(BiblioWoodsForestryEdition.ID, "seatBack5", 1, 15),
                new Object[] { "PapayaSlabs", "PapayaSlabs", null,
                        getModItem(BiblioWoodsForestryEdition.ID, "seatBack2", 1, 15), null, null, null, null,
                        null });
    }
}
