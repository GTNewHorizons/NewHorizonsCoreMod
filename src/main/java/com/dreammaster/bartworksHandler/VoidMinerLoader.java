package com.dreammaster.bartworksHandler;


import com.github.bartimaeusnek.bartworks.system.material.Werkstoff;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.interfaces.ISubTagContainer;

import java.util.Arrays;

import static com.dreammaster.bartworksHandler.BartWorksMaterials.addVoidMinerDropsToDimension;
import static gregtech.api.enums.Materials.values;

public class VoidMinerLoader {

    private VoidMinerLoader() {
    }

    private static final int DEEPDARK_ID = 100;

    private static boolean hasOres(Materials materials){
        return (materials.mTypes & 8) != 0;
    }

    private static boolean hasOres(Werkstoff materials){
        return materials.hasItemType(OrePrefixes.ore);
    }

    private static void addVoidDimerDrops(ISubTagContainer materials){
        addVoidMinerDropsToDimension(DEEPDARK_ID, materials, 1f);
    }

    public static void initDeepDark() {
        //1 to filter out _NULL without != material for every entry...
        Arrays.stream(values(), 1, values().length).filter(VoidMinerLoader::hasOres).forEach(VoidMinerLoader::addVoidDimerDrops);
        Werkstoff.werkstoffHashSet.stream().filter(VoidMinerLoader::hasOres).forEach(VoidMinerLoader::addVoidDimerDrops);
    }

}