package com.dreammaster.recipes;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;

class ResolvedIngredientsFlattener implements IngredientsFlattener {

    /**
     * Flattens a recipe to only have up to one ItemStack per slot.
     * 
     * @param ingredients A recipe which contains only ItemStack, List<ItemStack> and null values.
     * @return An array of ItemStack or null values.
     */
    @Override
    public ItemStack[] flatten(Object[] ingredients) {
        return Arrays.stream(ingredients).map(this::flattenIngredient).toArray(ItemStack[]::new);
    }

    private ItemStack flattenIngredient(Object ingredient) {
        if (ingredient instanceof List<?>list) {
            ingredient = getFirstFromList(list);
            if (Objects.isNull(ingredient)) {
                throw new IllegalArgumentException("List provided in resolved ingredients contains nulls!");
            }
        } else if (Objects.isNull(ingredient)) {
            return null;
        }
        if (ingredient instanceof ItemStack itemStack) {
            return itemStack;
        }
        throw new IllegalArgumentException(describeUnexpectedIngredient(ingredient));
    }

    private static Object getFirstFromList(List<?> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list provided in resolved ingredients!");
        }
        return list.get(0);
    }

    @Nonnull
    private static String describeUnexpectedIngredient(Object itemStackCandidate) {
        return "Unexpected recipe ingredient! " + itemStackCandidate + " : " + itemStackCandidate.getClass().getName();
    }

}
