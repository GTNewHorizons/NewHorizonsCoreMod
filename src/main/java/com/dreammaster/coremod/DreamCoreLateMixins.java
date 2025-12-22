package com.dreammaster.coremod;

import java.util.List;
import java.util.Set;

import org.jetbrains.annotations.NotNull;

import com.dreammaster.mixins.Mixins;
import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;
import com.gtnewhorizon.gtnhmixins.builders.IMixins;

@LateMixin
public class DreamCoreLateMixins implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.dreamcraft.late.json";
    }

    @NotNull
    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        return IMixins.getLateMixins(Mixins.class, loadedMods);
    }
}
