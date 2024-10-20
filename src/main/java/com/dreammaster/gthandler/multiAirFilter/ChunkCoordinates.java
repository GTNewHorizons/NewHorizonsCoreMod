package com.dreammaster.gthandler.multiAirFilter;

import net.minecraft.world.World;

import gregtech.common.pollution.Pollution;

public class ChunkCoordinates {

    private final int chunkX;
    private final int chunkZ;
    private final World world;

    public ChunkCoordinates(int chunkX, int chunkZ, World world) {
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
        this.world = world;
    }

    public int getChunkX() {
        return chunkX;
    }

    public int getChunkZ() {
        return chunkZ;
    }

    public World getWorld() {
        return world;
    }

    public int getPollution() {
        return Pollution.getPollution(world, chunkX, chunkZ);
    }

    public void removePollution(int amount) {
        Pollution.addPollution(world, chunkX, chunkZ, -amount);
    }
}
