package com.dreammaster.bartworksHandler;

import java.util.Optional;

import bartworks.API.VoidMinerDropAdder;
import bartworks.API.WerkstoffAPI;
import bartworks.system.material.Werkstoff;
import gregtech.api.enums.Materials;
import gregtech.api.interfaces.ISubTagContainer;

public class BartWorksMaterials {

    @Deprecated
    public static Materials getBartWorksMaterialByVarName(String name) {
        Materials materials = Materials._NULL;
        try {
            materials = WerkstoffAPI.getWerkstoff(name).getBridgeMaterial();
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
        return materials;
    }

    @Deprecated
    public static Materials getBartWorksMaterialByODName(String name) {
        return Werkstoff.werkstoffHashSet.stream().filter(e -> e.getVarName().equals(name)).findFirst()
                .map(Werkstoff::getBridgeMaterial).orElse(Materials._NULL);
    }

    @Deprecated
    public static Materials getBartWorksMaterialByIGNName(String name) {
        return Optional.ofNullable(Werkstoff.werkstoffNameHashMap.get(name)).map(Werkstoff::getBridgeMaterial)
                .orElse(Materials._NULL);
    }

    @Deprecated
    public static Materials getBartWorksMaterialByID(int id) {
        return Optional.ofNullable(Werkstoff.werkstoffHashMap.get((short) id)).map(Werkstoff::getBridgeMaterial)
                .orElse(Materials._NULL);
    }

    public static void addVoidMinerDropsToDimension(int dimID, ISubTagContainer material, float chance) {
        VoidMinerDropAdder.addDropsToDim(dimID, material, chance);
    }
}
