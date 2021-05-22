package com.dreammaster.TwilightForest;

import com.dreammaster.gthandler.CustomItemList;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
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
        System.out.println("I'm in your loot, adding new things");

        //Hill1 = small
        TFTreasure.hill1.common.add(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Thaumium, 2L), 30);
        TFTreasure.hill1.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4L), 50);
        TFTreasure.hill1.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nickel, 4L), 50);
        TFTreasure.hill1.common.add(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thaumium, 2L), 30);
        TFTreasure.hill1.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Manganese, 4L), 50);
        TFTreasure.hill1.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Antimony, 4L), 50);
        TFTreasure.hill1.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L), 30);
        TFTreasure.hill1.ultrarare.add(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Aluminium, 4L), 50);
        // Hill2 = medium
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Thaumium, 4L), 50);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Manganese, 4L), 70);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Antimony, 4L), 70);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4L), 70);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nickel, 4L), 70);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 6L), 70);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Electrum, 2L), 40);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 6L), 50);
        TFTreasure.hill2.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Magnesium, 4L), 50);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thaumium, 4L), 50);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 0), 50);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 1), 50);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 2), 50);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 3), 50);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 4), 50);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 5), 50);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DamascusSteel, 4L), 50);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 4L), 50);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 4L), 40);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Molybdenum, 4L), 60);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedAlloy, 4L), 80);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 4L), 80);
        TFTreasure.hill2.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L), 80);
        TFTreasure.hill2.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L), 50);
        TFTreasure.hill2.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 16L), 50);
        TFTreasure.hill2.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L), 50);
        TFTreasure.hill2.ultrarare.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Gallium, 1L), 30);
        TFTreasure.hill3.ultrarare.add(GT_ModHandler.getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0), 20);
        //Hill3 = huge
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Thaumium, 6L), 70);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Manganese, 6L), 70);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Antimony, 6L), 70);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 6L), 100);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Electrum, 2L), 50);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 6L), 70);
        TFTreasure.hill3.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Magnesium, 4L), 70);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thaumium, 6L), 70);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 0), 70);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 1), 70);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 2), 70);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 3), 70);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 4), 70);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 4, 5), 70);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemShard", 2, 6), 50);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DamascusSteel, 4L), 70);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 4L), 70);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 4L), 60);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Molybdenum, 4L), 80);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedAlloy, 4L), 100);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 4L), 100);
        TFTreasure.hill3.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L), 100);
        TFTreasure.hill3.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L), 70);
        TFTreasure.hill3.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L), 70);
        TFTreasure.hill3.rare.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1L), 50);
        TFTreasure.hill3.rare.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 16L), 70);
        TFTreasure.hill3.rare.add(GT_ModHandler.getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0), 20);
        TFTreasure.hill3.ultrarare.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Gallium, 1L), 50);

        //UrGhast Tower Basment
        TFTreasure.basement.common.add(new ItemStack(Blocks.torch, 16, 0), 20);
        TFTreasure.basement.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 16L), 50);
        TFTreasure.basement.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Void, 8L), 30);
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8198), 70);//potion night vision i
        TFTreasure.basement.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 8, 1), 50);//Nitor
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8193), 30); //potion regen i
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8197), 30); //potion health i
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8194), 30); //potion swiftness i
        TFTreasure.basement.uncommon.add(new ItemStack(Items.potionitem, 1, 8195), 30); //potion fire resistance i
        TFTreasure.basement.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 8, 0), 50);//Alumentum
        TFTreasure.basement.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 16, 14), 30);//Salis Mundus
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8257), 30); //potion regen ii
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8229), 30); //potion health ii
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8258), 30); //potion extended swiftness ii
        TFTreasure.basement.rare.add(GT_ModHandler.getModItem("DraconicEvolution", "dezilsMarshmallow", 4, 0), 20);
        TFTreasure.basement.rare.add(new ItemStack(Items.potionitem, 1, 8259), 30); //potion fire resistance iI

        //Litch Tower Library
        TFTreasure.tower_library.common.add(new ItemStack(Blocks.torch, 16, 0), 30);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 0), 50);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 1), 50);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 2), 50);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 3), 50);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 4), 50);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 5), 50);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 6), 50);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 7), 50);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 8), 50);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 9), 50);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 10), 50);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 11), 50);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 12), 50);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 13), 50);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 14), 50);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "blockCandle", 4, 15), 50);
        TFTreasure.tower_library.common.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 4L), 70);
        TFTreasure.tower_library.common.add(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 4L), 70);
        TFTreasure.tower_library.common.add(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderPearl, 8L), 70);
        TFTreasure.tower_library.common.add(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 2L), 50);
        TFTreasure.tower_library.common.add(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Void, 2L), 30);
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 2, 1), 50);//Nitor
        TFTreasure.tower_library.common.add(new ItemStack(Items.potionitem, 1, 8201), 50); //potion strength i
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 1, 0), 50);//Alumentum
        TFTreasure.tower_library.common.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 4, 14), 30);//Salis Mundus
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8198), 70);//potion night vision i
        TFTreasure.tower_library.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 2, 1), 50);//Nitor
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8193), 30); //potion regen i
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8197), 30); //potion health i
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8194), 30); //potion swiftness i
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8195), 30); //potion fire resistance i
        TFTreasure.tower_library.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 1, 0), 50);//Alumentum
        TFTreasure.tower_library.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 4, 14), 30);//Salis Mundus
        TFTreasure.tower_library.uncommon.add(new ItemStack(Items.potionitem, 1, 8233), 50); //potion strength ii
        TFTreasure.tower_library.uncommon.add(GT_ModHandler.getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0), 70);
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8257), 30); //potion regen ii
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8229), 30); //potion health ii
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8258), 30); //potion extended swiftness ii
        TFTreasure.tower_library.rare.add(GT_ModHandler.getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0), 20);
        TFTreasure.tower_library.rare.add(new ItemStack(Items.potionitem, 1, 8259), 30); //potion fire resistance iI

        //Litch Tower Boss Room
        TFTreasure.tower_room.common.add(GT_ModHandler.getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0), 50);
        TFTreasure.tower_room.common.add(GT_ModHandler.getModItem("Thaumcraft", "ItemLootBag", 1, 0), 70);
        //TFTreasure.tower_room.common.add(CustomItemList.LichBone.get(2),50);
        //TFTreasure.tower_room.common.add(CustomItemList.LichBoneChip.get(8),75);
        TFTreasure.tower_room.uncommon.add(GT_ModHandler.getModItem("Thaumcraft", "ItemLootBag", 1, 1), 50);
        TFTreasure.tower_room.uncommon.add(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.NetherStar, 4L), 50);
        TFTreasure.tower_room.rare.add(GT_ModHandler.getModItem("Thaumcraft", "ItemLootBag", 1, 2), 30);
    }
}
