package com.dreammaster.thaumcraft;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import net.minecraftforge.oredict.OreDictionary;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class TCMaterialAspectHelper {

    /**
     * Aspect helper class for adding TC Aspects to GT5 Materials
     * 
     * @param material       (String format of Material name)
     * @param mainAspect     (String format of Aspect name)
     * @param specialAspects (String format of Aspect name, Accepts multiple aspects in seperate Strings)
     */
    public static void registerMaterialAspects(String material, String mainAspect, String... specialAspects) {

        // Convert varargs → Aspect[]
        List<Aspect> specials = new ArrayList<>();
        for (String pa : specialAspects) {
            Aspect a = Aspect.getAspect(pa);
            if (a != null) specials.add(a);
        }

        // Cache common aspects
        Aspect perditio = Aspect.getAspect("perditio");
        Aspect perfodio = Aspect.getAspect("perfodio");
        Aspect fabrico = Aspect.getAspect("fabrico");
        Aspect motus = Aspect.getAspect("motus");
        Aspect machina = Aspect.getAspect("machina");
        Aspect instrumentum = Aspect.getAspect("instrumentum");
        Aspect ordo = Aspect.getAspect("ordo");
        Aspect meto = Aspect.getAspect("meto");
        Aspect arbor = Aspect.getAspect("arbor");
        Aspect electrum = Aspect.getAspect("electrum");
        Aspect terra = Aspect.getAspect("terra");
        Aspect main = Aspect.getAspect(mainAspect);

        // main 2 + specials
        Supplier<AspectList> main2special = () -> {
            AspectList list = new AspectList().add(main, 2);
            for (Aspect a : specials) list.add(a, 1);
            return list;
        };

        // main 3 + specials
        Supplier<AspectList> main3special = () -> {
            AspectList list = new AspectList().add(main, 3);
            for (Aspect a : specials) list.add(a, 1);
            return list;
        };

        // Declarative rules
        Map<String, Supplier<AspectList>> rules = new LinkedHashMap<>();

        rules.put("dust", () -> {
            AspectList list = new AspectList().add(main, 2).add(perditio, 1);
            for (Aspect a : specials) list.add(a, 1);
            return list;
        });
        rules.put("dustSmall", () -> new AspectList().add(perditio, 1));
        rules.put("dustTiny", () -> new AspectList().add(perditio, 1));
        rules.put("ingot", main3special);
        rules.put("ingotHot", main2special);
        rules.put("nugget", () -> new AspectList().add(main, 1));

        rules.put("stick", () -> new AspectList().add(main, 2).add(instrumentum, 1));
        rules.put("stickLong", main2special);
        rules.put("bolt", () -> new AspectList().add(instrumentum, 1));
        rules.put("screw", () -> new AspectList().add(instrumentum, 3).add(fabrico, 1).add(ordo, 1));
        rules.put("ring", () -> new AspectList().add(instrumentum, 3).add(fabrico, 3).add(ordo, 3).add(main, 1));
        rules.put("foil", () -> new AspectList().add(fabrico, 1));
        rules.put("wireFine", () -> new AspectList().add(electrum, 1));
        rules.put("gear", () -> {
            AspectList list = new AspectList().add(main, 2).add(motus, 1).add(machina, 1);
            for (Aspect a : specials) list.add(a, 2);
            return list;
        });
        rules.put("gearSmall", () -> {
            AspectList list = new AspectList().add(main, 2).add(motus, 1).add(machina, 1);
            for (Aspect a : specials) list.add(a, 2);
            return list;
        });
        rules.put("rotor", () -> {
            AspectList list = new AspectList().add(main, 2);
            for (Aspect a : specials) list.add(a, 2);
            return list;
        });
        rules.put("spring", () -> {
            AspectList list = new AspectList().add(main, 2);
            for (Aspect a : specials) list.add(a, 2);
            return list;
        });
        rules.put(
                "springSmall",
                () -> new AspectList().add(instrumentum, 5).add(fabrico, 3).add(ordo, 3).add(meto, 1).add(arbor, 1));

        // All plate/tool variants share the same aspect list
        String[] plateVariants = { "plate", "plateDouble", "plateTriple", "plateQuadruple", "plateQuintuple",
                "plateDense", "plateSuperdense" };
        for (String p : plateVariants) rules.put(p, () -> {
            AspectList list = new AspectList().add(main, 2).add(fabrico, 1);
            for (Aspect a : specials) list.add(a, 1);
            return list;
        });

        String[] toolVariants = { "toolHeadSaw", "toolHeadHammer", "toolHeadFile", "toolHeadDrill", "toolHeadChainsaw",
                "toolHeadWrench", "toolHeadBuzzSaw" };
        for (String t : toolVariants) rules.put(t, () -> {
            AspectList list = new AspectList().add(main, 2).add(instrumentum, 2);
            for (Aspect a : specials) list.add(a, 1);
            return list;
        });

        rules.put("rawOre", main2special);
        rules.put("crushed", () -> new AspectList().add(perfodio, 1));
        rules.put("crushedPurified", () -> new AspectList().add(perfodio, 1));
        rules.put("crushedCentrifuged", () -> new AspectList().add(perfodio, 1));
        rules.put("dustImpure", () -> new AspectList().add(perditio, 1));
        rules.put("dustPure", () -> new AspectList().add(perditio, 1));

        rules.put("frameGt", () -> {
            AspectList list = new AspectList().add(instrumentum, 3).add(fabrico, 3).add(ordo, 3).add(main, 3);
            for (Aspect a : specials) list.add(a, 1);
            return list;
        });

        rules.put("ore", () -> {
            AspectList list = new AspectList().add(main, 3);
            for (Aspect a : specials) list.add(a, 1);
            list.add(terra, 1);
            return list;
        });
        rules.put("block", () -> {
            AspectList list = new AspectList().add(main, 10);
            for (Aspect a : specials) list.add(a, 7);
            return list;
        });

        rules.put("pipeTiny", () -> new AspectList().add(main, 1));
        rules.put("pipeSmall", () -> new AspectList().add(fabrico, 1).add(main, 1));
        rules.put("pipeNonuple", () -> new AspectList().add(fabrico, 6).add(main, 6));
        rules.put("wireGt01", () -> new AspectList().add(fabrico, 2).add(main, 1).add(instrumentum, 1).add(ordo, 1));
        rules.put("pipeMedium", () -> {
            AspectList list = new AspectList().add(main, 4).add(fabrico, 3);
            for (Aspect a : specials) list.add(a, 2);
            list.add(instrumentum, 1);
            list.add(ordo, 1);
            return list;
        });
        rules.put("pipeLarge", () -> {
            AspectList list = new AspectList().add(main, 9).add(fabrico, 6);
            for (Aspect a : specials) list.add(a, 4);
            list.add(instrumentum, 3);
            list.add(ordo, 3);
            list.add(machina, 1);
            return list;
        });
        rules.put("pipeHuge", () -> {
            AspectList list = new AspectList().add(main, 9).add(fabrico, 6);
            for (Aspect a : specials) list.add(a, 4);
            list.add(instrumentum, 3);
            list.add(ordo, 3);
            list.add(machina, 1);
            return list;
        });
        rules.put("pipeQuadruple", () -> {
            AspectList list = new AspectList().add(main, 12).add(fabrico, 9);
            for (Aspect a : specials) list.add(a, 6);
            list.add(instrumentum, 3);
            list.add(ordo, 3);
            return list;
        });
        rules.put("wireGt02", () -> {
            AspectList list = new AspectList().add(fabrico, 3).add(main, 1);
            for (Aspect a : specials) list.add(a, 1);
            list.add(instrumentum, 1);
            list.add(ordo, 1);
            return list;
        });
        rules.put("wireGt04", () -> {
            AspectList list = new AspectList().add(fabrico, 5).add(main, 2);
            for (Aspect a : specials) list.add(a, 2);
            list.add(instrumentum, 2);
            list.add(ordo, 2);
            return list;
        });
        rules.put("wireGt08", () -> {
            AspectList list = new AspectList().add(fabrico, 7).add(main, 4);
            for (Aspect a : specials) list.add(a, 4);
            list.add(instrumentum, 4);
            list.add(ordo, 4);
            return list;
        });
        rules.put("wireGt12", () -> {
            AspectList list = new AspectList().add(fabrico, 10).add(main, 5);
            for (Aspect a : specials) list.add(a, 5);
            list.add(instrumentum, 5);
            list.add(ordo, 5);
            return list;
        });
        rules.put("wireGt16", () -> {
            AspectList list = new AspectList().add(fabrico, 12).add(main, 7);
            for (Aspect a : specials) list.add(a, 7);
            list.add(instrumentum, 7);
            list.add(ordo, 7);
            return list;
        });

        // Apply all rules
        for (Map.Entry<String, Supplier<AspectList>> entry : rules.entrySet()) {
            String key = entry.getKey() + material;

            if (!OreDictionary.getOres(key).isEmpty()) {
                ThaumcraftApi.registerObjectTag(key, entry.getValue().get());
            }
        }
    }
}
