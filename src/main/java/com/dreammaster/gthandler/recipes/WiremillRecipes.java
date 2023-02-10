package com.dreammaster.gthandler.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.CustomItemList;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_RecipeRegistrator;
import gregtech.api.util.GT_Utility;

public class WiremillRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addWiremillRecipe(
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.MeteoricIron, 1L),
                CustomItemList.MeteoricIronString.get(4L),
                600,
                480);
        GT_Values.RA.addWiremillRecipe(
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Tungsten, 1L),
                CustomItemList.TungstenString.get(4L),
                1200,
                1024);

        GT_Values.RA.addWiremillRecipe(
                GT_Utility.getIntegratedCircuit(3),
                Materials.BorosilicateGlass.getIngots(1),
                ItemList.Circuit_Parts_GlassFiber.get(8L),
                200,
                120);

        GT_RecipeRegistrator.registerWiremillRecipes(Materials.NetherStar, 200, 4);

        if (Loader.isModLoaded("Natura")) {
            GT_Values.RA.addWiremillRecipe(
                    GT_ModHandler.getModItem("Natura", "barleyFood", 2L, 3),
                    new ItemStack(Items.string, 1, 0),
                    200,
                    8);
        }
    }
}
