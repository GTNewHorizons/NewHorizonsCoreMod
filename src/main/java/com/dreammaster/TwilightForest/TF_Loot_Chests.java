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
        //System.out.println("I'm in your loot, adding new things");

        //Hill1 = small
        TFTreasure.hill1.common.add(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Thaumium, 2L), 3);
        TFTreasure.hill1.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4L), 5);
        TFTreasure.hill1.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nickel, 4L), 5);
        TFTreasure.hill1.common.add(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thaumium, 2L), 3);
        TFTreasure.hill1.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Manganese, 4L), 5);
        TFTreasure.hill1.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Antimony, 4L), 5);
        TFTreasure.hill1.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L), 3);
        TFTreasure.hill1.ultrarare.add(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Aluminium, 4L), 5);
        // Hill2 = medium
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Thaumium, 4L), 5);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Manganese, 4L), 7);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Antimony, 4L), 7);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4L), 7);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nickel, 4L), 7);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 6L), 7);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Electrum, 2L), 4);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 6L), 5);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Magnesium, 4L), 5);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thaumium, 4L), 5);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 0), 5);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 1), 5);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 2), 5);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 3), 5);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 4), 5);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 5), 5);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DamascusSteel, 4L), 5);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 4L), 5);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 4L), 4);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Molybdenum, 4L), 6);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedAlloy, 4L), 8);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 4L), 8);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L), 8);
        TFTreasure.hill2.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L), 5);
        TFTreasure.hill2.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 16L), 5);
        TFTreasure.hill2.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L), 5);
        TFTreasure.hill2.ultrarare.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Gallium, 1L), 3);
        TFTreasure.hill3.ultrarare.add(GT_ModHandler.getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0), 2);
        //Hill3 = huge
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Thaumium, 6L), 7);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Manganese, 6L), 7);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Antimony, 6L), 7);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 6L), 10);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Electrum, 2L), 5);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 6L), 7);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Magnesium, 4L), 7);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thaumium, 6L), 7);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 0), 7);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 1), 7);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 2), 7);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 3), 7);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 4), 7);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 5), 7);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 2, 6), 5);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DamascusSteel, 4L), 7);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 4L), 7);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 4L), 6);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Molybdenum, 4L), 8);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedAlloy, 4L), 10);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 4L), 10);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L), 10);
        TFTreasure.hill3.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L), 7);
        TFTreasure.hill3.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L), 7);
        TFTreasure.hill3.rare.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1L), 5);
        TFTreasure.hill3.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 16L), 7);
        TFTreasure.hill3.rare.add(GT_ModHandler.getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0), 2);
        TFTreasure.hill3.ultrarare.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Gallium, 1L), 5);

        //Litch Tower Basment
        TFTreasure.basement.common.add(new ItemStack(Blocks.torch, 16, 0), 20);
        TFTreasure.basement.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 0), 5);
        TFTreasure.basement.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 1), 5);
        TFTreasure.basement.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 2), 5);
        TFTreasure.basement.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 3), 5);
        TFTreasure.basement.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 4), 5);
        TFTreasure.basement.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 5), 5);
        TFTreasure.basement.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 6), 5);
        TFTreasure.basement.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 7), 5);
        TFTreasure.basement.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 8), 5);
        TFTreasure.basement.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 9), 5);
        TFTreasure.basement.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 10), 5);
        TFTreasure.basement.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 11), 5);
        TFTreasure.basement.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 12), 5);
        TFTreasure.basement.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 13), 5);
        TFTreasure.basement.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 14), 5);
        TFTreasure.basement.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 15), 5);
        TFTreasure.basement.common.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 4L), 7);
        TFTreasure.basement.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 2L), 5);
        TFTreasure.basement.common.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Void, 1L), 3);
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8198), 7);//potion night vision i
        TFTreasure.basement.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 2, 1), 5);//Nitor
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8193), 3); //potion regen i
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8197), 3); //potion health i
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8194), 3); //potion swiftness i
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8195), 3); //potion fire resistance i
        TFTreasure.basement.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 1, 0), 5);//Alumentum
        TFTreasure.basement.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 4, 14), 3);//Salis Mundus
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8257), 3); //potion regen ii
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8229), 3); //potion health ii
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8258), 3); //potion extended swiftness ii
        TFTreasure.basement.rare.add(GT_ModHandler.getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0), 2);
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8259), 3); //potion fire resistance iI

        //Litch Tower Library
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8198), 7);//potion night vision i
        TFTreasure.tower_library.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 2, 1), 5);//Nitor
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8193), 5); //potion regen i
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8197), 5); //potion health i
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8194), 5); //potion swiftness i
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8195), 5); //potion fire resistance i
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8201), 5); //potion strength i
        TFTreasure.tower_library.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 1, 0), 5);//Alumentum
        TFTreasure.tower_library.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 4, 14), 3);//Salis Mundus
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8257), 5); //potion regen ii
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8229),5); //potion health ii
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8258),5 ); //potion extended swiftness ii
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8259), 5); //potion fire resistance ii
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8197), 5); //potion healing
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8233), 5); //potion strength ii
        TFTreasure.tower_library.rare.add(GT_ModHandler.getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0), 7);

    }
}
