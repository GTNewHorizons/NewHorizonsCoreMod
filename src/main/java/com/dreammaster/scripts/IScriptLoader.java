package com.dreammaster.scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.dreammaster.main.MainRegistry;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.objects.ItemData;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.common.items.GT_MetaGenerated_Item_01;
import gregtech.common.items.GT_MetaGenerated_Item_02;

public interface IScriptLoader {
    // todo: cache the lookups for the itemstacks
    // todo: make an error for the itemstack lookup if it returns null

    int wildcard = 32767;

    /**
     * Function to get the name of the script.
     *
     * @return the name of the script.
     */
    String getScriptName();

    /**
     * Function to get the list of all the dependencies needed to load the script. Avoid manual checks with
     * Loader.isModLoaded.
     *
     * @return a list of string containing the dependencies.
     */
    List<String> getDependencies();

    /**
     * Method to override to implement the recipes in the script
     */
    void loadRecipes();

    /**
     * Code strongly inspired from what did alkalus in GT++.
     * 
     * @param inputs       Object array that should contain only the 9 object representing the items in the crafting
     *                     grid. Acceptable types are Item, Block, ItemStack, ItemData and null (for empty slots).
     * @param aOutputStack The result of the crafting recipe
     * @return a boolean
     */
    default boolean addShapedRecipe(ItemStack aOutputStack, Object[] inputs) {
        Object[] slots = new Object[9];
        StringBuilder fullString = new StringBuilder();
        String slotMappings = "abcdefghi";
        try {
            for (int i = 0; i < 9; i++) {
                Object o = inputs[i];
                if (o instanceof ItemStack) {
                    final ItemStack itemStack = ((ItemStack) o).copy();
                    itemStack.stackSize = 1;
                    slots[i] = itemStack.copy();
                    fullString.append(slotMappings.charAt(i));
                } else if (o instanceof Item) {
                    final ItemStack itemStack = new ItemStack((Item) o, 1);
                    slots[i] = itemStack.copy();
                    fullString.append(slotMappings.charAt(i));
                } else if (o instanceof Block) {
                    final ItemStack itemStack = new ItemStack((Block) o, 1);
                    slots[i] = itemStack.copy();
                    fullString.append(slotMappings.charAt(i));
                } else if (o instanceof String) {
                    slots[i] = o;
                    fullString.append(slotMappings.charAt(i));
                } else if (o instanceof ItemData) {
                    ItemData data = (ItemData) o;
                    ItemStack itemStack = GT_OreDictUnificator.get(data.mPrefix, data.mMaterial.mMaterial, 1);
                    if (itemStack == null) {
                        throw new NullPointerException("bad item passed in the recipe");
                    } else {
                        slots[i] = itemStack;
                        fullString.append(slotMappings.charAt(i));
                    }

                } else if (o == null) {
                    slots[i] = null;
                    fullString.append(" ");
                } else {
                    slots[i] = null;
                    throw new NullPointerException("bad recipe generated");
                }
            }
            String aRow1 = fullString.substring(0, 3);
            String aRow2 = fullString.substring(3, 6);
            String aRow3 = fullString.substring(6, 9);
            String[] recipeRows = new String[] { aRow1, aRow2, aRow3 };
            Object[] recipeInputs = new Object[19];
            recipeInputs[0] = recipeRows;
            int aIndex = 0;
            for (int u = 1; u < 20; u += 2) {
                if (aIndex == 9) {
                    break;
                }
                if (fullString.charAt(aIndex) != (' ')) {
                    recipeInputs[u] = fullString.charAt(aIndex);
                    recipeInputs[u + 1] = slots[aIndex];
                }
                aIndex++;
            }
            recipeInputs = removeNulls(recipeInputs);
            ShapedOreRecipe aRecipe = new ShapedOreRecipe(aOutputStack, recipeInputs);
            GameRegistry.addRecipe(aRecipe);
        } catch (Exception e) {
            MainRegistry.Logger.error("a recipe went wrong:");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Utility fonction copied from GT++ to strip nulls from the array.
     * 
     * @param v The object array to process.
     * @return An object array with null elements removed
     */
    static Object[] removeNulls(final Object[] v) {
        List<Object> list = new ArrayList<>(Arrays.asList(v));
        list.removeAll(Collections.singleton(null));
        return list.toArray(new Object[0]);
    }

    /**
     * Helper function to get the GT_MetaGenerated_Item_02 item based on its meta.
     * 
     * @param meta the meta id of the item to look at.
     * @return an itemstack with a stacksize of 1 corresponding to the item looked for.
     */
    default ItemStack getMeta02(int meta) {
        return new ItemStack(GT_MetaGenerated_Item_02.INSTANCE, 1, meta);
    }

    /**
     * Helper function to get the GT_MetaGenerated_Item_01 item based on its meta.
     * 
     * @param meta the meta id of the item to look at.
     * @return an itemstack with a stacksize of 1 corresponding to the item looked for.
     */
    default ItemStack getMeta01(int meta) {
        return new ItemStack(GT_MetaGenerated_Item_01.INSTANCE, 1, meta);
    }

    /**
     * Function to know if a script is loadable: if at least one of its dependencies is missing then it won't be
     * considered as loadable.
     * 
     * @return a boolean representing if the script is loadable.
     */
    default boolean isScriptLoadable() {
        for (String dep : getDependencies()) {
            if (!Loader.isModLoaded(dep)) {
                return false;
            }
        }
        return true;
    }
}
