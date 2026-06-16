package com.dreammaster.sgcalc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dreammaster.sgcalc.source.AssemblyLineSource;
import com.dreammaster.sgcalc.source.AvaritiaSource;
import com.dreammaster.sgcalc.source.GTRecipeMapSource;
import com.dreammaster.sgcalc.source.VanillaCraftingSource;

import gregtech.api.enums.Mods;

/** A reverse index (output key -> candidate recipes), built once by scanning every recipe source. */
public final class RecipeIndex {

    private final Map<String, List<RecipeCandidate>> byOutput = new HashMap<>();
    private int recipeCount;
    private int inputlessCount;

    public void add(RecipeCandidate candidate) {
        recipeCount++;
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

    public int recipeCount() {
        return recipeCount;
    }

    public int inputlessCount() {
        return inputlessCount;
    }

    public int indexedOutputs() {
        return byOutput.size();
    }

    public static RecipeIndex build() {
        RecipeIndex index = new RecipeIndex();
        new GTRecipeMapSource().collect(index::add);
        new AssemblyLineSource().collect(index::add);
        new VanillaCraftingSource().collect(index::add);
        if (Mods.Avaritia.isModLoaded()) {
            new AvaritiaSource().collect(index::add);
        }
        return index;
    }
}
