package com.dreammaster.recipes;

import java.util.HashMap;
import java.util.Set;
import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import gregtech.api.util.GT_Utility;

/**
 * Custom item matcher interface. For use in {@link ShapedUniversalRecipe} / {@link ShapelessUniversalRecipe}
 *
 * @author kuba6000
 */
public interface CustomItem {

    boolean matches(ItemStack stack);

    ItemStack getStack();

    static CustomItem createCustomItem(final Function<ItemStack, Boolean> matcher, final ItemStack stack) {
        return new CustomItem() {

            @Override
            public boolean matches(ItemStack stack) {
                return matcher.apply(stack);
            }

            @Override
            public ItemStack getStack() {
                return stack;
            }
        };
    }

    /**
     * Item with specified NBT tags.
     *
     * @author kuba6000
     */
    class NBTItem implements CustomItem {

        private ItemStack stack;
        private NBTTagCompound nbt;
        private boolean exact = false;

        private boolean noValues = false;

        public NBTItem() {}

        public NBTItem(ItemStack stack) {
            item(stack);
        }

        @Override
        public boolean matches(ItemStack stack) {
            if (!GT_Utility.areStacksEqual(this.stack, stack, true)) return false;
            if (nbt == null && stack.stackTagCompound != null) return !exact;
            if (nbt == null) return true;
            if (exact) return nbt.equals(stack.stackTagCompound);
            if (nbt.hasNoTags()) return true;
            if (stack.stackTagCompound == null) return false;
            // noinspection unchecked
            for (String key : (Set<String>) nbt.func_150296_c()) {
                NBTBase v = nbt.getTag(key);
                if (!stack.stackTagCompound.hasKey(key, v.getId())) return false;
                if ((!noValues) && (!stack.stackTagCompound.getTag(key).equals(v))) return false;
            }
            return true;
        }

        public NBTItem item(ItemStack stack) {
            this.stack = stack;
            if (this.stack.stackTagCompound != null) {
                this.nbt = this.stack.stackTagCompound;
                this.stack.stackTagCompound = null;
            }
            return this;
        }

        public NBTItem item(Item item) {
            this.stack = new ItemStack(item);
            return this;
        }

        public NBTItem item(Block block) {
            this.stack = new ItemStack(block);
            return this;
        }

        public NBTItem setNBT(NBTTagCompound nbt) {
            this.nbt = nbt;
            return this;
        }

        public NBTItem setNBT(String nbt) {
            try {
                this.nbt = (NBTTagCompound) JsonToNBT.func_150315_a(nbt);
            } catch (NBTException e) {
                throw new RuntimeException(e);
            }
            return this;
        }

        public NBTItem addNBT(String tagName, NBTBase nbt) {
            if (this.nbt == null) this.nbt = new NBTTagCompound();
            this.nbt.setTag(tagName, nbt);
            return this;
        }

        public NBTItem matchExact() {
            exact = true;
            return this;
        }

        public NBTItem noValues() {
            noValues = true;
            return this;
        }

        @Override
        public ItemStack getStack() {
            ItemStack stack = this.stack.copy();
            if (nbt != null && !nbt.hasNoTags()) stack.stackTagCompound = (NBTTagCompound) nbt.copy();
            return stack;
        }
    }

    /**
     * Enchanted book with specified enchantments.
     *
     * @author kuba6000
     */
    class EnchantedBookMatcher implements CustomItem {

        final ItemStack book;
        final HashMap<Short, Short> enchantments;

        public EnchantedBookMatcher() {
            book = new ItemStack(Items.enchanted_book);
            enchantments = new HashMap<>();
        }

        public EnchantedBookMatcher addEnchantment(EnchantmentData enchantment) {
            short id = (short) enchantment.enchantmentobj.effectId;
            if (enchantments.get(id) != null && enchantments.get(id) >= enchantment.enchantmentLevel) return this;
            Items.enchanted_book.addEnchantment(book, enchantment);
            enchantments.put(id, (short) enchantment.enchantmentLevel);

            return this;
        }

        public EnchantedBookMatcher addEnchantment(Enchantment enchantment, int lvl) {
            return addEnchantment(new EnchantmentData(enchantment, lvl));
        }

        public EnchantedBookMatcher addEnchantment(int enchantment, int lvl) {
            return addEnchantment(new EnchantmentData(enchantment, lvl));
        }

        @Override
        public boolean matches(ItemStack stack) {
            if (stack == null) return false;
            if (!(stack.getItem() instanceof ItemEnchantedBook)) return false;

            @SuppressWarnings("unchecked")
            HashMap<Short, Short> toFind = (HashMap<Short, Short>) enchantments.clone();

            NBTTagList stackEnchantments = Items.enchanted_book.func_92110_g(stack);

            for (int i = 0; i < stackEnchantments.tagCount(); ++i) {

                NBTTagCompound tag = stackEnchantments.getCompoundTagAt(i);
                short id = tag.getShort("id");
                short lvl = tag.getShort("lvl");

                Short found = toFind.get(id);
                if (found != null && lvl >= found) toFind.remove(id);

            }

            return toFind.isEmpty();
        }

        @Override
        public ItemStack getStack() {
            return book;
        }
    }
}
