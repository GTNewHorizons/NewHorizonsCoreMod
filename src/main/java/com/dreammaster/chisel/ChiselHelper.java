package com.dreammaster.chisel;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.cricketcraft.chisel.api.carving.CarvingUtils;
import com.cricketcraft.chisel.api.carving.ICarvingGroup;
import com.cricketcraft.chisel.api.carving.ICarvingRegistry;

public class ChiselHelper {

    public static void addVariationFromStack(String groupName, ItemStack stack) {
        CarvingUtils.getChiselRegistry()
                .addVariation(groupName, Block.getBlockFromItem(stack.getItem()), stack.getItemDamage(), 99);
    }

    public static void registerOredict(String groupName, String oreName) {
        CarvingUtils.getChiselRegistry().registerOre(groupName, oreName);
    }

    public static void removeVariationStack(ItemStack stack) {
        CarvingUtils.getChiselRegistry()
                .removeVariation(Block.getBlockFromItem(stack.getItem()), stack.getItemDamage());
    }

    /// Removes `stack` from chisel, including from a group that offers it through the group's ore-dictionary name.
    /// Such a group stops following its ore-dictionary name and keeps the name's other members as fixed variations.
    public static void removeVariationAndOreMember(ItemStack stack) {
        ICarvingRegistry registry = CarvingUtils.getChiselRegistry();
        registry.removeVariation(Block.getBlockFromItem(stack.getItem()), stack.getItemDamage());
        for (int oreId : OreDictionary.getOreIDs(stack)) {
            String oreName = OreDictionary.getOreName(oreId);
            for (String groupName : registry.getSortedGroupNames()) {
                ICarvingGroup group = registry.getGroup(groupName);
                if (group == null || !oreName.equals(group.getOreName())) continue;
                group.setOreName(null);
                for (ItemStack member : OreDictionary.getOres(oreName)) {
                    Block block = Block.getBlockFromItem(member.getItem());
                    if (block == Blocks.air || member.isItemEqual(stack)
                            || registry.getVariation(block, member.getItemDamage()) != null)
                        continue;
                    registry.addVariation(groupName, block, member.getItemDamage(), 99);
                }
            }
        }
    }

    public static void addGroup(String groupName) {
        CarvingUtils.getChiselRegistry().addGroup(new CarvingUtils.SimpleCarvingGroup(groupName));
    }
}
