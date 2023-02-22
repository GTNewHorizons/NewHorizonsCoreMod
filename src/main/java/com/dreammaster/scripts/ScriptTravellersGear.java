package com.dreammaster.scripts;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import cpw.mods.fml.common.registry.GameRegistry;

public class ScriptTravellersGear implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "TravellersGear";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList("Baubles", "TravellersGear", "BiblioCraft", "harvestcraft", "gregtech");
    }

    @Override
    public void loadRecipes() {
        final Item simpleGear = GameRegistry.findItem("TravellersGear", "simpleGear");
        final Block armorStand = GameRegistry.findBlock("TravellersGear", "armorstand");
        final Item hardenedLeatherItem = GameRegistry.findItem("harvestcraft", "hardenedleatherItem");
        final Item biblioArmorStandItem = GameRegistry.findItem("BiblioCraft", "Armor Stand");
        int[] dyeColours = { 0xffffff, 0xD87F33, 0xB24CD8, 0x6699D8, 0xE5E533, 0x7FCC19, 0xF27FA5, 0x4C4C4C, 0x999999,
                0x4C7F99, 0x7F3FB2, 0x334CB2, 0x664C33, 0x667F33, 0x993333, 0x191919 };
        for (int d = 0; d < dyeColours.length; d++) {
            GameRegistry.addRecipe(
                    new ShapelessOreRecipe(
                            getColouredItem(new ItemStack(simpleGear, 1, 0), dyeColours[d]),
                            new ItemStack(simpleGear, 1, 0),
                            new ItemStack(Items.dye, 1, (15 - d))));
        }
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        new ItemStack(simpleGear, 1, 0),
                        "RSR",
                        "WWW",
                        "WWW",
                        'R',
                        "ringIron",
                        'S',
                        Items.string,
                        'W',
                        new ItemStack(GameRegistry.findItem("harvestcraft", "wovencottonItem"))));
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        new ItemStack(simpleGear, 1, 4),
                        "ll ",
                        "ill",
                        " i ",
                        'i',
                        "screwIron",
                        'l',
                        new ItemStack(hardenedLeatherItem)));
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        new ItemStack(simpleGear, 1, 5),
                        " l ",
                        "lil",
                        " l ",
                        'i',
                        "screwIron",
                        'l',
                        new ItemStack(hardenedLeatherItem)));
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        new ItemStack(simpleGear, 1, 6),
                        " l ",
                        "pbp",
                        " l ",
                        'b',
                        Items.enchanted_book,
                        'p',
                        Items.paper,
                        'l',
                        "gemEmerald"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(armorStand), new ItemStack(biblioArmorStandItem)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(biblioArmorStandItem), new ItemStack(armorStand)));
    }

    private ItemStack getColouredItem(ItemStack item, int col) {
        if (!item.hasTagCompound()) {
            item.setTagCompound(new NBTTagCompound());
        }
        NBTTagCompound tag = item.getTagCompound().getCompoundTag("display");
        tag.setInteger("colour", col);
        item.getTagCompound().setTag("display", tag);
        return item;
    }

}
