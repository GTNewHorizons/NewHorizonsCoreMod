package com.dreammaster.TwilightForest;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.Thaumcraft;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.util.GTOreDictUnificator;
import twilightforest.TFTreasure;

public class TF_Loot_Chests {

    public static void init() {

        // Hill1 = small
        TFTreasure.hill1.common.add(MaterialLibAPI.getStack(Materials.Thaumium, Shapes.dustTiny, 2), 6);
        TFTreasure.hill1.common.add(MaterialLibAPI.getStack(Materials.Bronze, Shapes.ingot, 4), 12);
        TFTreasure.hill1.common.add(MaterialLibAPI.getStack(Materials.Nickel, Shapes.ingot, 4), 12);
        TFTreasure.hill1.common.add(MaterialLibAPI.getStack(Materials.Thaumium, Shapes.dustSmall, 2), 6);
        TFTreasure.hill1.uncommon.add(MaterialLibAPI.getStack(Materials.Manganese, Shapes.ingot, 4), 12);
        TFTreasure.hill1.uncommon.add(MaterialLibAPI.getStack(Materials.Antimony, Shapes.ingot, 4), 12);
        TFTreasure.hill1.rare.add(MaterialLibAPI.getStack(Materials.Thaumium, Shapes.dust, 1), 6);
        TFTreasure.hill1.ultrarare.add(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dustSmall, 4), 12);
        // Hill2 = medium
        TFTreasure.hill2.common.add(MaterialLibAPI.getStack(Materials.Thaumium, Shapes.dustTiny, 4), 12);
        TFTreasure.hill2.common.add(MaterialLibAPI.getStack(Materials.Manganese, Shapes.ingot, 4), 12);
        TFTreasure.hill2.common.add(MaterialLibAPI.getStack(Materials.Antimony, Shapes.ingot, 4), 12);
        TFTreasure.hill2.common.add(MaterialLibAPI.getStack(Materials.Bronze, Shapes.ingot, 4), 12);
        TFTreasure.hill2.common.add(MaterialLibAPI.getStack(Materials.Nickel, Shapes.ingot, 4), 12);
        TFTreasure.hill2.common.add(MaterialLibAPI.getStack(Materials.Tin, Shapes.ingot, 6), 12);
        TFTreasure.hill2.common.add(MaterialLibAPI.getStack(Materials.Electrum, Shapes.ingot, 2), 6);
        TFTreasure.hill2.common.add(MaterialLibAPI.getStack(Materials.Copper, Shapes.ingot, 6), 12);
        TFTreasure.hill2.common.add(MaterialLibAPI.getStack(Materials.Magnesium, Shapes.ingot, 4), 12);
        TFTreasure.hill2.uncommon.add(MaterialLibAPI.getStack(Materials.Thaumium, Shapes.dustSmall, 4), 12);
        TFTreasure.hill2.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 0), 12);
        TFTreasure.hill2.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 1), 12);
        TFTreasure.hill2.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 2), 12);
        TFTreasure.hill2.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 3), 12);
        TFTreasure.hill2.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 4), 12);
        TFTreasure.hill2.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 5), 12);
        TFTreasure.hill2.uncommon.add(MaterialLibAPI.getStack(Materials.DamascusSteel, Shapes.ingot, 4), 12);
        TFTreasure.hill2.uncommon.add(MaterialLibAPI.getStack(Materials.ElectricalSteel, Shapes.ingot, 4), 12);
        TFTreasure.hill2.uncommon.add(MaterialLibAPI.getStack(Materials.Cobalt, Shapes.ingot, 4), 12);
        TFTreasure.hill2.uncommon.add(MaterialLibAPI.getStack(Materials.Molybdenum, Shapes.ingot, 4), 12);
        TFTreasure.hill2.uncommon.add(MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.ingot, 4), 12);
        TFTreasure.hill2.uncommon.add(MaterialLibAPI.getStack(Materials.CastIron, Shapes.ingot, 4), 12);
        TFTreasure.hill2.uncommon.add(MaterialLibAPI.getStack(Materials.Steel, Shapes.ingot, 4), 12);
        TFTreasure.hill2.rare.add(MaterialLibAPI.getStack(Materials.Thaumium, Shapes.dust, 1), 12);
        TFTreasure.hill2.rare.add(MaterialLibAPI.getStack(Materials.Mica, Shapes.dust, 16), 12);
        TFTreasure.hill2.rare.add(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dust, 2), 12);
        TFTreasure.hill2.ultrarare.add(MaterialLibAPI.getStack(Materials.Gallium, Shapes.ingot, 1), 6);
        TFTreasure.hill2.ultrarare.add(getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0), 1);
        // Hill3 = huge
        TFTreasure.hill3.common.add(MaterialLibAPI.getStack(Materials.Thaumium, Shapes.dustTiny, 6), 12);
        TFTreasure.hill3.common.add(MaterialLibAPI.getStack(Materials.Manganese, Shapes.ingot, 6), 12);
        TFTreasure.hill3.common.add(MaterialLibAPI.getStack(Materials.Antimony, Shapes.ingot, 6), 12);
        TFTreasure.hill3.common.add(MaterialLibAPI.getStack(Materials.Tin, Shapes.ingot, 6), 12);
        TFTreasure.hill3.common.add(MaterialLibAPI.getStack(Materials.Electrum, Shapes.ingot, 2), 12);
        TFTreasure.hill3.common.add(MaterialLibAPI.getStack(Materials.Copper, Shapes.ingot, 6), 12);
        TFTreasure.hill3.common.add(MaterialLibAPI.getStack(Materials.Magnesium, Shapes.ingot, 4), 12);
        TFTreasure.hill3.uncommon.add(MaterialLibAPI.getStack(Materials.Thaumium, Shapes.dustSmall, 6), 12);
        TFTreasure.hill3.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 0), 12);
        TFTreasure.hill3.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 1), 12);
        TFTreasure.hill3.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 2), 12);
        TFTreasure.hill3.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 3), 12);
        TFTreasure.hill3.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 4), 12);
        TFTreasure.hill3.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 4, 5), 12);
        TFTreasure.hill3.uncommon.add(getModItem(Thaumcraft.ID, "ItemShard", 2, 6), 12);
        TFTreasure.hill3.uncommon.add(MaterialLibAPI.getStack(Materials.DamascusSteel, Shapes.ingot, 4), 12);
        TFTreasure.hill3.uncommon.add(MaterialLibAPI.getStack(Materials.ElectricalSteel, Shapes.ingot, 4), 12);
        TFTreasure.hill3.uncommon.add(MaterialLibAPI.getStack(Materials.Cobalt, Shapes.ingot, 4), 12);
        TFTreasure.hill3.uncommon.add(MaterialLibAPI.getStack(Materials.Molybdenum, Shapes.ingot, 4), 12);
        TFTreasure.hill3.uncommon.add(MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.ingot, 4), 12);
        TFTreasure.hill3.uncommon.add(MaterialLibAPI.getStack(Materials.CastIron, Shapes.ingot, 4), 12);
        TFTreasure.hill3.uncommon.add(MaterialLibAPI.getStack(Materials.Steel, Shapes.ingot, 4), 12);
        TFTreasure.hill3.rare.add(MaterialLibAPI.getStack(Materials.Thaumium, Shapes.dust, 1), 12);
        TFTreasure.hill3.rare.add(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dust, 2), 12);
        TFTreasure.hill3.rare.add(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.ingot, 1), 12);
        TFTreasure.hill3.rare.add(MaterialLibAPI.getStack(Materials.Mica, Shapes.dust, 16), 12);
        TFTreasure.hill3.rare.add(getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0), 2);
        TFTreasure.hill3.ultrarare.add(MaterialLibAPI.getStack(Materials.Gallium, Shapes.ingot, 1), 6);

        // UrGhast Tower Basment
        TFTreasure.basement.common.add(new ItemStack(Blocks.torch, 16, 0), 2);
        TFTreasure.basement.common.add(MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.ingot, 16), 12);
        TFTreasure.basement.common.add(MaterialLibAPI.getStack(Materials.Void, Shapes.ingot, 8), 6);
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8198), 12); // potion night vision i
        TFTreasure.basement.uncommon.add(getModItem(Thaumcraft.ID, "ItemResource", 8, 1), 12); // Nitor
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8193), 6); // potion regen i
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8197), 6); // potion health i
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8194), 6); // potion swiftness i
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8195), 6); // potion fire resistance i
        TFTreasure.basement.uncommon.add(getModItem(Thaumcraft.ID, "ItemResource", 8, 0), 12); // Alumentum
        TFTreasure.basement.uncommon.add(getModItem(Thaumcraft.ID, "ItemResource", 16, 14), 6); // Salis
                                                                                                // Mundus
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8257), 6); // potion regen ii
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8229), 6); // potion health ii
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8258), 6); // potion extended swiftness ii
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8259), 6); // potion fire resistance iI

        // Litch Tower Library
        TFTreasure.tower_library.common.add(new ItemStack(Blocks.torch, 16, 0), 6);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 0), 12);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 1), 12);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 2), 12);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 3), 12);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 4), 12);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 5), 12);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 6), 12);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 7), 12);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 8), 12);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 9), 12);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 10), 12);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 11), 12);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 12), 12);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 13), 12);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 14), 12);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "blockCandle", 4, 15), 12);
        TFTreasure.tower_library.common.add(MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.dust, 4), 6);
        TFTreasure.tower_library.common.add(GTOreDictUnificator.get(OrePrefixes.gem, Materials.EnderPearl, 8L), 6);
        TFTreasure.tower_library.common.add(MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.ingot, 2), 6);
        TFTreasure.tower_library.common.add(MaterialLibAPI.getStack(Materials.Void, Shapes.dust, 2), 6);
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "ItemResource", 2, 1), 12); // Nitor
        TFTreasure.tower_library.common.add(new ItemStack(Items.potionitem, 1, 8201), 6); // potion strength i
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "ItemResource", 1, 0), 12); // Alumentum
        TFTreasure.tower_library.common.add(getModItem(Thaumcraft.ID, "ItemResource", 4, 14), 6); // Salis
                                                                                                  // Mundus
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8198), 6); // potion night vision i
        TFTreasure.tower_library.uncommon.add(getModItem(Thaumcraft.ID, "ItemResource", 2, 1), 8); // Nitor
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8193), 6); // potion regen i
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8197), 6); // potion health i
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8194), 6); // potion swiftness i
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8195), 6); // potion fire resistance i
        TFTreasure.tower_library.uncommon.add(getModItem(Thaumcraft.ID, "ItemResource", 1, 0), 8); // Alumentum
        TFTreasure.tower_library.uncommon.add(getModItem(Thaumcraft.ID, "ItemResource", 4, 14), 6); // Salis
                                                                                                    // Mundus
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8233), 6); // potion strength ii
        TFTreasure.tower_library.uncommon.add(getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0), 1);
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8257), 6); // potion regen ii
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8229), 6); // potion health ii
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8258), 6); // potion extended swiftness ii
        TFTreasure.tower_library.rare.add(getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0), 2);
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8259), 6); // potion fire resistance iI

        // Litch Tower Boss Room
        TFTreasure.tower_room.common.add(getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0), 3);
        TFTreasure.tower_room.common.add(getModItem(Thaumcraft.ID, "ItemLootBag", 1, 0), 12);
        // TFTreasure.tower_room.common.add(NHItemList.LichBone.get(2),50);
        // TFTreasure.tower_room.common.add(NHItemList.LichBoneChip.get(8),75);
        TFTreasure.tower_room.uncommon.add(getModItem(Thaumcraft.ID, "ItemLootBag", 1, 1), 12);
        TFTreasure.tower_room.uncommon.add(MaterialLibAPI.getStack(Materials.NetherStar, Shapes.dustTiny, 1), 2);
        TFTreasure.tower_room.rare.add(getModItem(Thaumcraft.ID, "ItemLootBag", 1, 2), 6);
    }
}
