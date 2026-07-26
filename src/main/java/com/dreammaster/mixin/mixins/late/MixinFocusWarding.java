package com.dreammaster.mixin.mixins.late;

import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;

import thaumcraft.api.wands.ItemFocusBasic;
import thaumcraft.common.items.wands.foci.ItemFocusWarding;

@Mixin(value = ItemFocusWarding.class)
public class MixinFocusWarding extends ItemFocusBasic {

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack p_77630_1_) {
        return false;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        return stack;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
}
