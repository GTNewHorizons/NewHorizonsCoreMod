package com.dreammaster.bartworksHandler;

import static com.github.bartimaeusnek.bartworks.system.material.WerkstoffLoader.Ruridit;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.OrePrefixes.bolt;
import static gregtech.api.enums.OrePrefixes.dustTiny;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_ModHandler;

public class BW_Recipe_Loader implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addImplosionRecipe(
                CustomItemList.HeavyDutyAlloyIngotT4.get(1L),
                32,
                CustomItemList.HeavyDutyPlateTier4.get(1L),
                Ruridit.get(dustTiny, 4));
        GT_Values.RA.addAssemblylineRecipe(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1L, 0),
                2500,
                new ItemStack[] { GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1L, 0),
                        CustomItemList.IceCompressedPlate.get(3L), CustomItemList.IceCompressedPlate.get(3L),
                        Ruridit.get(bolt, 4) },
                new FluidStack[] { FluidRegistry.getFluidStack("molten.indalloy140", 36) },
                CustomItemList.HeavyDutyAlloyIngotT4.get(1L),
                300,
                30720);
    }
}
