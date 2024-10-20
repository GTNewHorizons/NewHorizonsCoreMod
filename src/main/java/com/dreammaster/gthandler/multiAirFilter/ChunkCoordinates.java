package com.dreammaster.gthandler.multiAirFilter;

import net.minecraft.world.World;

import gregtech.common.pollution.Pollution;

public class ChunkCoordinates {

    private final int chunkX;
    private final int chunkZ;

    public ChunkCoordinates(int chunkX, int chunkZ) {
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
    }

    public int getChunkX() {
        return chunkX;
    }

    public int getChunkZ() {
        return chunkZ;
    }

    public int getPollution(World world) {
        return Pollution.getPollution(world, chunkX, chunkZ);
    }

    public void removePollution(int amount, World world) {
        Pollution.addPollution(world, chunkX, chunkZ, -amount);
    }
}
