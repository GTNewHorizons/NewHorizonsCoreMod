package com.dreammaster.tinkersConstruct;

import java.lang.reflect.Field;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import gregtech.api.util.GTUtility;
import mantle.utils.ItemMetaWrapper;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.FluidType;
import tconstruct.library.crafting.Smeltery;

public class TConstructHelper {

    public static void removeBasinRecipe(ItemStack output) {
        TConstructRegistry.getBasinCasting().getCastingRecipes()
                .removeIf(r -> GTUtility.areStacksEqual(r.output, output, true));
    }

    public static void removeTableRecipe(ItemStack output) {
        TConstructRegistry.getTableCasting().getCastingRecipes()
                .removeIf(r -> GTUtility.areStacksEqual(r.output, output, true));
    }

    public static void removeSmelterAlloyMix(FluidStack output) {
        Smeltery.getAlloyList().removeIf(r -> GTUtility.areFluidsEqual(r.result, output, true));
    }

    public static void removeMeltingRecipe(ItemStack input) {
        ItemMetaWrapper wrap = new ItemMetaWrapper(input);
        Smeltery.getSmeltingList().remove(wrap);
        Smeltery.getTemperatureList().remove(wrap);
        Smeltery.getRenderIndex().remove(wrap);
    }

    public static MeltingRecipeAdder getMeltingAdder(Block renderBlock, int renderBlockMeta, int meltingTemperature,
            String fluidName, int amount) {
        return new MeltingRecipeAdder(renderBlock, renderBlockMeta, meltingTemperature, fluidName, amount);
    }

    public static MeltingRecipeAdder getMeltingAdder(FluidType fluidType, int temperatureDifference, int amount) {
        return new MeltingRecipeAdder(
                fluidType.renderBlock,
                fluidType.renderMeta,
                fluidType.baseTemperature + temperatureDifference,
                fluidType.fluid.getName(),
                amount);
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
