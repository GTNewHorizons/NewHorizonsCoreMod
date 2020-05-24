package com.dreammaster.bartworksHandler;

import com.dreammaster.gthandler.CustomItemList;
import gregtech.api.enums.GT_Values;

import static com.github.bartimaeusnek.bartworks.system.material.WerkstoffLoader.*;
import static gregtech.api.enums.OrePrefixes.*;

public class BW_Recipe_Loader implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addImplosionRecipe(CustomItemList.HeavyDutyAlloyIngotT4.get(1L), 32, CustomItemList.HeavyDutyPlateTier4.get(1L), Ruridit.get(dustTiny,4));
    }
}
