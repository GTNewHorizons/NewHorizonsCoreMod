package com.dreammaster.main;

import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.dreammaster.block.BlockList;
import com.dreammaster.item.NHItemList;
import com.google.common.collect.ImmutableSet;

import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public final class NHRemapper {

    private final HashMap<String, Block> blockMappings;
    private final HashMap<String, Item> itemMappings;
    private final ImmutableSet<String> ignoreMappings;

    public NHRemapper() {
        BlockList[] blocks = BlockList.values();
        NHItemList[] items = NHItemList.values();

        blockMappings = new HashMap<>(blocks.length * 3 / 2);
        itemMappings = new HashMap<>((blocks.length + items.length) * 3 / 2);

        // Remap all the old Yamcl names (for Blocks & their ItemBlocks)
        for (final var block : blocks) {
            final String oldName = "tile." + block.name;
            blockMappings.put(oldName, block.block);
            itemMappings.put(oldName, Item.getItemFromBlock(block.block));
        }

        // Remaps MysteriousCrystal to MysteriousCrystalBlock in order to not conflict with the item
        blockMappings.put("tile.MysteriousCrystal", BlockList.MysteriousCrystalBlock.block);
        itemMappings.put("tile.MysteriousCrystal", Item.getItemFromBlock(BlockList.MysteriousCrystalBlock.block));

        // Remap all the old Yamcl names (for Items)
        for (final var item : items) {
            final String oldName = "item." + item.name;
            itemMappings.put(oldName, item.item);
        }

        // Replace the old Quantum Bread declaration with the new one.
        itemMappings.put("itemQuantumToast", NHItemList.QuantumBread.item);

        // Remaps the old "UnfiredSlimeSoulBrick" (with a typo) to the new, correct "UnfiredSlimeSoilBrick".
        itemMappings.put("item.UnfiredSlimeSoulBrick", NHItemList.UnfiredSlimeSoilBrick.item);

        final var bars = new BlockList[] { BlockList.AluminiumBars, BlockList.ChromeBars, BlockList.IridiumBars,
                BlockList.NeutroniumBars, BlockList.OsmiumBars, BlockList.StainlessSteelBars, BlockList.SteelBars,
                BlockList.TitaniumBars, BlockList.TungstenSteelBars };

        // Remap the Yamcl bar items to blocks.
        for (BlockList bar : bars) {
            final var itemBar = Item.getItemFromBlock(bar.block);
            itemMappings.put("item." + bar.name, itemBar);
        }

        ignoreMappings = ImmutableSet.copyOf(
                new String[] {
                        // For people updating from 2.8.4 or below
                        "item.ConductiveIronBars", "item.ElectricalSteelBars", "item.EnderiumBars",
                        "item.EnderiumBaseBars", "item.EnergeticAlloyBars", "item.PulsatingIronBars",
                        "item.RedstoneAlloyBars", "item.SoulariumBars", "item.TungstenBars", "item.VibrantAlloyBars",
                        // For people updating from the dailies
                        "ConductiveIronBars", "ElectricalSteelBars", "EnderiumBars", "EnderiumBaseBars",
                        "EnergeticAlloyBars", "PulsatingIronBars", "RedstoneAlloyBars", "SoulariumBars", "TungstenBars",
                        "VibrantAlloyBars",
                        // Removed fluid blocks & fluid buckets
                        "dreamcraft_SodiumPotassium", "dreamcraft_SodiumPotassium_bucket",
                        "dreamcraft_EnrichedBacterialSludge", "dreamcraft_EnrichedBacterialSludge_bucket",
                        "dreamcraft_FermentedBacterialSludge", "dreamcraft_FermentedBacterialSludge_bucket",
                        "dreamcraft_NitricAcid", "dreamcraft_NitricAcid_bucket", "dreamcraft_Ammonia",
                        "dreamcraft_Ammonia_bucket", "dreamcraft_CompressedOxygen",
                        "dreamcraft_CompressedOxygen_bucket", "dreamcraft_CompressedNitrogen",
                        "dreamcraft_CompressedNitrogen_bucket", "dreamcraft_Pollution",
                        "dreamcraft_Pollution_bucket", });
    }

    public static void remapAll(List<FMLMissingMappingsEvent.MissingMapping> missingMappings, int startFrom) {
        NHRemapper instance = new NHRemapper();

        for (int i = startFrom, size = missingMappings.size(); i < size; i++) {
            final var mapping = missingMappings.get(i);
            if (!mapping.name.startsWith("dreamcraft:")) continue;
            instance.remap(mapping);
        }
    }

    private void remap(FMLMissingMappingsEvent.MissingMapping mapping) {
        final String name = mapping.name.substring(11);

        if (mapping.type == GameRegistry.Type.BLOCK) {
            Block newBlock = blockMappings.get(name);
            if (newBlock != null) {
                mapping.remap(newBlock);
                return;
            }
        } else {
            Item newItem = itemMappings.get(name);
            if (newItem != null) {
                mapping.remap(newItem);
                return;
            }
        }

        if (ignoreMappings.contains(name)) {
            mapping.ignore();
        }
    }
}
