package com.dreammaster.auxiliary;

import net.minecraft.item.ItemStack;

import com.dreammaster.main.MainRegistry;
import com.ruling_0.materiallib.api.StackResolver;

import cpw.mods.fml.common.registry.GameRegistry;

/// Rewrites the `ml:<Material>:<shapeToken>` form the XML item configs accept into the `modid:item[:meta]` form their
/// lookups compare against. A config entry names the material and shape because MaterialLib item metadata is a
/// material index that shifts whenever the material set changes.
///
/// Resolution reads MaterialLib's resolved registries, so it runs no earlier than the config modules' postInit load.
public final class MaterialLibNames {

    private static final String PREFIX = "ml:";

    private MaterialLibNames() {}

    /// Whether `itemName` is written in the `ml:<Material>:<shapeToken>` form.
    public static boolean isMaterialLibName(String itemName) {
        return itemName != null && itemName.startsWith(PREFIX);
    }

    /// The `modid:item[:meta]` name of the stack an `ml:` entry names, matching the form
    /// [eu.usrv.yamcore.auxiliary.ItemDescriptor#toString] produces. Returns `itemName` unchanged when it is not an
    /// `ml:` entry, and null when the entry is malformed or names nothing MaterialLib serves.
    public static String canonicalize(String itemName) {
        if (!isMaterialLibName(itemName)) {
            return itemName;
        }

        String[] tParts = itemName.split(":");
        if (tParts.length != 3) {
            MainRegistry.LOGGER.error("MaterialLib entry [{}] is not of the form ml:<Material>:<Shape>", itemName);
            return null;
        }

        ItemStack tStack = StackResolver.getStack(tParts[1], tParts[2], 1);
        if (tStack == null) {
            return null;
        }

        GameRegistry.UniqueIdentifier tUID = GameRegistry.findUniqueIdentifierFor(tStack.getItem());
        if (tUID == null) {
            MainRegistry.LOGGER.error("MaterialLib entry [{}] resolved to an unregistered item", itemName);
            return null;
        }

        if (tStack.getItemDamage() > 0) {
            return String.format("%s:%d", tUID.toString(), tStack.getItemDamage());
        }
        return tUID.toString();
    }
}
