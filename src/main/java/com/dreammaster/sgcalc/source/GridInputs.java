package com.dreammaster.sgcalc.source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.sgcalc.RecipeCandidate.Ingredient;
import com.dreammaster.sgcalc.RecipeCandidate.Output;
import com.dreammaster.sgcalc.SGItem;

/** Shared helpers for the recipe sources: grid collapsing plus stack/fluid validity and single-element builders. */
final class GridInputs {

    private GridInputs() {}

    static boolean isValid(ItemStack stack) {
        return stack != null && stack.getItem() != null && stack.stackSize > 0;
    }

    static boolean isValid(FluidStack fluid) {
        return fluid != null && fluid.getFluid() != null && fluid.amount > 0;
    }

    static Ingredient fluidIngredient(FluidStack fluid) {
        return new Ingredient(Collections.singletonList(SGItem.of(fluid)), fluid.amount);
    }

    static Output stackOutput(ItemStack stack) {
        return new Output(SGItem.of(stack), stack.stackSize);
    }

    /**
     * Collapses a crafting grid into per-slot {@link Ingredient}s with consumption counts. Each element may be an
     * {@link ItemStack}, an ore-dictionary expansion ({@link List} of stacks) or null (empty cell).
     */
    static List<Ingredient> collapse(Iterable<?> elements) {
        Map<String, List<SGItem>> altsByKey = new LinkedHashMap<>();
        Map<String, long[]> counts = new LinkedHashMap<>();

        for (Object element : elements) {
            List<SGItem> alts = new ArrayList<>();
            String key;
            if (element instanceof ItemStack stack) {
                if (isIgnored(stack)) continue;
                SGItem item = SGItem.of(stack);
                alts.add(item);
                key = item.key;
            } else if (element instanceof Iterable<?>oreAlts) {
                StringBuilder sb = new StringBuilder("ore[");
                for (Object alt : oreAlts) {
                    if (alt instanceof ItemStack as && as.getItem() != null) {
                        SGItem item = SGItem.of(as);
                        alts.add(item);
                        sb.append(item.key).append(',');
                    }
                }
                if (alts.isEmpty()) continue;
                key = sb.append(']').toString();
            } else {
                continue;
            }
            altsByKey.putIfAbsent(key, alts);
            counts.computeIfAbsent(key, k -> new long[1])[0]++;
        }

        List<Ingredient> ingredients = new ArrayList<>();
        for (Map.Entry<String, long[]> e : counts.entrySet()) {
            ingredients.add(new Ingredient(altsByKey.get(e.getKey()), e.getValue()[0]));
        }
        return ingredients;
    }

    /** GregTech's programmed/integrated circuit is a recipe selector, never consumed -- exclude it from cost. */
    static boolean isIgnored(ItemStack stack) {
        if (stack == null || stack.getItem() == null) return true;
        Object name = net.minecraft.item.Item.itemRegistry.getNameForObject(stack.getItem());
        return name != null && name.toString().endsWith(":gt.integrated_circuit");
    }
}
