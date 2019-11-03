package com.dreammaster.bartworksHandler;

import bloodasp.galacticgreg.bartworks.BW_Worldgen_Ore_Layer_Space;
import bloodasp.galacticgreg.bartworks.BW_Worldgen_Ore_SmallOre_Space;

import static com.github.bartimaeusnek.bartworks.system.material.WerkstoffLoader.*;
import static gregtech.api.enums.Materials.*;
public class BW_New_Ores_Loader implements Runnable {

    @Override
    public void run() {
        loadSmallOres();
        loadVeins();
    }

    /**
     * Small Ores go in here
     */
    private void loadSmallOres(){
        new BW_Worldgen_Ore_SmallOre_Space("small.Platinum",true,20,80,8, PTMetallicPowder.getmID(),PTMetallicPowder);
        new BW_Worldgen_Ore_SmallOre_Space("small.Osmium",true,10,30,8, IrOsLeachResidue.getmID(),IrOsLeachResidue);
        new BW_Worldgen_Ore_SmallOre_Space("small.Iridium",true,20,40,8, IrLeachResidue.getmID(),IrLeachResidue);
        new BW_Worldgen_Ore_SmallOre_Space("small.Rhodium",true,30,50,8, CrudeRhMetall.getmID(),CrudeRhMetall);
        new BW_Worldgen_Ore_SmallOre_Space("small.Ruthenium",true,15,45,8, LeachResidue.getmID(),LeachResidue);
        new BW_Worldgen_Ore_SmallOre_Space("small.Palladium",true,40,60,8, PDMetallicPowder.getmID(),PDMetallicPowder);
        new BW_Worldgen_Ore_SmallOre_Space("small.Arsenopyrite",true,10,70,8, Arsenopyrite.getmID(),Arsenopyrite);
    }
    /**
     * Ore Veins go in here
     */
    private void loadVeins(){
        new BW_Worldgen_Ore_Layer_Space("mix.mercury",true,20,60,25,3,16, Cinnabar,Terlinguaite,Atheneite,Temagamite);
    }

}
