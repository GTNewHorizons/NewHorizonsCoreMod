package com.dreammaster.recipes;

import static com.dreammaster.scripts.IScriptLoader.wildcard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import gregtech.api.interfaces.IItemContainer;
import gregtech.api.objects.ItemData;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

/**
 * ShapelessOreRecipe implementation with NBT checking support. Use {@link CustomItem} in input objects to check for NBT
 *
 * @author kuba6000
 */
public class ShapelessUniversalRecipe extends ShapelessOreRecipe {

    private final ItemStack output;
    private final ArrayList<Object> recipe = new ArrayList<>();
    private final ArrayList<Object> recipeXY = new ArrayList<>();

    public ShapelessUniversalRecipe(ItemStack result, Object... recipe) {
        super(result);
        output = result.copy();
        if (recipe.length > 9) throw new IllegalArgumentException("Too many recipe arguments");
        for (Object value : recipe) {
            if (value == null) continue;
            if (value instanceof String) {
                ArrayList<ItemStack> ores = OreDictionary.getOres((String) value);
                HashSet<GTUtility.ItemId> oresHashes = new HashSet<>();
                for (ItemStack o : ores) {
                    ItemStack i = o.copy();
                    i.stackTagCompound = null;
                    oresHashes.add(GTUtility.ItemId.createNoCopy(i));
                }
                this.recipe.add(oresHashes);
                this.recipeXY.add(ores);
            } else if (value instanceof List<?>list) {
                List<ItemStack> items = new ArrayList<>();
                HashSet<GTUtility.ItemId> itemHash = new HashSet<>();
                for (Object o : list) {
                    if (!(o instanceof ItemStack itemStack)) {
                        throw new IllegalArgumentException("Invalid item stack: " + o);
                    }
                    ItemStack i = itemStack.copy();
                    items.add(i);
                    itemHash.add(GTUtility.ItemId.createNoCopy(i));
                }
                this.recipe.add(itemHash);
                this.recipeXY.add(items);
            } else if (value instanceof ItemStack) {
                ItemStack i = ((ItemStack) value).copy();
                this.recipe.add(i);
                this.recipeXY.add(i);
            } else if (value instanceof IItemContainer) {
                ItemStack i = ((IItemContainer) value).get(1);
                this.recipe.add(i);
                this.recipeXY.add(i);
            } else if (value instanceof Item) {
                ItemStack i = new ItemStack((Item) value);
                this.recipe.add(i);
                this.recipeXY.add(i);
            } else if (value instanceof Block) {
                ItemStack i = new ItemStack((Block) value);
                this.recipe.add(i);
                this.recipeXY.add(i);
            } else if (value instanceof ItemData) {
                ItemData data = (ItemData) value;
                ItemStack itemStack = GTOreDictUnificator.get(data.mPrefix, data.mMaterial.mMaterial, 1);
                if (itemStack == null) {
                    throw new NullPointerException("bad item passed in the recipe");
                } else {
                    this.recipe.add(itemStack);
                    this.recipeXY.add(itemStack);
                }
            } else if (value instanceof CustomItem) {
                this.recipe.add(value);
                this.recipeXY.add(((CustomItem) value).getStack());
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
                    if (!GTUtility.areStacksEqual((ItemStack) r, stack, true)) continue;
                    iterator.remove();
                    continue invloop;
                } else if (r instanceof HashSet) {
                    ItemStack copy = stack.copy();
                    copy.stackTagCompound = null;
                    // noinspection unchecked
                    if (!((HashSet<GTUtility.ItemId>) r).contains(GTUtility.ItemId.createNoCopy(copy))) {
                        Items.feather.setDamage(copy, wildcard);
                        // noinspection unchecked
                        if (!((HashSet<GTUtility.ItemId>) r).contains(GTUtility.ItemId.createNoCopy(copy))) continue;
                    }
                    iterator.remove();
                    continue invloop;
                } else if (r instanceof CustomItem) {
                    if (!((CustomItem) r).matches(stack)) continue;
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

    @Override
    public ArrayList<Object> getInput() {
        return recipeXY;
    }
}
