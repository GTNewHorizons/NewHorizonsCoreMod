package com.dreammaster.scripts;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;

import org.jetbrains.annotations.NotNull;

import cpw.mods.fml.common.registry.GameRegistry;

public final class IngredientFactory {

    private static final boolean DEBUG = Boolean.parseBoolean(System.getProperty("dreamcraft.debug.recipe"));

    /**
     * Handle what happens when an item cannot be found in the runtime environment.
     *
     * @param modId Mod ID of the mod the item is from
     * @param name  Item registry name
     * @return An ItemStack of `minecraft:fire` with a custom name containing the ID of the missing item. (if debug mode
     *         is enabled.)
     * @throws RuntimeException If debug mode is disabled.
     */
    private static @NotNull ItemStack invalidItem(String modId, String name) {
        if (DEBUG) {
            final var fire = new ItemStack(Blocks.fire);
            fire.setStackDisplayName(EnumChatFormatting.RED + "Missing Item: " + modId + ":" + name);
            return fire;
        } else {
            throw new RuntimeException("Could not find ItemStack: " + modId + ":" + name);
        }
    }

    /**
     * Helper function to get a new ItemStack from another mod with a stack size of 1.
     *
     * @param modId Mod ID of the mod the item is from
     * @param name  Item registry name
     * @return Created ItemStack or a placeholder fire ItemStack if lookup fails & debug mode is enabled.
     * @throws RuntimeException If the item cannot be found and debug mode is disabled.
     */
    public static @NotNull ItemStack getModItem(String modId, String name) {
        final var item = GameRegistry.findItem(modId, name);
        if (item == null) return invalidItem(modId, name);

        return new ItemStack(item);
    }

    /**
     * Helper function to get a new ItemStack from another mod with a specific stack size.
     *
     * @param modId  Mod ID of the mod the item is from
     * @param name   Item registry name
     * @param amount The amount of items in the ItemStack
     * @return Created ItemStack or a placeholder fire ItemStack if lookup fails & debug mode is enabled.
     * @throws RuntimeException If the item is cannot be found and debug mode is disabled.
     */
    public static @NotNull ItemStack getModItem(String modId, String name, int amount) {
        final var item = GameRegistry.findItem(modId, name);
        if (item == null) return invalidItem(modId, name);

        return new ItemStack(item, amount);
    }

    /**
     * Helper function to get a new ItemStack from another mod with a specific stack size and damage value.
     *
     * @param modId  Mod ID of the mod the item is from
     * @param name   Item registry name
     * @param amount The amount of items in the ItemStack
     * @param meta   The meta (damage value) of the items in the ItemStack
     * @return Created ItemStack or a placeholder fire ItemStack if lookup fails & debug mode is enabled.
     * @throws RuntimeException If the item cannot be found and debug mode is disabled.
     */
    public static @NotNull ItemStack getModItem(String modId, String name, int amount, int meta) {
        final var item = GameRegistry.findItem(modId, name);
        if (item == null) return invalidItem(modId, name);

        return new ItemStack(item, amount, meta);
    }

    /**
     * Helper function to get a new ItemStack with specified damage (meta) value and NBT tags.
     *
     * @param modId  Mod ID of the mod the item is from
     * @param name   Item registry name
     * @param amount The amount of items in the ItemStack
     * @param meta   The meta (damage value) of the items in the ItemStack
     * @param nbt    NBT data that the created stack should get, in format that {@link NBTTagCompound#toString()}
     *               returns. Can be checked in-game with `/iih` command
     * @return Created ItemStack or a placeholder fire ItemStack if lookup fails & debug mode is enabled.
     * @throws RuntimeException If the item is cannot be found and debug mode is disabled, or if the NBT string parsing
     *                          fails.
     */
    public static @NotNull ItemStack createItemStack(String modId, String name, int amount, int meta, String nbt) {
        final var item = GameRegistry.findItem(modId, name);
        if (item == null) return invalidItem(modId, name);

        final var stack = new ItemStack(item, amount, meta);
        try {
            stack.setTagCompound((NBTTagCompound) JsonToNBT.func_150315_a(nbt));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return stack;
    }

    private IngredientFactory() {}
}
