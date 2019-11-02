package com.dreammaster.bartworksHandler;

import bloodasp.galacticgreg.bartworks.BW_Worldgen_Ore_SmallOre_Space;

import static com.github.bartimaeusnek.bartworks.system.material.WerkstoffLoader.*;

public class BW_New_Ores_Loader implements Runnable {

    @Override
    public void run() {
        new BW_Worldgen_Ore_SmallOre_Space("Platinum",true,0,250,120,PTMetallicPowder.getmID(),PTMetallicPowder);
        new BW_Worldgen_Ore_SmallOre_Space("Osmium",true,0,250,120, IrOsLeachResidue.getmID(),IrOsLeachResidue);
        new BW_Worldgen_Ore_SmallOre_Space("Iridium",true,0,250,120,IrLeachResidue.getmID(),IrLeachResidue);
        new BW_Worldgen_Ore_SmallOre_Space("Rhodium",true,0,250,120,CrudeRhMetall.getmID(),CrudeRhMetall);
        new BW_Worldgen_Ore_SmallOre_Space("Ruthenium",true,0,250,120,LeachResidue.getmID(),LeachResidue);
        new BW_Worldgen_Ore_SmallOre_Space("Palladium",true,0,250,120,PDMetallicPowder.getmID(),PDMetallicPowder);

        new BW_Worldgen_Ore_SmallOre_Space("Arsenopyrite",true,0,250,120,Arsenopyrite.getmID(),Arsenopyrite);
    }
}
