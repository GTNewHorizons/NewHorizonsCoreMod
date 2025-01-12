package com.dreammaster.tinkersConstruct;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import tconstruct.library.crafting.Smeltery;

public class MeltingRecipeAdder {

    private final Consumer<ItemStack> addMelting;
    private final Block renderBlock;
    private final int renderBlockMeta;
    private final int meltingTemperature;
    private final String fluidName;

    MeltingRecipeAdder(Block renderBlock, int renderBlockMeta, int meltingTemperature, String fluidName, int amount) {
        this.renderBlock = renderBlock;
        this.renderBlockMeta = renderBlockMeta;
        this.meltingTemperature = meltingTemperature;
        this.fluidName = fluidName;
        addMelting = itemStack -> Smeltery.addMelting(
                itemStack,
                renderBlock,
                renderBlockMeta,
                meltingTemperature,
                FluidRegistry.getFluidStack(fluidName, amount));
    }

    public MeltingRecipeAdder withAmount(int newAmount) {
        return new MeltingRecipeAdder(renderBlock, renderBlockMeta, meltingTemperature, fluidName, newAmount);
    }

    public MeltingRecipeAdder add(ItemStack itemStack) {
        addMelting.accept(itemStack);
        return this;
    }

    public MeltingRecipeAdder add(Stream<ItemStack> itemStackStream) {
        itemStackStream.forEach(addMelting);
        return this;
    }

    public MeltingRecipeAdder add(ItemStack... itemStacks) {
        add(Arrays.stream(itemStacks));
        return this;
    }
}
