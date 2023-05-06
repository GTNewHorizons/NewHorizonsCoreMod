package com.dreammaster.recipes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import gregtech.api.objects.ItemData;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ShapelessUniversalRecipe implements IRecipe {

    ItemStack output;
    ArrayList<Object> recipe = new ArrayList<Object>();

    public ShapelessUniversalRecipe(ItemStack result, Object... recipe) {
        output = result.copy();
        if (recipe.length > 9) throw new IllegalArgumentException("Too many recipe arguments");
        for (Object value : recipe) {
            if (value == null) continue;
            if (value instanceof String) {
                ArrayList<ItemStack> ores = OreDictionary.getOres((String) value);
                HashSet<GT_Utility.ItemId> oresHashes = new HashSet<>();
                ores.forEach(o -> {
                    ItemStack oi = o.copy();
                    oi.stackTagCompound = null;
                    oresHashes.add(GT_Utility.ItemId.createNoCopy(oi));
                });
                this.recipe.add(oresHashes);
            } else if (value instanceof ItemStack) this.recipe.add(((ItemStack) value).copy());
            else if (value instanceof Item) this.recipe.add(new ItemStack((Item) value));
            else if (value instanceof Block) this.recipe.add(new ItemStack((Block) value));
            else if (value instanceof ItemData) {
                ItemData data = (ItemData) value;
                ItemStack itemStack = GT_OreDictUnificator.get(data.mPrefix, data.mMaterial.mMaterial, 1);
                if (itemStack == null) {
                    throw new NullPointerException("bad item passed in the recipe");
                } else {
                    this.recipe.add(itemStack);
                }
            } else if (value instanceof NBTItem) {
                this.recipe.add(value);
            } else {
                throw new IllegalArgumentException("Wrong argument in recipe");
            }
        }
    }

    @Override
    public boolean matches(InventoryCrafting inv, World world) {
        ArrayList<Object> required = new ArrayList<>(recipe);
        invloop: for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (stack == null) continue;
            for (Iterator<Object> iterator = required.iterator(); iterator.hasNext();) {
                Object r = iterator.next();
                if (r instanceof ItemStack) {
                    if (!GT_Utility.areStacksEqual((ItemStack) r, stack, true)) continue;
                    iterator.remove();
                    continue invloop;
                } else if (r instanceof HashSet) {
                    ItemStack copy = stack;
                    if (copy.stackTagCompound != null) {
                        copy = stack.copy();
                        copy.stackTagCompound = null;
                    }
                    // noinspection unchecked
                    if (!((HashSet<GT_Utility.ItemId>) r).contains(GT_Utility.ItemId.createNoCopy(copy))) continue;
                    iterator.remove();
                    continue invloop;
                } else if (r instanceof NBTItem) {
                    if (!((NBTItem) r).matches(stack)) continue;
                    iterator.remove();
                    continue invloop;
                } else {
                    // ????
                    return false;
                }
            }
            return false;
        }
        return required.isEmpty();
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return getRecipeOutput().copy();
    }

    @Override
    public int getRecipeSize() {
        return recipe.size();
    }

    @Override
    public ItemStack getRecipeOutput() {
        return output;
    }
}
