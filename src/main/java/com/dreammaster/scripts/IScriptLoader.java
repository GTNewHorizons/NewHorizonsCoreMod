package com.dreammaster.scripts;

import static gregtech.api.util.GTModHandler.getModItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;

import com.dreammaster.main.MainRegistry;
import com.dreammaster.recipes.CustomItem;
import com.dreammaster.recipes.ShapedUniversalRecipe;
import com.dreammaster.recipes.ShapelessUniversalRecipe;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.interfaces.IItemContainer;
import gregtech.api.objects.ItemData;
import gregtech.common.items.MetaGeneratedItem01;
import gregtech.common.items.MetaGeneratedItem02;

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
     * Adds shaped crafting recipe using {@link ShapedUniversalRecipe}
     *
     * @param inputs  Crafting ingredient, maximum 9 accepted. Supports String (OreDict), ItemStack, Item, Block,
     *                ItemData, {@link IItemContainer}, {@link ItemData}, {@link CustomItem}, null (empty slot)
     * @param aOutput The result of the crafting recipe
     * @return a boolean
     */
    default boolean addShapedRecipe(ItemStack aOutput, Object... inputs) {
        try {
            GameRegistry.addRecipe(new ShapedUniversalRecipe(aOutput, inputs));
        } catch (Exception e) {
            MainRegistry.Logger.error("a recipe went wrong:");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Adds shapeless crafting recipe using {@link ShapelessUniversalRecipe}
     *
     * @param inputs  Crafting ingredient, maximum 9 accepted. Supports String (OreDict), ItemStack, Item, Block,
     *                ItemData, {@link IItemContainer}, {@link ItemData}, {@link CustomItem}
     * @param aOutput The result of the crafting recipe
     * @return a boolean
     */
    default boolean addShapelessRecipe(ItemStack aOutput, Object... inputs) {
        try {
            GameRegistry.addRecipe(new ShapelessUniversalRecipe(aOutput, inputs));
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
        return new ItemStack(MetaGeneratedItem02.INSTANCE, 1, meta);
    }

    /**
     * Helper function to get the GT_MetaGenerated_Item_01 item based on its meta.
     * 
     * @param meta the meta id of the item to look at.
     * @return an itemstack with a stacksize of 1 corresponding to the item looked for.
     */
    default ItemStack getMeta01(int meta) {
        return new ItemStack(MetaGeneratedItem01.INSTANCE, 1, meta);
    }

    /**
     * Helper function to get a new ItemStack with specified damage (meta) value and NBT tags. Calls
     * {@link gregtech.api.util.GTModHandler#getModItem(java.lang.String, java.lang.String, long, int)} internally
     *
     * @param aModID       Mod ID of an the item
     * @param aItem        Item registry name
     * @param aAmount      Amount to get
     * @param aMeta        the meta id of the item to look at.
     * @param aNBTString   NBT data that the created stack should get, in format that {@link NBTTagCompound#toString()}
     *                     returns. Can be checked in-game with `/iih` command
     * @param aReplacement Replacement stack to return if the item is not found. NBT data is not applied to it.
     * @return Created ItemStack or replacement stack
     * @throws RuntimeException if the NBT string parsing fails
     */
    default ItemStack createItemStack(String aModID, String aItem, long aAmount, int aMeta, String aNBTString,
            ItemStack aReplacement) {
        ItemStack s = getModItem(aModID, aItem, aAmount, aMeta);
        if (s == null) return aReplacement;
        try {
            s.stackTagCompound = (NBTTagCompound) JsonToNBT.func_150315_a(aNBTString);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return s;
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

    ItemStack missing = new ItemStack(Blocks.fire);
}
