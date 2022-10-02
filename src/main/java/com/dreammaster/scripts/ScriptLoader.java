package com.dreammaster.scripts;

import com.dreammaster.main.MainRegistry;

public class ScriptLoader {
    public static void run() {
        IScriptLoader[] scripts = new IScriptLoader[] {
            new ScriptAE2FC(),
            new ScriptAFSU(),
            new ScriptAlveary(),
            new ScriptAppliedEnergistics2(),
            new ScriptArchitectureCraft(),
            new ScriptAvaritiaAddons(),
            new ScriptBetterQuesting(),
            new ScriptBiblioCraft(),
            new ScriptBiblioWoodsBoP(),
            new ScriptBiblioWoodsForestry(),
            new ScriptBiblioWoodsNatura(),
            new ScriptComputronics(),
            new ScriptEC2(),
            new ScriptEnderIO(),
            new ScriptEnderZoo(),
            new ScriptForgeMultipart(),
            new ScriptHoloInventory(),
            new ScriptIguanaTweaks(),
            new ScriptJABBA(),
            new ScriptNuclearControl(),
            new ScriptSleepingBags(),
            new ScriptSpiceOfLife(),
            new ScriptTranslocator(),
            new ScriptOpenBlocks()
        };

        for (IScriptLoader script : scripts) {
            script.initScriptData();
            if (script.isScriptLoadable()) {
                script.loadScript();
                MainRegistry.Logger.info(script.getScriptName() + " took " + script.getExecutionTime() + " ms.");
            } else {
                MainRegistry.Logger.info(
                        "missing requirements for the script " + script.getScriptName() + ". It won't be loaded");
            }
        }
    }
}
