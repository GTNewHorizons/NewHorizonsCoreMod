package com.dreammaster.thaumcraft;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import net.minecraftforge.oredict.OreDictionary;

import com.github.bsideup.jabel.Desugar;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class TCMaterialAspectHelper {

    // Helper record passed to each rule
    @Desugar
    public record RuleContext(Aspect main, Aspect[] specials) {}

    // Pre-cached common aspects
    private static final Aspect PERDITIO = Aspect.getAspect("perditio");
    private static final Aspect PERFODIO = Aspect.getAspect("perfodio");
    private static final Aspect FABRICO = Aspect.getAspect("fabrico");
    private static final Aspect MOTUS = Aspect.getAspect("motus");
    private static final Aspect MACHINA = Aspect.getAspect("machina");
    private static final Aspect INSTRUMENT = Aspect.getAspect("instrumentum");
    private static final Aspect ORDO = Aspect.getAspect("ordo");
    private static final Aspect METO = Aspect.getAspect("meto");
    private static final Aspect ARBOR = Aspect.getAspect("arbor");
    private static final Aspect ELECTRUM = Aspect.getAspect("electrum");
    private static final Aspect TERRA = Aspect.getAspect("terra");

    // Static cached rule table
    private static final Map<String, Function<RuleContext, AspectList>> RULES = new LinkedHashMap<>();

    static {
        // Reusable rule combinators
        Function<RuleContext, AspectList> main2special = ctx -> {
            AspectList list = new AspectList().add(ctx.main(), 2);
            for (Aspect a : ctx.specials()) list.add(a, 1);
            return list;
        };

        Function<RuleContext, AspectList> main3special = ctx -> {
            AspectList list = new AspectList().add(ctx.main(), 3);
            for (Aspect a : ctx.specials()) list.add(a, 1);
            return list;
        };

        // --- Declarative rules ---
        RULES.put("dust", ctx -> {
            AspectList list = new AspectList().add(ctx.main(), 2).add(PERDITIO, 1);
            for (Aspect a : ctx.specials()) list.add(a, 1);
            return list;
        });

        RULES.put("dustSmall", ctx -> new AspectList().add(PERDITIO, 1));
        RULES.put("dustTiny", ctx -> new AspectList().add(PERDITIO, 1));

        RULES.put("ingot", main3special);
        RULES.put("ingotHot", main2special);
        RULES.put("nugget", ctx -> new AspectList().add(ctx.main(), 1));

        RULES.put("stick", ctx -> new AspectList().add(ctx.main(), 2).add(INSTRUMENT, 1));
        RULES.put("stickLong", main2special);

        RULES.put("bolt", ctx -> new AspectList().add(INSTRUMENT, 1));
        RULES.put("screw", ctx -> new AspectList().add(INSTRUMENT, 3).add(FABRICO, 1).add(ORDO, 1));
        RULES.put("ring", ctx -> new AspectList().add(INSTRUMENT, 3).add(FABRICO, 3).add(ORDO, 3).add(ctx.main(), 1));
        RULES.put("foil", ctx -> new AspectList().add(FABRICO, 1));
        RULES.put("wireFine", ctx -> new AspectList().add(ELECTRUM, 1));
        RULES.put("gear", ctx -> {
            AspectList list = new AspectList().add(ctx.main(), 2).add(MOTUS, 1).add(MACHINA, 1);
            for (Aspect a : ctx.specials()) list.add(a, 2);
            return list;
        });
        RULES.put("gearSmall", RULES.get("gear"));
        RULES.put("rotor", ctx -> {
            AspectList list = new AspectList().add(ctx.main(), 2);
            for (Aspect a : ctx.specials()) list.add(a, 2);
            return list;
        });
        RULES.put("spring", RULES.get("rotor"));
        RULES.put(
                "springSmall",
                ctx -> new AspectList().add(INSTRUMENT, 5).add(FABRICO, 3).add(ORDO, 3).add(METO, 1).add(ARBOR, 1));

        // Plate variants
        String[] plateVariants = { "plate", "plateDouble", "plateTriple", "plateQuadruple", "plateQuintuple",
                "plateDense", "plateSuperdense" };
        for (String p : plateVariants) {
            RULES.put(p, ctx -> {
                AspectList list = new AspectList().add(ctx.main(), 2).add(FABRICO, 1);
                for (Aspect a : ctx.specials()) list.add(a, 1);
                return list;
            });
        }

        // Tool head variants
        String[] toolVariants = { "toolHeadSaw", "toolHeadHammer", "toolHeadFile", "toolHeadDrill", "toolHeadChainsaw",
                "toolHeadWrench", "toolHeadBuzzSaw" };
        for (String t : toolVariants) {
            RULES.put(t, ctx -> {
                AspectList list = new AspectList().add(ctx.main(), 2).add(INSTRUMENT, 2);
                for (Aspect a : ctx.specials()) list.add(a, 1);
                return list;
            });
        }

        RULES.put("rawOre", main2special);
        RULES.put("crushed", ctx -> new AspectList().add(PERFODIO, 1));
        RULES.put("crushedPurified", RULES.get("crushed"));
        RULES.put("crushedCentrifuged", RULES.get("crushed"));
        RULES.put("dustImpure", ctx -> new AspectList().add(PERDITIO, 1));
        RULES.put("dustPure", RULES.get("dustImpure"));

        RULES.put("frameGt", ctx -> {
            AspectList list = new AspectList().add(INSTRUMENT, 3).add(FABRICO, 3).add(ORDO, 3).add(ctx.main(), 3);
            for (Aspect a : ctx.specials()) list.add(a, 1);
            return list;
        });
        RULES.put("ore", ctx -> {
            AspectList list = new AspectList().add(ctx.main(), 3).add(TERRA, 1);
            for (Aspect a : ctx.specials()) list.add(a, 1);
            return list;
        });
        RULES.put("block", ctx -> {
            AspectList list = new AspectList().add(ctx.main(), 10);
            for (Aspect a : ctx.specials()) list.add(a, 7);
            return list;
        });

        RULES.put("pipeTiny", ctx -> new AspectList().add(ctx.main(), 1));
        RULES.put("pipeSmall", ctx -> new AspectList().add(FABRICO, 1).add(ctx.main(), 1));
        RULES.put("pipeNonuple", ctx -> new AspectList().add(FABRICO, 6).add(ctx.main(), 6));

        RULES.put(
                "wireGt01",
                ctx -> new AspectList().add(FABRICO, 2).add(ctx.main(), 1).add(INSTRUMENT, 1).add(ORDO, 1));
        RULES.put("pipeMedium", ctx -> {
            AspectList list = new AspectList().add(ctx.main(), 4).add(FABRICO, 3);
            for (Aspect a : ctx.specials()) list.add(a, 2);
            list.add(INSTRUMENT, 1);
            list.add(ORDO, 1);
            return list;
        });
        RULES.put("pipeLarge", ctx -> {
            AspectList list = new AspectList().add(ctx.main(), 9).add(FABRICO, 6);
            for (Aspect a : ctx.specials()) list.add(a, 4);
            list.add(INSTRUMENT, 3);
            list.add(ORDO, 3);
            list.add(MACHINA, 1);
            return list;
        });
        RULES.put("pipeHuge", RULES.get("pipeLarge"));

        RULES.put("pipeQuadruple", ctx -> {
            AspectList list = new AspectList().add(ctx.main(), 12).add(FABRICO, 9);
            for (Aspect a : ctx.specials()) list.add(a, 6);
            list.add(INSTRUMENT, 3);
            list.add(ORDO, 3);
            return list;
        });
        RULES.put("wireGt02", ctx -> {
            AspectList list = new AspectList().add(FABRICO, 3).add(ctx.main(), 1);
            for (Aspect a : ctx.specials()) list.add(a, 1);
            list.add(INSTRUMENT, 1);
            list.add(ORDO, 1);
            return list;
        });
        RULES.put("wireGt04", ctx -> {
            AspectList list = new AspectList().add(FABRICO, 5).add(ctx.main(), 2);
            for (Aspect a : ctx.specials()) list.add(a, 2);
            list.add(INSTRUMENT, 2);
            list.add(ORDO, 2);
            return list;
        });
        RULES.put("wireGt08", ctx -> {
            AspectList list = new AspectList().add(FABRICO, 7).add(ctx.main(), 4);
            for (Aspect a : ctx.specials()) list.add(a, 4);
            list.add(INSTRUMENT, 4);
            list.add(ORDO, 4);
            return list;
        });
        RULES.put("wireGt12", ctx -> {
            AspectList list = new AspectList().add(FABRICO, 10).add(ctx.main(), 5);
            for (Aspect a : ctx.specials()) list.add(a, 5);
            list.add(INSTRUMENT, 5);
            list.add(ORDO, 5);
            return list;
        });
        RULES.put("wireGt16", ctx -> {
            AspectList list = new AspectList().add(FABRICO, 12).add(ctx.main(), 7);
            for (Aspect a : ctx.specials()) list.add(a, 7);
            list.add(INSTRUMENT, 7);
            list.add(ORDO, 7);
            return list;
        });
    }

    /**
     * Aspect helper method for adding TC Aspects to GT5 Materials
     *
     * @param material       (String format of Material name)
     * @param mainAspect     (String format of Aspect name)
     * @param specialAspects (String format of Aspect name, Accepts multiple aspects in seperate Strings)
     */
    public static void registerMaterialAspects(String material, String mainAspect, String... specialAspects) {
        Aspect main = Aspect.getAspect(mainAspect);

        Aspect[] specials = Arrays.stream(specialAspects).map(Aspect::getAspect).filter(Objects::nonNull)
                .toArray(Aspect[]::new);

        RuleContext ctx = new RuleContext(main, specials);

        for (Map.Entry<String, Function<RuleContext, AspectList>> entry : RULES.entrySet()) {
            String key = entry.getKey() + material;

            if (!OreDictionary.getOres(key).isEmpty()) {
                ThaumcraftApi.registerObjectTag(key, entry.getValue().apply(ctx));
            }
        }
    }
}
