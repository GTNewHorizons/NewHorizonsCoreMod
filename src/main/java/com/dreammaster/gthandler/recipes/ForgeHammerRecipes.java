package com.dreammaster.gthandler.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.util.GT_ModHandler;

public class ForgeHammerRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addForgeHammerRecipe(
                ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                ItemList.Circuit_Parts_RawCrystalParts.get(9),
                100,
                480);

        GT_Values.RA.addForgeHammerRecipe(
                ItemList.GalliumArsenideCrystal.get(1L),
                ItemList.GalliumArsenideCrystalSmallPart.get(4L),
                50,
                4);

        if (Loader.isModLoaded("TConstruct")) {
            GT_Values.RA.addForgeHammerRecipe(
                    GT_ModHandler.getModItem("TConstruct", "Smeltery", 1L, 2),
                    GT_ModHandler.getModItem("TConstruct", "materials", 3L, 2),
                    20,
                    16);
        }

        if (Loader.isModLoaded("Ztones")) {

            GT_Values.RA.addForgeHammerRecipe(
                    new ItemStack(Items.coal, 1, 0),
                    GT_ModHandler.getModItem("Ztones", "minicoal", 9L, 0),
                    50,
                    8);
            GT_Values.RA.addForgeHammerRecipe(
                    new ItemStack(Items.coal, 1, 1),
                    GT_ModHandler.getModItem("Ztones", "minicharcoal", 9L, 0),
                    50,
                    8);
        }
    }
}
