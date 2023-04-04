package com.dreammaster.item;

import mantle.items.abstracts.CraftingItem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import tconstruct.library.crafting.PatternBuilder;
import tconstruct.library.util.IPattern;

import static gregtech.api.enums.Mods.NewHorizonsCoreMod;

public class Pattern extends CraftingItem implements IPattern {

    public Pattern(String[] names, String[] tex, CreativeTabs tab) {
        super(names, tex, "", NewHorizonsCoreMod.ID, tab);
    }

    public Pattern(String[] names, String[] tex, String folder, String modTexturePrefix, CreativeTabs tab) {
        super(names, tex, folder, modTexturePrefix, tab);
    }

    @Override
    public int getPatternCost(ItemStack pattern) {
        return 0;
    }

    @Override
    public ItemStack getPatternOutput(ItemStack pattern, ItemStack input, PatternBuilder.MaterialSet set) {
        return null;
    }
}
