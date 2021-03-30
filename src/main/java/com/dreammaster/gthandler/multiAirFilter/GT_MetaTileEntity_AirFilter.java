package com.dreammaster.gthandler.multiAirFilter;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.gthandler.casings.GT_Container_CasingsNH;
import gregtech.api.enums.Textures;
import gregtech.api.gui.GT_GUIContainer_MultiMachine;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.items.GT_MetaGenerated_Tool;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Muffler;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_MultiBlockBase;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.api.util.GT_Multiblock_Tooltip_Builder;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;
import gregtech.common.GT_Pollution;
import gregtech.common.items.GT_MetaGenerated_Tool_01;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.Arrays;

import org.lwjgl.input.Keyboard;

import static gregtech.api.enums.GT_Values.V;
import static gregtech.api.enums.GT_Values.VN;
import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by danie_000 on 03.10.2016.
 */
public class GT_MetaTileEntity_AirFilter extends GT_MetaTileEntity_MultiBlockBase {
    protected int mPollutionReduction=0;
    protected int baseEff = 2500;
    protected boolean hasPollution=false;
    static final GT_Recipe tRecipe= new GT_Recipe(
            new ItemStack[]{CustomItemList.AdsorptionFilter.get(1L, new Object())},
            new ItemStack[]{CustomItemList.AdsorptionFilterDirty.get(1L,new Object())},
            null, null, null, null, 1, 1, 0);

    public GT_MetaTileEntity_AirFilter(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public GT_MetaTileEntity_AirFilter(String aName) {
        super(aName);
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_MetaTileEntity_AirFilter(mName);
    }

    @Override
    public String[] getDescription() {
    	final GT_Multiblock_Tooltip_Builder tt = new GT_Multiblock_Tooltip_Builder();
		tt.addMachineType("Air Filter")
		.addInfo("Controller block for the Electric Air Filter")
        .addInfo("Add Turbine in controller to increase efficiency")
        .addInfo("Add Air Filter in input to double efficiency")
		.addInfo("Machine tier * 2 = Maximum effective Muffler tier")
		.addInfo("Features Hysteresis control (tm)")
		.addInfo("Each muffler reduce pollution by 30 * TurbineEfficiency * EffectiveMufflerTier every second")
		.addSeparator()
		.beginStructureBlock(3, 4, 3, true)
		.addController("Front bottom")
		.addOtherStructurePart("Air Filter Turbine Casing", "Top and bottom")
		.addOtherStructurePart("Air Filter Vent Casing", "Corners of the middle 2 layers")
		.addOtherStructurePart("Muffler Hatch Or Air Filter Vent Casing", "8 in the middle layers")
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
            return new ITexture[]{Textures.BlockIcons.CASING_BLOCKS[57], new GT_RenderedTexture(aActive ? Textures.BlockIcons.OVERLAY_FRONT_DIESEL_ENGINE_ACTIVE : Textures.BlockIcons.OVERLAY_FRONT_DIESEL_ENGINE)};
        }
        return new ITexture[]{Textures.BlockIcons.CASING_BLOCKS[57]};
    }

    @Override
    public Object getClientGUI(int aID, InventoryPlayer aPlayerInventory, IGregTechTileEntity aBaseMetaTileEntity) {
        return new GT_GUIContainer_MultiMachine(aPlayerInventory, aBaseMetaTileEntity, getLocalName(), "ElectricAirFilter.png");
    }

    @Override
    public boolean isCorrectMachinePart(ItemStack aStack) {
        return true;
    }

    @Override
    public boolean isFacingValid(byte aFacing) {
        return aFacing > 1;
    }

    private static boolean isAnyTurbine(ItemStack aStack) {
        return aStack != null && aStack.getItem() instanceof GT_MetaGenerated_Tool_01 &&
                ((GT_MetaGenerated_Tool) aStack.getItem()).getToolStats(aStack).getSpeedMultiplier() > 0 &&
                GT_MetaGenerated_Tool.getPrimaryMaterial(aStack).mToolSpeed > 0 &&
                aStack.getItemDamage() > 169 && aStack.getItemDamage() < 180;
    }

    @Override
    public boolean checkRecipe(ItemStack aStack){
        mEfficiencyIncrease = 10000;
        mEfficiency = 10000 - (getIdealStatus() - getRepairStatus()) * 1000;
        mPollutionReduction = 0;
        mMaxProgresstime = 200;
        mEUt=-32;
        if(!hasPollution) {
            return true;
        }

        try{
            if (isAnyTurbine(aStack)) {
                baseEff = GT_Utility.safeInt((long) ((50.0F
                        + 10.0F * ((GT_MetaGenerated_Tool) aStack.getItem()).getToolCombatDamage(aStack)) * 100));
            } else {
                baseEff = 2500;
            }
        }catch (Exception e){
            baseEff = 2500;
        }

        long tVoltage = getMaxInputVoltage();
        byte tTier = (byte) max(1, GT_Utility.getTier(tVoltage));

        calculateOverclockedNessMulti(GT_Utility.safeInt(tVoltage-(tVoltage>>2)), 200, 1, tVoltage);
        //In case recipe is too OP for that machine
        if (mEUt == Integer.MAX_VALUE - 1) {
            return false;
        }
        if (mEUt > 0) {
            mEUt = -mEUt;
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

        for (GT_MetaTileEntity_Hatch_Muffler tHatch : mMufflerHatches) {
            if (isValidMetaTileEntity(tHatch)) {
                mPollutionReduction+= min(tTier*2,tHatch.mTier)*300;//reduction per muffler tier
            }
        }

        ItemStack[] tInputs = Arrays.copyOfRange(tInputList.toArray(new ItemStack[0]), 0, 2);
        if (!tInputList.isEmpty()) {
            if (tRecipe.isRecipeInputEqual(true, null, tInputs)) {
                mPollutionReduction*=2;//bonus for filter
                mOutputItems = new ItemStack[]{tRecipe.getOutput(0)};
                updateSlots();
            }
        }

        mPollutionReduction=GT_Utility.safeInt((long)mPollutionReduction*baseEff)/10000;
        mPollutionReduction=GT_Utility.safeInt((long)mPollutionReduction*mEfficiency/10000);

        GT_Pollution.addPollution(getBaseMetaTileEntity(), -mPollutionReduction);
        if (isAnyTurbine(aStack)) {
            ((GT_MetaGenerated_Tool) aStack.getItem()).doDamage(aStack, 10L * (long) min(-mEUt / (float) damageFactorLow, Math.pow(-mEUt, damageFactorHigh)));
        }
        return true;
    }

    @Override
    protected void calculateOverclockedNessMulti(int aEUt, int aDuration, int mAmperage, long maxInputVoltage) {
        byte mTier=(byte) max(0,GT_Utility.getTier(maxInputVoltage));
        mMaxProgresstime=aDuration;
        if(mTier==0){
            //Long time calculation
            mEUt=aEUt/4;
        }else{
            //Long EUt calculation
            long xEUt=aEUt;
            //Isnt too low EUt check?
            long tempEUt = max(xEUt, V[1]);

            while (tempEUt <= V[mTier -1] * mAmperage) {
                tempEUt *= 4;//this actually controls overclocking
                xEUt *= 4;//this is effect of overclocking
            }
            if(xEUt>Integer.MAX_VALUE-1){
                mEUt = Integer.MAX_VALUE-1;
                mMaxProgresstime = Integer.MAX_VALUE-1;
            }else{
                mEUt = (int)xEUt;
                mEUt = mEUt == 0 ? 1 : mEUt;
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
                if (!addMaintenanceToMachineList(tTileEntity, 57) &&
                        !addInputToMachineList(tTileEntity, 57) &&
                        !addOutputToMachineList(tTileEntity, 57) &&
                        !addEnergyInputToMachineList(tTileEntity, 57) &&
                        !isCasing(aBaseMetaTileEntity, xDir + i, 0, zDir + j)) {
                    return false;
                }
            }
        }
        //bottom casing done
        return true;
    }

    private boolean isPipeCasing(IGregTechTileEntity aBaseMetaTileEntity, int aOffsetX, int aOffsetY, int aOffsetZ) {
        return aBaseMetaTileEntity.getBlockOffset(aOffsetX, aOffsetY, aOffsetZ) == GT_Container_CasingsNH.sBlockCasingsNH && aBaseMetaTileEntity.getMetaIDOffset(aOffsetX, aOffsetY, aOffsetZ) == 1;
    }

    private boolean tryAddMufflerOrCasing(IGregTechTileEntity aBaseMetaTileEntity, int aOffsetX, int aOffsetY, int aOffsetZ) {
        if (addMufflerToMachineList(aBaseMetaTileEntity.getIGregTechTileEntityOffset(aOffsetX, aOffsetY, aOffsetZ), 57))
            return true;
        return isCasing(aBaseMetaTileEntity, aOffsetX, aOffsetY, aOffsetZ);
    }

    private boolean isCasing(IGregTechTileEntity aBaseMetaTileEntity, int aOffsetX, int aOffsetY, int aOffsetZ) {
        return aBaseMetaTileEntity.getBlockOffset(aOffsetX, aOffsetY, aOffsetZ) == GT_Container_CasingsNH.sBlockCasingsNH
                && aBaseMetaTileEntity.getMetaIDOffset(aOffsetX, aOffsetY, aOffsetZ) == 0;
    }

    @Override
    public int getMaxEfficiency(ItemStack aStack) {
        return 10000;
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        if (aBaseMetaTileEntity.isServerSide()) {
            if(mMachine && aTick % 200L == 0L){
                //check for pollution
                int pollution=GT_Pollution.getPollution(getBaseMetaTileEntity());
                hasPollution = pollution>=10000||(hasPollution&&pollution>=1000);//HYSTERESIS :O !!! (trust me i am engineer)
            }
        }else if (aTick % 200L == 0L){
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
    public int getPollutionPerTick(ItemStack aStack) {
        return 0;//set to zero since it will directly affect pollution in chunk
    }

    @Override
    public int getDamageToComponent(ItemStack aStack) {
        try{
            if(aStack.getItem() instanceof GT_MetaGenerated_Tool_01 &&
                    ((GT_MetaGenerated_Tool) aStack.getItem()).getToolStats(aStack).getSpeedMultiplier()>0 &&
                    ((GT_MetaGenerated_Tool) aStack.getItem()).getPrimaryMaterial(aStack).mToolSpeed>0 ) {
                return 10;
            }
        }catch (Exception e){/**/}
        return 0;
    }

    public int getAmountOfOutputs() {
        return 1;
    }

    @Override
    public boolean explodesOnComponentBreak(ItemStack aStack) {
        return false;
    }

    @Override
    public String[] getInfoData() {
        return new String[]{
                "Progress:",
                EnumChatFormatting.GREEN + Integer.toString(mProgresstime/20) + EnumChatFormatting.RESET +" s / "+
                        EnumChatFormatting.YELLOW + Integer.toString(mMaxProgresstime/20) + EnumChatFormatting.RESET +" s",
                "Stored Energy:",
                EnumChatFormatting.GREEN + Long.toString(getBaseMetaTileEntity().getStoredEU()) + EnumChatFormatting.RESET +" EU / "+
                        EnumChatFormatting.YELLOW + Long.toString(getBaseMetaTileEntity().getEUCapacity()) + EnumChatFormatting.RESET +" EU",
                "Probably uses: "+
                        EnumChatFormatting.RED + Integer.toString(mEUt) + EnumChatFormatting.RESET + " EU/t",
                "Max Energy Income: "+
                        EnumChatFormatting.YELLOW+Long.toString(getMaxInputVoltage())+EnumChatFormatting.RESET+ " EU/t(*2A) Tier: "+
                        EnumChatFormatting.YELLOW+VN[GT_Utility.getTier(getMaxInputVoltage())]+ EnumChatFormatting.RESET,
                "Problems: "+
                        EnumChatFormatting.RED+ (getIdealStatus() - getRepairStatus())+EnumChatFormatting.RESET+
                        " Efficiency: "+
                        EnumChatFormatting.YELLOW+Float.toString(mEfficiency / 100.0F)+EnumChatFormatting.RESET + " %",
                "Pollution reduction: "+ EnumChatFormatting.GREEN + mPollutionReduction/10 + EnumChatFormatting.RESET+" gibbl/s"
        };
    }
}
