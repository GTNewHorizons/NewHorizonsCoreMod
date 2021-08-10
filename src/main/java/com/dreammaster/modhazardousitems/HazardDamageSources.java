package com.dreammaster.modhazardousitems;

import com.dreammaster.modhazardousitems.cause.HazardCause;
import com.dreammaster.modhazardousitems.cause.HazardCause.Type;
import com.dreammaster.modhazardousitems.cause.InventoryItemHazardCause;
import com.google.common.collect.ImmutableMap;
import eu.usrv.yamcore.gameregistry.DamageTypeHelper;
import gregtech.api.damagesources.GT_DamageSources;
import net.minecraft.util.DamageSource;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.Function;

public class HazardDamageSources {
    public static final Map<String, Function<HazardCause, DamageSource>> EXTRA_SOURCE_FACTORIES = ImmutableMap.<String, Function<HazardCause, DamageSource>>builder()
            .put(
                    "gregtech:hot", cause -> {
                        if (cause.getType() == Type.INVENTORY) {
                            return new GT_DamageSources.DamageSourceHotItem(((InventoryItemHazardCause) cause).getStack());
                        } else {
                            return GT_DamageSources.getHeatDamage();
                        }
                    }
            ).build();

    public static boolean isValid(String damageSourceId) {
        return getDamageSourceFactory(damageSourceId) != null;
    }

    @Nullable
    public static Function<HazardCause, DamageSource> getDamageSourceFactory(String damageSourceId) {
        for (Map.Entry<String, Function<HazardCause, DamageSource>> entry : EXTRA_SOURCE_FACTORIES.entrySet()) {
            if(entry.getKey().equals(damageSourceId)) {
                return entry.getValue();
            }
        }

        DamageSource damageSource = DamageTypeHelper.ParseStringToDamageSource(damageSourceId);
        return damageSource != null ? cause -> damageSource : null;
    }

    public static Function<HazardCause, DamageSource> getDamageSourceFactoryOrFail(String damageSourceId){
        Function<HazardCause, DamageSource> sourceFactory = getDamageSourceFactory(damageSourceId);
        if(sourceFactory == null) {
            throw new IllegalArgumentException(String.format("Unknown damage source id: %s", damageSourceId));
        }

        return sourceFactory;
    }
}
