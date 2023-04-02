package com.dreammaster.gthandler.casings;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.gthandler.multiAirFilter.GT_MetaTileEntity_AirFilterT1;
import com.dreammaster.gthandler.multiAirFilter.GT_MetaTileEntity_AirFilterT2;
import com.dreammaster.gthandler.multiAirFilter.GT_MetaTileEntity_AirFilterT3;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.enums.Dyes;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.objects.GT_CopiedBlockTexture;
import gregtech.api.util.GT_LanguageManager;
import gregtech.common.blocks.GT_Block_Casings_Abstract;
import gregtech.common.blocks.GT_Material_Casings;

/**
 * Created by danie_000 on 03.10.2016.
 */
public class GT_Block_CasingsNH extends GT_Block_Casings_Abstract {

    public static boolean mConnectedMachineTextures = true;

    public GT_Block_CasingsNH() {
        super(GT_Item_CasingsNH.class, "gt.blockcasingsNH", GT_Material_Casings.INSTANCE);
        for (byte b = 0; b < 16; b = (byte) (b + 1)) {
            Textures.BlockIcons.casingTexturePages[8][b + 64] = new GT_CopiedBlockTexture(this, 6, b);
            /* IMPORTANT for block recoloring */
        }
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".0.name", "Air Filter Turbine Casing"); // adding
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".1.name", "Air Filter Vent Casing"); // adding
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".2.name", "Pyrolyse Oven Casing"); // adding
        GT_LanguageManager
                .addStringLocalization(getUnlocalizedName() + ".3.name", "Advanced Air Filter Turbine Casing"); // adding
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".4.name", "Advanced Air Filter Vent Casing"); // adding
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".5.name", "Super Air Filter Turbine Casing"); // adding
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".6.name", "Super Air Filter Vent Casing"); // adding

        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".10.name", "UEV Machine Casing"); // adding
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".11.name", "UIV Machine Casing"); // adding
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".12.name", "UMV Machine Casing"); // adding
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".13.name", "UXV Machine Casing"); // adding
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".14.name", "MAX Machine Casing"); // adding

        CustomItemList.Casing_AirFilter_Turbine_T1.set(new ItemStack(this, 1, 0)); // adding
        CustomItemList.Casing_AirFilter_Vent_T1.set(new ItemStack(this, 1, 1)); // adding
        CustomItemList.Casing_Pyrolyse.set(new ItemStack(this, 1, 2)); // adding
        CustomItemList.Casing_AirFilter_Turbine_T2.set(new ItemStack(this, 1, 3)); // adding
        CustomItemList.Casing_AirFilter_Vent_T2.set(new ItemStack(this, 1, 4)); // adding
        CustomItemList.Casing_AirFilter_Turbine_T3.set(new ItemStack(this, 1, 5)); // adding
        CustomItemList.Casing_AirFilter_Vent_T3.set(new ItemStack(this, 1, 6)); // adding

        CustomItemList.Casing_UEV.set(new ItemStack(this, 1, 10));
        CustomItemList.Casing_UIV.set(new ItemStack(this, 1, 11));
        CustomItemList.Casing_UMV.set(new ItemStack(this, 1, 12));
        CustomItemList.Casing_UXV.set(new ItemStack(this, 1, 13));
        CustomItemList.Casing_MAXV.set(new ItemStack(this, 1, 14));
    }

    @Override
    public void registerBlockIcons(IIconRegister aIconRegister) {
    }

    @Override
    public IIcon getIcon(int aSide, int aMeta) {
        switch (aMeta) {
            case 0:
                return Textures.BlockIcons.MACHINE_CASING_TURBINE.getIcon();
            case 1:
                return Textures.BlockIcons.MACHINE_CASING_PIPE_STEEL.getIcon();
            case 2:
                return Textures.BlockIcons.MACHINE_8V_SIDE.getIcon();
            case 3:
                return Textures.BlockIcons.MACHINE_CASING_STABLE_TITANIUM.getIcon();
            case 4:
                return Textures.BlockIcons.MACHINE_CASING_PIPE_TITANIUM.getIcon();
            case 5:
                return Textures.BlockIcons.MACHINE_CASING_ROBUST_TUNGSTENSTEEL.getIcon();
            case 6:
                return Textures.BlockIcons.MACHINE_CASING_PIPE_TUNGSTENSTEEL.getIcon();
            default:
                if (aSide == 0) {
                    return Textures.BlockIcons.MACHINECASINGS_BOTTOM[aMeta].getIcon();
                }
                if (aSide == 1) {
                    return Textures.BlockIcons.MACHINECASINGS_TOP[aMeta].getIcon();
                }
                return Textures.BlockIcons.MACHINECASINGS_SIDE[aMeta].getIcon();
        }
    }

    private IIcon getTurbineCasing(int meta, int iconIndex, boolean active) {
        switch (meta) {
            case 3:
                return active ? Textures.BlockIcons.TURBINE_ACTIVE2[iconIndex].getIcon()
                        : Textures.BlockIcons.TURBINE2[iconIndex].getIcon();
            case 5:
                return active ? Textures.BlockIcons.TURBINE_ACTIVE3[iconIndex].getIcon()
                        : Textures.BlockIcons.TURBINE3[iconIndex].getIcon();
            default: // 0 or undefined turbine meta casing
                return active ? Textures.BlockIcons.TURBINE_ACTIVE[iconIndex].getIcon()
                        : Textures.BlockIcons.TURBINE[iconIndex].getIcon();
        }
    }

    public boolean isTurbineMeta(int tMeta) {
        return tMeta == 0 || tMeta == 3 || tMeta == 5;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess aWorld, int xCoord, int yCoord, int zCoord, int aSide) {
        int tMeta = aWorld.getBlockMetadata(xCoord, yCoord, zCoord);
        if (!isTurbineMeta(tMeta) && tMeta < 9 || tMeta == 15) {
            return getIcon(aSide, tMeta);
        }
        if (!isTurbineMeta(tMeta) || !mConnectedMachineTextures) {
            return getIcon(aSide, tMeta);
        }
        if (aSide == 1) {
            TileEntity tTileEntity;
            IMetaTileEntity tMetaTileEntity;

            for (int xi = -2; xi <= 2; xi++) {
                for (int zi = -2; zi <= 2; zi++) {
                    if (null != (tTileEntity = aWorld.getTileEntity(xCoord + xi, Math.max(yCoord - 3, 0), zCoord + zi))
                            && tTileEntity instanceof IGregTechTileEntity
                            && null != (tMetaTileEntity = ((IGregTechTileEntity) tTileEntity).getMetaTileEntity())
                            && (tMetaTileEntity instanceof GT_MetaTileEntity_AirFilterT1
                                    || tMetaTileEntity instanceof GT_MetaTileEntity_AirFilterT2
                                    || tMetaTileEntity instanceof GT_MetaTileEntity_AirFilterT3)) {
                        boolean active = false;
                        if (((IGregTechTileEntity) tTileEntity).isActive()) {
                            active = true;
                        }
                        // check for direction and placement and apply the texture
                        switch (((IGregTechTileEntity) tTileEntity).getFrontFacing()) {
                            case 2:
                                if (xi < 2 && xi > -2 && zi < 1) { // if invalid position ignore (aka too far away)
                                    try {
                                        return getTurbineCasing(tMeta, -xi + 1 - zi * 3, active);
                                    } catch (Exception e) {
                                        return getIcon(aSide, tMeta);
                                    }
                                }
                                break;
                            case 3:
                                if (xi < 2 && xi > -2 && zi > -1) {
                                    try {
                                        return getTurbineCasing(tMeta, -xi + 1 + (2 - zi) * 3, active);
                                    } catch (Exception e) {
                                        return getIcon(aSide, tMeta);
                                    }
                                }
                                break;
                            case 4:
                                if (zi < 2 && zi > -2 && xi < 1) {
                                    try {
                                        return getTurbineCasing(tMeta, -xi + (1 - zi) * 3, active);
                                    } catch (Exception e) {
                                        return getIcon(aSide, tMeta);
                                    }
                                }
                                break;
                            case 5:
                                if (zi < 2 && zi > -2 && xi > -1) {
                                    try {
                                        return getTurbineCasing(tMeta, -xi + 2 + (1 - zi) * 3, active);
                                    } catch (Exception e) {
                                        return getIcon(aSide, tMeta);
                                    }
                                }
                        }
                    }
                }
            }
        }
        return getIcon(aSide, tMeta);
    }

    @Override
    public int colorMultiplier(IBlockAccess aWorld, int aX, int aY, int aZ) {
        return aWorld.getBlockMetadata(aX, aY, aZ) <= 9 ? super.colorMultiplier(aWorld, aX, aY, aZ)
                : Dyes.MACHINE_METAL.mRGBa[0] << 16 | Dyes.MACHINE_METAL.mRGBa[1] << 8 | Dyes.MACHINE_METAL.mRGBa[2];
    }
}
