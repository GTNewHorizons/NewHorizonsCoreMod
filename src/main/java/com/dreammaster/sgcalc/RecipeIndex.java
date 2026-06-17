package com.dreammaster.sgcalc;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.main.MainRegistry;
import com.dreammaster.sgcalc.source.AssemblyLineSource;
import com.dreammaster.sgcalc.source.AvaritiaSource;
import com.dreammaster.sgcalc.source.GTRecipeMapSource;
import com.dreammaster.sgcalc.source.VanillaCraftingSource;

import gregtech.api.enums.Mods;

/** A reverse index (output key -> candidate recipes), built once by scanning every recipe source. */
public final class RecipeIndex {

    private final Map<String, List<RecipeCandidate>> byOutput = new HashMap<>();
    private final List<String> rawSources;
    private final Set<String> rawOutputs = new HashSet<>();
    private int recipeCount;
    private int inputlessCount;

    private RecipeIndex(List<String> rawSources) {
        this.rawSources = rawSources;
    }

    public void add(RecipeCandidate candidate) {
        recipeCount++;
        // Outputs of a "raw source" (e.g. the Eye of Harmony) are treated as raw ingredients rather than crafted, so
        // the recipe is recorded only as a producer of raws and never as a normal production path.
        if (isRawSource(candidate.sourceId)) {
            for (RecipeCandidate.Output output : candidate.outputs) {
                rawOutputs.add(output.item.key);
            }
            return;
        }
        // A recipe whose inputs are all non-consumed (zero quantity, so all filtered out -- e.g. the Eye of Harmony
        // display recipe, whose trigger item and fluids are quantity 0) consumes nothing and is not a real production
        // path. Never offer it as a producer, otherwise it would make its outputs free.
        if (candidate.inputs.isEmpty()) {
            inputlessCount++;
            return;
        }
        for (RecipeCandidate.Output output : candidate.outputs) {
            byOutput.computeIfAbsent(output.item.key, k -> new ArrayList<>()).add(candidate);
        }
    }

    public List<RecipeCandidate> producersOf(String key) {
        return byOutput.getOrDefault(key, Collections.emptyList());
    }

    /** Keys of items produced by a raw source; in the low-level pass these stop recursing and count as raws. */
    public Set<String> rawOutputs() {
        return rawOutputs;
    }

    private boolean isRawSource(String sourceId) {
        for (String pattern : rawSources) {
            if (pattern == null || pattern.trim().isEmpty() || pattern.startsWith("#")) continue;
            pattern = pattern.trim();
            if (pattern.equals(sourceId)
                    || (pattern.endsWith(":*") && sourceId.startsWith(pattern.substring(0, pattern.length() - 1)))) {
                return true;
            }
        }
        return false;
    }

    public int recipeCount() {
        return recipeCount;
    }

    public int inputlessCount() {
        return inputlessCount;
    }

    public int indexedOutputs() {
        return byOutput.size();
    }

    public static RecipeIndex build(List<String> rawSources, List<String> rawProviders) {
        RecipeIndex index = new RecipeIndex(rawSources);
        new GTRecipeMapSource().collect(index::add);
        new AssemblyLineSource().collect(index::add);
        new VanillaCraftingSource().collect(index::add);
        if (Mods.Avaritia.isModLoaded()) {
            new AvaritiaSource().collect(index::add);
        }
        index.collectRawProviders(rawProviders);
        return index;
    }

    /**
     * Reads custom recipe tables that are not {@link gregtech.api.recipe.RecipeMap}s (e.g. the Space Pumping Module's
     * static map) reflectively from `<class>#<staticField>`, registering every item/fluid found as a raw.
     */
    private void collectRawProviders(List<String> rawProviders) {
        for (String entry : rawProviders) {
            if (entry == null || entry.trim().isEmpty() || entry.startsWith("#")) continue;
            int hash = entry.indexOf('#');
            if (hash < 0) continue;
            try {
                Field field = Class.forName(entry.substring(0, hash).trim()).getField(entry.substring(hash + 1).trim());
                collectRaw(field.get(null));
            } catch (Throwable t) {
                MainRegistry.LOGGER.warn("sgcalc: could not read raw provider '" + entry + "': " + t);
            }
        }
    }

    private void collectRaw(Object value) {
        if (value instanceof ItemStack stack) {
            if (stack.getItem() != null) rawOutputs.add(SGItem.of(stack).key);
        } else if (value instanceof FluidStack fluid) {
            if (fluid.getFluid() != null) rawOutputs.add(SGItem.of(fluid).key);
        } else if (value instanceof Map<?, ?>map) {
            for (Object v : map.values()) collectRaw(v);
        } else if (value instanceof Iterable<?>iterable) {
            for (Object v : iterable) collectRaw(v);
        }
    }
}
