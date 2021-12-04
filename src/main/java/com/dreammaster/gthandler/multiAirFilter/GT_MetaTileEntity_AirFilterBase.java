package com.dreammaster.gthandler.multiAirFilter;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.gthandler.casings.GT_Container_CasingsNH;
import com.dreammaster.item.ItemList;
import com.dreammaster.main.MainRegistry;
import eu.usrv.yamcore.auxiliary.PlayerChatHelper;
import gregtech.GT_Mod;
import gregtech.api.enums.Textures;
import gregtech.api.gui.GT_GUIContainer_MultiMachine;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.items.GT_MetaGenerated_Tool;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Muffler;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_MultiBlockBase;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_Multiblock_Tooltip_Builder;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;
import gregtech.common.GT_Pollution;
import gregtech.common.items.GT_MetaGenerated_Tool_01;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.Arrays;

import static gregtech.api.enums.GT_Values.*;
import static java.lang.Math.max;
import static java.lang.Math.min;

public abstract class GT_MetaTileEntity_AirFilterBase extends GT_MetaTileEntity_MultiBlockBase {
    protected int mPollutionReductionWholeCycle =0;
    protected int baseEff = 2500;
    protected int multiTier = 0;
    protected int chunkIndex = 0;
    protected boolean hasPollution=false;
    protected int[][] chunkList; //list of the chunks, each entry contains the x and z coords of the chunks
    protected int mode = 0; // 0 for processing chunks in order, 1 for processing chunks randomly
    protected int size; //current working size of the multi, max is 2*multiTier + 1

    static final GT_Recipe tRecipeT1= new GT_Recipe(
            new ItemStack[]{CustomItemList.AdsorptionFilter.get(1L, new Object())},
            new ItemStack[]{CustomItemList.AdsorptionFilterDirty.get(1L,new Object())},
            null, null, null, null, 200, 30, 0);
    static final GT_Recipe tRecipeT2= new GT_Recipe(
            new ItemStack[]{CustomItemList.AdsorptionFilter.get(1L, new Object())},
            new ItemStack[]{CustomItemList.AdsorptionFilterDirty.get(1L,new Object())},
            null, null, null, null, 200, 480, 0);
    static final GT_Recipe tRecipeT3= new GT_Recipe(
            new ItemStack[]{CustomItemList.AdsorptionFilter.get(1L, new Object())},
            new ItemStack[]{CustomItemList.AdsorptionFilterDirty.get(1L,new Object())},
            null, null, null, null, 200, 7680, 0);

    public GT_MetaTileEntity_AirFilterBase(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public GT_MetaTileEntity_AirFilterBase(String aName) {
        super(aName);
    }

    protected void populateChunkList() {
        chunkList = new int[size * size][2];
        for (int i = 0; i < size * size; i++) {
            chunkList[i][0] = (this.getBaseMetaTileEntity().getXCoord() - 16 * (size / 2 - (i % (size)))) >> 4; // xcoord
            chunkList[i][1] = (this.getBaseMetaTileEntity().getZCoord() + 16 * (size / 2 - (i / (size)))) >> 4; // zcoord
        }
    }

    public GT_Recipe getRecipe(){
        switch (multiTier){
            case 3:
                return tRecipeT3;
            case 2:
                return tRecipeT2;
            default:
                return tRecipeT1;
        }
    }

    @Override
    public String[] getDescription() {
        final GT_Multiblock_Tooltip_Builder tt = new GT_Multiblock_Tooltip_Builder();
        tt.addMachineType("Air Filter")
                .addInfo("Controller block for the Electric Air Filter T"+ multiTier)
                .addInfo("Add Turbine in controller to increase efficiency")
                .addInfo("Add " + ItemList.AdsorptionFilter.getIS().getDisplayName() + " in input bus to double efficiency")
                .addInfo("Machine tier = Maximum effective Muffler tier")
                .addInfo("Can process "+(2*multiTier+1)+"x"+(2*multiTier+1)+" chunks")
                .addInfo("Each muffler reduce pollution by 30 * TurbineEfficiency * Floor(2.5^Tier) every second")
                .addSeparator()
                .beginStructureBlock(3, 4, 3, true)
                .addController("Front bottom")
                .addOtherStructurePart(GT_LanguageManager.getTranslation(GT_Container_CasingsNH.sBlockCasingsNH.getUnlocalizedName()+"."+getCasingMeta()+".name"), "Top and bottom")
                .addOtherStructurePart(GT_LanguageManager.getTranslation(GT_Container_CasingsNH.sBlockCasingsNH.getUnlocalizedName()+"."+getPipeMeta()+".name"), "Corners of the middle 2 layers")
                .addOtherStructurePart("Muffler Hatch Or "+GT_LanguageManager.getTranslation(GT_Container_CasingsNH.sBlockCasingsNH.getUnlocalizedName()+"."+getPipeMeta()+".name"), "8 in the middle layers")
                .addEnergyHatch("Any bottom layer casing")
                .addMaintenanceHatch("Any bottom layer casing")
                .addInputBus("Any bottom layer casing")
                .addOutputBus("Any bottom layer casing")
                .toolTipFinisher("GTNH Coremod");
        if (!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            return tt.getInformation();
        } else {
            return tt.getStructureInformation();
        }
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, byte aSide, byte aFacing, byte aColorIndex, boolean aActive, boolean aRedstone) {
        if (aSide == aFacing) {
            return new ITexture[]{Textures.BlockIcons.getCasingTextureForId(getCasingIndex()), new GT_RenderedTexture(aActive ? Textures.BlockIcons.OVERLAY_FRONT_DIESEL_ENGINE_ACTIVE : Textures.BlockIcons.OVERLAY_FRONT_DIESEL_ENGINE)};
        }
        return new ITexture[]{Textures.BlockIcons.getCasingTextureForId(getCasingIndex())};
    }

    public int getCasingIndex(){
        if (multiTier <=1){
            return 57;
        }
        else if (multiTier == 2){
            return 59;
        }
        else{
            return 60;
        }
    }

    @Override
    public Object getClientGUI(int aID, InventoryPlayer aPlayerInventory, IGregTechTileEntity aBaseMetaTileEntity) {
        return new GT_GUIContainer_MultiMachine(aPlayerInventory, aBaseMetaTileEntity, getLocalName(), "ElectricAirFilter.png");
    }

    @Override
    public boolean isCorrectMachinePart(ItemStack aStack) {
        return aStack != null && aStack.getItem() instanceof GT_MetaGenerated_Tool_01 &&
                ((GT_MetaGenerated_Tool) aStack.getItem()).getToolStats(aStack).getSpeedMultiplier() > 0 &&
                GT_MetaGenerated_Tool.getPrimaryMaterial(aStack).mToolSpeed > 0 &&
                aStack.getItemDamage() > 169 && aStack.getItemDamage() < 180;
    }

    @Override
    public boolean isFacingValid(byte aFacing) {
        return aFacing > 1;
    }

    @Override
    public boolean checkRecipe(ItemStack aStack){
        mEfficiencyIncrease = 10000;
        mEfficiency = 10000 - (getIdealStatus() - getRepairStatus()) * 1000;
        mPollutionReductionWholeCycle = 0;
        // check pollution for next cycle:
        hasPollution = getTotalPollution()>=10000;
        mMaxProgresstime = getRecipe().mDuration;
        mEUt=-getRecipe().mEUt;
        if(!hasPollution) {
            return true;
        }

        try{
            if (isCorrectMachinePart(aStack)) {
                baseEff = GT_Utility.safeInt((long) ((50.0F
                        + 10.0F * ((GT_MetaGenerated_Tool) aStack.getItem()).getToolCombatDamage(aStack)) * 100));
            } else {
                baseEff = 2500;
            }
        }catch (Exception e){
            baseEff = 2500;
        }

        ArrayList<ItemStack> tInputList = getStoredInputs();
        int tInputList_sS=tInputList.size();
        for (int i = 0; i < tInputList_sS - 1; i++) {
            for (int j = i + 1; j < tInputList_sS; j++) {
                if (GT_Utility.areStacksEqual(tInputList.get(i), tInputList.get(j))) {
                    if (tInputList.get(i).stackSize >= tInputList.get(j).stackSize) {
                        tInputList.remove(j--); tInputList_sS=tInputList.size();
                    } else {
                        tInputList.remove(i--); tInputList_sS=tInputList.size();
                        break;
                    }
                }
            }
        }

        long tVoltage = getMaxInputVoltage();
        byte tTier = (byte) max(1, GT_Utility.getTier(tVoltage));
        for (GT_MetaTileEntity_Hatch_Muffler tHatch : mMufflerHatches) {
            if (isValidMetaTileEntity(tHatch)) {
                mPollutionReductionWholeCycle += ((int) Math.pow(2.5, min(tTier, tHatch.mTier))) * 300;//reduction per muffler
            }
        }

        ItemStack[] tInputs = Arrays.copyOfRange(tInputList.toArray(new ItemStack[0]), 0, 2);
        if (!tInputList.isEmpty()) {
            if (getRecipe().isRecipeInputEqual(true, null, tInputs)) {
                mPollutionReductionWholeCycle *=2;//bonus for filter
                mOutputItems = new ItemStack[]{getRecipe().getOutput(0)};
                updateSlots();
            }

        }

        mPollutionReductionWholeCycle =GT_Utility.safeInt((long) mPollutionReductionWholeCycle *baseEff)/10000;
        mPollutionReductionWholeCycle =GT_Utility.safeInt((long) mPollutionReductionWholeCycle *mEfficiency/10000);
        cleanPollution();
        return true;
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT){
        super.saveNBTData(aNBT);
        aNBT.setInteger("mode", mode); // running mode
        aNBT.setInteger("chunkIndex", chunkIndex); // chunk index when running in normal mode
        aNBT.setInteger("size", size); // working area

    }

    @Override
    public void loadNBTData(NBTTagCompound aNBT){
        super.loadNBTData(aNBT);
        mode = aNBT.getInteger("mode");
        chunkIndex = aNBT.getInteger("chunkIndex");
        size = aNBT.getInteger("size");
    }

    public void cleanPollution(){
        if (mPollutionReductionWholeCycle > 0) {
                /*mAccumulatedPollutionReduction += mPollutionReductionWholeCycle;
                int tActualReduction = mAccumulatedPollutionReduction / mMaxProgresstime;
                mAccumulatedPollutionReduction = mAccumulatedPollutionReduction % mMaxProgresstime;*/
            if (mode==0){ //processing chunk normally
                GT_Pollution.addPollution(getBaseMetaTileEntity().getWorld(), chunkList[chunkIndex][0], chunkList[chunkIndex][1], -mPollutionReductionWholeCycle);
                chunkIndex += 1;
                if (chunkIndex == chunkList.length) {
                    chunkIndex = 0;
                }
            }
            else{// process chunks randomly
                ArrayList<Integer[]> pollutedChunkList = new ArrayList<>();
                for (int[] chunk : chunkList){
                    if (GT_Pollution.getPollution(getBaseMetaTileEntity().getWorld(),chunk[0],chunk[1]) > 0){
                        pollutedChunkList.add(new Integer[]{Integer.valueOf(chunk[0]), Integer.valueOf(chunk[1])});
                    }
                }
                Integer[] pollutedChunk;
                if (pollutedChunkList.size() > 1){
                    pollutedChunk = pollutedChunkList.get(MainRegistry.Rnd.nextInt(pollutedChunkList.size()-1));
                    GT_Pollution.addPollution(getBaseMetaTileEntity().getWorld(), pollutedChunk[0], pollutedChunk[1], -mPollutionReductionWholeCycle);
                }
                else if (pollutedChunkList.size() == 1){ // no random on only one element
                    pollutedChunk = pollutedChunkList.get(0);
                    GT_Pollution.addPollution(getBaseMetaTileEntity().getWorld(), pollutedChunk[0], pollutedChunk[1], -mPollutionReductionWholeCycle);
                }

            }
        }
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        int xDir = ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()).offsetX;
        int zDir = ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()).offsetZ;
        int one = 1;
        int two = 2;

        //air check and top casing check
        if (!aBaseMetaTileEntity.getAirOffset(xDir, one, zDir) || !aBaseMetaTileEntity.getAirOffset(xDir, two, zDir)) {//check air inside
            return false;
        }
        for(int i=-one; i<two; i++) {
            for (int j = -one; j < two; j++) {
                if (!aBaseMetaTileEntity.getAirOffset(xDir+i, 4, zDir+j) || !aBaseMetaTileEntity.getAirOffset(xDir+i, 5, zDir+j)) {//check air at on top of top layer
                    return false;
                }
                if (!isCasing(aBaseMetaTileEntity,xDir+i, 3, zDir+j)) {
                    return false;//top casing
                }
            }
        }
        if (!aBaseMetaTileEntity.getAirOffset(two+xDir, one, zDir) || !aBaseMetaTileEntity.getAirOffset(two+xDir, two, zDir)) {
            return false;
        }
        if (!aBaseMetaTileEntity.getAirOffset(xDir-two, one, zDir) || !aBaseMetaTileEntity.getAirOffset(xDir-two, two, zDir)) {
            return false;
        }
        if (!aBaseMetaTileEntity.getAirOffset(xDir, one, two+zDir) || !aBaseMetaTileEntity.getAirOffset(xDir, two, two+zDir)) {
            return false;
        }
        if (!aBaseMetaTileEntity.getAirOffset(xDir, one, zDir-two) || !aBaseMetaTileEntity.getAirOffset(xDir, two, zDir-two)) {
            return false;
        }


        if (!aBaseMetaTileEntity.getAirOffset(two+xDir, one, one+zDir) || !aBaseMetaTileEntity.getAirOffset(two+xDir, two, one+zDir)) {
            return false;
        }
        if (!aBaseMetaTileEntity.getAirOffset(two+xDir, one, zDir-one) || !aBaseMetaTileEntity.getAirOffset(two+xDir, two, zDir-one)) {
            return false;
        }

        if (!aBaseMetaTileEntity.getAirOffset(xDir-two, one, one+zDir) || !aBaseMetaTileEntity.getAirOffset(xDir-two, two, one+zDir)) {
            return false;
        }
        if (!aBaseMetaTileEntity.getAirOffset(xDir-two, one, zDir-one) || !aBaseMetaTileEntity.getAirOffset(xDir-two, two, zDir-one)) {
            return false;
        }

        if (!aBaseMetaTileEntity.getAirOffset(one+xDir, one, two+zDir) || !aBaseMetaTileEntity.getAirOffset(one+xDir, two, two+zDir)) {
            return false;
        }
        if (!aBaseMetaTileEntity.getAirOffset(xDir-one, one, two+zDir) || !aBaseMetaTileEntity.getAirOffset(xDir-one, two, two+zDir)) {
            return false;
        }

        if (!aBaseMetaTileEntity.getAirOffset(one+xDir, one, zDir-two) || !aBaseMetaTileEntity.getAirOffset(one+xDir, two, zDir-two)) {
            return false;
        }
        if (!aBaseMetaTileEntity.getAirOffset(xDir-one, one, zDir-two) || !aBaseMetaTileEntity.getAirOffset(xDir-one, two, zDir-two)) {
            return false;
        }

        //air check and top casing check done

        //muffler check
        mMufflerHatches.clear();
        if (!tryAddMufflerOrCasing(aBaseMetaTileEntity, one + xDir, one, zDir)) return false;
        if (!tryAddMufflerOrCasing(aBaseMetaTileEntity, one + xDir, two, zDir)) return false;
        if (!tryAddMufflerOrCasing(aBaseMetaTileEntity, xDir - one, one, zDir)) return false;
        if (!tryAddMufflerOrCasing(aBaseMetaTileEntity, xDir - one, two, zDir)) return false;
        if (!tryAddMufflerOrCasing(aBaseMetaTileEntity, xDir, one, one + zDir)) return false;
        if (!tryAddMufflerOrCasing(aBaseMetaTileEntity, xDir, two, one + zDir)) return false;
        if (!tryAddMufflerOrCasing(aBaseMetaTileEntity, xDir, one, zDir - one)) return false;
        if (!tryAddMufflerOrCasing(aBaseMetaTileEntity, xDir, two, zDir - one)) return false;

        if(mMufflerHatches.isEmpty()) {
            return false;
        }
        //muffler check done
        //pipe casing check
        if (!isPipeCasing(aBaseMetaTileEntity, one + xDir, one, one + zDir)) return false;
        if (!isPipeCasing(aBaseMetaTileEntity, one + xDir, two, one + zDir)) return false;
        if (!isPipeCasing(aBaseMetaTileEntity, xDir - one, one, one + zDir)) return false;
        if (!isPipeCasing(aBaseMetaTileEntity, xDir - one, two, one + zDir)) return false;
        if (!isPipeCasing(aBaseMetaTileEntity, one + xDir, one, zDir - one)) return false;
        if (!isPipeCasing(aBaseMetaTileEntity, one + xDir, two, zDir - one)) return false;
        if (!isPipeCasing(aBaseMetaTileEntity, xDir - one, one, zDir - one)) return false;
        if (!isPipeCasing(aBaseMetaTileEntity, xDir - one, two, zDir - one)) return false;
        //pipe casing check done
        //bottom casing
        for (int i = -one; i < two; i++) {
            for (int j = -one; j < two; j++) {
                if (xDir + i == 0 && zDir + j == 0)
                    // exclusion of the controller block
                    continue;
                IGregTechTileEntity tTileEntity = aBaseMetaTileEntity.getIGregTechTileEntityOffset(xDir + i, 0, zDir + j);
                if (!addMaintenanceToMachineList(tTileEntity, getCasingIndex()) &&
                        !addInputToMachineList(tTileEntity, getCasingIndex()) &&
                        !addOutputToMachineList(tTileEntity, getCasingIndex()) &&
                        !addEnergyInputToMachineList(tTileEntity, getCasingIndex()) &&
                        !isCasing(aBaseMetaTileEntity, xDir + i, 0, zDir + j)) {
                    return false;
                }
            }
        }
        //bottom casing done
        return true;
    }

    private boolean isPipeCasing(IGregTechTileEntity aBaseMetaTileEntity, int aOffsetX, int aOffsetY, int aOffsetZ) {
        return aBaseMetaTileEntity.getBlockOffset(aOffsetX, aOffsetY, aOffsetZ) == GT_Container_CasingsNH.sBlockCasingsNH &&
                aBaseMetaTileEntity.getMetaIDOffset(aOffsetX, aOffsetY, aOffsetZ) == getPipeMeta();
    }

    public int getPipeMeta(){
        if (multiTier == 0 || multiTier == 1){
            return 1;
        }
        else if (multiTier == 2){
            return 4;
        }
        else{
            return 6;
        }
    }

    private boolean tryAddMufflerOrCasing(IGregTechTileEntity aBaseMetaTileEntity, int aOffsetX, int aOffsetY, int aOffsetZ) {
        if (addMufflerToMachineList(aBaseMetaTileEntity.getIGregTechTileEntityOffset(aOffsetX, aOffsetY, aOffsetZ), getCasingIndex()))
            return true;
        return isCasing(aBaseMetaTileEntity, aOffsetX, aOffsetY, aOffsetZ);
    }

    private boolean isCasing(IGregTechTileEntity aBaseMetaTileEntity, int aOffsetX, int aOffsetY, int aOffsetZ) {
        return aBaseMetaTileEntity.getBlockOffset(aOffsetX, aOffsetY, aOffsetZ) == GT_Container_CasingsNH.sBlockCasingsNH &&
                aBaseMetaTileEntity.getMetaIDOffset(aOffsetX, aOffsetY, aOffsetZ) == getCasingMeta();
    }

    public int getCasingMeta(){
        if (multiTier==0 || multiTier==1) {
            return 0;
        }
        else if(multiTier==2){
            return 3;
        }
        else{
            return 5;
        }
    }

    @Override
    public int getMaxEfficiency(ItemStack aStack) {
        return 10000;
    }

    @Override
    public void onPreTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick){
        if (chunkList == null){
            if (size == 0){ // here in case it's not set by NBT loading
                size = 2*multiTier+1;
            }
            populateChunkList();
        }
        super.onPreTick(aBaseMetaTileEntity, aTick);
    }
    
    public int getTotalPollution(){
        int pollutionAmount = 0;
        int index = 0;
        for (int[] chunkCoords : chunkList){
            int addition = GT_Pollution.getPollution(getBaseMetaTileEntity().getWorld(), chunkCoords[0], chunkCoords[1]);
            pollutionAmount += addition;
            index+=1;
        }
        return pollutionAmount;
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
         if (aTick % 200L == 0L){
            //refresh casing on state change
            int Xpos = aBaseMetaTileEntity.getXCoord() + ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()).offsetX;
            int Ypos = aBaseMetaTileEntity.getYCoord()+3;
            int Zpos = aBaseMetaTileEntity.getZCoord() + ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()).offsetZ;
            try {
                aBaseMetaTileEntity.getWorld().markBlockRangeForRenderUpdate(Xpos - 1, Ypos, Zpos - 1, Xpos + 1, Ypos, Zpos + 1);
            } catch (Exception ignored) {}
        }
        super.onPostTick(aBaseMetaTileEntity, aTick);
    }

    @Override
    public int getDamageToComponent(ItemStack aStack) {
        try{
            if(isCorrectMachinePart(aStack) && hasPollution) { // no pollution no damage
                return getBaseMetaTileEntity().getRandomNumber(2); // expected to be 0.5 damage in long term
            }
        }catch (Exception e){/**/}
        return 0;
    }

    @Override
    public boolean explodesOnComponentBreak(ItemStack aStack) {
        return false;
    }

    @Override
    public void onScrewdriverRightClick(byte aSide, EntityPlayer aPlayer, float aX, float aY, float aZ){
        if (!aPlayer.isSneaking()){ // change mode on sneak
            mode = mode==1 ? 0 : 1;
            if (mode==0){
                chunkIndex = 0;
                PlayerChatHelper.SendInfo(aPlayer, "Electric air filter now running in normal mode");
            }
            else{
                PlayerChatHelper.SendInfo(aPlayer, "Electric air filter now running in random mode");
            }
        }else{ // change radius on sneak
            if (size==1){
                size = 2*multiTier+1;
            }
            else{
                size -= 2; // always get odd number
            }
            chunkIndex = 0;
            PlayerChatHelper.SendInfo(aPlayer, "Electric air filter is now working in a "+size+"x"+size+" area");
            int x = (this.getBaseMetaTileEntity().getXCoord()) >> 4; // xcoord
            int z = (this.getBaseMetaTileEntity().getZCoord()) >> 4; // zcoord
            populateChunkList();
            for (int i =0; i < chunkList.length; i++) {
                PlayerChatHelper.SendInfo(aPlayer,"chunk n°"+i+" X:"+chunkList[i][0]+" Z:"+chunkList[i][1]);
            }

        }
    }

    @Override
    public String[] getInfoData() {
        return new String[]{
                "Progress:",
                EnumChatFormatting.GREEN + Integer.toString(mProgresstime/20) + EnumChatFormatting.RESET +" s / "+
                        EnumChatFormatting.YELLOW + mMaxProgresstime / 20 + EnumChatFormatting.RESET +" s",
                "Stored Energy:",
                EnumChatFormatting.GREEN + Long.toString(getBaseMetaTileEntity().getStoredEU()) + EnumChatFormatting.RESET +" EU / "+
                        EnumChatFormatting.YELLOW + getBaseMetaTileEntity().getEUCapacity() + EnumChatFormatting.RESET +" EU",
                "Probably uses: "+
                        // negative EU triggers special EU consumption behavior. however it does not produce power.
                        EnumChatFormatting.RED + Math.abs(mEUt) + EnumChatFormatting.RESET + " EU/t",
                "Max Energy Income: "+
                        EnumChatFormatting.YELLOW+ getMaxInputVoltage() +EnumChatFormatting.RESET+ " EU/t(*2A) Tier: "+
                        EnumChatFormatting.YELLOW+VN[GT_Utility.getTier(getMaxInputVoltage())]+ EnumChatFormatting.RESET,
                "Problems: "+
                        EnumChatFormatting.RED+ (getIdealStatus() - getRepairStatus())+EnumChatFormatting.RESET+
                        " Efficiency: "+
                        EnumChatFormatting.YELLOW+ mEfficiency / 100.0F +EnumChatFormatting.RESET + " %",
                "Pollution reduction: "+ EnumChatFormatting.GREEN + mPollutionReductionWholeCycle/mMaxProgresstime + EnumChatFormatting.RESET+" gibbl/t"
        };
    }
}

