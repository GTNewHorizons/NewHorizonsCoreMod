package com.dreammaster.recipes;

import static com.dreammaster.scripts.IScriptLoader.wildcard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import gregtech.api.interfaces.IItemContainer;
import gregtech.api.objects.ItemData;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

/**
 * ShapedOreRecipe implementation with NBT checking support. Use {@link CustomItem} in input objects to check for NBT
 *
 * @author kuba6000
 */
public class ShapedUniversalRecipe extends ShapedOreRecipe {

    static final ItemStack MISSING = new ItemStack(Blocks.fire);
    private final ItemStack output;
    private final Object[][] recipe = new Object[3][3];
    private final Object[] recipeXY = new Object[9];
    private int maxX, maxY = 0;

    public ShapedUniversalRecipe(ItemStack result, Object... recipe) {
        super(result, "xxx", "xxx", "xxx", 'x', MISSING);
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
            if (recipe.length == 4) {
                for (int y = 0; y < 2; y++) {
                    for (int x = 0; x < 2; x++) {
                        int i = y * 2 + x;
                        this.recipe[y][x] = recipe[i];
                        if (recipe[i] != null) {
                            if (maxX < x) maxX = x;
                            if (maxY < y) maxY = y;
                        }
                    }
                }
            } else {
                for (int y = 0; y < 3; y++) {
                    for (int x = 0; x < 3; x++) {
                        int i = y * 3 + x;
                        if (!(i >= recipe.length)) {
                            this.recipe[y][x] = recipe[i];
                            if (maxX < x) maxX = x;
                            if (maxY < y) maxY = y;
                        }
                    }
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
                    for (ItemStack o : ores) {
                        ItemStack i = o.copy();
                        i.stackTagCompound = null;
                        oresHashes.add(GT_Utility.ItemId.createNoCopy(i));
                    }
                    this.recipe[y][x] = oresHashes;
                } else if (this.recipe[y][x] instanceof ItemStack) {
                    this.recipe[y][x] = ((ItemStack) this.recipe[y][x]).copy();
                    this.recipeXY[y * 3 + x] = this.recipe[y][x];
                } else if (this.recipe[y][x] instanceof IItemContainer) {
                    this.recipe[y][x] = ((IItemContainer) this.recipe[y][x]).get(1);
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
                } else if (this.recipe[y][x] instanceof CustomItem) {
                    this.recipeXY[y * 3 + x] = ((CustomItem) this.recipe[y][x]).getStack();
                } else {
                    throw new IllegalArgumentException("Wrong argument in recipe");
                }
            }
        }
    }

    @Override
    public boolean matches(InventoryCrafting inv, World world) {
        for (int y = 0; y < (3 - maxY); y++) {
            for (int x = 0; x < (3 - maxX); x++) {
                if (matches(inv, x, y)) return true;
            }
        }
        return false;
    }

    private boolean matches(InventoryCrafting inv, int offsetX, int offsetY) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                ItemStack stack = inv.getStackInRowAndColumn(x, y);
                Object r = x - offsetX < 0 || y - offsetY < 0 ? null : this.recipe[y - offsetY][x - offsetX];
                if (r == null ^ stack == null) return false;
                if (stack == null) continue;
                if (r instanceof ItemStack) {
                    if (!GT_Utility.areStacksEqual((ItemStack) r, stack, true)) return false;
                } else if (r instanceof HashSet) {
                    ItemStack copy = stack.copy();
                    copy.stackTagCompound = null;
                    // noinspection unchecked
                    if (!((HashSet<GT_Utility.ItemId>) r).contains(GT_Utility.ItemId.createNoCopy(copy))) {
                        Items.feather.setDamage(copy, wildcard);
                        // noinspection unchecked
                        if (!((HashSet<GT_Utility.ItemId>) r).contains(GT_Utility.ItemId.createNoCopy(copy)))
                            return false;
                    }
                } else if (r instanceof CustomItem) {
                    if (!((CustomItem) r).matches(stack)) return false;
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
