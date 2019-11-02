package com.dreammaster.bartworksHandler;

import bloodasp.galacticgreg.bartworks.BW_Worldgen_Ore_SmallOre_Space;

import static com.github.bartimaeusnek.bartworks.system.material.WerkstoffLoader.*;

public class BW_New_Ores_Loader implements Runnable {

    @Override
    public void run() {
        new BW_Worldgen_Ore_SmallOre_Space("Platinum",true,20,80,8, PTMetallicPowder.getmID(),PTMetallicPowder);
        new BW_Worldgen_Ore_SmallOre_Space("Osmium",true,10,30,8, IrOsLeachResidue.getmID(),IrOsLeachResidue);
        new BW_Worldgen_Ore_SmallOre_Space("Iridium",true,20,40,8, IrLeachResidue.getmID(),IrLeachResidue);
        new BW_Worldgen_Ore_SmallOre_Space("Rhodium",true,30,50,8, CrudeRhMetall.getmID(),CrudeRhMetall);
        new BW_Worldgen_Ore_SmallOre_Space("Ruthenium",true,15,45,8, LeachResidue.getmID(),LeachResidue);
        new BW_Worldgen_Ore_SmallOre_Space("Palladium",true,40,60,8, PDMetallicPowder.getmID(),PDMetallicPowder);
        new BW_Worldgen_Ore_SmallOre_Space("Arsenopyrite",true,10,70,8, Arsenopyrite.getmID(),Arsenopyrite);
    }
}
