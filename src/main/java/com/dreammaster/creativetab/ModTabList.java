package com.dreammaster.creativetab;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.item.NHItemList;

import eu.usrv.yamcore.creativetabs.CreativeTabsManager;
import eu.usrv.yamcore.creativetabs.ModCreativeTab;
import eu.usrv.yamcore.items.ModItemManager;
import gregtech.api.GregTechAPI;

public final class ModTabList {

    public static String ModGenericTab = "tabDreamCraftItems_Generic";
    public static String ModShapesTab = "tabDreamCraftItems_Shapes";
    public static String ModMoldsTab = "tabDreamCraftItems_Molds";
    public static String ModThaumcraftTab = "tabDreamCraftItems_Thaum";
    public static String ModCircuitsTab = "tabDreamCraftItems_Circuit";
    public static String ModFluidsTab = "tabDreamCraftFluids";
    public static String ModBlocksTab = "tabDreamCraftBlocks";
    public static String ModSpaceTab = "tabDreamCraftSpace";
    public static String ModSolarTab = "tabDreamCraftSolar";
    public static String ModBarsAndCasingsTab = "tabDreamCraftBars_Casings";
    public static String ModAdditionsToGregTechTab = "tabDreamGregTechAdditions";

    private ModTabList() {}

    public static void InitModTabs(CreativeTabsManager pTabManager, ModItemManager pItemManager) {
        pTabManager.AddCreativeTab(
                new ModCreativeTab(ModGenericTab, NHItemList.AsteroidsStoneDust.Item.getConstructedItem()));
        pTabManager.AddCreativeTab(new ModCreativeTab(ModShapesTab, NHItemList.ShapeBlock.Item.getConstructedItem()));
        pTabManager.AddCreativeTab(new ModCreativeTab(ModMoldsTab, NHItemList.MoldFormAnvil.Item.getConstructedItem()));
        pTabManager.AddCreativeTab(
                new ModCreativeTab(ModThaumcraftTab, NHItemList.ChargedVoidWandCap.Item.getConstructedItem()));
        pTabManager.AddCreativeTab(
                new ModCreativeTab(ModCircuitsTab, NHItemList.QuantumCircuit.Item.getConstructedItem()));
        pTabManager.AddCreativeTab(new ModCreativeTab(ModFluidsTab, Items.bucket));
        pTabManager.AddCreativeTab(new ModCreativeTab(ModBlocksTab, Item.getItemFromBlock(Blocks.stone)));
        pTabManager.AddCreativeTab(
                new ModCreativeTab(ModSpaceTab, NHItemList.HeavyDutyNoseConeTier3.Item.getConstructedItem()));
        pTabManager.AddCreativeTab(
                new ModCreativeTab(
                        ModSolarTab,
                        NHItemList.EnrichedNaquadriaNeutroniumSunnariumAlloy.Item.getConstructedItem()));
        pTabManager.AddCreativeTab(
                new ModCreativeTab(ModBarsAndCasingsTab, NHItemList.ChromeBars.Item.getConstructedItem()));
        pTabManager.AddCreativeTab(
                new ModCreativeTab(
                        ModAdditionsToGregTechTab,
                        NHItemList.EtchedLudicrousVoltageWiring.Item.getConstructedItem()) {

                    @Override
                    public void displayAllReleventItems(List stuffToShow) {
                        // te adder
                        for (CustomItemList item : CustomItemList.values()) {
                            if (item.hasBeenSet() && item.getBlock() == GregTechAPI.sBlockMachines) {
                                stuffToShow.add(item.get(1));
                            }
                        }
                        super.displayAllReleventItems(stuffToShow);
                    }
                });
    }
}
