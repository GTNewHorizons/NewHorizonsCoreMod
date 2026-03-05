package com.dreammaster.travellersgear;

import static com.gtnewhorizons.postea.utility.PosteaUtilities.cleanseNBT;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import com.gtnewhorizons.postea.api.TileEntityReplacementManager;
import com.gtnewhorizons.postea.utility.BlockInfo;

import cpw.mods.fml.common.registry.GameRegistry;

public class TGConverter {

    public static void doPostInitialization() {
        TileEntityReplacementManager.tileEntityTransformer(
                "TravellersGear.ArmorStand",
                (tag, world, chunk) -> new BlockInfo(Blocks.chest, 0, TGConverter::chestTransformer));
    }

    private static NBTTagCompound chestTransformer(NBTTagCompound oldTag) {
        NBTTagList items = oldTag.getTagList("Inv", 10);

        // These armor stands had recipes to swap between them before. Seems fair to give this one.
        Item stand = GameRegistry.findItem("BiblioCraft", "Armor Stand");
        if (stand != null) {
            NBTTagCompound replacementStand = new NBTTagCompound();
            replacementStand.setByte("Count", (byte) 1);
            replacementStand.setByte("Slot", (byte) 26);
            replacementStand.setShort("Damage", (short) 0);
            replacementStand.setShort("id", (short) Item.getIdFromItem(stand));
            items.appendTag(replacementStand);
        }

        NBTTagCompound newTag = cleanseNBT("Chest", oldTag);

        newTag.setTag("Items", items);

        return newTag;
    }
}
