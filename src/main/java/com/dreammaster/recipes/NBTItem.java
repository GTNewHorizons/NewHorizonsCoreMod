package com.dreammaster.recipes;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;

import gregtech.api.util.GT_Utility;

public class NBTItem {

    private ItemStack stack;
    private NBTTagCompound nbt;
    private boolean exact = false;

    public NBTItem() {}

    public NBTItem(ItemStack stack) {
        item(stack);
    }

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
            if (!stack.stackTagCompound.getTag(key).equals(v)) return false;
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

    public ItemStack getStack() {
        ItemStack stack = this.stack.copy();
        if (nbt != null && !nbt.hasNoTags()) stack.stackTagCompound = (NBTTagCompound) nbt.copy();
        return stack;
    }
}
