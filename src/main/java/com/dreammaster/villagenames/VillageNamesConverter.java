package com.dreammaster.villagenames;

import net.minecraft.block.Block;

import com.gtnewhorizons.postea.api.BlockReplacementManager;
import com.gtnewhorizons.postea.api.IDExtenderCompat;
import com.gtnewhorizons.postea.api.ItemStackReplacementManager;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Postea migration for GT-New-Horizons-Modpack issue #24317.
 *
 * VillageNames registers its own concrete, concrete powder and glazed terracotta, duplicating the Et Futurum Requiem
 * versions of the same blocks. The VillageNames versions are going away (they are no longer registered when Et Futurum
 * Requiem is present), so every VillageNames block already placed in a world and every VillageNames item stack in an
 * inventory is converted to the matching Et Futurum Requiem block here.
 *
 * Concrete and concrete powder are one block per mod and their meta is the color (0-15) on both sides, so a simple meta
 * preserving replacement is enough for them.
 *
 * Glazed terracotta is split differently: VillageNames uses 4 blocks, where the group of 4 colors is decided by which
 * of the blocks it is, the rest of the color is meta % 4 and the orientation is meta / 4. Et Futurum Requiem uses one
 * block per color, whose meta is only the orientation. Converting it therefore needs the meta to be taken apart, which
 * is what the transformation handlers below do. Item stacks are simpler, their damage is always the full color, as seen
 * in VillageNames' ItemBlockGlazedTerracotta.
 */
public class VillageNamesConverter {

    public static final String VILLAGE_NAMES_MOD_ID = "VillageNames";
    public static final String ET_FUTURUM_MOD_ID = "etfuturum";

    // Color names in meta order, index 8 is called "silver" by VillageNames and "light_gray" by Et Futurum Requiem,
    // every other index uses the same name in both mods.
    private static final String[] COLOR_NAMES = { "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink",
            "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black" };

    private static final String[] GLAZED_TERRACOTTA_NAMES = { "glazedTerracotta", "glazedTerracotta2",
            "glazedTerracotta3", "glazedTerracotta4" };

    private static final int[] glazedTerracottaBlockIds = new int[16];
    private static final int[] glazedTerracottaItemIds = new int[16];

    static {
        for (int i = 0; i < 16; i++) {
            glazedTerracottaBlockIds[i] = -1;
            glazedTerracottaItemIds[i] = -1;
        }
    }

    public static void doPostInitialization() {
        replaceConcrete();
        replaceConcretePowder();
        replaceGlazedTerracotta();
    }

    private static void replaceConcrete() {
        BlockReplacementManager.ignoreMissingMapping(VILLAGE_NAMES_MOD_ID + ":concrete");
        ItemStackReplacementManager.ignoreMissingMapping(VILLAGE_NAMES_MOD_ID + ":concrete");

        Block concrete = GameRegistry.findBlock(ET_FUTURUM_MOD_ID, "concrete");
        if (concrete != null) {
            // Also registers the matching item stack replacement, meta (the color) is preserved by both.
            BlockReplacementManager.addSimpleReplacement(VILLAGE_NAMES_MOD_ID + ":concrete", concrete);
        }
    }

    private static void replaceConcretePowder() {
        BlockReplacementManager.ignoreMissingMapping(VILLAGE_NAMES_MOD_ID + ":concretePowder");
        ItemStackReplacementManager.ignoreMissingMapping(VILLAGE_NAMES_MOD_ID + ":concretePowder");

        Block concretePowder = GameRegistry.findBlock(ET_FUTURUM_MOD_ID, "concrete_powder");
        if (concretePowder != null) {
            // Also registers the matching item stack replacement, meta (the color) is preserved by both.
            BlockReplacementManager.addSimpleReplacement(VILLAGE_NAMES_MOD_ID + ":concretePowder", concretePowder);
        }
    }

    private static void replaceGlazedTerracotta() {
        for (int color = 0; color < 16; color++) {
            final int targetColor = color;
            String targetName = ET_FUTURUM_MOD_ID + ":" + COLOR_NAMES[color] + "_glazed_terracotta";
            BlockReplacementManager.registerIDResolver(targetName, i -> glazedTerracottaBlockIds[targetColor] = i);
            ItemStackReplacementManager.registerIDResolver(targetName, i -> glazedTerracottaItemIds[targetColor] = i);
        }

        for (int group = 0; group < GLAZED_TERRACOTTA_NAMES.length; group++) {
            final int colorOffset = group * 4;
            String originalName = VILLAGE_NAMES_MOD_ID + ":" + GLAZED_TERRACOTTA_NAMES[group];

            BlockReplacementManager.ignoreMissingMapping(originalName);
            ItemStackReplacementManager.ignoreMissingMapping(originalName);

            BlockReplacementManager.addTransformationHandler(originalName, info -> {
                int color = colorOffset + info.metadata % 4;
                if (glazedTerracottaBlockIds[color] == -1) return false;
                info.blockID = glazedTerracottaBlockIds[color];
                info.metadata = info.metadata / 4;
                return true;
            });

            ItemStackReplacementManager.addTransformationHandler(originalName, (name, nbt) -> {
                int color = colorOffset + nbt.getShort("Damage") % 4;
                if (glazedTerracottaItemIds[color] == -1) return false;
                IDExtenderCompat.setItemStackID(nbt, glazedTerracottaItemIds[color]);
                nbt.setShort("Damage", (short) 0);
                return true;
            });
        }
    }
}
