package com.dreammaster.bartworksHandler;

import com.github.bartimaeusnek.bartworks.API.VoidMinerDropAdder;
import com.github.bartimaeusnek.bartworks.API.WerkstoffAPI;
import com.github.bartimaeusnek.bartworks.system.material.Werkstoff;

import gregtech.api.enums.Materials;
import gregtech.api.interfaces.ISubTagContainer;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class BartWorksMaterials {

    public static Materials getBartWorksMaterialByVarName(String name) {
        Materials materials = Materials._NULL;
        try {
            materials = WerkstoffAPI.getWerkstoff(name).getBridgeMaterial();
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
        return materials;
    }

    public static Materials getBartWorksMaterialByODName(String name) {
        return Werkstoff.werkstoffHashSet.stream().filter(e -> e.getVarName().equals(name)).findFirst().map(Werkstoff::getBridgeMaterial).orElse(Materials._NULL);
    }

    public static Materials getBartWorksMaterialByIGNName(String name) {
        return Optional.ofNullable(Werkstoff.werkstoffNameHashMap.get(name)).map(Werkstoff::getBridgeMaterial).orElse(Materials._NULL);
    }

    public static Materials getBartWorksMaterialByID(int id) {
        return Optional.ofNullable(Werkstoff.werkstoffHashMap.get((short) id)).map(Werkstoff::getBridgeMaterial).orElse(Materials._NULL);
    }

    public static void addVoidMinerDropsToDimension(int dimID, ISubTagContainer material, float chance){
        try {
            VoidMinerDropAdder.addDropsToDim(dimID, material, chance);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}