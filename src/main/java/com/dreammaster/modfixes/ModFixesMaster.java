package com.dreammaster.modfixes;

import java.util.HashMap;

import com.dreammaster.main.MainRegistry;

/**
 * Don't change anything here unless you know what you're doing. Nothing needs to be done here in order to create a new
 * mod-fix!
 */
public final class ModFixesMaster {

    private static boolean mEnabled = false;
    private static HashMap<String, IModFix> mModFixes = new HashMap<>();

    private ModFixesMaster() {}

    public static void registerModFix(IModFix pConstructedModFix) {
        if (mEnabled) {
            MainRegistry.LOGGER.error(
                    "ModFix {} tried to register after enable phase. This mod-fix will be ignored",
                    pConstructedModFix.getModFixName());
            return;
        }

        if (!mModFixes.containsKey(pConstructedModFix.getModFixName())) {
            mModFixes.put(pConstructedModFix.getModFixName(), pConstructedModFix);
        } else {
            MainRegistry.LOGGER.error(
                    "ModFix [{}] is already registered! Did you forget to change the name?",
                    pConstructedModFix.getModFixName());
        }
    }

    public static void enableModFixes() {
        if (mEnabled) {
            MainRegistry.LOGGER.error("ModFixesMaster::enableModFixes() was called more than once");
            return;
        }

        for (IModFix tModFix : mModFixes.values()) {
            if (!tModFix.init()) {
                MainRegistry.LOGGER.error("ModFix [{}] could not be initialized", tModFix.getModFixName());
            } else {
                MainRegistry.LOGGER.info("ModFix [{}] initialized and enabled", tModFix.getModFixName());
            }
        }
        mEnabled = true;
    }

    public static IModFix getModFixInstance(String modFixName) {
        return mModFixes.get(modFixName);
    }
}
