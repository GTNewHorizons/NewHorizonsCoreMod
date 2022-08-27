package com.dreammaster.TwilightForest;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import twilightforest.TFTreasure;

public class TF_Loot_Chests {

    public static void init() {
        // System.out.println("I'm in your loot, adding new things to TF");

        // Hill1 = small
        TFTreasure.hill1.common.add(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Thaumium, 2L), 6);
        TFTreasure.hill1.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4L), 12);
        TFTreasure.hill1.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nickel, 4L), 12);
        TFTreasure.hill1.common.add(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thaumium, 2L), 6);
        TFTreasure.hill1.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Manganese, 4L), 12);
        TFTreasure.hill1.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Antimony, 4L), 12);
        TFTreasure.hill1.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L), 6);
        TFTreasure.hill1.ultrarare.add(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Aluminium, 4L), 12);
        // Hill2 = medium
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Thaumium, 4L), 12);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Manganese, 4L), 12);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Antimony, 4L), 12);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4L), 12);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nickel, 4L), 12);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 6L), 12);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Electrum, 2L), 6);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 6L), 12);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Magnesium, 4L), 12);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thaumium, 4L), 12);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 0), 12);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 1), 12);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 2), 12);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 3), 12);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 4), 12);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 5), 12);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DamascusSteel, 4L), 12);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 4L), 12);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 4L), 12);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Molybdenum, 4L), 12);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedAlloy, 4L), 12);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 4L), 12);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L), 12);
        TFTreasure.hill2.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L), 12);
        TFTreasure.hill2.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 16L), 12);
        TFTreasure.hill2.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L), 12);
        TFTreasure.hill2.ultrarare.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Gallium, 1L), 6);
        TFTreasure.hill2.ultrarare.add(GT_ModHandler.getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0), 1);
        // Hill3 = huge
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Thaumium, 6L), 12);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Manganese, 6L), 12);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Antimony, 6L), 12);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 6L), 12);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Electrum, 2L), 12);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 6L), 12);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Magnesium, 4L), 12);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thaumium, 6L), 12);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 0), 12);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 1), 12);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 2), 12);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 3), 12);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 4), 12);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 5), 12);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 2, 6), 12);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DamascusSteel, 4L), 12);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 4L), 12);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 4L), 12);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Molybdenum, 4L), 12);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedAlloy, 4L), 12);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 4L), 12);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L), 12);
        TFTreasure.hill3.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L), 12);
        TFTreasure.hill3.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L), 12);
        TFTreasure.hill3.rare.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1L), 12);
        TFTreasure.hill3.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 16L), 12);
        TFTreasure.hill3.rare.add(GT_ModHandler.getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0), 2);
        TFTreasure.hill3.ultrarare.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Gallium, 1L), 6);

        // UrGhast Tower Basment
        TFTreasure.basement.common.add(new ItemStack(Blocks.torch, 16, 0), 2);
        TFTreasure.basement.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 16L), 12);
        TFTreasure.basement.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Void, 8L), 6);
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8198), 12); // potion night vision i
        TFTreasure.basement.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 8, 1), 12); // Nitor
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8193), 6); // potion regen i
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8197), 6); // potion health i
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8194), 6); // potion swiftness i
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8195), 6); // potion fire resistance i
        TFTreasure.basement.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 8, 0), 12); // Alumentum
        TFTreasure.basement.uncommon.add(
                GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 16, 14), 6); // Salis Mundus
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8257), 6); // potion regen ii
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8229), 6); // potion health ii
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8258), 6); // potion extended swiftness ii
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8259), 6); // potion fire resistance iI

        // Litch Tower Library
        TFTreasure.tower_library.common.add(new ItemStack(Blocks.torch, 16, 0), 6);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 0), 12);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 1), 12);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 2), 12);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 3), 12);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 4), 12);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 5), 12);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 6), 12);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 7), 12);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 8), 12);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 9), 12);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 10), 12);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 11), 12);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 12), 12);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 13), 12);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 14), 12);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 15), 12);
        TFTreasure.tower_library.common.add(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 4L), 12);
        TFTreasure.tower_library.common.add(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 4L), 12);
        TFTreasure.tower_library.common.add(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderPearl, 8L), 12);
        TFTreasure.tower_library.common.add(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 2L), 12);
        TFTreasure.tower_library.common.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Void, 2L), 6);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 2, 1), 12); // Nitor
        TFTreasure.tower_library.common.add(new ItemStack(Items.potionitem, 1, 8201), 12); // potion strength i
        TFTreasure.tower_library.common.add(
                GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 1, 0), 12); // Alumentum
        TFTreasure.tower_library.common.add(
                GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 4, 14), 6); // Salis Mundus
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8198), 12); // potion night vision i
        TFTreasure.tower_library.uncommon.add(
                GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 2, 1), 12); // Nitor
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8193), 6); // potion regen i
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8197), 6); // potion health i
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8194), 6); // potion swiftness i
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8195), 6); // potion fire resistance i
        TFTreasure.tower_library.uncommon.add(
                GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 1, 0), 12); // Alumentum
        TFTreasure.tower_library.uncommon.add(
                GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 4, 14), 6); // Salis Mundus
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8233), 12); // potion strength ii
        TFTreasure.tower_library.uncommon.add(
                GT_ModHandler.getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0), 1);
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8257), 6); // potion regen ii
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8229), 6); // potion health ii
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8258), 6); // potion extended swiftness ii
        TFTreasure.tower_library.rare.add(GT_ModHandler.getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0), 2);
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8259), 6); // potion fire resistance iI

        // Litch Tower Boss Room
        TFTreasure.tower_room.common.add(GT_ModHandler.getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0), 3);
        TFTreasure.tower_room.common.add(GT_ModHandler.getModItem("Thaumcraft", "ItemLootBag", 1, 0), 12);
        // TFTreasure.tower_room.common.add(CustomItemList.LichBone.get(2),50);
        // TFTreasure.tower_room.common.add(CustomItemList.LichBoneChip.get(8),75);
        TFTreasure.tower_room.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemLootBag", 1, 1), 12);
        TFTreasure.tower_room.uncommon.add(
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.NetherStar, 4L), 12);
        TFTreasure.tower_room.rare.add(GT_ModHandler.getModItem("Thaumcraft", "ItemLootBag", 1, 2), 6);
    }
}
