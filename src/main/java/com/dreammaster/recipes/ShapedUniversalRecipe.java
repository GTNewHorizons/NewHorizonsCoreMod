package com.dreammaster.recipes;

import static com.dreammaster.scripts.IScriptLoader.missing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import gregtech.api.objects.ItemData;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ShapedUniversalRecipe extends ShapedOreRecipe {

    ItemStack output;
    Object[][] recipe = new Object[3][3];
    Object[] recipeXY = new Object[9];

    public ShapedUniversalRecipe(ItemStack result, Object... recipe) {
        super(result, 'x', missing);
        output = result.copy();
        if (recipe.length > 3 && recipe[0] instanceof String
                && recipe[1] instanceof String
                && recipe[2] instanceof String
                && ((String) recipe[0]).length() == 3
                && ((String) recipe[1]).length() == 3
                && ((String) recipe[2]).length() == 3) {
            HashMap<Character, Object> itemMap = new HashMap<>();
            for (int i = 3; i < recipe.length; i += 2) {
                if (recipe[i + 1] != null) itemMap.put((Character) recipe[i], recipe[i + 1]);
            }
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    this.recipe[y][x] = itemMap.get(((String) recipe[y]).charAt(x));
                }
            }
        } else {
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    int i = y * 3 + x;
                    this.recipe[y][x] = recipe.length > i ? recipe[i] : null;
                }
            }
        }
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (this.recipe[y][x] == null) continue;
                if (this.recipe[y][x] instanceof String) {
                    ArrayList<ItemStack> ores = OreDictionary.getOres((String) this.recipe[y][x]);
                    this.recipeXY[y * 3 + x] = ores;
                    HashSet<GT_Utility.ItemId> oresHashes = new HashSet<>();
                    ores.forEach(o -> {
                        ItemStack i = o.copy();
                        i.stackTagCompound = null;
                        oresHashes.add(GT_Utility.ItemId.createNoCopy(i));
                    });
                    this.recipe[y][x] = oresHashes;
                } else if (this.recipe[y][x] instanceof ItemStack) {
                    this.recipe[y][x] = ((ItemStack) this.recipe[y][x]).copy();
                    this.recipeXY[y * 3 + x] = this.recipe[y][x];
                } else if (this.recipe[y][x] instanceof Item) {
                    this.recipe[y][x] = new ItemStack((Item) this.recipe[y][x]);
                    this.recipeXY[y * 3 + x] = this.recipe[y][x];
                } else if (this.recipe[y][x] instanceof Block) {
                    this.recipe[y][x] = new ItemStack((Block) this.recipe[y][x]);
                    this.recipeXY[y * 3 + x] = this.recipe[y][x];
                } else if (this.recipe[y][x] instanceof ItemData) {
                    ItemData data = (ItemData) this.recipe[y][x];
                    ItemStack itemStack = GT_OreDictUnificator.get(data.mPrefix, data.mMaterial.mMaterial, 1);
                    if (itemStack == null) {
                        throw new NullPointerException("bad item passed in the recipe");
                    } else {
                        this.recipe[y][x] = itemStack;
                        this.recipeXY[y * 3 + x] = this.recipe[y][x];
                    }
                } else if (this.recipe[y][x] instanceof NBTItem) {
                    this.recipeXY[y * 3 + x] = ((NBTItem) this.recipe[y][x]).getStack();
                } else {
                    throw new IllegalArgumentException("Wrong argument in recipe");
                }
            }
        }
    }

    @Override
    public boolean matches(InventoryCrafting inv, World world) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                ItemStack stack = inv.getStackInRowAndColumn(y, x);
                Object r = this.recipe[y][x];
                if (r == null ^ stack == null) return false;
                if (stack == null) continue;
                if (r instanceof ItemStack) {
                    if (!GT_Utility.areStacksEqual((ItemStack) r, stack, true)) return false;
                } else if (r instanceof HashSet) {
                    ItemStack copy = stack;
                    if (copy.stackTagCompound != null) {
                        copy = stack.copy();
                        copy.stackTagCompound = null;
                    }
                    // noinspection unchecked
                    if (!((HashSet<GT_Utility.ItemId>) r).contains(GT_Utility.ItemId.createNoCopy(copy))) return false;
                } else if (r instanceof NBTItem) {
                    if (!((NBTItem) r).matches(stack)) return false;
                } else {
                    // ????
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return getRecipeOutput().copy();
    }

    @Override
    public int getRecipeSize() {
        return 9;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return output;
    }

    @Override
    public Object[] getInput() {
        return recipeXY;
    }

    @Override
    public ShapedOreRecipe setMirrored(boolean mirror) {
        throw new UnsupportedOperationException();
    }
}
