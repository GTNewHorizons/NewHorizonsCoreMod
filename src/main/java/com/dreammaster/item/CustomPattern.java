package com.dreammaster.item;

import static gregtech.api.enums.Mods.ModIDs.TINKER_CONSTRUCT;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Optional;
import tconstruct.library.crafting.PatternBuilder;
import tconstruct.library.util.IPattern;

@Optional.Interface(modid = TINKER_CONSTRUCT, iface = "tconstruct.library.util.IPattern")
public class CustomPattern extends Item implements IPattern {

    @Override
    @Optional.Method(modid = TINKER_CONSTRUCT)
    public int getPatternCost(ItemStack pattern) {
        return 0;
    }

    @Override
    @Optional.Method(modid = TINKER_CONSTRUCT)
    public ItemStack getPatternOutput(ItemStack pattern, ItemStack input, PatternBuilder.MaterialSet set) {
        return null;
    }
}
