package com.dreammaster.bartworksHandler;


import com.github.bartimaeusnek.bartworks.system.material.Werkstoff;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.interfaces.ISubTagContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.dreammaster.bartworksHandler.BartWorksMaterials.addVoidMinerDropsToDimension;
import static com.dreammaster.main.MainRegistry.CoreConfig;
import static gregtech.api.enums.Materials.values;

public class VoidMinerLoader {
    protected static final Logger log = LogManager.getLogger(VoidMinerLoader.class);

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
        // Map of material name to Materials.
        HashMap<String, Materials> materials =
                Arrays.stream(values())
                        .filter(VoidMinerLoader::hasOres)
                        .collect(Collectors.toMap(Materials::toString, Function.identity(), VoidMinerLoader::keyConflict, HashMap::new));

        // Map of werkstoff name to Werkstoff.
        HashMap<String, Werkstoff> werkstoff =
                Werkstoff.werkstoffHashSet.stream()
                        .filter(VoidMinerLoader::hasOres)
                        .collect(Collectors.toMap(Werkstoff::getDefaultName, Function.identity(), VoidMinerLoader::keyConflict, HashMap::new));

        if (CoreConfig.DebugPrintAllMaterials) {
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAllMaterials]: Begin all materials list");
            log.info("==========");
            materials.keySet().stream().sorted().forEach(name -> log.info("  " + name));
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAllMaterials]: End all materials list");
            log.info("==========");
        }

        if (CoreConfig.DebugPrintAllWerkstoff) {
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAllWerkstoff]: Begin all werkstoff list");
            log.info("==========");
            werkstoff.keySet().stream().sorted().forEach(name -> log.info("  " + name));
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAllWerkstoff]: End all werkstoff list");
            log.info("==========");
        }

        Arrays.stream(CoreConfig.BlacklistedMaterials).forEach(materials::remove);
        Arrays.stream(CoreConfig.BlacklistedWerkstoff).forEach(werkstoff::remove);

        if (CoreConfig.DebugPrintMaterials) {
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintMaterials]: Begin added materials list");
            log.info("==========");
            materials.keySet().stream().sorted().forEach(name -> log.info("  " + name));
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintMaterials]: End added materials list");
            log.info("==========");
        }

        if (CoreConfig.DebugPrintWerkstoff) {
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintWerkstoff]: Begin added werkstoff list");
            log.info("==========");
            werkstoff.keySet().stream().sorted().forEach(name -> log.info("  " + name));
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintWerkstoff]: End added werkstoff list");
            log.info("==========");
        }

        materials.forEach((k, v) -> VoidMinerLoader.addVoidDimerDrops(v));
        werkstoff.forEach((k, v) -> VoidMinerLoader.addVoidDimerDrops(v));
    }

    /** Helper method that gets called when we run into a key conflict when trying to put {@link Materials} or {@link Werkstoff} into a map. */
    private static <T> T keyConflict(T a, T b) {
        throw new IllegalStateException(String.format("Got a name conflict: [%s], [%s]", a, b));
    }
}