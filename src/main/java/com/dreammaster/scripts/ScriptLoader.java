package com.dreammaster.scripts;

import com.dreammaster.main.MainRegistry;

public class ScriptLoader {

    public static void run() {
        IScriptLoader[] scripts = new IScriptLoader[] { new ScriptAE2FC(), new ScriptAFSU(),
                new ScriptIndustrialApiary(), new ScriptAppliedEnergistics2(), new ScriptArchitectureCraft(),
                new ScriptAvaritiaAddons(), new ScriptBetterQuesting(), new ScriptBiblioCraft(),
                new ScriptBiblioWoodsBoP(), new ScriptBiblioWoodsForestry(), new ScriptBiblioWoodsNatura(),
                new ScriptComputronics(), new ScriptEC2(), new ScriptEnderIO(), new ScriptEnderZoo(),
                new ScriptForgeMultipart(), new ScriptHoloInventory(), new ScriptIguanaTweaks(), new ScriptJABBA(),
                new ScriptNuclearControl(), new ScriptOpenBlocks(), new ScriptSleepingBags(), new ScriptSpiceOfLife(),
                new ScriptTranslocator(), new ScriptTwilightForest(), new ScriptThaumicEnergistics() };

        for (IScriptLoader script : scripts) {
            if (script.isScriptLoadable()) {
                final long timeStart = System.currentTimeMillis();
                script.loadRecipes();
                final long timeToLoad = System.currentTimeMillis() - timeStart;
                MainRegistry.Logger.info("Loaded " + script.getScriptName() + " script in " + timeToLoad + " ms.");
            } else {
                MainRegistry.Logger
                        .info("Missing dependencies to load " + script.getScriptName() + " script. It won't be loaded.");
            }
        }
    }
}
