package com.dreammaster.TwilightForest;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.Thaumcraft;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import twilightforest.TFTreasure;

public class TF_Loot_Chests {

    public static void init() {

        // Hill1 = small
        TFTreasure.hill1.common.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 2L), 24);
        TFTreasure.hill1.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4L), 432);
        TFTreasure.hill1.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Nickel, 4L), 432);
        TFTreasure.hill1.common.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 2L), 54);
        TFTreasure.hill1.uncommon.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Manganese, 4L), 432);
        TFTreasure.hill1.uncommon.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Antimony, 4L), 432);
        TFTreasure.hill1.rare.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L), 216);
        TFTreasure.hill1.ultrarare.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 4L), 108);
        // Hill2 = medium
        TFTreasure.hill2.common.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 4L), 108);
        TFTreasure.hill2.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Manganese, 4L), 432);
        TFTreasure.hill2.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Antimony, 4L), 432);
        TFTreasure.hill2.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4L), 432);
        TFTreasure.hill2.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Nickel, 4L), 432);
        TFTreasure.hill2.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 6L), 432);
        TFTreasure.hill2.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Electrum, 2L), 216);
        TFTreasure.hill2.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 6L), 432);
        TFTreasure.hill2.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Magnesium, 4L), 432);
        TFTreasure.hill2.uncommon.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 4L), 108);
        TFTreasure.hill2.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 0), 432);
        TFTreasure.hill2.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 1), 432);
        TFTreasure.hill2.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 2), 432);
        TFTreasure.hill2.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 3), 432);
        TFTreasure.hill2.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 4), 432);
        TFTreasure.hill2.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 5), 432);
        TFTreasure.hill2.uncommon.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.DamascusSteel, 4L), 432);
        TFTreasure.hill2.uncommon.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 4L), 432);
        TFTreasure.hill2.uncommon.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 4L), 432);
        TFTreasure.hill2.uncommon.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Molybdenum, 4L), 432);
        TFTreasure.hill2.uncommon.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.RedAlloy, 4L), 432);
        TFTreasure.hill2.uncommon.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.CastIron, 4L), 432);
        TFTreasure.hill2.uncommon.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L), 432);
        TFTreasure.hill2.rare.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L), 432);
        TFTreasure.hill2.rare.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 16L), 432);
        TFTreasure.hill2.rare.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L), 432);
        TFTreasure.hill2.ultrarare.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Gallium, 1L), 216);
        TFTreasure.hill2.ultrarare.add(getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0), 36);
        // Hill3 = huge
        TFTreasure.hill3.common.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 6L), 48);
        TFTreasure.hill3.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Manganese, 6L), 432);
        TFTreasure.hill3.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Antimony, 6L), 432);
        TFTreasure.hill3.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 6L), 432);
        TFTreasure.hill3.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Electrum, 2L), 432);
        TFTreasure.hill3.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 6L), 432);
        TFTreasure.hill3.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Magnesium, 4L), 432);
        TFTreasure.hill3.uncommon.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 6L), 108);
        TFTreasure.hill3.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 0), 432);
        TFTreasure.hill3.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 1), 432);
        TFTreasure.hill3.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 2), 432);
        TFTreasure.hill3.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 3), 432);
        TFTreasure.hill3.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 4), 432);
        TFTreasure.hill3.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 5), 432);
        TFTreasure.hill3.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 2, 6), 432);
        TFTreasure.hill3.uncommon.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.DamascusSteel, 4L), 432);
        TFTreasure.hill3.uncommon.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 4L), 432);
        TFTreasure.hill3.uncommon.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 4L), 432);
        TFTreasure.hill3.uncommon.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Molybdenum, 4L), 432);
        TFTreasure.hill3.uncommon.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.RedAlloy, 4L), 432);
        TFTreasure.hill3.uncommon.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.CastIron, 4L), 432);
        TFTreasure.hill3.uncommon.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L), 432);
        TFTreasure.hill3.rare.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L), 432);
        TFTreasure.hill3.rare.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L), 432);
        TFTreasure.hill3.rare.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1L), 432);
        TFTreasure.hill3.rare.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 16L), 432);
        TFTreasure.hill3.rare.add(getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0), 72);
        TFTreasure.hill3.ultrarare.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Gallium, 1L), 216);

        // UrGhast Tower Basment
        TFTreasure.basement.common.add(new ItemStack(Blocks.torch, 16, 0), 72);
        TFTreasure.basement.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 16L), 432);
        TFTreasure.basement.common.add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Void, 8L), 216);
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8198), 432); // potion night vision i
        TFTreasure.basement.uncommon.add(getModItem(Thaumcraft.ID, "ItemResource", 8, 1), 432); // Nitor
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8193), 216); // potion regen i
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8197), 216); // potion health i
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8194), 216); // potion swiftness i
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8195), 216); // potion fire resistance i
        TFTreasure.basement.uncommon.add(getModItem(Thaumcraft.ID, "ItemResource", 8, 0), 432); // Alumentum
        TFTreasure.basement.uncommon.add(getModItem(Thaumcraft.ID, "ItemResource", 16, 14), 216); // Salis
                                                                                                // Mundus
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8257), 216); // potion regen ii
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8229), 216); // potion health ii
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8258), 216); // potion extended swiftness ii
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8259), 216); // potion fire resistance iI

        // Litch Tower Library
        TFTreasure.tower_library.common.add(new ItemStack(Blocks.torch, 16, 0), 216);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 0), 432);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 1), 432);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 2), 432);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 3), 432);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 4), 432);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 5), 432);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 6), 432);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 7), 432);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 8), 432);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 9), 432);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 10), 432);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 11), 432);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 12), 432);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 13), 432);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 14), 432);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 15), 432);
        TFTreasure.tower_library.common.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 4L), 216);
        TFTreasure.tower_library.common.add(GTOreDictUnificator.get(OrePrefixes.gem, Materials.EnderPearl, 8L), 216);
        TFTreasure.tower_library.common
                .add(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 2L), 216);
        TFTreasure.tower_library.common.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Void, 2L), 216);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "ItemResource", 2, 1), 432); // Nitor
        TFTreasure.tower_library.common.add(new ItemStack(Items.potionitem, 1, 8201), 216); // potion strength i
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "ItemResource", 1, 0), 432); // Alumentum
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "ItemResource", 4, 14), 216); // Salis
                                                                                                  // Mundus
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8198), 216); // potion night vision i
        TFTreasure.tower_library.uncommon.add(getModItem(Thaumcraft.ID, "ItemResource", 2, 1), 288); // Nitor
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8193), 216); // potion regen i
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8197), 216); // potion health i
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8194), 216); // potion swiftness i
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8195), 216); // potion fire resistance i
        TFTreasure.tower_library.uncommon.add(getModItem(Thaumcraft.ID, "ItemResource", 1, 0), 288); // Alumentum
        TFTreasure.tower_library.uncommon.add(getModItem(Thaumcraft.ID, "ItemResource", 4, 14), 216); // Salis
                                                                                                    // Mundus
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8233), 216); // potion strength ii
        TFTreasure.tower_library.uncommon.add(getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0), 36);
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8257), 216); // potion regen ii
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8229), 216); // potion health ii
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8258), 216); // potion extended swiftness ii
        TFTreasure.tower_library.rare.add(getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0), 72);
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8259), 216); // potion fire resistance iI

        // Litch Tower Boss Room
        TFTreasure.tower_room.common.add(getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0), 108);
        TFTreasure.tower_room.common.add(getModItem(Thaumcraft.ID, "ItemLootBag", 1, 0), 432);
        // TFTreasure.tower_room.common.add(NHItemList.LichBone.get(2),50);
        // TFTreasure.tower_room.common.add(NHItemList.LichBoneChip.get(8),75);
        TFTreasure.tower_room.uncommon.add(getModItem(Thaumcraft.ID, "ItemLootBag", 1, 1), 432);
        TFTreasure.tower_room.uncommon.add(GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 1L), 8);
        TFTreasure.tower_room.rare.add(getModItem(Thaumcraft.ID, "ItemLootBag", 1, 2), 216);
    }
}
