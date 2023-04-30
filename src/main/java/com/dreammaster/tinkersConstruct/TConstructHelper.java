package com.dreammaster.tinkersConstruct;

import java.lang.reflect.Field;
import java.util.Map;

import mantle.utils.ItemMetaWrapper;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.Smeltery;
import gregtech.api.util.GT_Utility;

public class TConstructHelper {

    public static void removeBasinRecipe(ItemStack output) {
        TConstructRegistry.getBasinCasting().getCastingRecipes()
                .removeIf(r -> GT_Utility.areStacksEqual(r.output, output, true));
    }

    public static void removeTableRecipe(ItemStack output) {
        TConstructRegistry.getTableCasting().getCastingRecipes()
                .removeIf(r -> GT_Utility.areStacksEqual(r.output, output, true));
    }

    public static void removeSmelterAlloyMix(FluidStack output) {
        Smeltery.getAlloyList().removeIf(r -> GT_Utility.areFluidsEqual(r.result, output, true));
    }

    public static void removeMeltingRecipe(ItemStack input) {
        ItemMetaWrapper wrap = new ItemMetaWrapper(input);
        Smeltery.getSmeltingList().remove(wrap);
        Smeltery.getTemperatureList().remove(wrap);
        Smeltery.getRenderIndex().remove(wrap);
    }

    private static Map<Fluid, Integer[]> smelteryFuelList = null;

    @SuppressWarnings("unchecked")
    public static void removeFuel(Fluid input) {

        if (smelteryFuelList == null) {
            try {
                Field smelteryFuels = Smeltery.class.getDeclaredField("smelteryFuels");
                smelteryFuels.setAccessible(true);
                smelteryFuelList = (Map<Fluid, Integer[]>) smelteryFuels.get(Smeltery.instance);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        smelteryFuelList.remove(input);
    }
}
