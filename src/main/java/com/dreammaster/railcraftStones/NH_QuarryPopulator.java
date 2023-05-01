package com.dreammaster.railcraftStones;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mods.railcraft.common.blocks.aesthetics.cube.BlockCube;
import mods.railcraft.common.blocks.aesthetics.cube.EnumCube;
import mods.railcraft.common.plugins.forge.WorldPlugin;
import mods.railcraft.common.worldgen.WorldGenQuarry;

public final class NH_QuarryPopulator {

    public static final PopulateChunkEvent.Populate.EventType EVENT_TYPE = (PopulateChunkEvent.Populate.EventType) EnumHelper
            .addEnum(PopulateChunkEvent.Populate.EventType.class, "RAILCRAFT_QUARRY", new Class[0], new Object[0]);
    private static NH_QuarryPopulator instance;
    private final WorldGenQuarry quarry;

    private NH_QuarryPopulator() {
        quarry = new WorldGenQuarry(BlockCube.getBlock(), EnumCube.QUARRIED_STONE.ordinal());
    }

    public static NH_QuarryPopulator instance() {
        if (instance == null) {
            instance = new NH_QuarryPopulator();
        }

        return instance;
    }

    @SubscribeEvent
    public void generate(PopulateChunkEvent.Pre event) {
        if (TerrainGen.populate(
                event.chunkProvider,
                event.world,
                event.rand,
                event.chunkX,
                event.chunkZ,
                event.hasVillageGenerated,
                EVENT_TYPE)) {
            generateQuarry(event.world, event.rand, event.chunkX, event.chunkZ);
        }
    }

    public void generateQuarry(World world, Random rand, int chunkX, int chunkZ) {
        int x = chunkX * 16 + 8;
        int z = chunkZ * 16 + 8;
        if (canGen(world, rand, x, z)) {
            int y = world.getTopSolidOrLiquidBlock(x, z) - 3;
            if (WorldPlugin.getBlock(world, x, y, z) == Blocks.dirt) {
                quarry.generate(world, rand, x, y, z);
            }
        }
    }

    private boolean canGen(World world, Random rand, int x, int z) {
        BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
        return BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.FOREST)
                && BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.SNOWY)
                && rand.nextDouble() <= 0.03D;
    }
}
