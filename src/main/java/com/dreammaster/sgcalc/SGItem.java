package com.dreammaster.sgcalc;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import gregtech.api.util.GTOreDictUnificator;

/**
 * A single node in the cost graph: either an item or a fluid, reduced to a stable canonical {@link #key} used for
 * recipe-index lookups, cycle detection and tally bucketing. Items are passed through {@link GTOreDictUnificator} so
 * that ore-dictionary-equivalent forms collapse to one key.
 */
public final class SGItem {

    public final ItemStack stack;
    public final FluidStack fluid;
    public final String key;

    private SGItem(ItemStack stack, FluidStack fluid, String key) {
        this.stack = stack;
        this.fluid = fluid;
        this.key = key;
    }

    public static SGItem of(ItemStack input) {
        ItemStack unified = GTOreDictUnificator.get(input);
        if (unified == null) unified = input;
        return new SGItem(unified, null, itemKey(unified));
    }

    public static SGItem of(FluidStack input) {
        String name = input.getFluid() != null ? input.getFluid().getName() : "unknown";
        return new SGItem(null, input, "fluid:" + name);
    }

    public boolean isFluid() {
        return fluid != null;
    }

    /** Whether this item accepts any metadata (a wildcard ingredient, e.g. a charge-agnostic electric item). */
    public boolean isWildcard() {
        return stack != null && stack.getItemDamage() == OreDictionary.WILDCARD_VALUE;
    }

    /**
     * This item's {@link #key} with a wildcard meta. Producers are also indexed under this key so a wildcard ingredient
     * -- one that accepts any meta, such as a lapotron crystal at any charge -- still finds a concrete-meta producer.
     */
    public String wildcardKey() {
        if (stack == null) return null;
        int hash = key.lastIndexOf('#');
        return (hash < 0 ? key : key.substring(0, hash)) + "#" + OreDictionary.WILDCARD_VALUE;
    }

    static String itemKey(ItemStack s) {
        Object name = Item.itemRegistry.getNameForObject(s.getItem());
        return (name == null ? "?" : name.toString()) + "#" + s.getItemDamage();
    }

    public String displayName() {
        // Some modded items throw from getDisplayName/getLocalizedName; the canonical key is an acceptable fallback.
        try {
            if (fluid != null) return fluid.getLocalizedName();
            return stack.getDisplayName();
        } catch (RuntimeException e) {
            return key;
        }
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof SGItem other && key.equals(other.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public String toString() {
        return key;
    }
}
