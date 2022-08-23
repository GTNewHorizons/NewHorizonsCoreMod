package com.dreammaster.witchery;

import com.emoniph.witchery.brewing.AltarPower;
import com.emoniph.witchery.brewing.BrewItemKey;
import com.emoniph.witchery.brewing.WitcheryBrewRegistry;
import com.emoniph.witchery.brewing.action.BrewAction;
import com.emoniph.witchery.brewing.action.BrewActionRitualRecipe;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class WitcheryBrewRegistryAccessor {
    static final Logger log = LogManager.getLogger("WitcheryCompat");
    static final Method methodRegister;
    static final Field fieldRecipes;
    static final Hashtable<BrewItemKey, BrewAction> ingredient;

    static {
        Hashtable<BrewItemKey, BrewAction> ingredient1;
        Method tmp;
        Field field, f2;
        try {
            final ClassLoader classLoader = WitcheryPlugin.class.getClassLoader();
            Class<?> clazz = Class.forName("com.emoniph.witchery.brewing.WitcheryBrewRegistry", false, classLoader);
            tmp = clazz.getDeclaredMethod("register", BrewAction.class);
            tmp.setAccessible(true);
            field = clazz.getDeclaredField("ingredients");
            field.setAccessible(true);
            ingredient1 = getIngredient(field);
            clazz = Class.forName("com.emoniph.witchery.brewing.action.BrewActionRitualRecipe", false, classLoader);
            f2 = clazz.getDeclaredField("recipes");
            f2.setAccessible(true);
        } catch (NoSuchMethodException | ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            log.error("Cannot find Witchery brew registry stuff. Related functionality will have no effect!", e);
            tmp = null;
            ingredient1 = null;
            f2 = null;
        }
        ingredient = ingredient1;
        methodRegister = tmp;
        fieldRecipes = f2;
    }

    @SuppressWarnings("unchecked")
    private static Hashtable<BrewItemKey, BrewAction> getIngredient(Field field) throws IllegalAccessException {
        return (Hashtable<BrewItemKey, BrewAction>) field.get(WitcheryBrewRegistry.INSTANCE);
    }

    static void registerBrewAction(BrewAction action) {
        if (methodRegister != null) {
            try {
                methodRegister.invoke(WitcheryBrewRegistry.INSTANCE, action);
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error("Error registering brew action", e);
            }
        }
    }

    static void modifyBrewRecipe(BrewActionRitualRecipe ritualRecipe, BrewActionRitualRecipe.Recipe[] recipes) {
        removeAction(ritualRecipe);
        AltarPower power = new AltarPower(0);
        ritualRecipe.accumulatePower(power);
        registerBrewAction(new BrewActionRitualRecipe(ritualRecipe.ITEM_KEY, power, recipes));
    }

    static void removeAction(BrewActionRitualRecipe action) {
        ingredient.remove(action.ITEM_KEY);
        WitcheryBrewRegistry.INSTANCE.getRecipes().remove(action);
    }

    static BrewActionRitualRecipe.Recipe[] getRecipes(BrewActionRitualRecipe ritualRecipe) {
        try {
            return (BrewActionRitualRecipe.Recipe[]) fieldRecipes.get(ritualRecipe);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    static boolean isCauldronRecipeMatch(BrewActionRitualRecipe.Recipe recipe, ItemStack lastItem, ItemStack[] items) {
        final ItemStack[] ingredients = recipe.ingredients;
        final int length = ingredients.length;
        if (length != items.length + 1) return false;
        boolean[] found = new boolean[length];
        for (ItemStack item : items) {
            boolean foundThisRound = false;
            int i;
            for (i = 0; i < length - 1; i++) {
                if (!found[i] && item.isItemEqual(ingredients[i])) {
                    found[i] = true;
                    foundThisRound = true;
                    break;
                }
            }
            if (!foundThisRound && !found[i] && lastItem.isItemEqual(ingredients[i])) {
                found[i] = true;
                foundThisRound = true;
            }
            if (!foundThisRound) return false;
        }
        // length check done already, no need to repeat
        return true;
    }
}
