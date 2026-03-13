package com.dreammaster.scripts;

import com.dreammaster.coremod.DreamCoreMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import org.jetbrains.annotations.NotNull;

public final class IngredientFactory {

    private static final boolean DEBUG = !DreamCoreMod.isObf();

    private static @NotNull ItemStack invalidItem(String modId, String item) {
        if (DEBUG) {
            final var fire = new ItemStack(Blocks.fire);
            fire.setStackDisplayName(EnumChatFormatting.RED + "Missing Item: " + modId + ":" + item);
            return fire;
        } else {
            throw new RuntimeException("Could not find ItemStack: " + modId + ":" + item);
        }
    }

    public static @NotNull ItemStack getModItem(String modId, String item) {
        final var stack = GameRegistry.findItemStack(modId, item, 1);
        if (stack == null) return invalidItem(modId, item);

        return stack;
    }

    public static @NotNull ItemStack getModItem(String modId, String item, int amount) {
        final var stack = GameRegistry.findItemStack(modId, item, amount);
        if (stack == null) return invalidItem(modId, item);
        
        return stack;
    }

    public static @NotNull ItemStack getModItem(String modId, String item, int amount, int meta) {
        final var stack = GameRegistry.findItemStack(modId, item, amount);
        if (stack == null) return invalidItem(modId, item);
        
        Items.feather.setDamage(stack, meta);
        return stack;
    }

    private IngredientFactory() {}

    /**
     * Helper function to get a new ItemStack with specified damage (meta) value and NBT tags.
     *
     * @param modId       Mod ID of an the item
     * @param item        Item registry name
     * @param amount      Amount to get
     * @param meta        the meta id of the item to look at.
     * @param nbt   NBT data that the created stack should get, in format that {@link NBTTagCompound#toString()}
     *                     returns. Can be checked in-game with `/iih` command
     * @return Created ItemStack or replacement stack
     * @throws RuntimeException if the NBT string parsing fails
     */
    public static @NotNull ItemStack createItemStack(String modId, String item, int amount, int meta, String nbt) {
        ItemStack s = GameRegistry.findItemStack(modId, item, amount);
        if (s == null) return invalidItem(modId, item);

        Items.feather.setDamage(s, meta);
        try {
            s.stackTagCompound = (NBTTagCompound) JsonToNBT.func_150315_a(nbt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return s;
    }
}
