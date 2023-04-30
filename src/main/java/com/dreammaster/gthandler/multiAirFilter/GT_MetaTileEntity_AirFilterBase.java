package com.dreammaster.gthandler.multiAirFilter;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.*;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static gregtech.api.enums.GT_Values.*;
import static gregtech.api.util.GT_StructureUtility.ofHatchAdder;
import static gregtech.api.util.GT_StructureUtility.ofHatchAdderOptional;
import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.gthandler.casings.GT_Container_CasingsNH;
import com.dreammaster.item.ItemList;
import com.dreammaster.main.MainRegistry;
import com.gtnewhorizon.structurelib.alignment.IAlignmentLimits;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;

import eu.usrv.yamcore.auxiliary.PlayerChatHelper;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.items.GT_MetaGenerated_Tool;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_EnhancedMultiBlockBase;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Muffler;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.api.util.GT_Multiblock_Tooltip_Builder;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;
import gregtech.common.items.GT_MetaGenerated_Tool_01;

public abstract class GT_MetaTileEntity_AirFilterBase
        extends GT_MetaTileEntity_EnhancedMultiBlockBase<GT_MetaTileEntity_AirFilterBase> {

    protected int baseEff = 0;
    protected int multiTier = 0;
    protected int chunkIndex = 0;
    protected boolean hasPollution = false;
    protected ChunkCoordinates[] chunkList; // list of the chunks in the working area
    protected int mode = 0; // 0 for processing chunks in order, 1 for processing chunks randomly
    protected int size; // current working size of the multi, max is 2*multiTier + 1
    protected boolean isFilterLoaded = false;
    protected int filterUsageRemaining = 0;
    protected int tickCounter = 0; // because we can't trust the world tick, it may be in a dim with eternal day, etc
    protected static final String STRUCTURE_PIECE_MAIN = "main";
    protected static final ClassValue<IStructureDefinition<GT_MetaTileEntity_AirFilterBase>> STRUCTURE_DEFINITION = new ClassValue<IStructureDefinition<GT_MetaTileEntity_AirFilterBase>>() {

        @Override
        protected IStructureDefinition<GT_MetaTileEntity_AirFilterBase> computeValue(Class<?> type) {
            return StructureDefinition.<GT_MetaTileEntity_AirFilterBase>builder()
                    .addShape(
                            STRUCTURE_PIECE_MAIN,
                            transpose(
                                    new String[][] { { "xxx", "xxx", "xxx" }, { "vmv", "m-m", "vmv" },
                                            { "vmv", "m-m", "vmv" }, { "c~c", "ccc", "ccc" }, }))
                    .addElement(
                            'c',
                            lazy(
                                    x -> ofChain(
                                            ofBlock(GT_Container_CasingsNH.sBlockCasingsNH, x.getCasingMeta()),
                                            ofHatchAdder(
                                                    GT_MetaTileEntity_AirFilterBase::addMaintenanceToMachineList,
                                                    x.getCasingIndex(),
                                                    1),
                                            ofHatchAdder(
                                                    GT_MetaTileEntity_AirFilterBase::addInputToMachineList,
                                                    x.getCasingIndex(),
                                                    1),
                                            ofHatchAdder(
                                                    GT_MetaTileEntity_AirFilterBase::addOutputToMachineList,
                                                    x.getCasingIndex(),
                                                    1),
                                            ofHatchAdder(
                                                    GT_MetaTileEntity_AirFilterBase::addEnergyInputToMachineList,
                                                    x.getCasingIndex(),
                                                    1))))
                    .addElement('x', lazy(x -> ofBlock(GT_Container_CasingsNH.sBlockCasingsNH, x.getCasingMeta())))
                    .addElement('v', lazy(x -> ofBlock(GT_Container_CasingsNH.sBlockCasingsNH, x.getPipeMeta())))
                    .addElement(
                            'm',
                            lazy(
                                    x -> ofHatchAdderOptional(
                                            GT_MetaTileEntity_AirFilterBase::addMufflerToMachineList,
                                            x.getCasingIndex(),
                                            2,
                                            GT_Container_CasingsNH.sBlockCasingsNH,
                                            x.getCasingMeta())))
                    .build();
        }
    };

    @Override
    public final IStructureDefinition<GT_MetaTileEntity_AirFilterBase> getStructureDefinition() {
        return STRUCTURE_DEFINITION.get(getClass());
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        buildPiece(STRUCTURE_PIECE_MAIN, stackSize, hintsOnly, 1, 3, 0);
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        return checkPiece(STRUCTURE_PIECE_MAIN, 1, 3, 0) && !mMufflerHatches.isEmpty()
                && mMaintenanceHatches.size() == 1;
    }

    static final GT_Recipe tRecipeT1 = new GT_Recipe(
            new ItemStack[] { CustomItemList.AdsorptionFilter.get(1L, new Object()) },
            new ItemStack[] { CustomItemList.AdsorptionFilterDirty.get(1L, new Object()) },
            null,
            null,
            null,
            null,
            200,
            30,
            0);
    static final GT_Recipe tRecipeT2 = new GT_Recipe(
            new ItemStack[] { CustomItemList.AdsorptionFilter.get(1L, new Object()) },
            new ItemStack[] { CustomItemList.AdsorptionFilterDirty.get(1L, new Object()) },
            null,
            null,
            null,
            null,
            200,
            480,
            0);
    static final GT_Recipe tRecipeT3 = new GT_Recipe(
            new ItemStack[] { CustomItemList.AdsorptionFilter.get(1L, new Object()) },
            new ItemStack[] { CustomItemList.AdsorptionFilterDirty.get(1L, new Object()) },
            null,
            null,
            null,
            null,
            200,
            7680,
            0);

    public GT_MetaTileEntity_AirFilterBase(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public GT_MetaTileEntity_AirFilterBase(String aName) {
        super(aName);
    }

    protected void populateChunkList() {
        chunkList = new ChunkCoordinates[size * size];
        World world = this.getBaseMetaTileEntity().getWorld();
        int xCoordMulti = this.getBaseMetaTileEntity().getXCoord();
        int zCoordMulti = this.getBaseMetaTileEntity().getZCoord();

        for (int i = 0; i < size * size; i++) {
            int xCoordChunk = (xCoordMulti - 16 * (size / 2 - (i % (size)))) >> 4;
            int zCoordChunk = (zCoordMulti + 16 * (size / 2 - (i / (size)))) >> 4;
            chunkList[i] = new ChunkCoordinates(xCoordChunk, zCoordChunk, world);
        }
    }

    public abstract GT_Recipe getRecipe();

    public String getCasingString() {
        switch (getCasingMeta()) {
            case 0:
                return "Air Filter Turbine Casing";
            case 3:
                return "Advanced Air Filter Turbine Casing";
            case 5:
                return "Super Air Filter Turbine Casing";
            default:
                return "fill a ticket on github if you read this";
        }
    }

    public String getPipeString() {
        switch (getPipeMeta()) {
            case 1:
                return "Air Filter Vent Casing";
            case 4:
                return "Advanced Air Filter Vent Casing";
            case 6:
                return "Super Air Filter Vent Casing";
            default:
                return "fill a ticket on github if you read this";
        }
    }

    @Override
    protected GT_Multiblock_Tooltip_Builder createTooltip() {
        final GT_Multiblock_Tooltip_Builder tt = new GT_Multiblock_Tooltip_Builder();
        tt.addMachineType("Air Filter").addInfo("Controller block for the Electric Air Filter T" + multiTier)
                .addInfo("Needs a Turbine in the controller")
                .addInfo(
                        "Add " + ItemList.AdsorptionFilter.getIS().getDisplayName()
                                + " in input bus to double efficiency (30 uses per item)")
                .addInfo("Machine tier = Maximum effective Muffler tier")
                .addInfo("Can process " + (2 * multiTier + 1) + "x" + (2 * multiTier + 1) + " chunks")
                .addInfo(
                        "Each muffler reduce pollution by " + MainRegistry.CoreConfig.globalMultiplicator
                                + " * bonusMultiTier * turbineEff * multiEff * Floor("
                                + MainRegistry.CoreConfig.scalingFactor
                                + "^effectiveTier) every second")
                .addInfo("The value of bonusMultiTier for this controller is: " + getBonusByTier()).addSeparator()
                .beginStructureBlock(3, 4, 3, true).addController("Front bottom")
                .addOtherStructurePart(getCasingString(), "Top and bottom")
                .addOtherStructurePart(getPipeString(), "Corners of the middle 2 layers")
                .addOtherStructurePart("Muffler Hatch Or " + getPipeString(), "8 in the middle layers")
                .addEnergyHatch("Any bottom layer casing", 1).addMaintenanceHatch("Any bottom layer casing", 1)
                .addInputBus("Any bottom layer casing", 1).addOutputBus("Any bottom layer casing", 1)
                .addMufflerHatch("Middle Center", 2).toolTipFinisher("GTNH Coremod");
        return tt;
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, ForgeDirection side, ForgeDirection facing,
            int colorIndex, boolean aActive, boolean aRedstone) {
        if (side == facing) {
            return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingIndex()),
                    new GT_RenderedTexture(
                            aActive ? Textures.BlockIcons.OVERLAY_FRONT_DIESEL_ENGINE_ACTIVE
                                    : Textures.BlockIcons.OVERLAY_FRONT_DIESEL_ENGINE) };
        }
        return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(getCasingIndex()) };
    }

    public abstract float getBonusByTier();

    public abstract int getCasingIndex();

    @Override
    public boolean isCorrectMachinePart(ItemStack aStack) {
        return aStack != null && aStack.getItem() instanceof GT_MetaGenerated_Tool_01
                && ((GT_MetaGenerated_Tool) aStack.getItem()).getToolStats(aStack).getSpeedMultiplier() > 0
                && GT_MetaGenerated_Tool.getPrimaryMaterial(aStack).mToolSpeed > 0
                && aStack.getItemDamage() > 169
                && aStack.getItemDamage() < 180;
    }

    @Override
    protected IAlignmentLimits getInitialAlignmentLimits() {
        // don't rotate it, it's cursed.
        return (d, r, f) -> d.offsetY == 0 && r.isNotRotated() && !f.isVerticallyFliped();
    }

    public int getPollutionCleaningRatePerTick(float turbineEff, float multiEff, boolean isRateBoosted) {
        return getPollutionCleaningRatePerSecond(turbineEff, multiEff, isRateBoosted) / 20;
    }

    public int getPollutionCleaningRatePerSecond(float turbineEff, float multiEff, boolean isRateBoosted) {
        long tVoltage = getMaxInputVoltage();
        byte tTier = (byte) max(1, GT_Utility.getTier(tVoltage));
        int pollutionPerSecond = 0;
        for (GT_MetaTileEntity_Hatch_Muffler tHatch : mMufflerHatches) {
            if (isValidMetaTileEntity(tHatch)) {
                // applying scaling factor
                pollutionPerSecond += (int) Math.pow(MainRegistry.CoreConfig.scalingFactor, min(tTier, tHatch.mTier));
            }
        }
        // apply the boost
        if (isRateBoosted) {
            pollutionPerSecond = (int) (pollutionPerSecond * MainRegistry.CoreConfig.boostPerAbsorptionFilter);
        }
        // apply the rest of the coefs
        pollutionPerSecond = (int) (pollutionPerSecond * turbineEff
                * multiEff
                * getBonusByTier()
                * MainRegistry.CoreConfig.globalMultiplicator);
        return pollutionPerSecond;
    }

    @Override
    public boolean checkRecipe(ItemStack aStack) {
        mEfficiencyIncrease = 10000;
        mEfficiency = 10000 - (getIdealStatus() - getRepairStatus()) * 1000;
        // check pollution for next cycle:
        hasPollution = getTotalPollution() >= MainRegistry.CoreConfig.pollutionThresholdAirFilter;
        mMaxProgresstime = getRecipe().mDuration;
        mEUt = -getRecipe().mEUt;
        if (!hasPollution) {
            return true;
        }

        try {
            // make the turbine to be required
            if (isCorrectMachinePart(aStack)) {
                baseEff = GT_Utility.safeInt(
                        (long) ((50.0F + 10.0F * ((GT_MetaGenerated_Tool) aStack.getItem()).getToolCombatDamage(aStack))
                                * 100));
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        tickCounter = 0; // resetting the counter in case of a power failure, etc

        // scan the inventory to search for filter if none has been loaded previously
        if (!isFilterLoaded && isCorrectMachinePart(aStack)) {
            ArrayList<ItemStack> tInputList = getStoredInputs();
            int tInputList_sS = tInputList.size();
            for (int i = 0; i < tInputList_sS - 1; i++) {
                for (int j = i + 1; j < tInputList_sS; j++) {
                    if (GT_Utility.areStacksEqual(tInputList.get(i), tInputList.get(j))) {
                        if (tInputList.get(i).stackSize >= tInputList.get(j).stackSize) {
                            tInputList.remove(j--);
                            tInputList_sS = tInputList.size();
                        } else {
                            tInputList.remove(i--);
                            tInputList_sS = tInputList.size();
                            break;
                        }
                    }
                }
            }

            ItemStack[] tInputs = Arrays.copyOfRange(tInputList.toArray(new ItemStack[0]), 0, 2);
            if (!tInputList.isEmpty()) {
                if (getRecipe().isRecipeInputEqual(true, null, tInputs)) {
                    updateSlots();
                    filterUsageRemaining = MainRegistry.CoreConfig.usagesPerAbsorptionFilter;
                    isFilterLoaded = true;
                }
            }
        }

        // if a filter is loaded in
        if (isFilterLoaded) {

            // consume one use of the filter
            filterUsageRemaining -= 1;

            // when the filter finished its last usage, we give it back in dirty form.
            if (filterUsageRemaining == 0) {
                mOutputItems = new ItemStack[] { getRecipe().getOutput(0) };
                isFilterLoaded = false;
            } else {
                mOutputItems = null; // no return until the filter has been totally consumed
            }
        }

        return true;
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);
        aNBT.setInteger("mode", mode); // running mode
        aNBT.setInteger("chunkIndex", chunkIndex); // chunk index when running in normal mode
        aNBT.setInteger("size", size); // working area
        aNBT.setBoolean("isFilterLoaded", isFilterLoaded);
        aNBT.setInteger("filterUsageRemaining", filterUsageRemaining);
    }

    @Override
    public void loadNBTData(NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
        mode = aNBT.getInteger("mode");
        chunkIndex = aNBT.getInteger("chunkIndex");
        size = aNBT.getInteger("size");
        isFilterLoaded = aNBT.getBoolean("isFilterLoaded");
        filterUsageRemaining = aNBT.getInteger("filterUsageRemaining");
    }

    public void cleanPollution() {
        int pollutionCleaningRatePerSecond = getPollutionCleaningRatePerSecond(
                baseEff / 10000f,
                mEfficiency / 10000f,
                isFilterLoaded);
        if (pollutionCleaningRatePerSecond > 0) {
            if (mode == 0) { // processing chunk normally
                chunkList[chunkIndex].removePollution(pollutionCleaningRatePerSecond);
                chunkIndex += 1;
                if (chunkIndex == chunkList.length) {
                    chunkIndex = 0;
                }
            } else { // process chunks randomly

                // list all the polluted chunks
                ArrayList<ChunkCoordinates> pollutedChunkList = new ArrayList<>();
                for (ChunkCoordinates chunk : chunkList) {
                    if (chunk.getPollution() > 0) {
                        pollutedChunkList.add(chunk);
                    }
                }

                // pick the chunk randomly
                ChunkCoordinates pollutedChunk;
                if (pollutedChunkList.size() > 1) {
                    pollutedChunk = pollutedChunkList.get(MainRegistry.Rnd.nextInt(pollutedChunkList.size() - 1));
                    pollutedChunk.removePollution(pollutionCleaningRatePerSecond);
                } else if (pollutedChunkList.size() == 1) { // no random on only one element
                    pollutedChunk = pollutedChunkList.get(0);
                    pollutedChunk.removePollution(pollutionCleaningRatePerSecond);
                }
            }
        }
    }

    public abstract int getPipeMeta();

    public abstract int getCasingMeta();

    @Override
    public int getMaxEfficiency(ItemStack aStack) {
        return 10000;
    }

    @Override
    public void onPreTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        if (chunkList == null) {
            if (size == 0) { // here in case it's not set by NBT loading
                size = 2 * multiTier + 1;
            }
            populateChunkList();
        }
        super.onPreTick(aBaseMetaTileEntity, aTick);
    }

    public int getTotalPollution() {
        int pollutionAmount = 0;
        for (ChunkCoordinates chunk : chunkList) {
            pollutionAmount += chunk.getPollution();
        }
        return pollutionAmount;
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        if (aTick % 200L == 0L) {
            // refresh casing on state change
            int Xpos = aBaseMetaTileEntity.getXCoord() + aBaseMetaTileEntity.getBackFacing().offsetX;
            int Ypos = aBaseMetaTileEntity.getYCoord() + 3;
            int Zpos = aBaseMetaTileEntity.getZCoord() + aBaseMetaTileEntity.getBackFacing().offsetZ;
            try {
                aBaseMetaTileEntity.getWorld()
                        .markBlockRangeForRenderUpdate(Xpos - 1, Ypos, Zpos - 1, Xpos + 1, Ypos, Zpos + 1);
            } catch (Exception ignored) {}
        }
        super.onPostTick(aBaseMetaTileEntity, aTick);
    }

    @Override
    public boolean onRunningTick(ItemStack aStack) {
        if (tickCounter == 19 && hasPollution) {
            cleanPollution();
            tickCounter = 0;
        } else {
            tickCounter += 1;
        }
        return super.onRunningTick(aStack);
    }

    @Override
    public int getDamageToComponent(ItemStack aStack) {
        try {
            if (isCorrectMachinePart(aStack) && hasPollution) { // no pollution no damage
                return getBaseMetaTileEntity().getRandomNumber(2); // expected to be 0.5 damage in long term
            }
        } catch (Exception e) {
            /**/
        }
        return 0;
    }

    @Override
    public boolean explodesOnComponentBreak(ItemStack aStack) {
        return false;
    }

    @Override
    public void onScrewdriverRightClick(ForgeDirection side, EntityPlayer aPlayer, float aX, float aY, float aZ) {
        if (!aPlayer.isSneaking()) { // change mode
            mode = mode == 1 ? 0 : 1;
            if (mode == 0) {
                chunkIndex = 0;
                PlayerChatHelper.SendInfo(aPlayer, "Electric air filter now running in normal mode");
            } else {
                PlayerChatHelper.SendInfo(aPlayer, "Electric air filter now running in random mode");
            }
        } else { // change radius on sneak
            if (size == 1) {
                size = 2 * multiTier + 1;
            } else {
                size -= 2; // always get odd number
            }
            chunkIndex = 0;
            populateChunkList();
            PlayerChatHelper
                    .SendInfo(aPlayer, "Electric air filter is now working in a " + size + "x" + size + " area");
        }
    }

    @Override
    public String[] getInfoData() {
        return new String[] { "Progress:",
                EnumChatFormatting.GREEN + Integer.toString(mProgresstime / 20)
                        + EnumChatFormatting.RESET
                        + " s / "
                        + EnumChatFormatting.YELLOW
                        + mMaxProgresstime / 20
                        + EnumChatFormatting.RESET
                        + " s",
                "Stored Energy:",
                EnumChatFormatting.GREEN + Long.toString(getBaseMetaTileEntity().getStoredEU())
                        + EnumChatFormatting.RESET
                        + " EU / "
                        + EnumChatFormatting.YELLOW
                        + getBaseMetaTileEntity().getEUCapacity()
                        + EnumChatFormatting.RESET
                        + " EU",
                "Probably uses: " +
                // negative EU triggers special EU consumption behavior. however it does not produce power.
                        EnumChatFormatting.RED + Math.abs(mEUt) + EnumChatFormatting.RESET + " EU/t",
                "Max Energy Income: " + EnumChatFormatting.YELLOW
                        + getMaxInputVoltage()
                        + EnumChatFormatting.RESET
                        + " EU/t(*2A) Tier: "
                        + EnumChatFormatting.YELLOW
                        + VN[GT_Utility.getTier(getMaxInputVoltage())]
                        + EnumChatFormatting.RESET,
                "Problems: " + EnumChatFormatting.RED
                        + (getIdealStatus() - getRepairStatus())
                        + EnumChatFormatting.RESET
                        + " Efficiency: "
                        + EnumChatFormatting.YELLOW
                        + mEfficiency / 100.0F
                        + EnumChatFormatting.RESET
                        + " %",
                "Pollution reduction: " + EnumChatFormatting.GREEN
                        + getPollutionCleaningRatePerTick(baseEff / 10000f, mEfficiency / 10000f, isFilterLoaded)
                        + EnumChatFormatting.RESET
                        + " gibbl/t",
                "Has a filter in it: " + isFilterLoaded,
                "remaining cycles for the filter (if present): " + filterUsageRemaining };
    }
}
