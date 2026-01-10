package com.dreammaster.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.dreammaster.item.NHItemList;

import eu.usrv.yamcore.creativetabs.CreativeTabsManager;
import eu.usrv.yamcore.creativetabs.ModCreativeTab;
import gregtech.api.GregTechAPI;

public final class ModTabList {

    public static String ModFluidsTab = "tabDreamCraftFluids";
    public static String ModBlocksTab = "tabDreamCraftBlocks";

    public static final CreativeTabs GENERIC = new CreativeTabs("tabDreamCraftItems_Generic") {

        @Override
        public Item getTabIconItem() {
            return NHItemList.AsteroidsStoneDust.item;
        }
    };

    public static final CreativeTabs SHAPES = new CreativeTabs("tabDreamCraftItems_Shapes") {

        @Override
        public Item getTabIconItem() {
            return NHItemList.ShapeBlock.item;
        }
    };

    public static final CreativeTabs MOLDS = new CreativeTabs("tabDreamCraftItems_Molds") {

        @Override
        public Item getTabIconItem() {
            return NHItemList.MoldFormAnvil.item;
        }
    };

    public static final CreativeTabs THAUMCRAFT = new CreativeTabs("tabDreamCraftItems_Thaum") {

        @Override
        public Item getTabIconItem() {
            return NHItemList.ChargedVoidWandCap.item;
        }
    };

    public static final CreativeTabs CIRCUITS = new CreativeTabs("tabDreamCraftItems_Circuit") {

        @Override
        public Item getTabIconItem() {
            return NHItemList.QuantumCircuit.item;
        }
    };

    public static final CreativeTabs SPACE = new CreativeTabs("tabDreamCraftSpace") {

        @Override
        public Item getTabIconItem() {
            return NHItemList.HeavyDutyNoseConeTier3.item;
        }
    };

    public static final CreativeTabs SOLAR = new CreativeTabs("tabDreamCraftSolar") {

        @Override
        public Item getTabIconItem() {
            return NHItemList.EnrichedNaquadriaNeutroniumSunnariumAlloy.item;
        }
    };

    public static final CreativeTabs BARS_AND_CASINGS = new CreativeTabs("tabDreamCraftBars_Casings") {

        @Override
        public Item getTabIconItem() {
            return NHItemList.ChromeBars.item;
        }
    };

    private ModTabList() {}

    public static void InitModTabs(CreativeTabsManager tabManager) {
        tabManager.AddCreativeTab(new ModCreativeTab(ModFluidsTab, Items.bucket));
        tabManager.AddCreativeTab(new ModCreativeTab(ModBlocksTab, Item.getItemFromBlock(Blocks.stone)));
    }
}
