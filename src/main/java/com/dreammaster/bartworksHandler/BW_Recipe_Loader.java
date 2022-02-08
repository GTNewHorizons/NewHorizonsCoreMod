package com.dreammaster.bartworksHandler;

import com.dreammaster.gthandler.CustomItemList;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_ModHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static com.github.bartimaeusnek.bartworks.system.material.WerkstoffLoader.*;
import static gregtech.api.enums.OrePrefixes.*;

public class BW_Recipe_Loader implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addImplosionRecipe(CustomItemList.HeavyDutyAlloyIngotT4.get(1L), 32, CustomItemList.HeavyDutyPlateTier4.get(1L), Ruridit.get(dustTiny,4));
        GT_Values.RA.addAssemblylineRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 0),
                2500,
                new ItemStack[]{
                        GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 0),
                        CustomItemList.IceCompressedPlate.get(3L),
                        CustomItemList.IceCompressedPlate.get(3L),
                        Ruridit.get(bolt, 4)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(36)
                },
                CustomItemList.HeavyDutyAlloyIngotT4.get(1L), 300, 30720
        );
    }
}
