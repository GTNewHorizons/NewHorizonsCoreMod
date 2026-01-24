package com.dreammaster.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

import com.dreammaster.creativetab.ModTabList;
import com.dreammaster.lib.Refstrings;

import cpw.mods.fml.common.registry.GameRegistry;

@SuppressWarnings("SameParameterValue")
public enum BlockList {

    // ===== Generic Blocks =====
    SandClayMix("SandClayMix", gravelLike(0, 0.5f)),
    PistonBlock("PistonBlock", stoneLike(1, 0.5f)),
    DiamondFrameBox("DiamondFrameBox", new BlockDiamondFrameBox()), // FIXME: Move to GT5U
    CompressedGraphite("CompressedGraphite", stoneLike(1, 5f)),

    // ===== Resource Blocks =====
    // FIXME: Move these to GT5-Unofficial
    CallistoColdIce("CallistoColdIce", crystal(2, 25f)),
    Ledox("Ledox", metal(3, 50f)),
    MysteriousCrystal("MysteriousCrystal", crystal(3, 50f)),
    Mytryl("Mytryl", metal(2, 30f)),
    Quantinum("Quantinum", metal(3, 50f)),
    BlackPlutonium("BlackPlutonium", metal(3, 50f)),

    // ===== Plated Reinforced Stone =====
    BronzePlatedReinforcedStone("BronzePlatedReinforcedStone", platedStone(4, 60f)),
    SteelPlatedReinforcedStone("SteelPlatedReinforcedStone", platedStone(3, 150f)),
    TitaniumPlatedReinforcedStone("TitaniumPlatedReinforcedStone", platedStone(4, 200f)),
    TungstensteelPlatedReinforcedStone("TungstensteelPlatedReinforcedStone", platedStone(4, 250f)),
    NaquadahPlatedReinforcedStone("NaquadahPlatedReinforcedStone", platedStone(5, 500f)),
    NeutroniumPlatedReinforcedStone("NeutroniumPlatedReinforcedStone", platedStone(5, 750f)),

    // ===== Compressed Coal Blocks =====
    Charcoal("Charcoal", stoneLike(1, 5f)),
    CompressedCharcoal("CompressedCharcoal", stoneLike(1, 10f)),
    CompressedCoal("CompressedCoal", stoneLike(1, 10f)),
    CompressedCoalCoke("CompressedCoalCoke", stoneLike(1, 10f)),
    DoubleCompressedCharcoal("DoubleCompressedCharcoal", stoneLike(1, 15f)),
    DoubleCompressedCoal("DoubleCompressedCoal", stoneLike(1, 15f)),
    DoubleCompressedCoalCoke("DoubleCompressedCoalCoke", stoneLike(1, 15f)),
    TripleCompressedCharcoal("TripleCompressedCharcoal", stoneLike(2, 20f)),
    TripleCompressedCoal("TripleCompressedCoal", stoneLike(2, 20f)),
    TripleCompressedCoalCoke("TripleCompressedCoalCoke", stoneLike(2, 20f)),
    QuadrupleCompressedCharcoal("QuadrupleCompressedCharcoal", stoneLike(3, 25f)),
    QuadrupleCompressedCoal("QuadrupleCompressedCoal", stoneLike(3, 25f)),
    QuadrupleCompressedCoalCoke("QuadrupleCompressedCoalCoke", stoneLike(3, 25f)),
    QuintupleCompressedCharcoal("QuintupleCompressedCharcoal", stoneLike(3, 30f)),
    QuintupleCompressedCoal("QuintupleCompressedCoal", stoneLike(2, 30f)),
    QuintupleCompressedCoalCoke("QuintupleCompressedCoalCoke", stoneLike(3, 30f)),

    // ===== Blood Magic Altar Blocks =====
    BloodyThaumium("BloodyThaumium", metal(2, 30f)),
    BloodyVoid("BloodyVoid", metal(3, 60f)),
    BloodyIchorium("BloodyIchorium", metal(4, 120f)),

    // ===== Botania Blocks =====
    Gaia("Gaia", metal(6, 50f)),
    ManaPowder("ManaPowder", powder(3, 50f)),
    ManaPearl("ManaPearl", crystal(1, 50f)),
    PixieDust("PixieDust", powder(3, 50f));

    // ################################################################################
    public final String name;
    public final Block block;

    BlockList(String name, Block block) {
        this.name = name;
        this.block = block;

        block.setBlockName(name);
        block.setBlockTextureName(Refstrings.MODID + ":block" + name);
        block.setCreativeTab(ModTabList.BLOCKS);
    }

    public ItemStack getIS() {
        return new ItemStack(block, 1);
    }

    public ItemStack getIS(int amount) {
        return new ItemStack(block, amount);
    }

    public static void registerAll() {
        for (var entry : BlockList.values()) {
            GameRegistry.registerBlock(entry.block, entry.name);
        }
    }

    // ===== Simple Block Factories =====

    private static Block stoneLike(int harvestLevel, float hardness) {
        var newBlock = new Block(Material.rock).setHardness(hardness).setStepSound(Block.soundTypeStone);
        newBlock.setHarvestLevel("pickaxe", harvestLevel);
        return newBlock;
    }

    private static Block platedStone(int harvestLevel, float hardness) {
        var newBlock = new Block(Material.iron).setHardness(hardness).setResistance(hardness + 500f) // Blast-resistant
                .setStepSound(Block.soundTypeMetal);
        newBlock.setHarvestLevel("pickaxe", harvestLevel);
        return newBlock;
    }

    private static Block metal(int harvestLevel, float hardness) {
        var newBlock = new Block(Material.iron).setHardness(hardness).setStepSound(Block.soundTypeMetal);
        newBlock.setHarvestLevel("pickaxe", harvestLevel);
        return newBlock;
    }

    private static Block crystal(int harvestLevel, float hardness) {
        var newBlock = new Block(Material.glass).setHardness(hardness).setStepSound(Block.soundTypeGlass);
        newBlock.setHarvestLevel("pickaxe", harvestLevel);
        return newBlock;
    }

    private static Block powder(int harvestLevel, float hardness) {
        var newBlock = new Block(Material.sand).setHardness(hardness).setStepSound(Block.soundTypeSand);
        newBlock.setHarvestLevel("shovel", harvestLevel);
        return newBlock;
    }

    private static Block gravelLike(int harvestLevel, float hardness) {
        var newBlock = new Block(Material.sand).setHardness(hardness).setStepSound(Block.soundTypeGravel);
        newBlock.setHarvestLevel("shovel", harvestLevel);
        return newBlock;
    }
}
