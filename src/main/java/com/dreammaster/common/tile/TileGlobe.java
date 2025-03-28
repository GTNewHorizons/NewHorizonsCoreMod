package com.dreammaster.common.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileGlobe extends TileEntity {

    // Prevent culling when block is out of frame so model can remain active.
    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return INFINITE_EXTENT_AABB;
    }

    private static final int maxRotationSpeed = 64;
    private static final int maxSize = 200;

    private int size = 1;
    private int rotationSpeed = 0;
    private String name = "Globe";

    public void incrementSize() {
        size++;
    }

    public void increaseRotationSpeed() {
        rotationSpeed++;
    }

    public float getRotationSpeed() {
        return rotationSpeed % maxRotationSpeed;
    }

    public int getSize() {
        return size % maxSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static final String nbtKeySpeed = "rotationSpeed";
    private static final String nbtKeySize = "size";
    private static final String nbtKeyName = "name";

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger(nbtKeySpeed, rotationSpeed);
        compound.setInteger(nbtKeySize, size);
        compound.setString(nbtKeyName, name);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        rotationSpeed = compound.getInteger(nbtKeySpeed);
        size = compound.getInteger(nbtKeySize);
        name = compound.getString(nbtKeyName);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        writeToNBT(nbttagcompound);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, nbttagcompound);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readFromNBT(pkt.func_148857_g());
    }
}