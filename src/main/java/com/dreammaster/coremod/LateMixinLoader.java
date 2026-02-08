package com.dreammaster.coremod;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

import gregtech.api.enums.Mods;

@LateMixin
public class LateMixinLoader implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.dreamcraft.late.json";
    }

    @Override
    public @NotNull List<String> getMixins(Set<String> loadedMods) {
        if (loadedMods.contains(Mods.ModIDs.BIOMES_O_PLENTY)) {
            return Collections.singletonList("MixinBOPBlocks");
        }
        return Collections.emptyList();
    }
}
