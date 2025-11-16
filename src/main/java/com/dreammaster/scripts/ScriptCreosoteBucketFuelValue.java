package com.dreammaster.scripts;

import static com.dreammaster.main.MainRegistry.CoreConfig;
import static com.dreammaster.main.MainRegistry.Module_CustomFuels;
import static gregtech.api.enums.Mods.IguanaTweaksTinkerConstruct;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;

public class ScriptCreosoteBucketFuelValue implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Sets the fuel value for creosote buckets";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList(Railcraft.ID);
    }

    @Override
    public void loadRecipes() {
        if (!CoreConfig.ModCustomFuels_Enabled) return;

        for (ItemStack creosoteBucket : getCreosoteBuckets()) {
            Module_CustomFuels.registerCustomFuelValue(creosoteBucket, (short) 6400);
        }
    }

    @Nonnull
    private static List<ItemStack> getCreosoteBuckets() {
        List<ItemStack> creosoteBuckets = new ArrayList<>();
        creosoteBuckets.add(getModItem(Railcraft.ID, "fluid.creosote.bucket", 1, 0, missing));
        if (IguanaTweaksTinkerConstruct.isModLoaded()) {
            creosoteBuckets.add(getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketCreosote", 1, 0, missing));
        }
        return creosoteBuckets;
    }
}
