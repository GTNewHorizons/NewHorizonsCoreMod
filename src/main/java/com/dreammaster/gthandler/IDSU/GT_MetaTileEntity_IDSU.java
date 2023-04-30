package com.dreammaster.gthandler.IDSU;

import static gregtech.api.enums.GT_Values.V;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.objects.GT_RenderedTexture;

public class GT_MetaTileEntity_IDSU extends MetaTileEntity {

    public static final Map<Integer, Long> mIDSUList = new HashMap<>();
    public int mFrequency = 0;
    public static int mTier = 8;
    private static Textures.BlockIcons.CustomIcon _mIDSU;
    private static Textures.BlockIcons.CustomIcon _mIDSU_Out;

    public GT_MetaTileEntity_IDSU(int aID, String aBasicName, String aRegionalName, int aInvSlotCount) {
        super(aID, aBasicName, aRegionalName, aInvSlotCount);
    }

    @Override
    public void registerIcons(IIconRegister aBlockIconRegister) {
        super.registerIcons(aBlockIconRegister);
        _mIDSU = new Textures.BlockIcons.CustomIcon("IDSU");
        _mIDSU_Out = new Textures.BlockIcons.CustomIcon("IDSU_Out");
    }

    @Override
    public byte getTileEntityBaseType() {
        return 0;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return null;
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {}

    @Override
    public void loadNBTData(NBTTagCompound aNBT) {}

    @Override
    public boolean allowPullStack(IGregTechTileEntity aBaseMetaTileEntity, int aIndex, ForgeDirection side,
            ItemStack aStack) {
        return false;
    }

    @Override
    public boolean allowPutStack(IGregTechTileEntity aBaseMetaTileEntity, int aIndex, ForgeDirection side,
            ItemStack aStack) {
        return false;
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, ForgeDirection side, ForgeDirection facing,
            int colorIndex, boolean aActive, boolean aRedstone) {
        return new ITexture[] { side == facing ? new GT_RenderedTexture(_mIDSU_Out) : new GT_RenderedTexture(_mIDSU) };
    }

    @Override
    public boolean isTransformingLowEnergy() {
        return false;
    }

    @Override
    public boolean isFacingValid(ForgeDirection facing) {
        return true;
    }

    @Override
    public boolean isAccessAllowed(EntityPlayer aPlayer) {
        return true;
    }

    @Override
    public boolean isEnetOutput() {
        return true;
    }

    @Override
    public boolean isEnetInput() {
        return true;
    }

    @Override
    public boolean isOutputFacing(ForgeDirection side) {
        return side == getBaseMetaTileEntity().getFrontFacing();
    }

    @Override
    public boolean isInputFacing(ForgeDirection side) {
        return !isOutputFacing(side);
    }

    @Override
    public boolean isTeleporterCompatible() {
        return true;
    }

    @Override
    public long maxEUInput() {
        return V[(int) getInputTier()];
    }

    @Override
    public long maxEUOutput() {
        return V[(int) getOutputTier()];
    }

    @Override
    public long maxEUStore() {
        return Long.MAX_VALUE - 1;
    }

    @Override
    public long getInputTier() {
        return 8;
    }

    @Override
    public long getOutputTier() {
        return 8;
    }

    @Override
    public boolean isValidSlot(int aIndex) {
        return aIndex < 2;
    }

    @Override
    public int getSizeInventory() {
        return 3;
    }

    @Override
    public void onFirstTick(IGregTechTileEntity aBaseMetaTileEntity) {
        mFrequency = getBaseMetaTileEntity().getOwnerName().hashCode();
    }

    @Override
    public int rechargerSlotStartIndex() {
        return 0;
    }

    @Override
    public int rechargerSlotCount() {
        return 1;
    }

    @Override
    public int dechargerSlotStartIndex() {
        return 1;
    }

    @Override
    public int dechargerSlotCount() {
        return 1;
    }

    @Override
    public void setEUVar(long aEnergy) {
        mIDSUList.put(mFrequency, aEnergy);
    }

    @Override
    public long getEUVar() {
        Long tEU = mIDSUList.get(mFrequency);
        if (tEU == null) {
            tEU = 0L;
        }

        return tEU;
    }

    @Override
    public String[] getDescription() {
        return new String[] { "Interdimensional Storage Unit Mark II" };
    }

    public boolean allowPullStack(int aIndex, byte aSide, ItemStack aStack) {
        return aIndex < 2;
    }

    public boolean allowPutStack(int aIndex, byte aSide, ItemStack aStack) {
        return aIndex < 2;
    }
}
