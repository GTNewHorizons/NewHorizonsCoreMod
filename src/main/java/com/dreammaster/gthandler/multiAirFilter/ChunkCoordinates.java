package com.dreammaster.gthandler.multiAirFilter;

import gregtech.common.GT_Pollution;
import net.minecraft.world.World;

public class ChunkCoordinates {
    private int chunkX, chunkZ;
    private World world;

    public ChunkCoordinates(int chunkX, int chunkZ, World world){
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

    public World getWorld(){
        return world;
    }

    public int getPollution() {
        return GT_Pollution.getPollution(world, chunkX, chunkZ);
    }

    public void removePollution(int amount){
        GT_Pollution.addPollution(world, chunkX, chunkZ, -amount);
    }
}
