package com.dreammaster.tinkersConstruct.worldgen;

import static net.minecraft.world.biome.BiomeGenBase.extremeHills;
import static net.minecraft.world.biome.BiomeGenBase.extremeHillsEdge;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SAND;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate;

import com.dreammaster.block.BlockList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import tconstruct.util.config.PHConstruct;
import tconstruct.world.gen.SurfaceOreGen;

public class ZincGravelWorldgen {

    private final SurfaceOreGen zincSurface = new SurfaceOreGen(BlockList.ZincGravelOre.block, 0, 12, true);

    private static final ImmutableCollection<BiomeGenBase> EXTRA_ORE_BIOMES = ImmutableList
            .of(extremeHills, extremeHillsEdge);
    private static final int ZINC_ORE_GRAVEL_RARITY = 150;

    @SubscribeEvent
    public void onDecorateEvent(Decorate e) {
        // Trigger just before sand pass one--which comes just after vanilla ore
        // generation.
        if (e.type != SAND) return;

        BiomeGenBase biome = e.world.getWorldChunkManager().getBiomeGenAt(e.chunkX, e.chunkZ);
        int iterations = EXTRA_ORE_BIOMES.contains(biome) ? 2 : 1;
        for (int i = 0; i < iterations; i++) {
            generateSurfaceOres(e.rand, e.chunkX, e.chunkZ, e.world);
        }
    }

    private void generateSurfaceOres(Random random, int xChunk, int zChunk, World world) {
        if (random == null) return;

        int xPos, yPos, zPos;
        if (random.nextInt(ZINC_ORE_GRAVEL_RARITY) == 0) {
            xPos = xChunk + random.nextInt(16);
            yPos = 64 + PHConstruct.seaLevel;
            zPos = zChunk + random.nextInt(16);
            zincSurface.generate(world, random, xPos, yPos, zPos);
        }
    }
}
