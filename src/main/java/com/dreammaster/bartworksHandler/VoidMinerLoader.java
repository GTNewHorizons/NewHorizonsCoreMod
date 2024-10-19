package com.dreammaster.bartworksHandler;

import static com.dreammaster.bartworksHandler.BartWorksMaterials.addVoidMinerDropsToDimension;
import static com.dreammaster.main.MainRegistry.CoreConfig;
import static gregtech.api.enums.Materials.values;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Maps;

import bartworks.system.material.Werkstoff;
import bwcrossmod.galacticgreg.VoidMinerUtility;
import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.interfaces.ISubTagContainer;
import gtPlusPlus.core.material.Material;
import gtPlusPlus.everglades.gen.gt.WorldGen_GT_Ore_Layer;
import gtPlusPlus.everglades.gen.gt.WorldGen_Ores;

public class VoidMinerLoader {

    protected static final Logger log = LogManager.getLogger(VoidMinerLoader.class);

    private VoidMinerLoader() {}

    private static final int DEEPDARK_ID = 100;

    private static boolean hasOres(Materials materials) {
        return ((materials.mTypes & 8) != 0) && (materials.mMetaItemSubID > 0) && materials.mHasParentMod;
    }

    private static boolean hasOres(Werkstoff werkstoff) {
        return werkstoff.hasItemType(OrePrefixes.ore) && (werkstoff.getmID() > 0);
    }

    private static void addVoidDimerDrops(ISubTagContainer materials, float weight) {
        if (weight <= 0f) {
            return;
        }
        addVoidMinerDropsToDimension(DEEPDARK_ID, materials, weight);
    }

    private static void addVoidDimerDrops(Material material, float weight) {
        if (weight <= 0f) {
            return;
        }
        VoidMinerUtility.addBlockToDimensionList(DEEPDARK_ID, material.getOreBlock(1), 0, weight);
    }

    public static void initDeepDark() {
        // Map of material name to Materials.
        Map<String, Materials> materials = Arrays.stream(values()).filter(VoidMinerLoader::hasOres).collect(
                Collectors.toMap(Materials::toString, Function.identity(), VoidMinerLoader::keyConflict, HashMap::new));

        // Map of werkstoff name to Werkstoff.
        Map<String, Werkstoff> werkstoff = Werkstoff.werkstoffHashSet.stream().filter(VoidMinerLoader::hasOres).collect(
                Collectors.toMap(
                        Werkstoff::getDefaultName,
                        Function.identity(),
                        VoidMinerLoader::keyConflict,
                        HashMap::new));

        // Map of GT++ material name to GT++ Material.
        Map<String, Material> GTPPMaterials = new HashMap<>();
        for (WorldGen_GT_Ore_Layer t : WorldGen_Ores.validOreveins.values()) {
            GTPPMaterials.put(t.mPrimary.getLocalizedName(), t.mPrimary);
            GTPPMaterials.put(t.mSecondary.getLocalizedName(), t.mSecondary);
            GTPPMaterials.put(t.mBetween.getLocalizedName(), t.mBetween);
            GTPPMaterials.put(t.mSporadic.getLocalizedName(), t.mSporadic);
        }

        if (CoreConfig.DebugPrintAllOres) {
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAllOres]: Begin all materials list");
            log.info("==========");
            materials.keySet().stream().sorted().forEach(name -> log.info("  " + name));
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAllOres]: End all materials list");
            log.info("==========");

            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAllOres]: Begin all werkstoff list");
            log.info("==========");
            werkstoff.keySet().stream().sorted().forEach(name -> log.info("  " + name));
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAllOres]: End all werkstoff list");
            log.info("==========");

            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAllOres]: Begin all GT++ material list");
            log.info("==========");
            GTPPMaterials.keySet().stream().sorted().forEach(name -> log.info("  " + name));
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAllOres]: End all GT++ material list");
            log.info("==========");
        }

        // Map of material name to weight, prefilled with 1.
        Map<String, Float> materialWeights = materials.keySet().stream()
                .collect(Collectors.toMap(Function.identity(), k -> 1f, VoidMinerLoader::keyConflict, HashMap::new));

        // Map of werkstoff name to weight, prefilled with 1.
        Map<String, Float> werkstoffWeights = werkstoff.keySet().stream()
                .collect(Collectors.toMap(Function.identity(), k -> 1f, VoidMinerLoader::keyConflict, HashMap::new));

        // Map of werkstoff name to weight, prefilled with 1.
        Map<String, Float> GTPPMaterialWeights = GTPPMaterials.keySet().stream()
                .collect(Collectors.toMap(Function.identity(), k -> 1f, VoidMinerLoader::keyConflict, HashMap::new));

        Arrays.stream(CoreConfig.MaterialWeights).forEach(line -> parseWeight(line, materialWeights));
        Arrays.stream(CoreConfig.WerkstoffWeights).forEach(line -> parseWeight(line, werkstoffWeights));
        Arrays.stream(CoreConfig.GTPPMaterialWeights).forEach(line -> parseWeight(line, GTPPMaterialWeights));

        Map<String, Materials> addedMaterials = Maps.filterKeys(materials, name -> materialWeights.get(name) > 0f);
        Map<String, Werkstoff> addedWerkstoff = Maps.filterKeys(werkstoff, name -> werkstoffWeights.get(name) > 0f);
        Map<String, Material> addedGTPPMaterial = Maps
                .filterKeys(GTPPMaterials, name -> GTPPMaterialWeights.get(name) > 0f);

        if (CoreConfig.DebugPrintAddedOres) {
            // Here's how to use the logged metadata:
            // /give @p gregtech:gt.blockores 1 <metadata>
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAddedOres]: Begin added materials list");
            log.info("==========");
            addedMaterials.keySet().stream().sorted().forEach(
                    name -> log.info(
                            "  {} (weight: {} / metadata: {})",
                            name,
                            materialWeights.get(name),
                            materials.get(name).mMetaItemSubID));
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAddedOres]: End added materials list");
            log.info("==========");

            // Here's how to use the logged metadata:
            // /give @p bartworks:bw.blockores.01 1 <metadata>
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAddedOres]: Begin added werkstoff list");
            log.info("==========");
            addedWerkstoff.keySet().stream().sorted().forEach(
                    name -> log.info(
                            "  {} (weight: {} / metadata: {})",
                            name,
                            werkstoffWeights.get(name),
                            werkstoff.get(name).getmID()));
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAddedOres]: End added werkstoff list");
            log.info("==========");

            // Here's how to use the logged metadata:
            // /give @p <block id> 1
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAddedOres]: Begin added GT++ material list");
            log.info("==========");
            addedGTPPMaterial.keySet().stream().sorted().forEach(
                    name -> log.info(
                            "  {} (weight: {} / block id: {})",
                            name,
                            GTPPMaterialWeights.get(name),
                            GameRegistry.findUniqueIdentifierFor(GTPPMaterials.get(name).getOreBlock(1))));
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAddedOres]: End added GT++ material list");
            log.info("==========");

            double totalWeight = Stream.concat(
                    Stream.concat(materialWeights.values().stream(), werkstoffWeights.values().stream()),
                    GTPPMaterialWeights.values().stream()).filter(f -> f > 0f).mapToDouble(f -> f).sum();
            log.info("==========");
            log.info("[DeepDarkVoidMiner/DebugPrintAddedOres]: Total weight: {}", totalWeight);
            log.info("==========");
        }

        addedMaterials.forEach((k, v) -> VoidMinerLoader.addVoidDimerDrops(v, materialWeights.get(k)));
        addedWerkstoff.forEach((k, v) -> VoidMinerLoader.addVoidDimerDrops(v, werkstoffWeights.get(k)));
        addedGTPPMaterial.forEach((k, v) -> VoidMinerLoader.addVoidDimerDrops(v, GTPPMaterialWeights.get(k)));
    }

    /**
     * Parses the weight config line and enters it into the weights map, overwriting any prior entry with the same name.
     */
    private static void parseWeight(String line, Map<String, Float> weights) {
        String[] pieces = line.split(":");
        if (pieces.length != 2) {
            log.error("Malformed weight config: \"{}\"", line);
            return;
        }

        float weight;
        try {
            weight = Float.parseFloat(pieces[1]);
        } catch (NumberFormatException e) {
            log.error("Unable to parse weight: \"{}\"", line);
            return;
        }

        // We should maybe check this since we actually do have an ore named "InfinityCatalyst"...
        if (Float.isNaN(weight) || Float.isInfinite(weight)) {
            log.error("Invalid weight: \"{}\"", line);
            return;
        }

        weights.put(pieces[0].trim(), weight);
    }

    /**
     * Helper method that gets called when we run into a key conflict when trying to put {@link Materials} or
     * {@link Werkstoff} into a map.
     */
    private static <T> T keyConflict(T a, T b) {
        throw new IllegalStateException(String.format("Got a name conflict: [%s], [%s]", a, b));
    }
}
