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
        return "mixins.dreamcraft.json";
    }

    @Override
    public @NotNull List<String> getMixins(Set<String> loadedMods) {
        if (Mods.BiomesOPlenty.isModLoaded()) {
            return Collections.singletonList("MixinBOPBlocks");
        }
        return Collections.emptyList();
    }
}
