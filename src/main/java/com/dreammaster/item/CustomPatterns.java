package com.dreammaster.item;

import net.minecraft.creativetab.CreativeTabs;

import com.dreammaster.creativetab.ModTabList;
import com.dreammaster.main.MainRegistry;

import cpw.mods.fml.common.registry.GameRegistry;
import eu.usrv.yamcore.creativetabs.CreativeTabsManager;

public class CustomPatterns {

    public static Pattern BowFletchingCast;
    public static Pattern BowStringCast;

    public static boolean RegisterPatterns(CreativeTabsManager tabManager) {
        boolean tResult = true;
        CreativeTabs tab = tabManager.GetCreativeTabInstance(ModTabList.ModMoldsTab);
        try {
            BowFletchingCast = new Pattern(
                    new String[] { "BowFletchingCast" },
                    new String[] { "itemBowFletchingCast" },
                    tab);
            BowFletchingCast.setUnlocalizedName("Cast");
            GameRegistry.registerItem(BowFletchingCast, "item.BowFletchingCast");
        } catch (Exception E) {
            MainRegistry.Logger.warn("Unable to register BowFletchingCast, skipping");
            tResult = false;
        }
        try {
            BowStringCast = new Pattern(new String[] { "BowStringCast" }, new String[] { "itemBowStringCast" }, tab);
            BowStringCast.setUnlocalizedName("Cast");
            GameRegistry.registerItem(BowStringCast, "item.BowStringCast");
        } catch (Exception E) {
            tResult = false;
        }
        return tResult;
    }
}
