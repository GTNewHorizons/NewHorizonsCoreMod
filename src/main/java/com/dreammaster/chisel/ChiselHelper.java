package com.dreammaster.chisel;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.cricketcraft.chisel.api.carving.CarvingUtils;

public class ChiselHelper {

    public static void addVariationFromStack(String groupName, ItemStack stack) {
        CarvingUtils.getChiselRegistry()
                .addVariation(groupName, Block.getBlockFromItem(stack.getItem()), stack.getItemDamage(), 99);
    }

    public static void removeVariationStack(ItemStack stack) {
        CarvingUtils.getChiselRegistry()
                .removeVariation(Block.getBlockFromItem(stack.getItem()), stack.getItemDamage());
    }
}
